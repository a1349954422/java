package chapter11.analogClock;

import java.awt.*;

public class ClockFace {
    private int radiusClock;
    private int numCircles;
    private Color circleColor;
    private int radiusDotCircle;
    private int numDots;
    private int dotRadius;
    private Color dotColor;
    private int dotDistance;

    public ClockFace(){
        if(Consts.CV_WIDTH >Consts.CV_HEIGHT){
            radiusClock = (Consts.MAXY_DIS - Consts.MINY_DIS) / 2;
        }else {
            radiusClock = (Consts.MAXX_DIS - Consts.MINX_DIS) / 2;
        }
        numCircles = 8;
        circleColor = Color.ORANGE;
        radiusDotCircle = radiusClock - (int)(radiusClock * 0.10);
        numDots = 60;
        dotRadius = 3;
        dotColor = Color.GREEN;
        dotDistance = 30;
    }



    public void paintFace(Graphics2D g2d) {
        g2d.setColor(circleColor);
        for (int i = 0; i < numCircles; i++) {
            g2d.drawOval(Consts.CENTER_X - (radiusClock - i),Consts.CENTER_Y  - (radiusClock - i),
                    2 * (radiusClock - i), 2 * (radiusClock - i));
        }

        g2d.setColor(dotColor);
        for (int j = 0; j < numDots; j++) {
            int dotCx = Consts.CENTER_X + (int)(Math.sin(dotDistance * j * Consts.RADIAN) * radiusDotCircle);
            int dotCy = Consts.CENTER_Y - (int)(Math.cos(dotDistance * j * Consts.RADIAN) * radiusDotCircle);
            g2d.fillRect(dotCx - dotRadius, dotCy - dotRadius,
                     2 * dotRadius,  2 * dotRadius);
        }

        g2d.setColor(Color.BLACK);
        g2d.drawString("12", (int)(Consts.CENTER_X - 5 ), (int)(Consts.CENTER_Y - radiusClock + 30));
        g2d.drawString("3", (int)(Consts.CENTER_X + radiusClock - 30), (int)(Consts.CENTER_Y  + 5));
        g2d.drawString("6", (int)(Consts.CENTER_X  - 5), (int)(Consts.CENTER_Y + radiusClock - 25));
        g2d.drawString("9", (int)(Consts.CENTER_X - radiusClock + 25), (int)(Consts.CENTER_Y  + 5));
    }

    public int getRadiusClock() {
        return radiusClock;
    }
}
