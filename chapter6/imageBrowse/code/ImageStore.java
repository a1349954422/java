package imageBrowse.code;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class ImageStore {
    private ArrayList<BufferedImage> scenyList = new ArrayList<>();
    private int t = 0;
    private BufferedImage image;
    private Image leftArrow;
    private Image rightArrow;

    public ImageStore() {
        initScenyList();
    }

    private void initScenyList() {
        BufferedImage image;
        try {
            for (int i = 0; i < 6; i++) {
                t = i + 1;
                String path = "../image/"  + t +".jpg";
                image = ImageIO.read(getClass().getResource(path));
                scenyList.add(image);
            }
            rightArrow = ImageIO.read(getClass().getResource("../image/rightBtn.jpg"));
            leftArrow = ImageIO.read(getClass().getResource("../image/leftBtn.jpg"));
        } catch (IOException e) {
        }
    }

    public ArrayList<BufferedImage> getScenyListImageList() {
        return scenyList;
    }
    public BufferedImage getScenyImage(int index) {
        return scenyList.get(index);
    }

    public Image getLeftArrow(){
        return leftArrow;
    }

    public Image getRightArrow(){
        return rightArrow;
    }


}
