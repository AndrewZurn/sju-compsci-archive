
import objectdraw.*;
import java.awt.*;

// Class representing non-empty lists of URLs
public class NonemptyUrlList implements UrlListIfc {
    private String firstUrl;    // the first URL in the list
    private UrlListIfc rest;       // the rest of the list of URLs
    
    // Create a new list
    public NonemptyUrlList( String newURL, UrlListIfc existingList ) {
        firstUrl = newURL;
        rest = existingList;
    }
    
    // returns a list of all entries starting with prefix
    public UrlListIfc getMatches( String prefix ) {
        if ( firstUrl.startsWith( prefix ) ) {
            return new NonemptyUrlList( firstUrl, rest.getMatches(prefix));
        }
        else {
            return rest.getMatches( prefix );
        }
    }
    
    // determines whether the collection contains url
    public boolean contains( String url ) {
        return firstUrl.equals(url) || rest.contains( url );
    }
    
    // Convert list to a string with entries separated by new lines
    public String toString() {
        return firstUrl + "\n" + rest.toString();
    }
}
