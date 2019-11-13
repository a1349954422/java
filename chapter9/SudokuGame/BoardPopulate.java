package chapter9.SudokuGame;

import java.awt.*;
import java.util.Random;

public class BoardPopulate {
    private Random random;
    private Cell[][] validBoard;
    private int[] alreadyTested;
    private boolean allTested;
    private int  diffLevel;
    private Board board;

    public BoardPopulate() {
        random = new Random();
        alreadyTested = new int[9];
    }

    public void populateBoard(){
        int aDight = 0;
        boolean stop;

        for(int row = 0; row < Consts.MAX_CELLS; row++){
            for(int col = 0; col < Consts.MAX_CELLS; col++){
                initAry(alreadyTested);
                allTested = false;
                stop = false;
                while(!stop){
                    aDight = Math.abs(random.nextInt() % 9) + 1;
                    if((isNewDight(aDight, alreadyTested)) && (!allTested)){
                        if((validRow(aDight, row, col))
                                && (validColumn(aDight, row, col))
                                && validMiniBoaard(aDight, row, col)) {
                            stop = true;
                        }
                        }else if(allTested ){
                            stop = true;
                        }
                    }
                    if(!allTested){
                        insertDight(aDight, row, col);
                    }else {
                        board.initBoard();
                        row = 0;
                        col = -1;
                    }
                }
            }
        hideCell(diffLevel);
    }

    private boolean isNewDight(int aValue, int[] ary) {
        if(ary[ary.length - 1] != 0){
            allTested = true;
            return false;
        }
        for(int i = 0; i < ary.length; i++){
            if(ary[i] == aValue){
                return false;
            }else if(ary[i] == 0){
                ary[i] = aValue;
                break;
            }
        }
        return true;
    }

    private void initAry(int[] ary) {
        for (int i = 0; i < Consts.MAX_CELLS; i++) {
            ary[i] = 0;
        }
    }

    private boolean validRow(int aValue, int row, int col) {
        for (int i = 0; i < col; i++) {
            if(validBoard[row][i].getDight() == aValue){
                return false;
            }
        }
        return true;
    }

    private boolean validColumn(int aValue, int row, int col) {
        for (int i = 0; i < row; i++) {
            if(validBoard[i][col].getDight() == aValue){
                return false;
            }
        }
        return true;
    }

    private boolean validMiniBoaard(int aValue, int row, int col) {
        Cell[][] vMini = copyMiniBoard(row, col);
        int dight;
        for(int mRow = 0; mRow < 3; mRow++){
            for(int mCol = 0; mCol < 3; mCol++){
                dight = vMini[mRow][mCol].getDight();
                if((dight != 0) && (dight == aValue)){
                    return false;
                }
            }
        }
        return true;
    }

    private Cell[][] copyMiniBoard(int row, int col) {
        Cell[][] aMini = new Cell[3][3];
        if(row < 3 && col < 3){
            for (int mRow = 0; mRow < 3; mRow++) {
                System.arraycopy(validBoard[mRow], 0, aMini[mRow], 0, 3);
            }
        }else if(col > 2  && col < 6 && row < 3){
            for (int mRow = 0; mRow < 3; mRow++) {
                for (int mCol = 0; mCol < 3; mCol++) {
                    aMini[mRow][mCol] = validBoard[mRow][mCol + 1 * 3];
                }
            }
        }else if(col > 5 &&  row < 3){
            for (int mRow = 0; mRow < 3; mRow++) {
                for (int mCol = 0; mCol < 3; mCol++) {
                    aMini[mRow][mCol] = validBoard[mRow][mCol + 2 * 3];
                }
            }
        }else if(row > 2 && row < 6 && col < 3){
            for(int mRow = 0; mRow < 3; mRow++){
                System.arraycopy(validBoard[mRow + 1 * 3], 0, aMini[mRow], 0, 3);
            }
        }else if(row > 2 && row < 6 && col > 2 && col < 6){
            for(int mRow = 0; mRow < 3; mRow++){
                for(int mCol = 0; mCol < 3; mCol++){
                    aMini[mRow][mCol] = validBoard[mRow + 1 * 3][mCol + 1 * 3];
                }
            }
        }else if(row > 2 && col > 5 && row < 6){
            for(int mRow  = 0; mRow < 3; mRow++){
                for(int mCol = 0; mCol < 3; mCol++){
                    aMini[mRow][mCol] = validBoard[mRow + 1 * 3][mCol + 2 * 3];
                }
            }
        }else if(row > 5 && col < 3){
            for (int mRow = 0; mRow < 3; mRow++) {
                for (int mCol = 0; mCol < 3; mCol++) {
                    System.arraycopy(validBoard[mRow + 2 * 3], 0, aMini[mRow], 0, 3);
                }
            }
        }else if(row > 5 && col > 2 && col < 6){
            for(int mRow = 0; mRow < 3; mRow++){
                for(int mCol = 0; mCol < 3; mCol++){
                    aMini[mRow][mCol] = validBoard[mRow + 2 * 3][mCol + 1 * 3];
                }
            }
        }else{
            for(int mRow = 0; mRow < 3; mRow++){
                for(int mCol = 0; mCol < 3; mCol++){
                    aMini[mRow][mCol] = validBoard[mRow + 2 * 3][mCol + 2 * 3];
                }
            }
        }
        return aMini;
    }


    private void insertDight(int aValue, int row, int col) {
        validBoard[row][col].setDight(aValue);
    }

    private void hideCell(int level) {
        int numCell = 5;
        if(level == Consts.EASY){
            numCell = Math.abs(random .nextInt() % 11) + 5;
        }else if(level == Consts.MEDIUM){
            numCell = Math.abs(random.nextInt() % 15) + 16;
        }else if(level == Consts.HARD){
            numCell = Math.abs(random.nextInt() % 20) + 31;
        }

        for (int i = 0; i < numCell; i++) {
            int ranRow = Math.abs(random.nextInt() % 9);
            int ranCol = Math.abs(random.nextInt() % 9);
            validBoard[ranRow][ranCol].setVisable(false);
        }
    }

    public void setBoard(Board board) {
        this.board = board;
        validBoard = this.board.getsudokuBoard();
    }

    public void setDiffLevel(int diffLevel) {
        this.diffLevel = diffLevel;
    }
}
