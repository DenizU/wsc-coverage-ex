package de.tum.in.ibis;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.tum.in.ibis.UserAuthentication;
import de.tum.in.ibis.User;

public class UserAuthenticationTest {

    private UserAuthentication ua;

    @Before
    public void setUp() throws Exception {
        this.ua = new UserAuthentication();

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testExistingUser() {
        assertTrue( ua.isUsernameTaken( "user0" ) );
        assertTrue( ua.isUsernameTaken( "user1" ) );
        assertTrue( ua.isUsernameTaken( "user2" ) );
        assertTrue( ua.isUsernameTaken( "user3" ) );
        assertTrue( ua.isUsernameTaken( "user4" ) );
        assertTrue( ua.isUsernameTaken( "user5" ) );
        assertTrue( ua.isUsernameTaken( "user6" ) );
        assertTrue( ua.isUsernameTaken( "user7" ) );
        assertTrue( ua.isUsernameTaken( "user8" ) );
        assertTrue( ua.isUsernameTaken( "user9" ) );
    }

    @Test
    public void testNonExistingUser() {
        assertFalse( ua.isUsernameTaken( "user10" ) );
    }

    @Test
    public void testAddSimpleUser() {
        String username = "simpleUser";
        User user1 = new User( username, "simplePass" );
        try {
            ua.addUser( user1 );
        } catch ( UserAuthenticationException e ) {
            fail("Unexpected excpetion while adding user.");
        }
        assertTrue( ua.isUsernameTaken( username ) );
    }

    @Test
    public void testAddEmptyUser() {
        User user1 = new User( "", "nonemptyPass" );
        try {
            ua.addUser( user1 );
            fail("Expected exception for empty user was not thrown.");
        } catch ( UserAuthenticationException e ) {
            
        }
    }

    @Test
    public void testAddUserEmptyPass() {
        User user1 = new User( "nonemptyUser", "" );
        try {
            ua.addUser( user1 );
            fail("Expected exception for empty password was not thrown.");
        } catch ( UserAuthenticationException e ) {
            
        }
    }

    @Test
    public void testRemoveExistingUser() {
        assertTrue( ua.removeUser( "user5" ) );
        assertFalse( ua.isUsernameTaken( "user5" ) );
    }

    @Test
    public void testRemoveNonExistingUser() {
        assertFalse( ua.removeUser( "nonexistingUser" ) );
    }

    @Test
    public void testValidUserCredentials() {
        User user1 = new User ( "validUser", "validPass" );
        try {
            ua.addUser( user1 );
        } catch ( UserAuthenticationException e) {
            fail("Unexpected excpetion while adding user.");
        }
        try {
            assertTrue( ua.validate( "validUser", "validPass" ) );
        } catch ( UserAuthenticationException e ) {
            fail("Unexpected exception while validating valid User");
        }
    }
    
    @Test
    public void testInvalidUserCredentials() {
        try {
            ua.validate( "invalidUser", "invalidPass" );
            fail("Expected exception for invalid user was not thrown.");
        } catch ( UserAuthenticationException e ) {
            
        }
    }
}
