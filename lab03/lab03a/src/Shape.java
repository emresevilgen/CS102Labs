/**
 * Shape class implements Locatable
 * @author Munib Emre Sevilgen
 * @version 1.00 12.03.2018
 */ 
public abstract class Shape implements Locatable
{
   // properties
   double x;
   double y;
   
   // constructors
   
   // methods
   public abstract double getArea();
   
   public abstract String toString();
   
   /**
   * Sets the location of the object
   * @param x x coordinate
   * @param y y coordinate
   */ 
   public void setLocation( double x, double y) {
      this.x = x;
      this.y = y;
   }
   
   /**
   * Returns the x coordinate of the object
   * @return x coordinate
   */ 
   public double getX() {
      return x;
   }
   
   /**
   * Returns the y coordinate of the object
   * @return y coordinate
   */ 
   public double getY() {
      return y;
   }
   
}