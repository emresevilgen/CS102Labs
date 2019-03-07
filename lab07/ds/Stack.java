/**
 * Stack class
 * @author Munib Emre Sevilgen
 * @version 1.00 07.05.2018
 */
package cs102.ds;

public class Stack 
{
   // properties
   private List list;
   
   // constructor
   public Stack () {
      list = new List();
   }
   
   // methods
   /**
    * Adds an item to the head
    * @param item String item
    */
   public void push ( String content) {
      list.addToHead( content);
   }
   
   /**
    * Removes the item from the head
    * @return the item at the head
    */
   public String pop() {
      if ( list.isEmpty())
         return "List is empty!";
      return list.removeFromHead();
   }
   
   /**
    * Checks the list is empty or not
    * @return the list is empty or not
    */
   public boolean isEmpty() {
      return list.isEmpty();
   }
}
