package src.shapes;
import java.util.ArrayList;
import java.util.*;
/**
 * ShapeContainer class
 * @author Munib Emre Sevilgen
 * @version 2.00 26.03.2018
 */ 

public class ShapeContainer implements Iterable
{
   // properties
   private ArrayList<Selectable> shapes;
   
   // constructors
   public ShapeContainer() {
      shapes = new ArrayList<Selectable>();
   }
   
   // methods
   /**
    * Adds the shape into the collection
    * @param s type of the shape
    */ 
   public void add( Selectable s) {
      shapes.add( s);
   }
   
   /**
    * Returns the area o the object at given index
    * @param index index of the object
    * @return the area o the object at given index
    */ 
   public double getArea( int index) {
      
      return shapes.get( index).getArea();
   }
   
   /**
    * Returns the string of the object at given index
    * @param index of object
    * @return the string of the object at given index 
    */ 
   public String toString( int index) {
      return shapes.get( index).toString();
   }
   
   /**
    * Returns number of shapes
    * @return number of shapes
    */ 
   public int size() {
      return shapes.size();
   }
   
   /**
    * Selects the first shape in the collection contains (x,y)
    * @param x x coordinate
    * @param y y coordinate
    * @return first object itself if it exist, returns null otherwise
    */ 
   public Selectable findFirstByPoints( int x, int y)
   {
      Selectable shape;
      int index;
      index = shapes.size();
      for (  int i = 0 ; i < index ; i++) {  
         if (((shapes.get(i))).contains(x, y) != null) {
            index = i;
         }        
      }
      if ( index != shapes.size()) {
         shape = shapes.get(index);
      }
      else {
         return null;
      }
      shape.setSelected( !shape.getSelected());
      return shape;
      
   }
   
   /**
    * Removes the selected shapes from the collection
    */ 
   public void removeSelected()
   {
      for (int i = 0; i < shapes.size(); i++) {
         if ( (shapes.get(i)).getSelected() ) {
            shapes.remove(i);
            i--;
         }     
      }
   }
   
   /**
    * Selects all shapes that contains given x and y
    * @param x x coordinate 
    * @param y y coordinate
    * @return number of shapes that contains given x and y
    */ 
   public int selectAllAt( int x, int y)
   {
      int count = 0;
      for (  int i = ( shapes.size() - 1); i >= 0; i--)
      {  
         if ((shapes.get(i)).contains (x, y) != null )
         {
            (shapes.get(i)).setSelected (true);
            count ++ ;
         }        
      }
      return count;
   }
   
   /**
    * Creates an iterator for the collection.
    * @return the iterator of the array of shapes
    */ 
   @Override
   public Iterator iterator()
   {  
      return shapes.iterator();
   }
   
   
}
