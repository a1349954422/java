package chapter9.SudokuGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class GameCanvas extends JPanel {
    private Board board;
    private BoardPopulate boardPopulate;
    private CursorMark cursorMark;
    private int diffLevel;
    private NotePanel playerPanel;
    private boolean gameOver = false;

    public GameCanvas() {
        setLayout(new BorderLayout());
        diffLevel = Consts.EASY;
        addKeyListener(new MyKeyAdapter());
        setFocusable(true);
        initComponent();
    }

    private void initComponent() {
        playerPanel = new NotePanel();
        add(playerPanel, BorderLayout.EAST);
        board = new Board();
        initBoardPopulate();
        initCursorMrk();
    }

    private void initBoardPopulate() {
        boardPopulate = new BoardPopulate();
        boardPopulate.setBoard(board);
        boardPopulate.setDiffLevel(diffLevel);
        boardPopulate.populateBoard();
    }

    private void initCursorMrk() {
        cursorMark = new CursorMark();
        board.setCursorMark(cursorMark);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;

        board.paintBoard(g2d);
        cursorMark.paintCursor(g2d);
        if(gameOver){
            paintTerminate(g2d);
        }
    }

    private void paintTerminate(Graphics2D g2d) {
        playerPanel.setVisible(false);
        g2d.drawRect(Consts.PLAYER_P_H + Consts.LEFT_M, Consts.TOP_M,
                Consts.PLAYER_P_W - Consts.LEFT_M, Consts.PLAYER_P_H - 2 * Consts.TOP_M);
        g2d.setFont(new Font("Times",Font.BOLD,24));
        int leftMargin = Consts.PLAYER_P_H + Consts.LEFT_M + 10;
        g2d.drawString("Game Terminates", leftMargin, 2 * Consts.TOP_M);
        int score  = board.checkGuessed();
        score *= diffLevel;
        g2d.setColor(Color.MAGENTA);
        g2d.drawString("Your score is " + score + " ", leftMargin, 4 *Consts.TOP_M);
        g2d.setColor(Color.BLUE);
        g2d.setFont(new Font("Times",Font.BOLD,18));
        g2d.drawString("Press 'N' for new game",leftMargin, 6 * Consts.TOP_M );
        g2d.drawString("Press 'Q' for quit game", leftMargin, 7 * Consts.TOP_M);
        repaint();
    }

    class MyKeyAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent event) {
            switch (event.getKeyCode()) {
                case KeyEvent.VK_E:
                    diffLevel = Consts.EASY;
                    resetBoard(diffLevel);
                    break;
                case KeyEvent.VK_M:
                    diffLevel = Consts.MEDIUM;
                    resetBoard(diffLevel);
                    break;
                case KeyEvent.VK_H:
                    diffLevel = Consts.HARD;
                    resetBoard(diffLevel);
                    break;
                case KeyEvent.VK_UP:
                    cursorMark.updatePosition(Consts.UP);
                    break;
                case KeyEvent.VK_DOWN:
                    cursorMark.updatePosition(Consts.DOWN);
                    break;
                case KeyEvent.VK_LEFT:
                    cursorMark.updatePosition(Consts.LEFT);
                    break;
                case KeyEvent.VK_RIGHT:
                    cursorMark.updatePosition(Consts.RIGHT);
                    break;
                case KeyEvent.VK_C:
                    int score = board.checkGuessed() * diffLevel;
                    break;
                case KeyEvent.VK_N:
                    resetBoard(Consts.EASY);
                    break;
                case KeyEvent.VK_Q:
                    System.exit(0);
                    break;
            }
            repaint();
        }

        private void resetBoard(int diffLevel) {
            boardPopulate.setDiffLevel(diffLevel);
            boardPopulate.populateBoard();
            initCursorMrk();

            playerPanel.setVisible(true);
            gameOver = false;
        }

        public void keyTyped(KeyEvent e) {
            int row = cursorMark.getMoveRow();
            int col = cursorMark.getMoveCol();
            char keyChar = e.getKeyChar();
            if ((keyChar >= '1') && (keyChar <= '9')) {
                int dight = (int) keyChar - 48;
                board.setGuessDigit(row, col, dight);
                if (guessComplete()) {
                    gameOver = true;
                }
            }
            repaint();
        }

        private boolean guessComplete() {
            Cell aCell;
            Cell[][] aBoard = board.getsudokuBoard();
            for (int row = 0; row < Consts.MAX_CELLS; row++) {
                for (int col = 0; col < Consts.MAX_CELLS; col++) {
                    aCell = aBoard[row][col];
                    if ((!aCell.isVisable()) && (aCell.getGuessed() == 0)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
