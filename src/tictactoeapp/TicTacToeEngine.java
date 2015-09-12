package tictactoeapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Olzhas Kurenov
 */
public class TicTacToeEngine implements ActionListener {

  private final TicTacToe parent;
  private boolean currentPlayer = false;
  private int actionCount = 0;

  public TicTacToeEngine(TicTacToe t) {
    parent = t;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (actionCount >= 8) {
      JOptionPane.showConfirmDialog(null, "Nobody won. Try Again", "No Winner", JOptionPane.PLAIN_MESSAGE);
      resetGame();
    }
    else {
      JButton src = (JButton) e.getSource();
    if (currentPlayer) {
      src.setText("X");
    } else {
      src.setText("O");

    }
    src.setEnabled(false);
    togglePlayer();
    checkWhoWins();
    actionCount++;
    }    
  }

  private void togglePlayer() {
    currentPlayer = !currentPlayer;
    if (currentPlayer) {
      parent.setMessage("Player X, your turn.");
    } else {
      parent.setMessage("Player O, your turn.");
    }
  }

  private void checkWhoWins() {
    
    int offset;
    String winner = "";
    JButton[] btns = parent.btnArray;
    //Check for vertical and horizonal lines
    for (int i = 0; i < 3; i++) {
      offset = i * 3;
      //checks for vertical lines
      if ((btns[i].getText().equals(btns[i + 3].getText())) && (btns[i + 3].getText().equals(btns[i + 6].getText()))) {
        winner = btns[i].getText();
      } //checks for horizontal lines
      else if ((btns[offset].getText().equals(btns[offset + 1].getText())) && (btns[offset + 1].getText().equals(btns[offset + 2].getText()))) {
        winner = btns[offset].getText();
      }
    }

    //check for diagonals
    if (winner.equals("")) {
      //checks for left diagonal      
      if ((btns[6].getText().equals(btns[4].getText())) && (btns[4].getText().equals(btns[2].getText()))) {
        winner = btns[4].getText();
      } //checks for right diagonal
      else if ((btns[0].getText().equals(btns[4].getText())) && (btns[4].getText().equals(btns[8].getText()))) {
        winner = btns[4].getText();
      }
    }

    if (!winner.equals("")) {
      JOptionPane.showConfirmDialog(null, "Player " + winner + " won!", "Winner", JOptionPane.PLAIN_MESSAGE);
      resetGame();
    }
  }

  private void resetGame() {
    actionCount = 0;
    for (JButton btnArray : parent.btnArray) {
      btnArray.setText("");
      btnArray.setEnabled(true);
    }
  }

}
