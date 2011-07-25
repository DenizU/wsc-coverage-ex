package de.tum.in.ibis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.tum.in.ibis.User;

public class UserAuthentication {
    private List< User > users;

    public UserAuthentication() {
        /*
         * ArrayList to store users, as the number of random accesses to the
         * list are expected to be higher than the number of inserts/deletions.
         */
        this.users = new ArrayList< User >();

        /*
         * Add some static users for testing purposes.
         */
        this.addStaticUsers();
    }
    
    public boolean addUser( User u ) {
        if ( u == null ) {
            throw new UserAuthenticationException("User cannot be null.");
        }
        if ( u.getUsername().equals( "" ) ) {
            throw new UserAuthenticationException("Username must not be empty.");
        }
        if ( u.getPassword().equals( u.makeMD5( "" ) ) ) {
            throw new UserAuthenticationException("Password must not be empty.");
        }
        return this.users.add( u );
    }

    public boolean removeUser( String name ) {
        User user = this.getUser( name );
        if ( user != null ) {
            return this.users.remove( user );
        }
        return false;
    }

    public boolean isUsernameTaken( String name ) {
        Iterator< User > it = this.users.iterator();
        while ( it.hasNext() ) {
            User u = it.next();
            if ( u.getUsername().equals( name ) ) {
                return true;
            }

        }
        return false;
    }

    public boolean validate( String user, String password ) {
        Iterator< User > it = this.users.iterator();
        while ( it.hasNext() ) {
            User u = (User) it.next();
            if ( u.getUsername().equals( user ) &&
                 u.getPassword().equals( u.makeMD5( password ) ) ) {
                return true;
            }
        }
        throw new UserAuthenticationException(
                "Provided credentials for user \"" + user + "\" are invalid!");
    }

    public User getUser( String name ) {
        Iterator< User > it = this.users.iterator();
        while ( it.hasNext() ) {
            User u = (User) it.next();
            if ( u.getUsername().equals( name ) ) {
                return u;
            }
        }
        return null;
    }
    
    private void addStaticUsers() {
    User user0 = new User( "user0", "pass0" ); this.addUser( user0 );
    User user1 = new User( "user1", "pass1" ); this.addUser( user1 );
    User user2 = new User( "user2", "pass2" ); this.addUser( user2 );
    User user3 = new User( "user3", "pass3" ); this.addUser( user3 );
    User user4 = new User( "user4", "pass4" ); this.addUser( user4 );
    User user5 = new User( "user5", "pass5" ); this.addUser( user5 );
    User user6 = new User( "user6", "pass6" ); this.addUser( user6 );
    User user7 = new User( "user7", "pass7" ); this.addUser( user7 );
    User user8 = new User( "user8", "pass8" ); this.addUser( user8 );
    User user9 = new User( "user9", "pass9" ); this.addUser( user9 );
    }
}
