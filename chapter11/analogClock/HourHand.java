package chapter11.analogClock;

import java.awt.*;

public class HourHand extends ClockHand {
    public HourHand(int radiusClock) {
        super(radiusClock);
        setHandColor(Color.DARK_GRAY);
        setHandPercent(0.6);
        setHandTurnAngle(30);
        setAnglePerSec(Consts.HOUR_ANGLE);
        initHand();
    }
}
