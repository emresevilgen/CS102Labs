import java.util.Scanner;
import java.util.ArrayList;
/**
 * A simple menu-driven program that will maintain a collection of MySimpleURLReader objects
 * @author Munib Emre Sevilgen
 * @version 1.00 26.02.2018
 */ 
public class Lab02e
{
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);

      // constants

      // variables
      ArrayList<MySimpleURLReader> simpleURLList;
      int selection;
      int selection2;
      String url;    
      double[] currencies;
      
      // program code
      simpleURLList = new ArrayList<MySimpleURLReader>();
      currencies = new double[2];
      do {
         System.out.println( "(1) Enter the url of poem to add to collection" +
                            "\n(2) List all poems in the collection" +
                            "\n(3) List the currencies" +
                            "\n(4) Quit");
         selection = scan.nextInt();
         // For option 1
         if( selection == 1) {
            do {
               System.out.println( "Enter the URL: ");
               url = scan.next();
               
               // Adds to list respect to the end of the filename
               if( url.substring( url.length() - 3, url.length()).equals("txt")) {
                  simpleURLList.add( new MySimpleURLReader( url));
                  selection2 = 0;
               }
               else if( url.substring( url.length() - 3, url.length()).equals("htm")) {
                  simpleURLList.add( new HTMLFilteredReader ( url));
                  selection2 = 0;
               }
               else if( url.substring( url.length() - 4, url.length()).equals("html")) {
                  simpleURLList.add( new HTMLFilteredReader ( url));
                  selection2 = 0;
               }
               else {
                  System.out.println( "You entered unexpected url.");
                  selection2 = 1;
               }
               
            } while ( selection2 != 0 );
         }
         
         // For option 2
         else if( selection == 2) {
            
            do {
               // Prints the filename list
               for ( int i = 0; i < simpleURLList.size(); i++ ) {
                  System.out.println( (i + 1) + ")" + simpleURLList.get(i).getName());
               }
               // Prints the contents of the page at entered index
               System.out.println( "Enter the index number of a poem to view it: ");
               selection2 = scan.nextInt();
               if ( selection2 <= simpleURLList.size()) {
                  System.out.println( simpleURLList.get(selection2 - 1).getPageContents());
               }
            } while ( selection2 != simpleURLList.size() + 1);
         }
         // For currencies
         else if ( selection == 3) {
            
            currencies = getCurrencies();
            System.out.println("Dollar: " + currencies[0]);
            System.out.println("Euro: " + currencies[1]);
            
         }
            
         // For invalid selection
         else if ( selection != 4) {
            System.out.println( "You should choose from these options:");
         }
      } while ( selection != 4); // For quit
   }
   
   /**
    * Returns the exchange rates of currencies
    * @return array of the exchange rates of currencies
    */
   public static double[] getCurrencies() {
      double[] currencyList;
      int index;
      String content;
      HTMLFilteredReader currencies;
      
      currencyList = new double[2];
      currencies = new HTMLFilteredReader( "http://www.tcmb.gov.tr/kurlar/today.xml");
      content = currencies.getPageContents();
      
      index = content.indexOf( "DOLLAR"); 
      currencyList[0] = Double.parseDouble(content.substring( index + 10, index + 16));
      index = content.indexOf( "EURO");
      currencyList[1] = Double.parseDouble(content.substring( index + 16, index + 22));
      return currencyList;
   }
}