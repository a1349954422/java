package chapter8.pokeGame.code;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Card  {
    private int x, y;
    private int width = 60, height = 60;
    private Image image;
    private Image cardback;
    private int value;

    public Card() {
        try{
            cardback = ImageIO.read(getClass().getResource("../card/back.jpg"));
        } catch (IOException e) {
        }
    }

    public void paintCard(Graphics2D g2d){
        g2d.drawImage(image, x, y, width, height, null);
    }

    public void paintComputer(Graphics2D g2d){
        g2d.drawImage(cardback, x, y, width, height, null);
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

    public void setImage(Image image) {
        this.image = image;
    }
}
