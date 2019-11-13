package chapter9.SudokuGame;

import java.awt.*;

public class Board {
    private Cell[][] sudokuBoard;
    private CursorMark cursorMark;

    public Board() {
        sudokuBoard = new Cell[Consts.MAX_CELLS][Consts.MAX_CELLS];
        initBoard();
    }

    public void initBoard() {
        Cell aCell;
        int x, y;
        int xInit = Consts.LEFT_M;
        int yInit = Consts.TOP_M;

        for (int row = 0; row < Consts.MAX_CELLS; row++) {
            y = yInit + row * Consts.CELL_H;
            for(int col = 0; col < Consts.MAX_CELLS; col++ ){
                x = xInit + col * Consts.CELL_W;
                aCell = new Cell();
                aCell.setX(x);
                aCell.setY(y);
                sudokuBoard[row][col] = aCell;
            }
        }
    }

    public void paintBoard(Graphics2D g2d){
        for(int row = 0; row < Consts.MAX_CELLS; row++){
            for(int col = 0; col < Consts.MAX_CELLS; col++){
                sudokuBoard[row][col].paintCell(g2d);
            }
        }
        cursorMark.paintCursor(g2d);
    }

    public int checkGuessed(){
        int correct = 0, inCorrect = 0;
        Cell theCell;
        for(int row = 0; row < Consts.MAX_CELLS; row++){
            for(int col = 0;col < Consts.MAX_CELLS; col++){
                theCell = sudokuBoard[row][col];
                if(!theCell.isVisable()){
                    if(theCell.getGuessed() == theCell.getDight()){
                        theCell.setGuessCorrect(true);
                        correct++;
                    }else {
                        inCorrect++;
                    }
                }
            }
        }
        return (int)(((correct * 1.0) / correct + inCorrect) * 100);
    }

    public void setGuessDigit(int row, int col, int dight){
        sudokuBoard[row][col].setGuessed(dight);
    }

    public Cell[][] getsudokuBoard() {
        return sudokuBoard;
    }

    public void setCursorMark(CursorMark cursorMark) {
        this.cursorMark = cursorMark;
        Cell aCell = getsudokuBoard()[0][0];
        this.cursorMark.setBounds(aCell.getX(), aCell.getY(),aCell.getWidth(), aCell.getHeight());
        this.cursorMark.setLocation((int) getsudokuBoard()[0][0].getX(),(int) getsudokuBoard()[0][0].getY());
    }
}
