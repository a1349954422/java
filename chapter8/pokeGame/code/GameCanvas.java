package chapter8.pokeGame.code;


import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {
    private Player player;
    private Player computer;
    private Player gameZone;

    private Board board;
    private PlayPanel playPanel;
    private Deck deck;

    public GameCanvas() {
        setLayout(new BorderLayout());
        player = new Player();
        computer = new Player();
        gameZone = new Player();
        initComponent();
    }

    private void initComponent() {
        board = new Board();
        board.setPlayer(player);
        board.setComputer(computer);
        board.setGameZone(gameZone);

        playPanel = new PlayPanel();
        deck = new Deck();
        playPanel.setBoard(board);
        playPanel.setDeck(deck);
        playPanel.setPlayer(player);
        playPanel.setComputer(computer);
        playPanel.setGameZone(gameZone);

        initPlayer();
        add(board,BorderLayout.CENTER);
        add(playPanel,BorderLayout.SOUTH);
    }

    private void initPlayer() {
        player.setHandCard();
        player.setDeck(deck);
        player.setBoard(board);
        player.setPlayPanel(playPanel);

        computer.setHandCard();
        computer.setDeck(deck);
        computer.setBoard(board);
        computer.setPlayPanel(playPanel);

        gameZone.setHandCard();
        gameZone.setBoard(board);
        gameZone.setPlayPanel(playPanel);
    }
}
