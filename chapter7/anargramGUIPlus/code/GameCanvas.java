package chapter7.anargramGUI.code;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {
    private ReadFile readFile;
    private Board board;
    private PlayerPanel playerPanel;

    public GameCanvas() {
        setPreferredSize(new Dimension(Consts.CV_WIDTH,Consts.BOARD_H + Consts.PLAYER_PANEL_H));
        this.setLayout(new BorderLayout());

        initComponent();
    }

    private void initComponent() {
        initReadFile();
        initBoard();
        initPlayerPanel();
    }

    private void initReadFile() {
        readFile = new ReadFile();
    }

    private void initBoard() {
        board = new Board();
        board.setReadFile(readFile);
        add(board,BorderLayout.NORTH);
    }

    private void initPlayerPanel() {
        playerPanel = new PlayerPanel();
        add(playerPanel,BorderLayout.SOUTH);
        playerPanel.setReadFile(readFile);
        playerPanel.setBoard(board);
        board.setPlayerPanel(playerPanel);
    }
}
