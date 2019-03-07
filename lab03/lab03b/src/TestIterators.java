import java.util.Iterator;
/**
 * Tests IntBagIterator
 * @author Munib Emre Sevilgen
 * @version 1.00 12.03.2018
 */
public class TestIterators 
{
   public static void main( String [] args)
   {
      IntBagIterator i, j;
      IntBag bag = new IntBag();
      i = new IntBagIterator( bag);
      
      for (int k = 0 ; k < 10 ; k++)
      {
         bag.add(k);
      }
      
      while ( i.hasNext() ) 
      {
         System.out.println( i.next() );
         
         j = new IntBagIterator( bag);
         //j = bag.iterator();
         
         while ( j.hasNext() )
         {
            System.out.println( "--" + j.next() );
         }
      }
      
      System.out.println("\n----------\n");
      while ( i.hasPrevious() ) 
      {
         System.out.println( i.previousInt() );
      }
   }
}