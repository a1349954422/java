package chapter7.CountGames;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {
    private Playerp playerp;
    private Board board;

    public GameCanvas() {
        setPreferredSize(new Dimension(Consts.CV_WIDTH,Consts.PLAYER_PANEL_H + Consts.BOARD_H));
        this.setLayout(new BorderLayout());
        board = new Board();
        playerp = new Playerp();
        initCanvas();
    }

    private void initCanvas() {
        initPlayerP();
        initBoards();

    }

    private void initBoards() {
        board.setPlayerp(playerp);
        add(board,BorderLayout.SOUTH);
    }

    private void initPlayerP() {
        add(playerp,BorderLayout.NORTH);
        playerp.setBoard(board);

    }
}
