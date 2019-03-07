package src.shapes;
/**
 * Selectable Interface, enabling all the shapes to be selectable
 * @author Munib Emre Sevilgen
 * @version 2.00 26.03.2018
 */ 
public interface Selectable
{
   
   // methods
   public boolean getSelected();
   public void setSelected( boolean selection);
   public Shape contains( int x, int y);
   public double getArea();


}
