package de.tum.in.ibis;

public class InvalidBlogOperationException extends RuntimeException {
    
    public InvalidBlogOperationException(String s) {
        super(s);
    }
    
    public InvalidBlogOperationException() {
        super("");
    }
}
