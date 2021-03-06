package src;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * MyJFrame class that extends JFrame implements ActionListener
 * @author Munib Emre Sevilgen
 * @version 1.00 26.03.2018
 */ 
public class MyJFrame extends JFrame implements ActionListener
{
   private JButton  button;
   private JLabel statusBar;
   private JPanel p;
   private int prize;
   private JButton [] buttonArray;
   private int count;
   private int dialogResult;
   private int x;
   private int y;
   
   public MyJFrame( int x, int y)
   {    
      this.x = x;
      this.y = y;
      this.setBounds( 0, 0, ((x + 1) * 100), ((y + 1) * 100));
      p = new JPanel();

      this.setLayout( new BorderLayout());
      statusBar = new JLabel("Number of guesses: " + count, JLabel.CENTER);
      
      this.setVisible( true);
      buttonArray = new JButton[ x * y];
      p.setLayout (new GridLayout( y, x, y, x));
      
      // Adding buttons
      for ( int i = 0; i < (x * y) ; i++) {
         button = new JButton();
         buttonArray [i] = button;
         p.add( buttonArray [i]);
         buttonArray [i].setBackground( Color.yellow);
         buttonArray [i].addActionListener( this);
      }
      count = 0;
      
      // Adding panel and label to frame
      this.add( p, BorderLayout.CENTER);   
      this.add( statusBar, BorderLayout.SOUTH);
      
      setBackground(Color.yellow);
      repaint();
      
      // Calculating the random prize number
      prize =  (int)(Math.random() * (x * y)) - 1;
      
   }
   
   /**
    * Overrides actionPerformed method of the ActionListener class
    * @param e an ActionEvent object
    */ 
   public void actionPerformed( ActionEvent e)
   {
      int dialogButton;
      count++;
      statusBar.setText( "Number of guesses: " + count);
      // Checks whether prize at button or not
      if (((JButton)e.getSource()).equals(buttonArray [prize])) {
         JOptionPane.showMessageDialog(null,  "You got it in " + count + " attempts!");        
         
         // Play again option
         dialogButton = JOptionPane.YES_NO_OPTION;
         dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Game Over!", dialogButton);
         
         if ( dialogResult == 1) {
            System.exit(0);
         }
         else {
            
            // Resetting the game
            prize =  (int)(Math.random() * (x * y)) - 1;
            count = 0;
            for ( int i = 0; i < (x * y) ; i++) {
               (buttonArray [i]).setEnabled(true);
               buttonArray [i].setBackground( Color.yellow);
            }
            statusBar.setText( "Number of guesses: " + count);
            repaint();
         }
         
      }
      else {
         // Disables button when clicked
         ((JButton)e.getSource()).setEnabled(false);
         ((JButton)e.getSource()).setBackground( Color.blue);
      }
   }
}
