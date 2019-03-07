import java.util.Iterator;
/**
 * Extends Iterator
 * @author Munib Emre Sevilgen
 * @version 1.00 12.02.2018
 */
public interface IntIterator extends Iterator 
{ 
   // methods
   public int nextInt();
   public boolean hasPrevious();
   public int previousInt();
}