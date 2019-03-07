import java.util.Scanner;
import cs1.SimpleURLReader;
/**
 * Tests reader classes
 * @author Munib Emre Sevilgen
 * @version 1.00 26.02.2018
 */ 
public class Lab02a
{
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);

      // constants
      final String url = "http://www.cs.bilkent.edu.tr/~david/housman.txt";
      final String htmlUrl = "http://www.cs.bilkent.edu.tr/~david/housman.htm";
      final String htmlUrlWithLinks = "http://www.cs.bilkent.edu.tr/~david/index.html";
      
      // variables
      MySimpleURLReader urlReader;
      HTMLFilteredReader htmlReader;
      SuperHTMLFilteredReader superHtmlReader;
      SuperHTMLFilteredReader superHtmlReader2;
      
      // program code
      urlReader = new MySimpleURLReader ( url);
      htmlReader = new HTMLFilteredReader ( htmlUrl);
      superHtmlReader = new SuperHTMLFilteredReader ( htmlUrl);
      superHtmlReader2 = new SuperHTMLFilteredReader ( htmlUrlWithLinks);
      
      // Tests MySimpleURLReader class
      System.out.println( urlReader.getPageContents());
      System.out.println( "Line count: " + urlReader.getLineCount());
      System.out.println( "Name: " + urlReader.getName());
      
      // Tests HTMLFilteredReader class
      System.out.println( htmlReader.getPageContents());
      System.out.println( "Line count: " + htmlReader.getLineCount());
      System.out.println( "Name: " + htmlReader.getName());
      
      // Tests SuperHTMLFilteredReader class
      System.out.println( superHtmlReader.getPageContents());
      System.out.println( "Line count: " + superHtmlReader.getLineCount());
      System.out.println( "Name: " + superHtmlReader.getName());
      System.out.println( "Overhead: " + superHtmlReader.computeOverHead());
      System.out.println( "Links" + superHtmlReader.getLinks());
      
      System.out.println( superHtmlReader2.getPageContents());
      System.out.println( "Line count: " + superHtmlReader2.getLineCount());
      System.out.println( "Name: " + superHtmlReader2.getName());
      System.out.println( "Overhead: " + superHtmlReader2.computeOverHead());
      System.out.println( "Links" + superHtmlReader2.getLinks());
   }

}