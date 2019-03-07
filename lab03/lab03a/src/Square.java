/**
 * Creates a square object with given side length 
 * @author Munib Emre Sevilgen
 * @version 1.00 12.03.2018
 */
public class Square extends Rectangle implements Selectable
{
   // properties
   private double side;
   private boolean isSelected;
   
   // constructors
   public Square( double side) {
      super( side, side);
      this.side = side;
   }
   // methods
   
   /**
    * Returns the string of the properties of square
    * @return the string of the properties of square
    */ 
   public String toString() {
      String s;
      s = "Square with side " + side + " at (" + x + "," + y + ") is ";
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
   public void setSelected(boolean selected )
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
      if (( this.x <= x ) && ( x <= this.x + side ) && ( y <= this.y + side ) && ( this.y <= y))
         return this;
      return null;
   }
}