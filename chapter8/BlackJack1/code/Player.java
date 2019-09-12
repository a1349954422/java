package chapter8.BlackJack1.code;

import java.awt.*;
import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> hands;
    private int handsValue1;
    private int handsValue2;
    private int status;
    private int numAce;

    private ArrayList<Chip> chips;
    private int chipsValue;
    private int totalAmount;

    private Deck deck;

    public Player() {
        //initPlayer();
    }

    public void initPlayer() {
        hands = new ArrayList<>();
        numAce = 0;
        handsValue1 = 0;
        handsValue2 = 0;
        status = Consts.COMPARE1;
        chipsValue = 0;
        chips = new ArrayList<>();
    }

    public void assignHand(boolean faceUp,int y){
        Card card = deck.dealCard();
        card.setFaceCard(faceUp);
        if(hands.isEmpty()){
            card.setX(Consts.CARD_X);
        }else {
            int tempX = (hands.get(hands.size() - 1)).getX();
            card.setX(tempX + Consts.CARD_GAP);
        }
        card.setY(y);
        hands.add(card);
        if(card.getValue() == 11){
            numAce++;
        }
        handsValue1 += card.getValue();
        if(numAce > 0){
            handsValue2 = handsValue1 - numAce * 10;
        }
        if((handsValue1 == Consts.V_BLACKJACK) || (handsValue2 == Consts.V_BLACKJACK)){
            status = Consts.BLACKJACK;
        }else if((handsValue1 > Consts.V_BLACKJACK) && (handsValue2 > Consts.V_BLACKJACK)){
            status = Consts.BUSTED;
        }else if((handsValue1 > Consts.V_BLACKJACK) && (handsValue2 == 0)){
            status = Consts.BUSTED;
        }else if((handsValue1 > Consts.V_BLACKJACK) && (handsValue2 < Consts.V_BLACKJACK)){
            status = Consts.COMPARE2;
        }else if(handsValue1 < Consts.V_BLACKJACK){
            status = Consts.COMPARE1;
        }
    }

    public void paintHand(Graphics2D g2D){
        for (int i = 0; i < hands.size(); i++) {
            hands.get(i).paintCard(g2D);
        }
    }


    public int assignChips(int chipValue) {
        totalAmount -= chipValue;
        if(totalAmount >= 0){
            Chip chip = new Chip();
            chip.initChip(chipValue);
            chip.setX((int)((Math.random()) * Consts.CHIP_MINY) + Consts.CHIP_MINX);
            chip.setY((int)((Math.random()) * Consts.CHIP_RANGE_Y) + Consts.CHIP_MINY);
            chips.add(chip);
            chipsValue += chipValue;
        }else {

        }
        return totalAmount;
    }


    public void paintChips(Graphics2D g2d) {
        for (int i = 0; i < chips.size(); i++) {
            chips.get(i).paintChip(g2d);
        }
        g2d.drawString("" + chipsValue, Consts.CHIPS_VALUE_X,Consts.CHIPS_VALUE_Y );
    }

    public int getChipsValue() {
        return chipsValue;
    }

    public int gethandsValue1() {
        return handsValue1;
    }

    public int gethandsValue2() {
        return handsValue2;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Card> getHands() {
        return hands;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getTotalAmount() {
        return totalAmount;
    }
}
