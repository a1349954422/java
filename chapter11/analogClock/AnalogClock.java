package chapter11.analogClock;

import javax.swing.*;
import java.awt.*;

public class AnalogClock extends JFrame {
    private ClockCv clockCv;

    public AnalogClock(){
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("AnalogClock");
        setSize(Consts.CV_WIDTH, Consts.CV_HEIGHT + Consts.BUTTON_HEIGHT);

        clockCv = new ClockCv();
        add(clockCv, BorderLayout.CENTER);
        AutoSetButton autoSetButton = new AutoSetButton(clockCv);
        add(autoSetButton,BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new AnalogClock();
    }
}
