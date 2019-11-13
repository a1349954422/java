package chapter10.Agnes.code;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Card extends Component {
    private int x, y;
    private Image cardFront;
    private Image cardBack;
    private int width, height;
    private boolean faceUp;
    private int value;
    private int suit;

    public Card() {
        width = Consts.CARD_W;
        height = Consts.CARD_H;
        faceUp = false;
        try{
            cardBack = ImageIO.read(getClass().getResource("../card/back.jpg"));
        } catch (Exception e) {
        }
    }

    public void paintCard(Graphics2D g2d){
        if(faceUp){
            g2d.drawImage(cardFront, getX(), getY(), width, height, null);
        }else {
            g2d.drawImage(cardBack, getX(), getY(), width, height, null);
        }

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

    public Image getCardFront() {
        return cardFront;
    }

    public void setCardFront(Image cardFront) {
        this.cardFront = cardFront;
    }

    public Image getCardBack() {
        return cardBack;
    }

    public void setCardBack(Image cardBack) {
        this.cardBack = cardBack;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isFaceUp() {
        return faceUp;
    }

    public void setFaceUp(boolean faceUp) {
        this.faceUp = faceUp;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }
}