import objectdraw.*;
import java.awt.*;

// Interface for classes representing lists of URLs
public interface UrlListIfc {
    // returns a list of all entries starting with prefix
    public UrlListIfc getMatches( String prefix );
    
    // determines whether the collection contains url
    public boolean contains( String url );
    
    // Convert list to a string with entries separated by new lines
    public String toString();
}
