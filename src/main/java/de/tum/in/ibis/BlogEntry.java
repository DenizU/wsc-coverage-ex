package de.tum.in.ibis;

import java.text.DateFormat;
import java.util.Date;

/**
 * This class creates BlogEntry objects that can be used by a blog object.
 * @author Deniz
 *
 */
public class BlogEntry implements Comparable<BlogEntry>{

    private String UUID;
    private String title;
    private Date creationDate;
    private String author;
    private String content;
    
    private DateFormat df;
    
    
    public BlogEntry(String title, String author, String content) {
        // create new UUID
        this.UUID = java.util.UUID.randomUUID().toString();
        
        // set creationdate
        df = DateFormat.getDateInstance(DateFormat.SHORT);
        this.creationDate = new Date();
        
        // save title, author and content
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID( String uuid ) {
        UUID = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle( String title ) {
        this.title = title;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate( Date creationDate ) {
        this.creationDate = creationDate;
    }
    
    public String getCreationDateAsString() {
        return df.format( creationDate );
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor( String author ) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent( String content ) {
        this.content = content;
    }

    @Override
    public int compareTo( BlogEntry entry ) {
        // sorting entries descending by date (i.e. latest shows first)
        if(this.creationDate.after( entry.getCreationDate() )) {
            return -1;
        } else if(this.creationDate.before( entry.getCreationDate() )) {
            return 1;
        } else {
            return 0;
        }
    }
}
