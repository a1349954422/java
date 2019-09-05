package chapter7.CountGames;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    private GameCanvas gameCanvas;

    public Game() throws HeadlessException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Consts.CV_WIDTH ,Consts.PLAYER_PANEL_H +Consts.BOARD_H);
        setTitle("COUNT GAME");
        gameCanvas = new GameCanvas();
        add(gameCanvas);
        setVisible(true);
    }
}
