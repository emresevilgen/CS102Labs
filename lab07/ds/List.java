/*
 * List class
 * @author Munib Emre Sevilgen
 * @version 1.00 07.05.2018
 */
package cs102.ds;
import java.util.Iterator;

public class List
{
   //properties
   private Node head;
   
   //constructor
   public List() {
      head = null;
   }     
   
   /**
    * Adds the given item into the head of the list
    * @param item String
    */
   public void addToHead( String item) {
      if ( !isEmpty()) {
         Node nodeToAdd;
         nodeToAdd = new Node( item, head);    
         head = nodeToAdd;
      }
      else {
         head = new Node( item, null);
      }
      
   }
   
   /**
    * Adds the given item into the tail of the list
    * @param item String
    */
   public void addToTail( String item) {
      Node nodeToAdd;
      nodeToAdd = head;
      if ( !isEmpty()){
         while ( nodeToAdd.hasNext()) {
            nodeToAdd = nodeToAdd.next();
         }
         nodeToAdd.setNext( new Node( item, null)); 
      }
      else {
         head = new Node( item, null);
      }
   }
   
   /**
    * Removes the given item from the head of the list
    * @return item if it exists, otherwise error
    */
   public String removeFromHead() {
      if ( !isEmpty()) {
         Node remove = head;
         head = head.next();
         return remove.item;
      }
      else  
         return "List is empty!";
   }
   
   /**
    * Checks the list is empty or not
    * @return the list is empty or not
    */
   public boolean isEmpty() {
      if ( head == null) {
         return true;
      }
      return false;
   }
   
   /**
    * Returns the item at the given index in the list
    * @param  index of the item
    * @return item at the given index
    */
   public String getData( int index) {
      Node result = head;
      int count;
      count = 0;
      
      while (count < index && result.hasNext()) {
        result = result.next();
        count++;
      }
      
      if ( count != index) {
          return "No such index exists.";
      }
      return result.item;
   }
    
   /**
    * Prints the items in the list
    */
   public void print() {
      String output = "\n";
      if ( isEmpty()) {
         System.out.println( "List is empty!");
      }    
      else {
         Node currentNode = head;
         System.out.println( currentNode.item);
         while ( currentNode.hasNext()) {
            currentNode = currentNode.next();
            System.out.println( currentNode.item);
         }
      }
   }
    
   /**
    * Prints the items in the list in reverse order
    */
   public void printReverse( Node head) {
      if ( head != null) {
         if ( head.hasNext())
            printReverse( head.next());
         System.out.println( head.item);
      }
      else
         System.out.println( "List is empty!");
   }
   
   public void printReverse() {
      printReverse( head);
   }
   
   /**
    * Removes the item at the given index in the list
    * @param  index of the item
    * @return item at the given index
    */
   public String removeFromIndex( int index) {
      Node previousOfResult = head;
      Node result;
      int count;
      count = 0;
      
      while (count < index - 1 && previousOfResult.next().hasNext()) {
        previousOfResult = previousOfResult.next();
        count++;
      }
      
      if ( count != index - 1 ) {
          return "No such index exists.";
      }
      
      result = previousOfResult.next();
      previousOfResult.setNext( result.next());
      return result.item;
   }
   
   /**
    * Node objects keeps a string and next node
    */
   public class Node implements Iterator
   {
      // Properties
      private String item;
      private Node next;
      
      // Constructor
      public Node ( String item, Node next) {
         this.item = item;
         this.next = next;
      }
      
      // Methods
      /**
       * Returns the next Node
       * @return Returns the next Node
       */
      public Node next() {
         return this.next;
      }
      
      /**
       * Checks next Node is exist or not
       * @return next Node is exist or not
       */
      public boolean hasNext() {
         if ( next == null)
            return false;
         return true;
      }
      
      /**
       * Sets next Node
       * @param next next Node
       */
      public void setNext( Node next) {
         this.next = next;
      }
   }
   
}

