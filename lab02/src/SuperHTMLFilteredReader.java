import java.util.ArrayList;
/**
 * Extends the HTMLFilteredReader class, include computeOverHead() and getLinks() methods
 * @author Munib Emre Sevilgen
 * @version 1.00 26.02.2018
 */
public class SuperHTMLFilteredReader extends HTMLFilteredReader
{
   // properties

   // constructors
   public SuperHTMLFilteredReader( String url) {
      super( url);
   }
   
   // methods
   /**
    * Computes overhead
    * @return the percentage increase in size between the html and no-html contents
    */
   public int computeOverHead() {
      int htmlContentLength;
      int noHtmlContentLength;
      htmlContentLength = getUnfilteredPageContents().length();
      noHtmlContentLength = getPageContents().length();
      System.out.println( htmlContentLength + "-" + noHtmlContentLength );
      return (int)((( (double)htmlContentLength / (double)noHtmlContentLength) - 1) * 100);
   }
   
   /**
    * Returns the list of the url's that the page links to
    * @return the list of the url's that the page links to
    */
   public ArrayList<String> getLinks() {
      String content;
      ArrayList<String> urls;
      urls = new ArrayList<String>();
      int firstIndex = 0;
      int lastIndex = 0;
      content = getUnfilteredPageContents();
      for ( int i = 0; i < content.length(); i++) {
         firstIndex = content.indexOf( "href=\"", i);
         lastIndex = content.indexOf( "\"", firstIndex + 6);
         if ( firstIndex != -1) {
            urls.add( content.substring( firstIndex + 6, lastIndex));
            i = lastIndex;
         }
         else
            i = content.length();
      }
      return urls;
   }
}