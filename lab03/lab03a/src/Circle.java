/**
 * Creates a circle object with given radius 
 * @author Munib Emre Sevilgen
 * @version 1.00 12.03.2018
 */
public class Circle extends Shape implements Selectable
{
   // properties
   private double radius;
   private boolean isSelected;
   
   // constructors
   public Circle( double radius) {
      this.radius = radius;
      isSelected = false;
   }
   
   // methods
   /**
    * Returns the area of the circle
    * @return the area of the circle
    */ 
   public double getArea() {
      return Math.PI * Math.pow( radius, 2);
   }
   
   /**
    * Returns the string of the properties of circle
    * @return the string of the properties of circle
    */ 
   public String toString() {
      String s;
      s = "Circle with " + radius + " radius at (" + x + "," + y + ") is ";
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
   public void setSelected( boolean selected) {
      isSelected = selected;
   }
   
   /**
    * Returns selected state
    * @return isSelected
    */ 
   public boolean getSelected() {
      return isSelected;
   }
   
   /**
    * Checks that the shape contains point (x,y)
    * @param x x coordinate
    * @param y y coordinate
    * @return shape itself if it contains, null if not
    */ 
   public Shape contains( double x, double y) {
      if ( Math.pow((x - super.x), 2) + Math.pow(( y - super.y), 2) <= Math.pow( radius, 2))  
         return this;
      return null;
   }
}