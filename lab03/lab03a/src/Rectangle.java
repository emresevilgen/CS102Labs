/**
 * Creates a rectangle object with given width and height 
 * @author Munib Emre Sevilgen
 * @version 1.00 12.03.2018
 */
public class Rectangle extends Shape implements Selectable
{
   // properties
   private double width;
   private double height;
   boolean isSelected;
   
   // constructors
   public Rectangle ( double width, double height) {
      this.width = width;
      this.height = height;
   }
   
   // methods
   /**
    * Area o the rectangle
    * @return the area of the rectangle
    */ 
   public double getArea() {
      return width * height;
   }
   
   /**
    * Returns the string of the properties of rectangle
    * @return the string of the properties of rectangle
    */ 
   public String toString() {
      String s;
      s = "Rectangle with sides " + width + " and " + height + " at (" + x + "," + y + ") is ";
      if ( isSelected)
         s = s + "selected.";
      else
         s = s + "not selected.";
      return s; 
   }
   
   /**
    * Sets selected state to given state
    * @param selected state that will be used for changing state
    */ 
   public void setSelected( boolean selected )
   {
      isSelected = selected ;
   }
   
   /**
    * Returns selected state
    * @return isSelected
    */ 
   public boolean getSelected()
   {
      return isSelected;
   }
   
   /**
    * Checks that the shape contains point (x,y)
    * @param x x coordinate
    * @param y y coordinate
    * @return shape itself if it contains, null if not
    */ 
   public Shape contains( double x, double y)
   {
      if (( this.x <= x ) && ( x <= this.x + width ) && ( y <= this.y + height ) && ( this.y <= y))
         return this;  
      return null;
   }
}