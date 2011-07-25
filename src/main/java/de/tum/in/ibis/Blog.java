package de.tum.in.ibis;


import java.util.TreeSet;

/**
 * This class allows the creation of Blog objects.
 * Each object hast its own list of blog-entries
 * and manages operations to add, remove or update entries.
 * @author Deniz
 *
 */
public class Blog {
    
    private TreeSet<BlogEntry> blogEntries;
    
    public Blog() {
        this.blogEntries = new TreeSet<BlogEntry>();
    }
    
    /**
     * Adds a new entry to this blogs list while checking
     * for duplicate UUIDs and titles.
     * @param newEntry the entry to be added
     * @return true if the new entry's UUID and title were not yet contained in the list
     */
    public boolean add(BlogEntry newEntry) {
        for( BlogEntry entry : this.blogEntries ) {
            // duplicate UUID => exception
            if ( entry.getUUID().equals( newEntry.getUUID() ) ) {
                throw new InvalidBlogOperationException("Cannot add blog entry - found duplicate UUID: " + newEntry.getUUID() );
            }
            // duplicate title => exception
            else if ( entry.getTitle().equals( newEntry.getTitle()) ) {
                throw new InvalidBlogOperationException("Cannot add blog entry - found duplicate title: " + newEntry.getTitle() );
            }
        }
        // unique UUID and title => add to collection
        this.blogEntries.add( newEntry );
        return true;
    }
    
    public boolean remove(BlogEntry e) {
        this.blogEntries.remove( e );
        return true;
    }
    
    /**
     * Updates an entry of this blogs list if there is already
     * another entry with a matching UUID.
     * @param e The updated entry
     * @return true if an entry with matching UUID was found and replaced
     */
    public boolean update(BlogEntry e) {
        for( BlogEntry entry : this.blogEntries ){
            if ( e.getUUID().equals( entry.getUUID() ) ) {
                this.blogEntries.remove( entry );
                this.blogEntries.add( e );
                return true;
            }
        }
        throw new InvalidBlogOperationException("Could not update blog entry " + e.getTitle() + " because there was no such entry");
    }
    
    /**
     * Return all entries as a TreeSet
     * @return returns a TreeSet of all BlogEntries
     */
    public TreeSet<BlogEntry> getEntries() {
        return this.blogEntries;
    }
    
    /**
     * 
     * @param uuid the uuid of the entry to be returned
     * @return Returns a BlogEntry with the matching UUID
     *         throws a InvalidBlogOperationException if no match was found
     */
    public BlogEntry getEntryByUUID(String uuid) {
        for (BlogEntry e : this.blogEntries ) {
            if ( e.getUUID().equals( uuid ) ) {
                return e;
            }
        }
        throw new InvalidBlogOperationException("Found no blog entry with uuid " + uuid);
    }
    
    /**
     * 
     * @param title the title of the entry to be returned
     * @return Returns a BlogEntry with the matching title
     *         throws a InvalidBlogOperationException if no match was found
     */
    public BlogEntry getEntryByTitle(String title) {
        for (BlogEntry e : this.blogEntries ) {
            if ( e.getTitle().equals( title ) ) {
                return e;
            }
        }
        throw new InvalidBlogOperationException("Found no blog entry with title " + title);
    }
    
    // fills the list with static entries mainly for testing
    public void addStaticEntries() {
        try {
            BlogEntry e0 = new BlogEntry("entry0_title", "authorA", "content0"); this.blogEntries.add( e0 );
            Thread.sleep( 10 );
            BlogEntry e1 = new BlogEntry("entry1_title", "authorB", "content1"); this.blogEntries.add( e1 );
            Thread.sleep( 10 );
            BlogEntry e2 = new BlogEntry("entry2_title", "authorC", "content2"); this.blogEntries.add( e2 );
            Thread.sleep( 10 );
            BlogEntry e3 = new BlogEntry("entry3_title", "authorA", "content3"); this.blogEntries.add( e3 );
            Thread.sleep( 10 );
            BlogEntry e4 = new BlogEntry("entry4_title", "authorA", "content4"); this.blogEntries.add( e4 );
            Thread.sleep( 10 );
            BlogEntry e5 = new BlogEntry("entry5_title", "authorC", "content5"); this.blogEntries.add( e5 );
            Thread.sleep( 10 );
            BlogEntry e6 = new BlogEntry("entry6_title", "authorA", "content6"); this.blogEntries.add( e6 );
            Thread.sleep( 10 );
            BlogEntry e7 = new BlogEntry("entry7_title", "authorC", "content7"); this.blogEntries.add( e7 );
            Thread.sleep( 10 );
            BlogEntry e8 = new BlogEntry("entry8_title", "authorA", "content8"); this.blogEntries.add( e8 );
            Thread.sleep( 10 );
            BlogEntry e9 = new BlogEntry("entry9_title", "authorB", "content9"); this.blogEntries.add( e9 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
