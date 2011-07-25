package de.tum.in.ibis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class BlogTest {
    private Blog blog;
    
    @Before
    public void setUp() throws Exception {
        // create new blog
        this.blog = new Blog();
        
        // fill the set with some static entries for testing purpose
        this.blog.addStaticEntries();
    }
    
    @After
    public void tearDown() throws Exception {
        
    }
    
    @Test
    public void testAddEntry() {
        BlogEntry entry = new BlogEntry("newTitle", "newAuthor", "newContent");
        try {
            this.blog.add( entry );
        } catch (InvalidBlogOperationException e) {
            fail("Unexpected exception while adding new entry: " +e.getMessage());
        }
    }
    
    @Test
    public void testAddDuplicateUUIDEntry() {
        BlogEntry entry = new BlogEntry("duplicateuuidtitle", "authorX", "content");
        entry.setUUID( this.blog.getEntries().first().getUUID() );
        try {
            this.blog.add( entry );
            fail("Expected exception for duplicate UUID was not thrown.");
        } catch ( InvalidBlogOperationException e) {
            
        }
    }
    
    @Test
    public void testAddDuplicateTitleEntry() {
        BlogEntry entry = new BlogEntry("entry7_title","authorX","content");
        entry.setTitle( this.blog.getEntries().first().getTitle() );
        try {
            this.blog.add(entry);
            fail("Expected exception for duplicate title was not thrown.");
        } catch ( InvalidBlogOperationException e) {
            
        }
    }
    
    @Test
    public void testRemoveEntry() {
        BlogEntry e = this.blog.getEntries().first();
        assertTrue(this.blog.getEntries().contains( e ));
        this.blog.remove( e );
        assertFalse(this.blog.getEntries().contains(e));
    }
    
    @Test
    public void testUpdateEntry() {
        BlogEntry entry = this.blog.getEntries().first();
        entry.setContent( "updated content" );
        try {
            this.blog.update( entry );
        } catch ( InvalidBlogOperationException e) {
            fail("Unexpected exception, could not update entry: " + e.getMessage());
        }
        assertEquals(this.blog.getEntryByUUID( entry.getUUID() ).getContent(), "updated content");
    }
    
    @Test
    public void testGetEntries() {
        assertEquals(10, this.blog.getEntries().size());
        
        BlogEntry e1 = this.blog.getEntryByTitle( "entry2_title" );
        BlogEntry e2 = this.blog.getEntryByTitle( "entry5_title" );
        if( !this.blog.remove( e1 ) || !this.blog.remove( e2 ) ) {
            fail("Could not remove entries from collection");
        }
        assertEquals(8, this.blog.getEntries().size());
        assertFalse(this.blog.getEntries().contains( e1 ));
        assertFalse(this.blog.getEntries().contains( e2 ));
        
        int entryCount = this.blog.getEntries().size();
        BlogEntry e3 = new BlogEntry("testgetentriestitle", "testauthor0213", "newcontent13232<br />testets");
        try { 
            this.blog.add( e3 );
            assertEquals(9, entryCount+1);
            assertTrue(this.blog.getEntries().contains( e3 ));
        } catch (InvalidBlogOperationException e) {
            fail("Unexpected exception while adding entry: " + e.getMessage());
        }
    }
}
