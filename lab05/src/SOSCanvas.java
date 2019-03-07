import javax.swing.*;
import cs101.sosgame.SOS;
import java.awt.*;
/**
 * SOSCanvas class that extends JPanel
 * @author Munib Emre Sevilgen 
 * @version 1.00 02.04.2018
 */ 
public class SOSCanvas extends JPanel 
{
   // properties
   private SOS game;
   private int size;
   // constructors
   public SOSCanvas( SOS game, int size){
      this.game = game;
      this.size = size;
      this.setPreferredSize( new Dimension ( size + 1, size + 1 ));
   }
   
   // methods
   public void paintComponent( Graphics page) {
      int x;
      int y;
      int gridNumber;
      double gridSize;
      // Calculates grid size
      gridNumber = game.getDimension();
      gridSize = size / gridNumber;
      
      // Draws the lines
      for (int i = 0; i <= gridNumber; i++) {
         x = (int) (gridSize * i);
         y = (int) (gridSize * i);
         page.drawLine(x , 0 , x, size);
         page.drawLine(0, y, size, y);
      }
      // Draws the strings
      for (int k = 0; k < gridNumber; k++) {
         for ( int j = 0; j < gridNumber ; j++) {
            x = (int)(gridSize * j + gridSize / 2);
            y = (int) (gridSize * k  + gridSize / 2);
            if ( game.getCellContents( k, j) == 's') {
               page.setColor( Color.RED);
               page.drawString( "s", x, y);
            }
            else if ( game.getCellContents( k, j) == 'o'){
               page.setColor( Color.BLUE);
               page.drawString( "o", x, y);
            }
         }
      }
   }
}