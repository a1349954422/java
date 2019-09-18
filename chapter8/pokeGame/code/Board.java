package chapter8.pokeGame.code;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    private Player player;
    private Player computer;
    private Player gameZone;

    private boolean continueFlag;
    private boolean newGameFlag;

    public Board() {
        continueFlag = false;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setFont(new Font("Times",Font.BOLD,15));
        g2d.drawString("computer:", 5, 20);
        g2d.drawString("GameZone",5,150);
        g2d.drawString("player", 5,300 );
        if(newGameFlag){
            player.paintPlayerHand(g2d);
            computer.paintComputerHand(g2d);
            gameZone.paintGameZoneHand(g2d);
            setNewGameFlag(false);
        }
        if(continueFlag){
            player.paintPlayerHand(g2d);
            computer.paintComputerHand(g2d);
            gameZone.paintGameZoneHand(g2d);
            setContinueFlag(false);
        }
    }

    public void setContinueFlag(boolean b) {
        continueFlag = b;
    }

    public void setNewGameFlag(boolean b) {
        newGameFlag = b;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setComputer(Player computer) {
        this.computer = computer;
    }

    public void setGameZone(Player gameZone) {
        this.gameZone = gameZone;
    }
}
