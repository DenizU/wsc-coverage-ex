package de.tum.in.ibis;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class User {
    private String username;
    private String password;
    private List< UserRole > roles;

    private MessageDigest md5;

    public User() {
        try {
            md5 = MessageDigest.getInstance( "MD5" );
        } catch ( NoSuchAlgorithmException e ) {
            System.out.println( "Couldn't get instance for md5 message digest" );
            e.printStackTrace();
        }
    }
    
    public User( String username, String password ) {
        this();
        this.username = username;
        this.password = this.makeMD5( password );
    }

    /**
     * 
     * @param s
     * @return
     */
    public String makeMD5( String s ) {
        StringBuffer hexResult = new StringBuffer();
        if ( md5 != null ) {
            md5.reset();
            md5.update( s.getBytes() );
            byte[] hash = md5.digest();

            for ( int i = 0; i < hash.length; i++ ) {
                hexResult.append( Integer.toHexString( 0xFF & hash[i] ) );
            }
        }
        return hexResult.toString();
    }

    /**
     * @param username the username to set
     */
    public void setUsername( String username ) {
        this.username = username;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword( String password ) {
        this.password = this.makeMD5( password );
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Add the specified role if it is not yet
     * included in the roles list.<br />
     * If it is already included do nothing.
     * @param role the role to add to the roles list
     */
    public void addRole( UserRole role ) {
        if ( !this.roles.contains( role ) ) {
            this.roles.add( role );
        }
    }

    /**
     * @return the list of roles of this user
     */
    public List< UserRole > getRoles() {
        return roles;
    }

}
