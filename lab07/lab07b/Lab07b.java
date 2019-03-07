/**
 * Tests Stack class
 * @author Munib Emre Sevilgen
 * @version 1.00 07.05.2018
 */
package cs102.lab07.lab07b;

import cs102.ds.Stack;
import java.util.Scanner;

public class Lab07b 
{
   public static void main ( String[] args)
   {
      Scanner scan = new Scanner (System.in);
      
      // constants
      
      // variables
      Stack list;
      String expression; 
      int firstOperand;
      int secondOperand;
      int result;
      String operator;
      
      // program code
      list = new Stack();
      firstOperand = 0;
      secondOperand = 0;
      result = 0;
      
      System.out.print ( "Enter the postfix expression: ");
      expression = scan.nextLine();
      
      while ( 0 < expression.length()) {
         operator = expression.charAt(0) + "";
         expression = expression.substring(1);
         
         if ( operator.equals("+")) {
            secondOperand = Integer.parseInt( list.pop());
            firstOperand = Integer.parseInt( list.pop());
            result = firstOperand + secondOperand;
            list.push (result + "");
         }
         else if ( operator.equals("-")) {
            secondOperand = Integer.parseInt( list.pop());
            firstOperand = Integer.parseInt( list.pop());
            result = firstOperand - secondOperand;
            list.push (result + "");
         }
         else if ( operator.equals("*")) {
            secondOperand = Integer.parseInt( list.pop());
            firstOperand = Integer.parseInt( list.pop());
            result = firstOperand * secondOperand;
            list.push (result + "");
         }
         else if ( operator.equals("/")) {
            secondOperand = Integer.parseInt( list.pop());
            firstOperand = Integer.parseInt( list.pop());
            result = firstOperand / secondOperand;
            list.push (result + "");
         }
         else
            list.push ( operator);
      }
      
      System.out.println( "The result is: " + list.pop());
      
   }
}
