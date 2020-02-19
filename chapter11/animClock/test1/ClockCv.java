package chapter11.animClock.test1;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class ClockCv extends JPanel implements Runnable {
    private Date theData;
    private Thread animation;

    public ClockCv(){
        start();
    }

    private void start() {
        if(animation == null){
            animation = new Thread(this);
            animation.start();
        }
    }

    @Override
    public void run() {
        try{
            while(true){
                theData = new Date();
                repaint();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(new Color(50,250,250));
        g2d.fillRect(0, 0, 420, 200);

        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("TimeRoman", Font.BOLD, 24));
        g2d.drawString(theData.toString(), 10, 50);
    }
}
