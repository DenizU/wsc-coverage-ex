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

public class ShowBlogController extends HttpServlet {
    Blog blog;
    
    public void init() {
    }

    protected void doGet( HttpServletRequest req, HttpServletResponse resp ) 
    throws ServletException, IOException {
        ServletContext ctx = this.getServletContext();
        if(ctx.getAttribute( "blog" ) == null ) {
            blog = new Blog();
            blog.addStaticEntries();
            ctx.setAttribute( "blog", this.blog );
        } else {
            blog = (Blog) ctx.getAttribute( "blog" );
        }
        
        // check if the user is logged in
        HttpSession session = req.getSession(true);
        Boolean loggedIn = (Boolean) session.getAttribute( "loggedIn" );
        if( loggedIn ) {
            BlogEntry[] blogEntries = (BlogEntry[]) blog.getEntries().toArray( new BlogEntry[blog.getEntries().size()] );
            req.setAttribute("blogEntries", blogEntries);
            req.setAttribute( "createblogurl", resp.encodeURL( "./createblog.jsp" ).toString() );
            
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher( resp.encodeURL( "/blog.jsp" ) );
            dispatcher.forward(req, resp);
            return;
        } 
        
        
    }
    
    protected void doPost( HttpServletRequest req, HttpServletResponse resp ) 
    throws ServletException, IOException {
        this.doGet( req, resp );
    }
}
