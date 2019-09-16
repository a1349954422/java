package chapter8.FourPlayers.code;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {


    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;
    private String maxOwner = null;

    private PlayPanel playPanel;

    private boolean newGameFlag = false;

    public Board() {
    }

    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;

        g2d.setColor(Color.RED);
        g2d.drawRect(0,0,550,340);
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Times",Font.BOLD,15));
        g2d.drawString("player1", 240,15);
        g2d.drawString("player2", 15,150);
        g2d.drawString("player3", 450,150);
        g2d.drawString("player4", 240,320);

        if(newGameFlag){
            player1.paintHand(g2d, 0);
            player2.paintHand(g2d, 0);
            player3.paintHand(g2d, 0);
            player4.paintHand(g2d, 0);


            int p1Value = player1.getHandValue();
            int p2Value = player2.getHandValue();
            int p3Value = player3.getHandValue();
            int p4Value = player4.getHandValue();
            deterWiner(p1Value, p2Value, p3Value, p4Value);
            newGameFlag = false;
        }

    }

    private void deterWiner(int p1Value, int p2Value, int p3Value, int p4Value) {
        int max = 0;
            if (max < p1Value) {
                max = p1Value;
                maxOwner = "player1";
            }
            if (max < p2Value) {
                max = p2Value;
                maxOwner = "player2";
            }
            if (max < p3Value) {
                max = p3Value;
                maxOwner = "player3";
            }
            if (max < p4Value) {
                max = p4Value;
                maxOwner = "player4";
            }
            if(((p1Value == max) && (p2Value == max)) || ((p1Value == max) && (p3Value == max)) || ((p1Value == max) && (p4Value == max)) || ((p2Value == max) && (p3Value == max)) ||((p2Value == max) && (p4Value == max)) || ((p3Value == max) && (p4Value == max)) ){
                playPanel.setMsg("no one won the game");
            }else {
                playPanel.setMsg("the winer is " + maxOwner );
            }

    }

    public boolean isNewGameFlag() {
        return newGameFlag;
    }

    public void setNewGameFlag(boolean newGameFlag) {
        this.newGameFlag = newGameFlag;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public void setPlayer3(Player player3) {
        this.player3 = player3;
    }

    public void setPlayer4(Player player4) {
        this.player4 = player4;
    }

    public void setPlayPanel(PlayPanel playPanel) {
        this.playPanel = playPanel;
    }
}
