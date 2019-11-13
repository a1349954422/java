package chapter9.SudokuGame;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class NotePanel extends JPanel {
    private JLabel easyLbl;
    private JLabel mediumLbl;
    private JLabel hardLbl;
    private JLabel msgLbl;
    private JLabel upLbl;
    private JLabel downLbl;
    private JLabel leftLbl;
    private JLabel rightLbl;
    private JLabel newLbl;
    private JLabel checkLbl;
    private JLabel colorLbl;
    private JLabel quitLbl;
    private JLabel emptyLbl;
    private JLabel toEmptyLbl;

    private JPanel leverP;
    private JPanel moveP;
    private JPanel commandP;

    public NotePanel() {
        setLayout(new GridLayout(3,1));
        setPreferredSize(new Dimension(Consts.PLAYER_P_W, Consts.PLAYER_P_H));
        initLabel();
    }

    public void initLabel() {
        EmptyBorder eb = new EmptyBorder(new Insets(30, 0, 30, 30));
        this.setBorder(eb);
        emptyLbl = new JLabel("     ");

        leverP = new JPanel(new GridLayout(5, 1));
        easyLbl = new JLabel("E --easy level");
        mediumLbl = new JLabel("M -- medium level");
        hardLbl = new JLabel("H -- hard level");
        msgLbl = new JLabel("   You can reset level any time");
        leverP.add(easyLbl);
        leverP.add(mediumLbl);
        leverP.add(hardLbl);
        leverP.add(msgLbl);
        leverP.add(emptyLbl);
        add(leverP);

        moveP = new JPanel(new GridLayout(4, 1));
        upLbl = new JLabel("UP-KEY -- move cursorMark up");
        upLbl.setForeground(Color.BLUE);
        downLbl = new JLabel("DOWN-KEY -- move cursorMark down");
        downLbl.setForeground(Color.BLUE);
        leftLbl = new JLabel("LEFT-KEY -- move cursorMark left");
        leftLbl.setForeground(Color.BLUE);
        rightLbl = new JLabel("RIGHT-KEY -- move cursorMark right");
        rightLbl.setForeground(Color.BLUE);
        moveP.add(upLbl);
        moveP.add(downLbl);
        moveP.add(leftLbl);
        moveP.add(rightLbl);
        add(moveP);

        commandP = new JPanel(new GridLayout(5, 1));
        toEmptyLbl = new JLabel("       ");
        checkLbl = new JLabel("C - check guessed digits");
        checkLbl.setForeground(Color.RED);
        colorLbl = new JLabel("GREEN- correct guess");
        colorLbl.setForeground(Color.RED);
        newLbl = new JLabel("N- new game");
        newLbl.setForeground(Color.RED);
        quitLbl = new JLabel("Q- quit game");
        quitLbl.setForeground(Color.RED);
        commandP.add(toEmptyLbl);
        commandP.add(checkLbl);
        commandP.add(colorLbl);
        commandP.add(newLbl);
        commandP.add(quitLbl);
        add(commandP);
    }
}
