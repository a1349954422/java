package chapter8.FourPlayers.code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayPanel extends JPanel {
    private JButton newGameBtn;
    private JButton exitBtn;
    private JPanel gameP;

    private JPanel msgP;
    private JLabel msgLbl;
    private JTextField msgTxt;

    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;

    private Board board;

    public PlayPanel() {
        initPlayPanel();
    }

    private void initPlayPanel() {
        ActionListener myActionListener = new MyActionListener();

        gameP = new JPanel();
        newGameBtn = new JButton("newGame");
        newGameBtn.addActionListener(myActionListener);
        gameP.add(newGameBtn);
        exitBtn = new JButton("exit");
        exitBtn.addActionListener(myActionListener);
        gameP.add(exitBtn);

        msgP = new JPanel();
        msgLbl = new JLabel("message:");
        msgTxt = new JTextField(20);
        msgTxt.setText("Click newGameBtn to start game or exit");
        msgP.add(msgLbl);
        msgP.add(msgTxt);

        this.add(gameP);
        this.add(msgP);

    }

    private class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == newGameBtn){
                initGame();
                board.setNewGameFlag(true);
                player1.assignHand(240,50);
                player2.assignHand(75,120);
                player3.assignHand(380,120);
                player4.assignHand(240,240);
                board.repaint();

            }else if(e.getSource() == exitBtn){
                System.exit(0);
            }

        }
    }

    private void initGame() {
        player1.initPlayer();
        player2.initPlayer();
        player3.initPlayer();
        player4.initPlayer();
    }

    public void setMsg(String s){
        msgTxt.setText(s);
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public void setPlayer3(Player player3) {
        this.player3 = player3;
    }

    public void setPlayer4(Player player4) {
        this.player4 = player4;
    }
}
