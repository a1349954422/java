package chapter8.pokeGame.code;

import javax.swing.*;
import java.awt.*;

public class PokeGames extends JFrame {

    public PokeGames()  {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,500);
        setTitle("Poke Game");
        GameCanvas gameCanvas = new GameCanvas();
        add(gameCanvas);
        setVisible(true);
    }
}
