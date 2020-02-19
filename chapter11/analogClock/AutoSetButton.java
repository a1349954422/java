package chapter11.analogClock;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class AutoSetButton extends JPanel {

    private JButton autoSetButton;
    private ClockCv clockCv;

    public AutoSetButton(ClockCv clockCv){
        this.clockCv = clockCv;
        autoSetButton = new JButton("Auto-Set-Time");
        add(autoSetButton);
        autoSetButton.addActionListener(new AutoSetListener());
    }

    class AutoSetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == autoSetButton){
               String[] ids = TimeZone.getAvailableIDs();//获取所有时区ID；
                if(ids.length == 0){
                    System.exit(0);
                }
                SimpleTimeZone est = new SimpleTimeZone(
                        -5 * 60 * 60 * 1000, ids[0]);//美国东部时区
                est.setStartRule(Calendar.APRIL, 1, Calendar.SUNDAY,
                2 * 60 * 60 * 1000);
                est.setEndRule(Calendar.OCTOBER, -1, Calendar.SUNDAY,
                        2 * 60 * 60 * 1000);

                GregorianCalendar gcalendar = new GregorianCalendar(est);
                int hour = gcalendar.get(Calendar.HOUR);
                int minute = gcalendar.get(Calendar.MINUTE);
                int second = gcalendar.get(Calendar.SECOND);

                int secondDegree = second * Consts.SECOND_ANGLE;
                double minuteDegree = minute * 360 / 60 + secondDegree * 1.0 / 60;
                double hourDegree = hour * 360 / 12 + minuteDegree * 1.0 / 60;

                clockCv.getHourHand().setHandTurnAngle(hourDegree);
                clockCv.getMinuteHand().setHandTurnAngle(minuteDegree);
                clockCv.getSecondHand().setHandTurnAngle(secondDegree);
            }
        }
    }
}
