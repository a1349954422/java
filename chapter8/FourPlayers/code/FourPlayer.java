package chapter8.FourPlayers.code;

import javax.swing.*;
import java.awt.*;

public class FourPlayer extends JFrame {

    public FourPlayer()  {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Poke game");
        setSize(600,600);
        GameCanvas gameCanvas = new GameCanvas();
        add(gameCanvas);
        setVisible(true);
    }
}
