package chapter7.CountGames;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Playerp extends JPanel {
    private JComboBox numComboBox;
    private String[] numArray;
    private JLabel numLbl;

    private JComboBox diffComboBox;
    private String[] diffArray;
    private JLabel diffLbl;

    private JTextField countDisplay;
    private JLabel countMessage;
    private JTextField inputAnswer;
    private JLabel answerMessage;

    private JLabel scoreLbl;
    private JTextField scoreTxt;

    private JButton morePlayIngBtn;
    private JButton terminalBtn;

    private JPanel numSelP;
    private JPanel diffP;
    private JPanel selP;
    private JPanel disPlayP;
    private JPanel scoreP;

    private Board board;
    private Playerp playerp;

    public Playerp() {
        this.setPreferredSize(new Dimension(Consts.CV_WIDTH,Consts.PLAYER_PANEL_H + 50));
        this.setLayout(new BorderLayout());
        initPlayPenal();

    }

    public void initPlayPenal() {
        ActionListener myActionListener = new MyActionListner();
        numSelP = new JPanel();
        numSelP.setPreferredSize(new Dimension(numSelP.getPreferredSize().width,85));
        EmptyBorder eb = new EmptyBorder(new Insets(10,30,5,30));
        numSelP.setBorder(eb);
        numSelP.setLayout(new FlowLayout());
        numArray = new String[]{"1","2","3","4","5","6","7","8"};
        numComboBox = new JComboBox(numArray);
        numLbl = new JLabel("please select how much count do you want");
        Dimension d = numComboBox.getPreferredSize();
        numComboBox.setPreferredSize(new Dimension(120,d.height));
        numComboBox.addActionListener(myActionListener);
        numSelP.add(numLbl);
        numSelP.add(numComboBox);

        diffP = new JPanel();
        diffP.setPreferredSize(new Dimension(diffP.getPreferredSize().width,85));
        EmptyBorder eb2 = new EmptyBorder(new Insets(10,30,5,30));
        diffP.setBorder(eb2);
        diffP.setLayout(new FlowLayout());
        diffArray = new String[]{"easy","middle","hard"};
        diffComboBox = new JComboBox(diffArray);
        diffLbl = new JLabel("please select a diffculties");
        Dimension d1 = diffComboBox.getPreferredSize();
        diffComboBox.setPreferredSize(new Dimension(120,d1.height));
        diffComboBox.addActionListener(myActionListener);
        diffP.add(diffLbl);
        diffP.add(diffComboBox);

        selP = new JPanel();
        selP.setLayout(new BorderLayout());
        selP.add(numSelP,BorderLayout.NORTH);
        selP.add(diffP,BorderLayout.CENTER);

        disPlayP = new JPanel();
        EmptyBorder eb3 = new EmptyBorder(new Insets(5,30,5,30));
        disPlayP.setBorder(eb3);
        countDisplay = new JTextField(30);
        countMessage = new JLabel("count:");
        inputAnswer = new JTextField(30);
        inputAnswer.addActionListener(myActionListener);
        answerMessage = new JLabel("answer");
        morePlayIngBtn = new JButton("more playing");
        morePlayIngBtn.addActionListener(myActionListener);
        terminalBtn = new JButton("terminal");
        terminalBtn.addActionListener(myActionListener);
        disPlayP.add(countMessage);
        disPlayP.add(countDisplay);
        disPlayP.add(answerMessage);
        disPlayP.add(inputAnswer);
        disPlayP.add(morePlayIngBtn);
        disPlayP.add(terminalBtn);

        scoreP = new JPanel();
        scoreLbl = new JLabel("total score:");
        scoreTxt = new JTextField(20);
        scoreP.add(scoreLbl);
        scoreP.add(scoreTxt);

        this.add(selP,BorderLayout.NORTH);
        this.add(disPlayP,BorderLayout.CENTER);
        this.add(scoreP,BorderLayout.SOUTH);
    }

     class MyActionListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == numComboBox){
                diffComboBox.setEnabled(true);
                numComboBox.setEnabled(false);
                inputAnswer.setEnabled(false);
            }else if(e.getSource() == diffComboBox){
                numComboBox.setEnabled(false);
                diffComboBox.setEnabled(false);
                inputAnswer.setEnabled(true);
                board.setPlay(true);
                board.initGame();
                inputAnswer.setText("");
                inputAnswer.requestFocus();
            }else if(e.getSource() == inputAnswer){
                board.receiveAnswer(inputAnswer.getText());
                numComboBox.setEnabled(false);
                diffComboBox.setEnabled(false);
                inputAnswer.setEnabled(true);
                inputAnswer.setText("");
                inputAnswer.requestFocus();
            }
            else if(e.getSource() == morePlayIngBtn){
                diffComboBox.setEnabled(false);
                numComboBox.setEnabled(true);
                inputAnswer.setEnabled(false);
                board.setInit(true);
                board.repaint();
            }else if(e.getSource() == terminalBtn){
                System.exit(0);
            }

        }
    }

    public void setCount(String s){
        countDisplay.setText(s);
    }

    public void setScore(String n){
        scoreTxt.setText(n);
    }

    public void setBoard(Board board){
        this.board = board;
    }

    public String getNum(){
        return (String)numComboBox.getSelectedItem();
    }

    public String getDiff(){
        return (String)diffComboBox.getSelectedItem();
    }
}
