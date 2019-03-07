package src;
import java.awt.*;
import src.shapes.*;
/**
 * Balloon class that extends Circle class
 * @author Munib Emre Sevilgen
 * @version 1.00 26.03.2018
 */ 
public class Balloon extends Circle implements Drawable
{ 
   public Balloon ()
   {
      super(25);
      setLocation((int)(Math.random() * 800),(int)(Math.random() * 500));
   }
   
   /** 
    * Draws balloons of defined radius and random locations.
    * @param page Graphics page
    */
   public void draw ( Graphics page)
   {
      page.drawOval ((int)(getX() - getRadius()), (int)(getY() - getRadius()), (int)getRadius() * 2, (int)getRadius() * 2);
   }
   
   /**
    * The method grows balloons 1 pixel if the radius is smaller than limit
    */
   public void grow()
   {
      
      if ( getRadius() < 100)
         setRadius(getRadius() + 1);
      else {   
         setRadius (0);
         setSelected(true);    
      } 
   }
}