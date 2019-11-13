package chapter9.SudokuGame;

import javax.swing.*;

public class Sudoku extends JFrame {

    public Sudoku() {
        setTitle("Sudoku");
        setSize(Consts.CV_WIDTH, Consts.CV_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GameCanvas gameCanvas = new GameCanvas();
        add(gameCanvas);

        setVisible(true);
    }

}
