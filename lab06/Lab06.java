import java.util.ArrayList;
/**
 * Lab06 class
 * @author Munib Emre Sevilgen
 * @version 1.00 16.04.2018
 */ 

public class Lab06
{
   public static void main ( String [] args)
   {
      System.out.println( countE( ""));
      binaryEquivalent( 155);
      ArrayList<String> list;
      list = new ArrayList<String>();
      list.add( "ab");
      list.add( "abc");
      list.add( "def");
      list.add( "df");
      list.add( "f");
      System.out.println( "\n" + isLexicographic( list));
      generateEvenNumbers( 3);
      
      int set[] = {2, 3, 4, 5, 7};
      int target = 12;
      int size = set.length;
      System.out.println( isSubset(set, size, target));

         
   }
   
   /**
    * Counts 'e' in the given string
    * @param str the string that will be searched
    * @return the number of 'e' in the string
    */ 
   public static int countE( String str)
   {
      char searchedChar = 'e';
      int count = 0;
      if ( str.length() < 1) {
         return count;
      }
      else { 
         if ( str.charAt(0) == searchedChar)
            count++;
         count = count + countE ( str.substring (1));
         return count;
      }
   }
   
   /**
    * Prints the binary equivalent of the decimal value
    * @param decimal decimal value
    */
   public static void binaryEquivalent( int decimal)
   {
      if ( decimal > 0) {
         binaryEquivalent ( decimal / 2);
         System.out.print( decimal % 2);
      }
   }
   
   /**
    * Checks the array list is in Lexicographic order
    * @param list the string that will be searched
    * @return the number of 'e' in the string
    */
   public static boolean isLexicographic( ArrayList <String> list)
   {
      Boolean check;
      check = true;
      if ( list.size() <= 1) {
         return check;
      } 
      else {
         if ( list.get(0).compareTo( list.get(1)) > 0 )
            check = false;
         list.remove (0);
         if ( check && isLexicographic(list))
            return true;
         return false;
      }   
   }
   
   /**
    * Checks the number that its each digit is greater than the previous one
    * @param number that will be checked
    * @return true if the number meets the criteria or false if not
    */
   public static boolean isValid ( int number)
   {
      String decimal;
      Boolean check;
      decimal = "" + number;
      check = true;
      if ( decimal.length() >= 2) {
         if ( decimal.charAt(0) < decimal.charAt(1)) {
            check = isValid( Integer.parseInt( decimal.substring(1)));
         }
         else
            check = false;
      }
      return check;
   }
   
   /**
    * Sets the limits from the number of digits
    * @param n the number of digits
    */
   public static void generateEvenNumbers( int n) {
      int lowLimit;
      int upperLimit;
      lowLimit = (int) Math.pow( 10, ( n - 1));
      upperLimit = (int) Math.pow( 10, ( n));
      generateEvenNumbers( lowLimit, upperLimit);
      
   }
   
   /**
    * Generates the even numbers with given limits and criteria
    * @param lowLimit lower limit
    * @param upperLimit upper limit
    */
   public static void generateEvenNumbers( int lowLimit, int upperLimit ) {
      if ( lowLimit < upperLimit) {
         if ( isValid (lowLimit)) {
            System.out.println( lowLimit);
         }
         generateEvenNumbers( lowLimit + 2, upperLimit);
      }
   }
   
   
   /**
    * Checks whether there is a subset that sum of its elements is equal to the target 
    * @param set the set of the numbers
    * @param size the size of the set
    * @param target the target value
    * @return true/false
    */
   public static boolean isSubset(int[] set, int size, int target)
   {
      if ( size == 0 && target != 0)
         return false;
      else if ( target == 0)
         return true;
      
      if ( set[size - 1] > target)
         return isSubset( set, size - 1, target);
      
      return isSubset( set, size - 1, target - set[size - 1]);
    }
}