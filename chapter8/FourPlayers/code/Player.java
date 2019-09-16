package chapter8.FourPlayers.code;

import java.awt.*;
import java.util.ArrayList;

public class Player {
    private int handValue;
    private ArrayList<Card> handCard;
    private Cards cards;
    int x, y;

    public Player() {
        initPlayer();
    }

    public void initPlayer() {
        handCard = new ArrayList<>();
        handCard.clear();
        handValue = 0;
    }

    public void assignHand(int x,int y){
        cards = new Cards();
        Card card = cards.dealCard();
        card.setX(x);
        card.setY(y);
        handCard.add(card);
        handValue = card.getValue();

    }

    public int getHandValue() {
        return handValue;
    }

    public void setCards(Cards cards) {
        this.cards = cards;
    }

    public void setHandValue(int hand1Value) {
        this.handValue = hand1Value;
    }


    public void paintHand(Graphics2D g2d, int i) {
        handCard.get(i).paintCard(g2d);
    }

}
