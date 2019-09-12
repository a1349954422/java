package chapter8.BlackJack1.code;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Card {
    private Image cardFace;
    private Image cardBack;
    private int x, y;
    private boolean faceCard;
    private int width = 60,height = 65;
    private int value;

    public Card() {
        try{
            cardBack = ImageIO.read(getClass().getResource("../card/back.jpg"));
        } catch (IOException e) {
        }
    }

    public void paintCard(Graphics2D g2d){
        if(faceCard){
            g2d.drawImage(cardFace,x,y,width,height,null);
        }else {
            g2d.drawImage(cardBack,x,y,width,height,null);
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setCardFace(Image cardFace) {
        this.cardFace = cardFace;
    }

    public void setFaceCard(boolean faceCard) {
        this.faceCard = faceCard;
    }
}
