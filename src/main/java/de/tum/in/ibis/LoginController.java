package de.tum.in.ibis;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController extends HttpServlet {
    ServletContext ctx;
    Blog blog;
    
    private UserAuthentication ua;
    
    public void init() {
        this.ua = new UserAuthentication();
    }

    protected void doPost( HttpServletRequest req, HttpServletResponse resp ) 
    throws ServletException, IOException {
        ctx = this.getServletContext();
        if(ctx.getAttribute( "blog" ) == null ) {
            blog = new Blog();
            blog.addStaticEntries();
            ctx.setAttribute( "blog", this.blog );
        } else {
            blog = (Blog) ctx.getAttribute( "blog" );
        }
        
        String name = (String) req.getParameter( "name" );
        String password = (String) req.getParameter( "password" );
        
        // adjusted for exercise 3: catch exception and forward to the login form w/ error-msg
        try { 
            this.ua.validate( name, password );
        } catch ( UserAuthenticationException e ) {
            // pass exception message as attribute
            req.setAttribute( "errorMessage", e.getMessage() );
            
            // forward
            RequestDispatcher dispatcher = ctx.getRequestDispatcher( "/index.jsp" );
            dispatcher.forward( req, resp );
            return;
        }
        
        // no exception(=valid login) => redirect to blog.jsp
        // start session
        HttpSession session = req.getSession( true );
        session.setAttribute( "loggedIn", new Boolean(true) );
        
        // get the user object for the session
        UserAuthentication ua = new UserAuthentication();
        if (ua.isUsernameTaken( name ) ) {
            session.setAttribute( "user", ua.getUser( name ) );
        }
        resp.sendRedirect( resp.encodeRedirectURL( "./ShowBlogController" ) );
    }
    
    protected void doGet( HttpServletRequest req, HttpServletResponse resp ) 
    throws ServletException, IOException {
        this.doPost( req, resp );
    }
}
