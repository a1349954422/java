package chapter8.BlackJack1.code;

import javax.swing.*;
import java.awt.*;

public class BlackJack extends JFrame {

    public BlackJack()  {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Blackjack");
        setSize(Consts.CV_WIDTH + Consts.DECK_LEN,Consts.TOP_BAR_HEIGHT + Consts.BOARD_H + Consts.GAMBLER_Y);
        GameCanvas gameCanvas = new GameCanvas();
        add(gameCanvas);
        setVisible(true);
    }

}
