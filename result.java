import javax.swing.*;

// this class contains the check if the game is over
public class result {
    private boolean resultGameFinished;
    private JButton resultB[];

    public result(boolean getIsGameFinished, JButton getB[]) {
        resultB = getB;
        resultGameFinished = getIsGameFinished;
    }

    public boolean preWin() {
        for (int i = 1; i <= 14; i++) {
            if (resultGameFinished == false) {
                if (i == 1) {
                    // checking for diagonal win
                    checkWin(i, i + 5, i + 10, i+15);
                }
                if (i <= 3) {
                    // checking for column win
                    checkWin(i, i + 4, i + 8, i+12);
                }
                if (i == 1 || i == 5 || i == 9) {
                    // checking for row win
                    checkWin(i, i + 1, i + 2, i+3);
                }
                if (i == 4) {
                    // checking for inverse diagonal win
                    checkWin(i, i + 3, i + 6, i+9);
                }
            }
        }
        return resultGameFinished;
    }

    public void checkWin(int w, int x, int y, int z) {
        // checking if X wins
        if (resultB[w].getText().equals("X")){
        	if (resultB[x].getText().equals("X")) {
        		if (resultB[y].getText().equals("X")) {
        			if (resultB[z].getText().equals("X")) {
        				declareResult("X");
        				}
        			}
        		}
        	}
        // checking if O wins
        if (resultB[w].getText().equals("O")){
        	if (resultB[x].getText().equals("O")) {
        		if (resultB[y].getText().equals("O")) {
        			if (resultB[z].getText().equals("O")) {
        				declareResult("O");
        				}
        			}
        		}
        	}
        }

    public void declareResult(String i) {
        if (resultGameFinished == false) {
            JOptionPane.showMessageDialog(null, i + " wins!");
            for (int j = 1; j < 17; j++) {
                resultB[j].setEnabled(false);
            }
            resultGameFinished = true;
        }
    }

    // when game is draw
    public void declareDraw() {
        JOptionPane.showMessageDialog(null, "Draw!");
        resultGameFinished = true;
    }

    public int selectMode() {
        Object[] options = {"Two-Player Mode", "Cancel" };
        int n = JOptionPane.showOptionDialog(null,
                "Please select a game mode:", "Game Mode",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);
        return n;
    }
}
