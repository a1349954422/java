package chapter8.BlackJack1.code;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Chip {
    private int x, y;
    private int width = 25, height = 25;
    private BufferedImage chipFace;

    public Chip() {
    }

    public void initChip(int chipValue) {
        chipFace = null;
        switch (chipValue){
            case 25:
                try{
                    chipFace = ImageIO.read(getClass().getResource("../chips/25Chip.gif"));
                } catch (IOException e) {
                }
                break;
            case 100:
                try{
                    chipFace = ImageIO.read(getClass().getResource("../chips/100Chip.gif"));
                } catch (IOException e) {
                }
                break;
            case 500:
                try{
                    chipFace = ImageIO.read(getClass().getResource("../chips/500Chip.gif"));
                } catch (IOException e) {
                }
                break;
            case 1000:
                try{
                    chipFace = ImageIO.read(getClass().getResource("../chips/1000Chip.gif"));
                } catch (IOException e) {
                }
                break;
            case 5000:
                try{
                    chipFace = ImageIO.read(getClass().getResource("../chips/5000Chip.gif"));
                } catch (IOException e) {
                }
                break;
                default:
        }
    }

    public void paintChip(Graphics2D g2d) {
        g2d.drawImage(chipFace, x, y, width, height, null);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
