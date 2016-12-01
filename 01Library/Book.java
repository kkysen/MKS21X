//package sen.khyber.apcs.library;

import java.util.Map;

/**
 * represents a book with a title, author, and isbn
 * 
 * @author Khyber Sen
 */
public class Book {
    
    protected String author;
    protected String title;
    protected String isbn;
    
    public Book() {}
    
    public Book(final String author, final String title, final String isbn) {
        this.author = author;
        this.title = title;
        this.isbn = isbn;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    /**
     * optionally adds extra "fields" that should be included in #toString.
     * This implementation adds no extra fields but is meant for subclasses to use.
     * 
     * @see #toString
     *
     * @param augmentedToStringFields a map of the names of field names to their values as Objects
     *                                to be augmented by extra "fields" that should be included in #toString
     */
    protected void augmentToStringFields(final Map<String, Object> augmentedToStringFields) {}
    
    /**
     * uses reflection to include all fields,
     * in addition to added fields from #augmentToStringFields
     
     * @see #augmentToStringFields
     */
    @Override
    public String toString() {
        final Map<String, Object> augmentedToStringFields = Reflect.getStringInstanceVarEntries(this);
        augmentToStringFields(augmentedToStringFields);
        return Reflect.joinStringMap(augmentedToStringFields, this);
    }
    
}
