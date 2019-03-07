package src;
import java.awt.*;
import src.shapes.*;
import javax.swing.*;
import java.util.*;
import javax.swing.Timer;
import java.awt.event.*;
/**
 * BalloonsGamePanel class that extends JPanel and implements MouseListener
 * @author Munib Emre Sevilgen
 * @version 1.00 26.03.2018
 */ 
public class BalloonsGamePanel extends JPanel implements MouseListener
{
   //properties
   private ShapeContainer balloons;
   private Timer timeObj;
   private Grow taskPerformer; 
   private int points;
   private JLabel point;
   private JLabel time;
   private double elapsedTime;
   private int dialogResult;
   
   //constructor
   public BalloonsGamePanel()
   { 
      balloons = new ShapeContainer();
      taskPerformer = new Grow();
      elapsedTime = 0;
      points = 0;
      
      for (int i = 0 ; i < 25; i++) {
         balloons.add( new Balloon());
      }
      
      timeObj = new Timer ( 50, taskPerformer);
      timeObj.start();
      setBackground (Color.yellow);
      setPreferredSize (new Dimension (800, 500));
      addMouseListener(this);
      time = new JLabel("Time: " + elapsedTime);
      add(time);
      point = new JLabel("Points: "+ points);
      add(point);
   }
   
   /**
    * Grow class that implements ActionListener
    * @author Munib Emre Sevilgen
    * @version 1.00 26.03.2018
    */ 
   public class Grow implements ActionListener
   { 
      /**
       * Makes balloons grow
       * @param e an ActionEvent object
       */
      public void actionPerformed(ActionEvent e) 
      { 
         int dialogButton;
         elapsedTime = elapsedTime + 0.05;
         balloons.removeSelected();
         while ( balloons.size() < 25)
            balloons.add( new Balloon());
         
         // Growing
         Iterator iterator = balloons.iterator(); 
         while (iterator.hasNext()) {
            ((Balloon)iterator.next()).grow();  
         }
         time.setText("Time: " + (int) elapsedTime);
         repaint();
         
         // If the time limit has been reached
         if (elapsedTime > 25) {
            dialogButton = JOptionPane.YES_NO_OPTION;
            dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Game Over!", dialogButton);
            if( dialogResult == 0) {
               elapsedTime = 0;
               points = 0;
               balloons.removeSelected();
               time.setText("Time: " + (int)elapsedTime );
               point.setText("Points: "+ points );
               
            }
            else 
               System.exit(0);
         }      
      }
   }
   
   /**
    * Overrides mouseClicked method of MouseListener class
    * @param e MouseEvent e
    */
   public void mousePressed(MouseEvent e) 
   {  
      int numberOfShapes = balloons.selectAllAt (e.getX(), e.getY());
      if ( numberOfShapes >= 2) {
         points = points + numberOfShapes;
         point.setText("Points: "+ points);
         balloons.removeSelected();  
      }
      else {
         point.setText("Points: "+ points);
         balloons.removeSelected();
      }   
   }
   
   
   // This class implements the MouseListener interface, so all the methods must be defined inside the class.
   public void mouseClicked(MouseEvent e) {}
   public void mouseEntered(MouseEvent e) {}
   public void mouseExited(MouseEvent e) {}
   public void mouseReleased(MouseEvent e) {}
   
   /**
    * Overrides paintComponent class of JPanel class to redraw the balloons
    * @param page a Graphics object
    */
   @Override
   public void paintComponent (Graphics page)
   {
      super.paintComponent(page);
      Iterator iterator = balloons.iterator();
      while (iterator.hasNext()) {
         ((Drawable)iterator.next()).draw(page);  
      }
   }
}

