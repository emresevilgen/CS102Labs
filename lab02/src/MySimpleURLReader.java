import cs1.SimpleURLReader;
/**
 * Extends the SimpleURLReader class, include getURL() and getName() methods
 * @author Munib Emre Sevilgen
 * @version 1.00 26.02.2018
 */
public class MySimpleURLReader extends SimpleURLReader
{
   // properties
   private String url;
   
   // constructors
   public MySimpleURLReader ( String url) {
      super( url);
      this.url = url;
   }
   
   // methods
   /**
    * Returns the URL
    * @return string of the url
    */
   public String getURL() {
      return url;
   }
   
   /**
    * Returns filename part of the url
    * @return string of filename part of the url
    */
   public String getName() {
      int i;
      i = url.length() - 1;
      while ( !(url.charAt(i) == ( '/'))) {
         i--;
      }
      return url.substring( i + 1);
   }
   
   /**
    * Removes "null" and returns the page contents
    * @return string of the page contents without "null"
    */
   @Override
   public String getPageContents() {
      return super.getPageContents().substring( 4);
   }
}