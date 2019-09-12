package chapter8.BlackJack1.code;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {

    private Player dealer;
    private Player gambler;
    private boolean newGameFlag;
    private boolean standFlag;
    private boolean betFlag;

    public Board() {
        initBoard();
    }

    private void initBoard() {
        newGameFlag = false;
        standFlag = false;
        betFlag = false;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;

        g2d.setColor(Color.RED);
        g2d.drawRect(Consts.MINX, Consts.MINY, Consts.CV_WIDTH, Consts.BOARD_H);
        g2d.setColor(Color.BLUE);
        g2d.setFont(new Font("Times",Font.BOLD, 22));
        g2d.drawString("Dealer",10,60);
        g2d.drawString("gambler",10,190);

        if(newGameFlag){
            dealer.paintHand(g2d);
            gambler.paintHand(g2d);
            if(gambler.gethandsValue2() == 0){
                g2d.drawString("" + gambler.gethandsValue1(),Consts.VALUE_X,Consts.GAMBLER_V_Y);
            }else {
                g2d.drawString("" + gambler.gethandsValue1() + "(" + gambler.gethandsValue2() + ")" ,Consts.VALUE_X,Consts.GAMBLER_V_Y);
            }
            int specStatus = gambler.getStatus();
            if(specStatus == Consts.BLACKJACK){
                g2d.drawString("BLACKJACK", Consts.STATUS_X, Consts.GAMBLER_S_Y);
            }else if(specStatus == Consts.BUSTED) {
                g2d.drawString("BUSTED", Consts.STATUS_X, Consts.GAMBLER_S_Y);
            }
        }
        if(standFlag){
            if(dealer.gethandsValue2() == 0){
                g2d.drawString("" + dealer.gethandsValue1(), Consts.VALUE_X, Consts.DEALER_V_Y);
            }else{
                g2d.drawString("" + dealer.gethandsValue1() + "(" + dealer.gethandsValue2() + ")",
                        Consts.VALUE_X, Consts.DEALER_V_Y);
            }

            int specStatus = dealer.getStatus();
            if(specStatus == Consts.BLACKJACK){
                g2d.drawString("Blackjack", Consts.STATUS_X, Consts.DEALER_S_Y);
            }else if(specStatus == Consts.BUSTED){
                g2d.drawString("Busted",Consts.STATUS_X, Consts.DEALER_S_Y);
            }

            int ds = dealer.getStatus();
            int gs = gambler.getStatus();
            if(ds == Consts.WON){
                g2d.drawString("Won",Consts.STATUS_X, Consts.DEALER_S_Y);
            }else if(ds == Consts.PUSHED){
                g2d.drawString("PUSHED", Consts.STATUS_X, Consts.DEALER_S_Y);
                g2d.drawString("PUSHED", Consts.STATUS_X, Consts.GAMBLER_S_Y);
            }else if(gs == Consts.WON){
                g2d.drawString("Won", Consts.STATUS_X, Consts.GAMBLER_S_Y);
            }
        }
        if(betFlag){
            gambler.paintChips(g2d);
        }
    }
    public void setNewGameFlag(boolean b) {
        this.newGameFlag = b;
    }

    public void setStandFlag(boolean b) {
        this.standFlag = b;
    }


    public boolean isStandFlag() {
        return standFlag;
    }

    public void setBetFlag(boolean b) {
        this.betFlag = b;
    }

    public void setReset() {
        newGameFlag = false;
        standFlag = false;
        betFlag = false;
    }

    public void setDealer(Player dealer) {
        this.dealer = dealer;
    }

    public void setGambler(Player gambler) {
        this.gambler = gambler;
    }
}
