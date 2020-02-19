package chapter11.analogClock;

import java.awt.*;

public class SecondHand extends ClockHand{

    public SecondHand(int radiusClock) {
        super(radiusClock);
        setHandColor(Color.black);
        setHandPercent(0.85);
        setHandTurnAngle(0);
        setAnglePerSec(Consts.SECOND_ANGLE);
        initHand();
    }
}
