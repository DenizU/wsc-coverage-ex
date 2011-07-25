package de.tum.in.ibis;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateBlogEntryController extends HttpServlet {
    Blog blog;
    ServletContext ctx;
    
    public void init() {
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp ) 
    throws ServletException, IOException {
        ctx = this.getServletContext();
        if ( ctx.getAttribute( "blog" ) instanceof de.tum.in.ibis.Blog ) {
            this.blog = (Blog) ctx.getAttribute( "blog" );
        } else {
            this.blog = new Blog();
            ctx.setAttribute( "blog", this.blog );
        }
        
        // check if theres a session and get attributes
        Boolean loggedIn = false;
        User user = null;
        HttpSession session = req.getSession(false);
        if ( session != null ) {
            loggedIn = (Boolean) session.getAttribute( "loggedIn" );
            user = (User) session.getAttribute( "user" );
        }
        // the author name for the blog entry shall be the username
        String authorValue = "";
        if (loggedIn) {
            authorValue = user.getUsername();
        }
        // extract form data for title and content
        String titleValue = req.getParameter( "title" );
        String contentValue = req.getParameter( "content" );
        
        // input validation, on error redirect to form an fill in values/error vars
        String titleError, authorError, contentError, formError;
        titleError = contentError = formError = "false";
        
        if ( titleValue.equals( "" ) ) {
            titleError = "true";
            formError = "true";
        }
        if ( contentValue.equals( "" ) ) {
            contentError = "true";
            formError = "true";
        }
        if (!formError.equals( "true" ) ) {
            BlogEntry blogEntry = new BlogEntry(titleValue, authorValue, contentValue);
            this.blog.add( blogEntry );
        }
        
        
        
        // if an error was encountered store information in attributes
        if ( formError.equals( "true" ) ) {
            req.setAttribute( "titleError", titleError );
            req.setAttribute( "contentError", contentError );
            req.setAttribute( "formError", formError );
            
            req.setAttribute( "titleValue", titleValue );
            req.setAttribute(  "contentValue", contentValue );
            
            // forward to createblog.jsp
            RequestDispatcher dispatcher = ctx.getRequestDispatcher( resp.encodeURL( "/createblog.jsp" ) );
            if ( dispatcher != null ) {
                dispatcher.forward( req, resp );
                return;
            }
        } else {
            // redirect to showblogcontroller
            resp.sendRedirect( resp.encodeRedirectURL( "./ShowBlogController" ) );
        }
    }
}
