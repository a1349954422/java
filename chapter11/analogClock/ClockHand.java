package chapter11.analogClock;

import java.awt.*;

public class ClockHand {

    private int radiusClock;
    private int radiusHand;
    private double handPercent;
    private Color handColor;
    private int moveX;
    private int moveY;
    private double handTurnAngle;
    private double anglePerSec;



    public ClockHand(int radiusClock){
        this.radiusClock = radiusClock;
    }

    public void initHand(){
        radiusHand = (int)(this.radiusClock * getHandPercent());
        moveX = (int)(Math.sin(getHandTurnAngle() * Consts.RADIAN) * radiusHand );
        moveY = (int)(Math.cos(getHandTurnAngle() * Consts.RADIAN) * radiusHand);
    }

    public void paintHand(Graphics2D g2d){
        g2d.setColor(getHandColor());
        int handCx = Consts.CENTER_X + moveX;
        int handCy = Consts.CENTER_Y - moveY;
        g2d.drawLine(Consts.CENTER_X,Consts.CENTER_Y, handCx, handCy);
    }

    public void updateHand(){
        setHandTurnAngle(getHandTurnAngle() + getAnglePerSec());
        if(getHandTurnAngle() == 360){
            setHandTurnAngle(-360);
        }
        moveX = (int)(Math.sin(getHandTurnAngle() * Consts.RADIAN) * radiusHand);
        moveY = (int)(Math.cos(getHandTurnAngle() * Consts.RADIAN) * radiusHand);
    }

    public double getHandPercent() {
        return handPercent;
    }

    public void setHandPercent(double handPercent) {
        this.handPercent = handPercent;
    }

    public Color getHandColor() {
        return handColor;
    }

    public void setHandColor(Color handColor) {
        this.handColor = handColor;
    }

    public double getHandTurnAngle() {
        return handTurnAngle;
    }

    public void setHandTurnAngle(double handTurnAngle) {
        this.handTurnAngle = handTurnAngle;
    }

    public double getAnglePerSec() {
        return anglePerSec;
    }

    public void setAnglePerSec(double anglePerSec) {
        this.anglePerSec = anglePerSec;
    }
}
