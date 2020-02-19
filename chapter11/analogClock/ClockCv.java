package chapter11.analogClock;

import javax.swing.*;
import java.awt.*;

public class ClockCv extends JPanel implements Runnable{

    private Thread animThread;
    private ClockFace clockFace;
    private MinuteHand minuteHand;
    private SecondHand secondHand;
    private HourHand hourHand;
    private int radiusClock;

    public ClockCv(){
        initComponent();
        start();
    }

    private void initComponent() {
        initClockFace();
        initHourHand();
        initMinuteHand();
        initSecondHand();
    }


    private void initClockFace() {
        clockFace = new ClockFace();
        radiusClock = clockFace.getRadiusClock();
    }

    private void initHourHand() {
        hourHand = new HourHand(radiusClock);
    }

    private void initMinuteHand() {
        minuteHand = new MinuteHand(radiusClock);
    }

    private void initSecondHand() {
        secondHand = new SecondHand(radiusClock);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;

        clockFace.paintFace(g2d);
        hourHand.paintHand(g2d);
        minuteHand.paintHand(g2d);
        secondHand.paintHand(g2d);
    }


    private void start(){
        if(animThread == null){
            animThread = new Thread(this);
            animThread.start();
        }
    }


    @Override
    public void run() {
        try{
            while(true){
                updateComponent();
                repaint();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
        }

    }

    private void updateComponent() {
        hourHand.updateHand();
        minuteHand.updateHand();
        secondHand.updateHand();
    }

    public HourHand getHourHand() {
        return hourHand;
    }

    public MinuteHand getMinuteHand() {
        return minuteHand;
    }

    public SecondHand getSecondHand() {
        return secondHand;
    }
}
