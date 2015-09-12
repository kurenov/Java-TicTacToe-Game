package tictactoeapp;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Olzhas Kurenov
 * Simple TicTacToe Game
 */
public class TicTacToe {

  private JLabel message;
  protected JButton[] btnArray;
  
  //UI initialization
  public TicTacToe() {

    JFrame window = new JFrame("TicTacToe Game");
    JPanel windowContent = new JPanel(new BorderLayout());
    JPanel buttons = new JPanel(new GridLayout(3, 3));
    
    
    //TTT Engine
    TicTacToeEngine tEngine = new TicTacToeEngine(this);
    
    //North
    JLabel jl = new JLabel("TicTacToe App");
    windowContent.add(jl, BorderLayout.NORTH);

    //Center
    btnArray = new JButton[9];
    
    for(int i=0; i<btnArray.length; i++) {
      btnArray[i] = new JButton();
      btnArray[i].addActionListener(tEngine);
    }
    
    for (JButton btn : btnArray) {
      buttons.add(btn);
    }

    windowContent.add(buttons, BorderLayout.CENTER);

    //South
    message = new JLabel("Your Turn Player 0");
    windowContent.add(message, BorderLayout.SOUTH);    
        
    window.setContentPane(windowContent);
    window.setSize(300, 300);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true);
  }
  
  public void setMessage(String message) {
    this.message.setText(message);
  }
  
  public static void main(String[] args) {    
    TicTacToe ttt = new TicTacToe();    
  }

}
