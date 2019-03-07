import cs101.sosgame.SOS;
import javax.swing.*;
import java.awt.*;

/**
 * Initilize the game
 * @author Munib Emre Sevilgen 
 * @version 1.00 02.04.2018
 */ 
public class Lab05
{
   public static void main( String[] args)
   {

      // constants
  
      // variables
      JFrame frame;
      int size;
      SOSGUIPanel panel1;
      SOS sos5;
      
      // program code
      sos5 = new SOS(5);
      frame = new JFrame( "MySOSGame: v1.0");
      panel1 = new SOSGUIPanel( sos5, "David", "Gunes");
      frame.add(panel1);
      frame.pack();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }

}