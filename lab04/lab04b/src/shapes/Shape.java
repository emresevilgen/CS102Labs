package src.shapes;
/**
 * Shape class implements Locatable
 * @author Munib Emre Sevilgen
 * @version 2.00 26.03.2018
 */ 
public abstract class Shape implements Locatable
{
   // properties
   int x;
   int y;
   
   // constructors
   
   // methods
   public abstract double getArea();
   
   public abstract String toString();
   
   /**
   * Sets the location of the object
   * @param x x coordinate
   * @param y y coordinate
   */ 
   public void setLocation( int x, int y) {
      this.x = x;
      this.y = y;
   }
   
   /**
   * Returns the x coordinate of the object
   * @return x coordinate
   */ 
   public int getX() {
      return x;
   }
   
   /**
   * Returns the y coordinate of the object
   * @return y coordinate
   */ 
   public int getY() {
      return y;
   }
   
}