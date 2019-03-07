import java.lang.Integer;
/**
 * Implements Iterator class
 * @author Munib Emre Sevilgen
 * @version 1.00 12.02.2018
 */
public class IntBagIterator implements IntIterator 
{
   // properties
   IntBag aBag;
   int index;
   
   // constructors
   public IntBagIterator(IntBag bag)
   {
      index = 0;
      aBag = bag;
   }
   
   // methods
   
   /**
    * Checks collection has next int
    * @return true if collection has, false if not
    */ 
   public boolean hasNext()
   {
      return index < aBag.size() - 1;
   }
   
   /**
    * Returns next int in the collection as Integer object
    * @return next int in the collection as Integer object
    */ 
   public Integer next()
   {
      if ( hasNext()) {
         index++;
         return new Integer( nextInt());
      }
      return null;
   }
   
   /**
    * Returns next int in the collection
    * @return next int in the collection
    */ 
   public int nextInt()
   {
      return aBag.get( index);
   }
   
   
   /**
    * Checks collection has previous int
    * @return true if collection has, false if not
    */ 
   public boolean hasPrevious()
   {
      return index > 0;
   }
   
   /**
    * Returns previous int in the collection
    * @return previous int in the collection
    */ 
   public int previousInt()
   {
      index--;
      return aBag.get( index);
   }
   

}