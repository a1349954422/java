package chapter8.FourPlayers.code;

import java.awt.*;

public class Card {
    private int x, y;
    private int width = 60, height = 65;
    private Image cardFace;
    private int value;

    public Card() {
    }

    public void paintCard(Graphics2D g2d){
        g2d.drawImage(cardFace, x, y, width, height, null);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setCardFace(Image cardFace) {
        this.cardFace = cardFace;
    }

    public Image getCardFace() {
        return cardFace;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
