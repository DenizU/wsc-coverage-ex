package de.tum.in.ibis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionFilter implements Filter {
    
    // store urls that shall not be filtered for sessions in an arraylist
    private ArrayList<String> urlList;

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter( ServletRequest req, ServletResponse resp, FilterChain chain ) throws IOException,
            ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        
        // get requested url
        String url = request.getServletPath();
        boolean allowedRequest = false;
        if ( this.urlList.contains( url ) ) {
            allowedRequest = true;
        }
        
        if ( !allowedRequest ) {
            // request url was not in the excluding list => apply session filter
            HttpSession session = request.getSession(false); // check whether there is a session but don't start a new one
            if ( session == null ) {
                // no session => not logged in
                // redirect to new error page
                response.sendRedirect( "./sessionerror.jsp" );
                return;
            }
        }
        chain.doFilter( req, resp );
    }

    @Override
    public void init( FilterConfig config ) throws ServletException {
        // load urls that are not filtered for sessions from the init parameter
        // and store them in the arraylist
        String urls = config.getInitParameter( "allowed-urls" );
        StringTokenizer token = new StringTokenizer(urls, ","); // comma separated list of urls
        
        this.urlList = new ArrayList<String>();
        
        while ( token.hasMoreTokens() ) {
            this.urlList.add( token.nextToken() );
        }
    }

}
