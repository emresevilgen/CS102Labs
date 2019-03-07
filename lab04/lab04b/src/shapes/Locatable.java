package src.shapes;
/**
 * Locatable Interface, enables all shape class to be locatable
 * @author Munib Emre Sevilgen
 * @version 2.00 26.03.2018
 */ 
public interface Locatable
{
   // methods
   public int getX();
   public int getY();
   public void setLocation( int x, int y);
}