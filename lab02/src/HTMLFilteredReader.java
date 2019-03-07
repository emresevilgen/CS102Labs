/**
 * Extends the SimpleURLReader class, returns only the text without the html
 * @author Munib Emre Sevilgen
 * @version 1.00 26.02.2018
 */
public class HTMLFilteredReader extends MySimpleURLReader
{
   // properties

   // constructors
   public HTMLFilteredReader( String url) {
      super( url);
   }
   
   // methods
   /**
    * Extends the SimpleURLReader class, returns only the text without the html
    * @return string of the content without the html codes
    */
   @Override
   public String getPageContents() {
      String contentUnFiltered;
      String contentFiltered;
      int firstIndex;
      int lastIndex;
      firstIndex = 0;
      lastIndex = 0;
      contentUnFiltered = getUnfilteredPageContents();
      contentFiltered = "";
      for ( int i = 0; i < contentUnFiltered.length(); i++) {
         if ( contentUnFiltered.charAt(i) == '>')
            firstIndex = i;
         else if ( contentUnFiltered.charAt(i) == '<') {
            lastIndex = i;
            if (firstIndex != lastIndex) {
               contentFiltered = contentFiltered + contentUnFiltered.substring( firstIndex + 1, lastIndex);
            }
         }
      }
      contentFiltered = contentFiltered.replaceAll( "&nbsp;", "");
      contentFiltered = contentFiltered.replaceAll( "&quot;", "");
      return contentFiltered;
   }
   
   /**
    * Returns the original page complete with html codes
    * @return string of the content with the html codes 
    */
   public String getUnfilteredPageContents() {
      return super.getPageContents();
   }
}