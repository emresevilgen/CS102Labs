import java.util.Scanner;
/**
 * Finds first 100 prime numbers
 * @author Munib Emre Sevilgen
 * @version 1.00 12.02.2018
 */ 
public class PrimeNumbers
{
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);

      // constants
      final int numberOfPrimeNumbers = 100;
      
      // variables
      IntBag primeBag;
      boolean isPrime;
      int num;
      
      // program code
      primeBag = new IntBag( numberOfPrimeNumbers);
      primeBag.add(2);
      num = 3;
      while( primeBag.size() < numberOfPrimeNumbers) {
         isPrime = true;
         // Divide num with the primes smaller than it
         for (int i = 0; i < primeBag.size(); i++ ) {
            // If it can be divided then it is not prime number
            if( num % primeBag.get(i) == 0)
               isPrime = false;
         }
         // If it can't be divided then it is prime
         if ( isPrime) {
            primeBag.add( num);
         }
         num++;
      }
      System.out.println( primeBag.toString());
   }
}