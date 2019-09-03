package chapter7.anargramGUI.code;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerPanel extends JPanel {
    private ButtonGroup buttonGroup;
    private JLabel fileLbl;
    private JRadioButton fileAJBtn;
    private JRadioButton fileKZbtn;

    private JLabel diffLbl;
    private int missCharNum;
    private String[] fileNames;
    private JComboBox cBox;


    private JLabel guessWordLbl;
    private JTextField guessWordTxt;
    private JButton tremainateBtn;
    private JButton morePlayBtn;

    private JLabel msgLbl;
    private JTextField msgTxt;

    private JLabel scoreLbl;
    private JTextField scoreTxt;

    private JPanel selectFileP;
    private JPanel diffP;
    private JPanel playP;
    private JPanel playerP;
    private JPanel msgP;
    private JPanel scoreP;

    private JPanel selP;

    private ReadFile readFile;
    private Board board;

    public PlayerPanel() {
        board = new Board();
        this.setPreferredSize(new Dimension(Consts.CV_WIDTH,Consts.PLAYER_PANEL_H));
        this.setLayout(new BorderLayout());
        initPlayerPanel();
    }

    private void initPlayerPanel() {

        ActionListener myActionListener = new MyActionListener();
        selectFileP = new JPanel();
        selectFileP.setLayout(new GridLayout(3,1));
        EmptyBorder eb = new EmptyBorder(new Insets(30,150,5,30));
        selectFileP.setBorder(eb);
        fileLbl = new JLabel("select a file to start");
        buttonGroup = new ButtonGroup();
        fileAJBtn = new JRadioButton("wordaj.txt");
        fileAJBtn.setActionCommand("wordaj.txt");
        fileAJBtn.addActionListener(myActionListener);
        fileKZbtn = new JRadioButton("wordkz.txt");
        fileKZbtn.setActionCommand("wordkz.txt");
        fileKZbtn.addActionListener(myActionListener);
        buttonGroup.add(fileAJBtn);
        buttonGroup.add(fileKZbtn);
        selectFileP.add(fileLbl);
        selectFileP.add(fileAJBtn);
        selectFileP.add(fileKZbtn);

        diffP = new JPanel();
        diffP.setPreferredSize(new Dimension(diffP.getPreferredSize().width,85));
        EmptyBorder eb2 = new EmptyBorder(new Insets(30,150,5,130));
        diffP.setBorder(eb2);
        diffP.setLayout(new FlowLayout());
        diffLbl = new JLabel("please select diffculte");
        fileNames = new String[]{"easy","middle","hard"};
        cBox = new JComboBox(fileNames);
        Dimension d = cBox.getPreferredSize();
        cBox.setPreferredSize(new Dimension(120,d.height));
        cBox.addActionListener(myActionListener);
        diffP.add(diffLbl);
        diffP.add(cBox);


        playerP = new JPanel();
        EmptyBorder eb3 = new EmptyBorder(new Insets(5,30,20,30));
        playerP.setBorder(eb3);
        guessWordLbl = new JLabel("ENTER YOUT GUESS WORD");
        guessWordTxt = new JTextField(15);
        guessWordTxt.addActionListener(myActionListener);
        morePlayBtn = new JButton("more playing");
        morePlayBtn.addActionListener(myActionListener);
        tremainateBtn = new JButton("tremainate");
        tremainateBtn.addActionListener(myActionListener);
        playerP.add(guessWordLbl);
        playerP.add(guessWordTxt);
        playerP.add(morePlayBtn);
        playerP.add(tremainateBtn);

        scoreP = new JPanel();
        scoreLbl = new JLabel("Total score");
        scoreTxt = new JTextField(20);
        scoreP.add(scoreLbl);
        scoreP.add(scoreTxt);

        playP = new JPanel();
        playP.setLayout(new BorderLayout());
        playP.add(playerP,BorderLayout.NORTH);
        playP.add(scoreP,BorderLayout.CENTER);

        selP = new JPanel();
        selP.setLayout(new BorderLayout());
        selP.add(selectFileP,BorderLayout.WEST);
        selP.add(diffP,BorderLayout.CENTER);

        msgP = new JPanel();
        msgLbl = new JLabel("Message:");
        msgTxt = new JTextField(20);
        msgP.add(msgLbl);
        msgP.add(msgTxt);

        this.add(selP,BorderLayout.NORTH);
        this.add(playP,BorderLayout.CENTER);
        this.add(msgP,BorderLayout.SOUTH);

        setMsg("please select a file");
    }



    class MyActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == fileAJBtn || e.getSource() == fileKZbtn){
                readFile.selectFile(e.getActionCommand());
                fileKZbtn.setEnabled(false);
                fileAJBtn.setEnabled(false);
                diffP.setEnabled(true);
                guessWordTxt.setEnabled(false);
                guessWordTxt.setText("");
                guessWordTxt.requestFocus();
                msgTxt.setText("please select diffcult");
            }else  if(e.getSource() == guessWordTxt){
                board.receiveGuess(guessWordTxt.getText());
                guessWordTxt.setEnabled(false);
            }else if(e.getSource() == morePlayBtn){
                fileAJBtn.setEnabled(true);
                fileKZbtn.setEnabled(true);
                cBox.setEnabled(true);
                board.setInitPaint(true);
                board.repaint();
                msgTxt.setText("please enter your word");
            }else if(e.getSource() == tremainateBtn){
                System.exit(0);
            }else if(e.getSource() == cBox){
                board.initGivenWord();
                fileKZbtn.setEnabled(false);
                fileAJBtn.setEnabled(false);
                diffP.setEnabled(false);
                guessWordTxt.setEnabled(true);
                guessWordTxt.setText("");
                guessWordTxt.requestFocus();
                setMsg("please input your guess:");
            }
        }
    }



    public void setMsg(String s) {
        msgTxt.setText(s);
    }

    public void setReadFile(ReadFile readFile){
        this.readFile = readFile;
    }

    public void setBoard(Board board){
        this.board = board;
    }

    public String getSelect(){
        return (String)cBox.getSelectedItem();
    }

    public void setScoreTxt(String score){
        this.scoreTxt.setText(score);
    }
}
