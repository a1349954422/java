package chapter11.animClock.test1;

import javax.swing.*;

public class Windows extends JFrame {

    public Windows(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,400);
        setTitle("clock");
        ClockCv clockCv = new ClockCv();
        add(clockCv);
        setVisible(true);
    }
}
