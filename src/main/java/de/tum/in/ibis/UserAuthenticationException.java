package de.tum.in.ibis;

public class UserAuthenticationException extends RuntimeException {

    public UserAuthenticationException(String s) {
        super(s);
    }
    
    public UserAuthenticationException() {
        this("");
    }
}
