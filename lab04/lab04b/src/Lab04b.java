package src;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;
/**
 * Lab04b class that tests BalloonsGamePanel class
 * @author Munib Emre Sevilgen
 * @version 1.00 26.03.2018
 */ 
public class Lab04b
{
   public static void main (String[] args)
   {    
      JFrame frame = new JFrame ( " Lab04b - Balloons game " );  
      BalloonsGamePanel panel = new BalloonsGamePanel();
      frame.add (panel);
      frame.pack();
      
      // I got these two line code from internet to locate frame at the center of the screen
      Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
      frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
      
      frame.setVisible(true);    
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}