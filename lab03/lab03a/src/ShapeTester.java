import java.util.Scanner;
/**
 * Tests Shapes
 * @author Munib Emre Sevilgen
 * @version 1.00 12.03.2018
 */ 
public class ShapeTester 
{
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);

      // constants
      
      // variables
      ShapeContainer shapeContainer;
      double totalArea;
      int selection;
      int subSelection;
      double side;
      double width;
      double height;
      double radius;
      double x;
      double y;
      Rectangle rectangle;
      Square square;
      Circle circle;
      
      // program code
      shapeContainer = new ShapeContainer();
      selection = 0;
      subSelection = 0;
      do {
         System.out.println( "1)Add shape" 
                               + "\n2)Get total area" 
                               + "\n3)Show list of shapes"
                               + "\n4)Find the first Shape that contains a given x, y point and toggle its selected state"
                               + "\n5)Remove all selected shapes from the set of shapes"
                               + "\n6)Quit");
         System.out.print( "Enter your selection: ");
         selection = scan.nextInt();
         // 1)Add shape
         if ( selection == 1) {
            System.out.println( "1)Add a rectangle" 
                               + "\n2)Add a square" 
                               + "\n3)Add a circle" 
                               + "\n4)Return to Main Menu");
            System.out.print( "Enter your selection: ");
            subSelection = scan.nextInt();
            
            // 1)Add a rectangle
            if ( subSelection == 1) {
               System.out.print( "Enter the width and height with given order: ");
               width = scan.nextDouble();
               height = scan.nextDouble();
               rectangle = new Rectangle( width, height); 
               shapeContainer.add( rectangle);
               System.out.println( "Enter x and y coordinates of the left corner.");
               x = scan.nextDouble();
               y = scan.nextDouble();
               rectangle.setLocation( x, y);
            }
            
            // 2)Add a square
            else if ( subSelection == 2) {
               System.out.print( "Enter the length of side: ");
               side = scan.nextDouble();
               square = new Square( side); 
               shapeContainer.add( square);
               System.out.println( "Enter x and y coordinates of the left corner.");
               x = scan.nextDouble();
               y = scan.nextDouble();
               square.setLocation( x, y);
            }
            
            // 3)Add a circle
            else if ( subSelection == 3) {
               System.out.print( "Enter the radius: ");
               radius = scan.nextDouble();
               circle = new Circle( radius); 
               shapeContainer.add( circle);
               System.out.println( "Enter center coordinates of the circle.");
               x = scan.nextDouble();
               y = scan.nextDouble();
               circle.setLocation( x, y);
            }
            
            // 4)Return to Main Menu
            else if ( subSelection != 4) {
               System.out.println( "You have entered invalid selection.");
            }
         }
         
         // 2)Get total area
         else if ( selection == 2) {
            if( shapeContainer.getNumberOfShapes() > 0) {
               totalArea = 0;
               for (int i = 0; i < shapeContainer.getNumberOfShapes(); i++) {
                  totalArea = totalArea + shapeContainer.getArea( i);
               }
               System.out.println( "Total area is " + totalArea);
            }
            else {
               System.out.println( "There is no shape in the container.");
            }
         }
         
         // 3)Show list of shapes
         else if ( selection == 3) {
            if( shapeContainer.getNumberOfShapes() > 0) {
               for (int i = 0; i < shapeContainer.getNumberOfShapes(); i++) {
                  System.out.println( shapeContainer.toString( i));
               }
            }
            else {
               System.out.println( "There is no shape in the container.");
            }
         }
         
         // 4)Find the first Shape that contains a given x, y point and toggle its selected state
         else if( selection == 4) {
            if( shapeContainer.getNumberOfShapes() > 0) {
               System.out.print( "Enter the x and y with given order:");
               x = scan.nextDouble();
               y = scan.nextDouble();
               if (shapeContainer.findFirstByPoints( x, y) == null) {
                  System.out.println( "There is not any shape at (" + x + "," + y + ").");
               }
            }
            else {
               System.out.println( "There is no shape in the container.");
            }
         }
         
         // 5)Remove all selected shapes from the set of shapes
         else if( selection == 5) {
            shapeContainer.remove();
         }
         
         // 6)Quit
         else if ( selection != 6) {
            System.out.println( "You have entered invalid selection.");
         }
      } while ( selection != 6);     
      
   }
}