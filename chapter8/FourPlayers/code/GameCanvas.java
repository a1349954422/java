package chapter8.FourPlayers.code;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;

    private PlayPanel playPanel;
    private Board board;
    private Cards cards;

    public GameCanvas() {
        setLayout(new BorderLayout());
        initComponent();
    }

    private void initComponent() {
        cards = new Cards();
        board = new Board();
        playPanel =  new PlayPanel();
        playPanel.setBoard(board);
        board.setPlayPanel(playPanel);
        initPlayers();
        add(playPanel,BorderLayout.SOUTH);
        add(board,BorderLayout.CENTER);
    }

    private void initPlayers() {
        player1 = new Player();
        player1.initPlayer();
        player1.setCards(cards);
        player2 = new Player();
        player2.initPlayer();
        player2.setCards(cards);
        player3 = new Player();
        player3.initPlayer();
        player3.setCards(cards);
        player4 = new Player();
        player4.initPlayer();
        player1.setCards(cards);




        playPanel.setPlayer1(player1);
        playPanel.setPlayer2(player2);
        playPanel.setPlayer3(player3);
        playPanel.setPlayer4(player4);

        board.setPlayer1(player1);
        board.setPlayer2(player2);
        board.setPlayer3(player3);
        board.setPlayer4(player4);
    }

}
