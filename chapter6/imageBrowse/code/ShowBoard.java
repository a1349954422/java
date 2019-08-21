package imageBrowse.code;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ShowBoard extends JPanel {
    private BufferedImage showImage;
    private ImageStore img  = new ImageStore();
    private int imgHight;
    private int imgWidth;
    private int x, y;
    private int boardW;
    private int boardH;
    private double zoonRatio;
    private int index;

    public ShowBoard() {
        boardW = 400;
        boardH = 382;
        this.setPreferredSize(new Dimension(boardW,boardH));
    }

    public void initImage(){
        index = img.getScenyListImageList().size() / 2;
    }

    public void findImage(){
        showImage = img.getScenyImage(index);
        calcPostion();
    }

    public void calcPostion() {
        if(showImage.getHeight() <= showImage.getWidth()){
            zoonRatio = (boardW * 1.0) / showImage.getWidth();
            imgWidth = boardW;
            imgHight = (int)(showImage.getHeight() * zoonRatio);
            x = 0;
            y = boardH / 2 - imgHight / 2;
        }else{
            zoonRatio = (boardH * 1.0) / showImage.getHeight();
            imgHight = boardH;
            imgWidth = (int)(showImage.getWidth() * zoonRatio);
            y = 0;
            x = boardW / 2 - imgWidth / 2;
        }
    }

    public void paint(Graphics g){
        g.drawImage(showImage,x,y,imgWidth,imgHight,this);
    }

    public  void setImageStore(ImageStore imageStore){
        this.img = imageStore;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
