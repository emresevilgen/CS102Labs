/**
 * Tests List
 * @author Munib Emre Sevilgen
 * @version 1.00 07.05.2018
 */
package cs102.lab07.lab07a;
import cs102.ds.List;

public class Lab07a
{
   public static void main ( String[] args)
   {
      // constants
      
      // variables
      List cities;
      
      // program code
      cities = new List();
      
      // if list is empty
      cities.print();
      System.out.println();
      
      // tests addToHead, addToTail, print and printReverse methods
      
      
      cities.addToHead( "Istanbul");
      cities.addToHead( "New Mexico");
      cities.addToHead( "Eskisehir");
      
      cities.addToTail( "Kocaeli");
      cities.addToTail( "Ankara");
      
      System.out.println( "Print:");
      cities.print();
      System.out.println( "\nPrint in reverse order:");
      cities.printReverse();
      System.out.println();
      
      // getData - out of bounds error
      System.out.println( "Index out of bounds error: " + cities.getData(10) + "\n"); 
      
      // tests getData method
      System.out.println("Return data at index 4: " + cities.getData(4));
      System.out.println("Return data at index 2: " + cities.getData(2) + "\n"); 
      
      // tests removeFromHead method
      cities.removeFromHead();
      System.out.println( "Remove data from the head: ");
      cities.print();
      cities.removeFromHead();
      System.out.println( "\n" + "Remove data from the head: ");
      cities.print();
      
      // tests removeFromIndex method
      System.out.println( "\n" + "Remove data from the index 1: ");
      System.out.println( "Remove: " + cities.removeFromIndex(1) + "\n");
      cities.print();
    
      System.out.println( "\n" + "Remove data from the index 2: ");
      System.out.println( "Remove: " + cities.removeFromIndex(2)  + "\n");
      cities.print();


   }
}