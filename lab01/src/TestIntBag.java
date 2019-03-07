import java.util.Scanner;
/**
 * Test IntBag class
 * @author Munib Emre Sevilgen
 * @version 1.00 12.02.2018
 */ 
public class TestIntBag
{
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);
      
      // constants
      final int maximumCapacity = 100;
      // variables
      int selection; 
      boolean quit;
      IntBag collection;
      IntBag setOfLocations;
      int value;
      int testValue = -1;
      int index;
      int size;
      
      // program code
      quit = false;
      collection = new IntBag(maximumCapacity);
      setOfLocations = new IntBag(maximumCapacity);
      size = 0;
      do {
         System.out.println( "1)Create a new empty collection with a specified maximum capacity (any previous values are lost!)" 
                               + "\n2)Read a set of positive values into the collection (use a negative value to indicate all the values have been entered.)" 
                               + "\n3)Print the collection of values." 
                               + "\n4)Add a value to the collection of values at a specified location" 
                               + "\n5)Remove the value at a specified location from the collection of values" 
                               + "\n6)Read a single test value." 
                               + "\n7)Compute the set of locations of the test value within the collection" 
                               + "\n8)Print the set of locations." 
                               + "\n9)Quit the program" 
                               + "\n0)Remove multiples");
         selection = scan.nextInt();
         // For 1 selection
         if ( selection == 1) {
            System.out.println( "Enter the size: ");
            size = scan.nextInt();
            collection = new IntBag(size);
         }
         // For 2 selection
         else if ( selection == 2) {
            System.out.println( "Enter the value: ");
            value = scan.nextInt();
            while ( value >= 0){
               collection.add(value);
               System.out.println( "Enter the value: ");
               if( collection.size() != size)
                  value = scan.nextInt();
               else
                  value = -1;
            } 
         }
         // For 3 selection
         else if ( selection == 3) {
            System.out.println( "Values: " + collection.toString());
         }
         // For 4 selection
         else if ( selection == 4) {
            System.out.println( "Enter the value: ");
            value = scan.nextInt();
            System.out.println( "Enter the index: ");
            index = scan.nextInt();
            collection.add( value, index);
         }
         // For 5 selection
         else if ( selection == 5) {
            System.out.println( "Enter the index: ");
            index = scan.nextInt();
            collection.remove( index);
         }
         // For 6 selection
         else if ( selection == 6) {
            System.out.println( "Enter the test value: ");
            testValue = scan.nextInt();
         }
         // For 7 selection
         else if ( selection == 7) {
            setOfLocations = collection.findAll( testValue);
         }
         // For 8 selection
         else if ( selection == 8) {
            System.out.println( "Set of locations of " + testValue + " is " 
                                  + setOfLocations.toString());
         }
         // For 9 selection
         else if ( selection == 9) {
            quit = true;
         }
         else if ( selection == 0) {
            collection.removeMultiples();
         }
         // For error
         else {
            System.out.println( "Error: You should select from these ");
         }
      } while ( !quit); 
      
   }
   
}