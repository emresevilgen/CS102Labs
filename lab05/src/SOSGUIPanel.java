import javax.swing.*;
import cs101.sosgame.SOS;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
/**
 * SOSGUIPanel class that extends JPanel
 * @author Munib Emre Sevilgen 
 * @version 1.00 02.04.2018
 */ 
public class SOSGUIPanel extends JPanel 
{
   // properties
   private SOS sos;
   private SOSCanvas canvas;
   private JPanel labelPanel;
   private JLabel player1Label;
   private JLabel player2Label;
   private JPanel buttonPanel;
   private JPanel timePanel;
   private ButtonGroup group;
   private JRadioButton sButton;
   private JRadioButton oButton;
   private String playerName1;
   private String playerName2;
   private final int size = 500;
   private Timer time;
   private int elapsedTime;
   private JLabel timeLabel;
   private final String fileName = "HighScore.sos";
   private File file;
   private int highScore;
   private Scanner scan;
   private JLabel highScoreLabel;
   
   
   // constructors
   public SOSGUIPanel( SOS sos, String playerName1, String playerName2) {
      this.sos = sos;
      canvas = new SOSCanvas( sos, size);
      this.setLayout( new BorderLayout());
      labelPanel = new JPanel();
      labelPanel.setLayout( new BorderLayout());
      this.playerName1 = playerName1;
      this.playerName2 = playerName2;
      player1Label = new JLabel( playerName1 + ": " + sos.getPlayerScore1());
      player1Label.setBackground( Color.green);
      player2Label = new JLabel( playerName2 + ": " + sos.getPlayerScore2());
      player2Label.setBackground( Color.green);
      player1Label.setOpaque(true);
      player2Label.setOpaque(false);
      sButton = new JRadioButton ( "S" , true);
      oButton = new JRadioButton ( "O" , false);
      labelPanel.add( player1Label, BorderLayout.WEST);
      buttonPanel = new JPanel();
      group = new ButtonGroup();
      group.add( sButton);
      group.add( oButton);
      buttonPanel.setLayout( new FlowLayout());
      buttonPanel.add( sButton);
      buttonPanel.add( oButton);
      labelPanel.add( buttonPanel, BorderLayout.CENTER);
      labelPanel.add( player2Label, BorderLayout.EAST);
      this.add( canvas, BorderLayout.CENTER);
      this.add( labelPanel, BorderLayout.SOUTH);
      addMouseListener( new SOSMouseAdapter());
      // Gets high score
      file = new File( fileName);
      try {
         scan = new Scanner( file);
      }
      catch (Exception e) {
         System.out.println( e);
      }
      if ( file.exists()) {
         highScore = scan.nextInt();
         file.delete();
      }
      else {
         try {
            file.createNewFile();
            System.setOut( new PrintStream( fileName ) );
         }
         catch (Exception e) {
            System.out.println( e);
         }
         System.out.println( 0);
      }
      highScoreLabel = new JLabel( "High Score: " + highScore);
      time = new Timer( 1000, new SOSTime());
      elapsedTime = 0;
      timeLabel = new JLabel("Time: " + elapsedTime);
      timePanel = new JPanel();
      timePanel.setLayout( new BorderLayout());
      timePanel.add( timeLabel, BorderLayout.WEST);
      timePanel.add( highScoreLabel, BorderLayout.EAST);
      this.add( timePanel, BorderLayout.NORTH);
      time.start();
      repaint();
   }
   
   /**
    * SOSTime class implements ActionListener
    */
   public class SOSTime implements ActionListener {
      /**
       * Overrides actionPerformed for time
       * @param e ActionEvent
       */ 
      public void actionPerformed( ActionEvent e) {
         elapsedTime++;
         timeLabel.setText("Time: " + elapsedTime);
         repaint();
      }
   }
   /**
    * SOSMouseAdapter class extends MouseAdapter
    */
   public class SOSMouseAdapter extends MouseAdapter {
      /**
       * Overrides mouseClicked to get x and y
       * @param e ActionEvent
       */ 
      public void mouseClicked( MouseEvent e) {
         int x = e.getX();
         int y = e.getY();
         int column;
         int row;
         int scoreUpdate;
         int gridNumber;
         // Gets the x and y
         x = e.getX();
         y = e.getY();
         // Calculates the row and column that x and y locates at this row and column
         gridNumber = sos.getDimension();
         column = (int)(x / (size / gridNumber)) + 1;
         row = (int)(y / (size / gridNumber)) + 1;
         
         // Checks whether s or o is selected
         if ( sButton.isSelected()) {
            scoreUpdate = sos.play ( 's', row, column);
            // Checks the errors
            if (scoreUpdate != sos.INVALID_ROWCOL && scoreUpdate != sos.ROWCOL_NOT_EMPTY) {
               // Checks the turn is player 1 or player 2
               if ( sos.getTurn() == 1) {
                  player1Label.setText( playerName1 + ": " + sos.getPlayerScore1());
               }
               else {
                  player2Label.setText( playerName2 + ": " + sos.getPlayerScore2());
               }
            }
            // Cell is not empty error
            else if ( scoreUpdate != sos.INVALID_ROWCOL)
               JOptionPane.showMessageDialog( null, "The cell is not empty" );
         }
         else {
            scoreUpdate = sos.play ( 'o', row, column);
            if (scoreUpdate != sos.INVALID_ROWCOL && scoreUpdate != sos.ROWCOL_NOT_EMPTY) {
               if ( sos.getTurn() == 1) {
                  player1Label.setText( playerName1 + ": " + sos.getPlayerScore1());
               }
               else {
                  player2Label.setText( playerName2 + ": " + sos.getPlayerScore2());
               }
            }
            else if ( scoreUpdate != sos.INVALID_ROWCOL)
               JOptionPane.showMessageDialog(null, "The cell is not empty" );
         }
         
         // Makes the label green or white
         if (sos.getTurn() == 1) {
            player1Label.setOpaque(true);
            player2Label.setOpaque(false);
         }
         else {
            player2Label.setOpaque(true);
            player1Label.setOpaque(false);
         }
         repaint();
         
         // If game is over then shows a popup
         if ( sos.isGameOver()) {
            // Checks who wins
            if ( sos.getPlayerScore1() > sos.getPlayerScore2()) {
               JOptionPane.showMessageDialog(null, playerName1 + " wins." );
               // Checks the high score
               if ( sos.getPlayerScore1() > highScore) {
                  highScore = sos.getPlayerScore1();
                  try {
                     file.createNewFile();
                     System.setOut( new PrintStream( fileName ) );
                  }
                  catch (Exception d) {
                     System.out.println( d);
                  }
                  System.out.println( highScore);
                  JOptionPane.showMessageDialog(null, playerName1 + " got high score: " + highScore );
               }
            }
            else if (sos.getPlayerScore2() > sos.getPlayerScore1()) {
               JOptionPane.showMessageDialog(null, playerName2 + " wins." );
               if ( sos.getPlayerScore2() > highScore) {
                  highScore = sos.getPlayerScore2();
                  try {
                     file.createNewFile();
                     System.setOut( new PrintStream( fileName ) );
                  }
                  catch (Exception d) {
                     System.out.println( d);
                  }
                  System.out.println( highScore);
                  JOptionPane.showMessageDialog(null, playerName2 + " got high score: " + highScore );
               }
            }
            // Draw result
            else {
               JOptionPane.showMessageDialog(null, "It's a draw." );
               if ( sos.getPlayerScore1() > highScore) {
                  highScore = sos.getPlayerScore1();
                  try {
                     file.createNewFile();
                     System.setOut( new PrintStream( fileName ) );
                  }
                  catch (Exception d) {
                     System.out.println( d);
                  }
                  highScore = sos.getPlayerScore1();
                  System.out.println( highScore);
                  JOptionPane.showMessageDialog(null, "You both got high score: " + highScore );
               }
            }
            highScoreLabel.setText("High Score: " + highScore);
            repaint();
         }
      }      
   }
}