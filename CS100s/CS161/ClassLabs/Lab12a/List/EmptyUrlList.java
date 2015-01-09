import objectdraw.*;
import java.awt.*;

// Class representing empty lists of URLs
public class EmptyUrlList implements UrlListIfc {
    
    // constructor has nothing to initialize
    public EmptyUrlList() { }
    
    // returns a list of all entries starting with prefix
    public UrlListIfc getMatches( String prefix ) {
        return new EmptyUrlList();
    }
    
    
    // determines whether the collection contains url
    public boolean contains( String url ) {
        return false;
    }
    
    // Convert list to a string with entries separated by new lines
    public String toString() {
        return "";
    }
}
