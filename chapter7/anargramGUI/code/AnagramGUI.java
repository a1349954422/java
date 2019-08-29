package chapter7.anargramGUI.code;

import javax.swing.*;
import java.awt.*;

public class AnagramGUI extends JFrame {

    public AnagramGUI()  {
        setTitle("Anagram");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Consts.CV_WIDTH,Consts.BOARD_H + Consts.PLAYER_PANEL_H + 50);

        GameCanvas gameCanvas = new GameCanvas();
        add(gameCanvas);
        setVisible(true);
    }
}
