package chapter11.analogClock;

import java.awt.*;

public class MinuteHand extends ClockHand {

    public MinuteHand(int radiusClock) {
        super(radiusClock);
        setHandColor(Color.orange);
        setHandPercent(0.75);
        setHandTurnAngle(18);
        setAnglePerSec(Consts.MINUTE_ANGLE);
        initHand();
    }
}
