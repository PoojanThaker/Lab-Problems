package System;

import javax.swing.JFrame;

import javax.swing.WindowConstants;
/**
 * 
 * @author Poojan Thaker
 *
 */
public class Main
{

    public static void main(String[] args)
    {
        GameBoard gameBoard = new GameBoard();
        JFrame frame = new JFrame("NEED FOR SPEED : The Run");
        frame.setSize(Values.SCREEN_WIDTH,Values.SCREEN_HEIGHT);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(gameBoard);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.requestFocus();
        gameBoard.run();
    }
}
