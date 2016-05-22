import java.awt.event.*;

public class myAction implements ActionListener {
    // this class defines the behavior of the buttons made in
    // the gui class, hence, the latter class must be declared
    // in order to gain access to those buttons
    private gui myGUI;

    public myAction(gui getLogGUI) {
        // instantiates myGUI with the values of gui
        myGUI = getLogGUI;
    }

    public void actionPerformed(ActionEvent e) {

        result a = new result(myGUI.getComplete(), myGUI.getButtonA());

        // action for quit button
        if (e.getActionCommand() == "Quit") {
            System.exit(0);

            // action for new button
        } else if (e.getActionCommand() == "New") {
            myGUI.setPlayerMode(a.selectMode());
            // does nothing if cancel is chosen in selecting modes
            if (myGUI.getPlayerMode() < 2) {
                for (int i = 1; i < 17; i++) {
                    myGUI.getButton(i).setText("");
                    myGUI.getButton(i).setEnabled(true);

                }
                myGUI.setComplete(false);
                myGUI.setLeftBoxes(16);
                if (myGUI.getPlayerMode() == 0) {
                }
            }

            // action for the other buttons (the ones to mark with X or O)
        } else {
            myGUI.reduceLeftBoxes(); // if one cell is clicked, then one less
            // remaining un-clicked cells
            if (myGUI.getPlayerMode() == 0) { // 2 player mode
                for (int i = 1; i < 17; i++) {

                    if (e.getSource().equals(myGUI.getButton(i))) {
                        if (myGUI.getXTurn()) {
                            myGUI.getButton(i).setText("X");
                            myGUI.getButton(i).setEnabled(false);
                            myGUI.getButton(0).setText("O Turn");
                            myGUI.setXTurn(false);
                        } else if (myGUI.getXTurn() == false) {
                            myGUI.getButton(i).setText("O");
                            myGUI.getButton(i).setEnabled(false);
                            myGUI.setXTurn(true);
                            myGUI.getButton(0).setText("X Turn");
                        }
                    }
                }
            }

            myGUI.setComplete(a.preWin()); // checking for win

            if (myGUI.getLeftBoxes() == 0 && myGUI.getComplete() == false) {
                a.declareDraw();
            }
        }

    }

}
