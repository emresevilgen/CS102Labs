import java.util.Scanner;
import java.util.Iterator;
/**
 * IntBag class
 * @author Munib Emre Sevilgen
 * @version 2.00 12.03.2018
 */
public class IntBag
{
   // properties
   private int[] bag;
   private int valid;
   
   // constructors
   public IntBag(){
      bag = new int [100];
      valid = 0;
   }
   public IntBag( int desiredMaxNumberOfElements){
      bag = new int [desiredMaxNumberOfElements];
      valid = 0;
   }
   
   // methods
   /**
    * Adds a value to the end of the collection
    * @param value that will be added to end of the collection
    */
   public void add( int value){
      if ( bag.length > valid){
         bag [valid] = value;
         valid++;
      }
      else
         System.out.println( "Can't add the value. Bag is full.");
   }
   
   /**
    * Adds a value to the end of the collection
    * @param value that will be added to end of the collection
    * @param i the value will be added at that index
    */
   public void add( int value, int i){
      if ( bag.length > valid && i <= valid){
         int indexTemp = valid - 1;
         while ( indexTemp >= i) {
            bag[indexTemp + 1] = bag [indexTemp];
            indexTemp--;
         }
         bag[i] = value;
         valid++;
      }
      else if( bag.length > valid) {
         add( value);
         System.out.println( "The value is added to end of the valid values.");
      }
      else
         System.out.println( "Can't add the value. Bag is full.");
   }
   
   /**
    * Removes the value at a given index
    * @param i index of the value
    */
   public void remove ( int i){
      if ( i < valid) {
         int indexTemp;
         indexTemp = i;
         while ( indexTemp < valid - 1) {
            bag[indexTemp] = bag [indexTemp + 1];
            indexTemp++;
         }
         valid--;
      }
      else
         System.out.println( "Can't remove the value. Entered index is out of bounds.");
   }
   
   /**
    * Checks the IntBag object whether contains the value or not
    * @param value that will be checked
    * @return true of false
    */
   public boolean contains( int value) {
      for (int i = 0; i < valid; i++) {
         if ( bag[i] == value)
            return true;
      }
      return false;
   }
   
   /**
    * Returns a String representation of the collection
    * @return string representation of the collection
    */
   public String toString() {
      if ( valid > 0) {
         String s;
         s = "" + bag[0];
         for( int i = 1; i < valid; i++ ) {
            s = s + ", " + bag[i];
         }
         return s;
      }
      else 
         return "None";
   }
   
   /**
    * Returns the number of values currently in the collection
    * @return the number of values currently in the collection
    */
   public int size() {
      return valid;
   }
   
   /**
    * Gets the value at location i within the collection
    * @param i index of the value
    * @return the value
    */
   public int get(int i) {
      return bag [i];
   }
   
   /**
    * Returns the set of locations of the value
    * @param value that will be checked
    * @return indexes of the value as an IntBag object
    */
   public IntBag findAll( int value) {
      IntBag indexes;
      indexes = new IntBag(valid);
      for ( int i = 0; i < valid; i++) {
         if ( bag[i] == value) {
            indexes.add(i);
         }
      }
      if ( indexes.size() == 0)
         indexes = new IntBag(0);
      return indexes;
   }
   
   /**
    * Removes the multiples
    */
   public void removeMultiples() {
      IntBag temp;
      for ( int i = 0; i < size() ; i++) {
         temp = findAll( get(i));
         for ( int j = temp.size() - 1; j > 0; j--)  { 
            remove( temp.get(j));
         }
      }
   }
   
   /**
    * Creates an iterator and returns it
    * @return iterator
    */
   public Iterator iterator() 
   {
      IntBagIterator iterator = new IntBagIterator(this);
      return iterator;
   }
}