/**
 * Selectable Interface, enabling all the shapes to be selectable
 * @author Munib Emre Sevilgen
 * @version 1.00 12.03.2018
 */ 
public interface Selectable
{
   
   // methods
   public boolean getSelected();
   public void setSelected( boolean selection);
   public Shape contains( double x, double y);
   public double getArea();
}