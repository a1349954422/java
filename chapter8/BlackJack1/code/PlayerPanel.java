package chapter8.BlackJack1.code;

import chapter7.CountGames.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerPanel extends JPanel {
    private Player dealer;
    private Player gambler;
    private Board board;

    private JPanel betP;
    private JPanel actionP;
    private JPanel msgP;

    private JButton newGameBtn;
    private JButton hitBtn;
    private JButton standBtn;
    private JButton bet25Btn;
    private JButton bet100Btn;
    private JButton bet500Btn;
    private JButton bet1000Btn;
    private JButton bet5000Btn;
    private JLabel totalLbl;
    private JTextField totalTxt;
    private JButton exitBtn;
    private JLabel msgLbl;
    private JTextField msgTxt;
    private boolean newBet = true;
    private int preChipValue;

    public PlayerPanel() {
        initPlayerPanel();
    }

    private void initPlayerPanel() {
        ActionListener myActionListener = new MyActionListener();
        setLayout(new GridLayout(4,1));

        betP = new JPanel();
        bet25Btn = new JButton("Bet 25");
        bet25Btn.addActionListener(myActionListener);
        bet100Btn = new JButton("Bet 100");
        bet100Btn.addActionListener(myActionListener);
        bet500Btn = new JButton("Bet 500");
        bet500Btn.addActionListener(myActionListener);
        bet1000Btn = new JButton("Bet 1000");
        bet1000Btn.addActionListener(myActionListener);
        bet5000Btn = new JButton("Bet 5000");
        bet5000Btn.addActionListener(myActionListener);
        betP.add(bet25Btn);
        betP.add(bet100Btn);
        betP.add(bet500Btn);
        betP.add(bet1000Btn);
        betP.add(bet5000Btn);
        add(betP);

        actionP = new JPanel();
        newGameBtn = new JButton("New Game");
        newGameBtn.addActionListener(myActionListener);
        newGameBtn.setEnabled(false);
        actionP.add(newGameBtn);
        hitBtn = new JButton("Hit");
        hitBtn.addActionListener(myActionListener);
        actionP.add(hitBtn);
        standBtn = new JButton("Stand");
        standBtn.addActionListener(myActionListener);
        actionP.add(standBtn);
        totalLbl = new JLabel("Total");
        actionP.add(totalLbl);
        totalTxt = new JTextField(10);
        totalTxt.addActionListener(myActionListener);
        actionP.add(totalTxt);
        add(actionP);

        msgP = new JPanel();
        msgLbl = new JLabel("Message:");
        msgP.add(msgLbl);
        msgTxt = new JTextField(25);
        msgTxt.setForeground(Color.RED);
        msgP.add(msgTxt);
        exitBtn = new JButton("Exit");
        exitBtn.addActionListener(myActionListener);
        msgP.add(exitBtn);
        add(msgP);
        msgTxt.setText("Enter your total amount and press <Enter>");

        initGame();
    }

    private void initGame() {
        hitBtn.setEnabled(false);
        standBtn.setEnabled(false);
        disableBet();
    }

    private class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == newGameBtn){
                resetGame();
                dealer.assignHand(false,Consts.DEALER_Y);
                dealer.assignHand(true,Consts.DEALER_Y);

                gambler.assignHand(true,Consts.GAMBLER_Y);
                gambler.assignHand(true,Consts.GAMBLER_Y);
                clickNewGame();
            }else if(e.getSource() == hitBtn){
                newBet = false;
                gambler.assignHand(true,Consts.GAMBLER_Y);
                int status = gambler.getStatus();
                checkGamblerStatus(status);
            }else if(e.getSource() == standBtn){
                hitBtn.setEnabled(false);
                Card theCard  = dealer.getHands().get(0);
                theCard.setFaceCard(true);

                dealerHitStand();
                determineFinalStatus();
            }else if(e.getSource() == totalTxt){
                gambler.setTotalAmount(Integer.parseInt(totalTxt.getText()));
                newGameBtn.setEnabled(true);
                msgTxt.setText("Click button New Game or Exit");
            }else if(e.getSource() == bet25Btn){
                gamblerBet(25);
            }else if(e.getSource() == bet100Btn){
                gamblerBet(100);
            }else if(e.getSource() == bet500Btn){
                gamblerBet(500);
            }else if(e.getSource() == bet1000Btn){
                gamblerBet(1000);
            }else if(e.getSource() == bet5000Btn){
                gamblerBet(5000);
            }else if(e.getSource() == exitBtn){
                System.exit(0);
            }
            board.repaint();

            if(gambler.getTotalAmount() >= 0){
                totalTxt.setText("" + gambler.getTotalAmount());
            }

            if(board.isStandFlag() == true){
                if(gambler.getTotalAmount() >= 25){
                    newGameBtn.setEnabled(true);
                }else {
                    newGameBtn.setEnabled(false);
                    msgTxt.setText("You have no money to play a new game,sir!");
                }
                initGame();
            }
        }
    }

    private void gamblerBet(int chipValue) {
        if(!newBet){
            gambler.setTotalAmount(gambler.getTotalAmount() + preChipValue);
            newBet = true;
        }
        int remainTotal = gambler.assignChips(chipValue);
        if(remainTotal > 0){
            hitBtn.setEnabled(true);
            standBtn.setEnabled(true);
            board.setBetFlag(true);
            msgTxt.setText("More bet or click button Hit or Stand");
        }else if(remainTotal == 0){
            disableBet();
            hitBtn.setEnabled(true);
            standBtn.setEnabled(true);
            msgTxt.setText("No more bet can made");
        }else {
            preChipValue = chipValue;
            newBet = false;
            hitBtn.setEnabled(false);
            standBtn.setEnabled(false);
            msgTxt.setText("Your money is not enough,RE-BET or Exit");
            totalTxt.setText("" + (gambler.getTotalAmount() + chipValue) + "<" + chipValue);
        }
    }

    private void disableBet() {
        bet25Btn.setEnabled(false);
        bet100Btn.setEnabled(false);
        bet500Btn.setEnabled(false);
        bet1000Btn.setEnabled(false);
        bet5000Btn.setEnabled(false);
    }

    private void checkGamblerStatus(int status) {
        if(status == Consts.BUSTED){
            msgTxt.setText("Click Stand button to see dealer's status");
        }else {
            msgTxt.setText("Bet or click button Hit or Stand");
        }
    }

    public void clickNewGame(){
        board.setNewGameFlag(true);
        newGameBtn.setEnabled(false);
        hitBtn.setEnabled(true);
        standBtn.setEnabled(true);
        bet25Btn.setEnabled(true);
        bet100Btn.setEnabled(true);
        bet500Btn.setEnabled(true);
        bet1000Btn.setEnabled(true);
        bet5000Btn.setEnabled(true);
        exitBtn.setEnabled(true);

        msgTxt.setText("Bet or click button Hit or Stand");
    }

    private void dealerHitStand(){
        if(dealer.gethandsValue2() == 0){
            if(dealer.gethandsValue1() <= 16){
                while(dealer.gethandsValue1() <= 16){
                    dealer.assignHand(true,Consts.DEALER_Y);
                }
            }else if(dealer.gethandsValue1() >= 17){
            }
        }
        if(dealer.gethandsValue2() != 0){
            if(dealer.gethandsValue1() == 21){

            }else if(dealer.gethandsValue1() <= 16){
                while(dealer.gethandsValue1() <= 16){
                    dealer.assignHand(true,Consts.DEALER_Y);
                }
            }else if(dealer.gethandsValue1() >= 17){

            }
            if(dealer.gethandsValue1() >21){
                if(dealer.gethandsValue2() <= 16){
                    while(dealer.gethandsValue2() <= 12){
                        dealer.assignHand(true,Consts.DEALER_Y);
                    }
                }else if(dealer.gethandsValue2() >= 17){
                }
            }
        }
        board.setStandFlag(true);
    }

    private void determineFinalStatus(){
        int ds = dealer.getStatus();
        int gs = gambler.getStatus();
        if((ds == Consts.BLACKJACK) && (gs == Consts.BLACKJACK)){
            dealer.setStatus(Consts.PUSHED);
            gambler.setStatus(Consts.PUSHED);
            sayHa();
        }else if((ds == Consts.BUSTED) && (gs == Consts.BUSTED)){
            dealer.setStatus(Consts.PUSHED);
            gambler.setStatus(Consts.PUSHED);
            sayHa();
        }else if((ds == Consts.BLACKJACK) && (gs != Consts.BLACKJACK)){
            sayBad();
        }else if((ds != Consts.BLACKJACK) && (gs == Consts.BLACKJACK)){
            sayGood();
        }else if((ds == Consts.BUSTED) && (gs != Consts.BUSTED)){
            gambler.setStatus(Consts.WON);
            sayGood();
        }else if((ds != Consts.BUSTED) && (gs == Consts.BUSTED)){
            dealer.setStatus(Consts.WON);
            sayBad();
        }
        else if(((ds == Consts.COMPARE1) || (ds == Consts.COMPARE2)) && ((gs == Consts.COMPARE1) || (gs == Consts.COMPARE2))){
            int dv1 = dealer.gethandsValue1();
            int dv2 = dealer.gethandsValue2();
            int gv1 = gambler.gethandsValue1();
            int gv2 = gambler.gethandsValue2();
            if((ds == Consts.COMPARE1) &&(gs == Consts.COMPARE1)){
                compHandValues(dv1, gv1);
            } else if((ds == Consts.COMPARE1) && (gs == Consts.COMPARE2)){
                compHandValues(dv1, gv2);
            }else if((ds == Consts.COMPARE2) && (gs == Consts.COMPARE1)){
               compHandValues(dv2, gv1);
            }else if((ds == Consts.COMPARE2) && (gs == Consts.COMPARE2)){
                compHandValues(dv2, gv2);
            }
        }


}

    private void compHandValues(int dv, int gv) {
        if(dv == gv){
            dealer.setStatus(Consts.PUSHED);
            gambler.setStatus(Consts.PUSHED);
            sayHa();
        }else {
            if(dv > gv){
                dealer.setStatus(Consts.WON);
                sayBad();
            }else {
                gambler.setStatus(Consts.WON);
                sayGood();
            }
        }
    }

    private void sayGood() {
        gambler.setTotalAmount(gambler.getTotalAmount() + 2 * gambler.getChipsValue());
        msgTxt.setText("Congratulations!!!You won! New Game or Exit");
    }

    private void sayBad() {
        msgTxt.setText("Sorry!You lost!! New Game or Exit");
    }

    private void sayHa() {
        gambler.setTotalAmount(gambler.getTotalAmount() + gambler.getChipsValue());
        msgTxt.setText("Ha, no one won the game, New Game or Exit");
    }


    private void resetGame() {
        initGame();
        dealer.initPlayer();
        gambler.initPlayer();
        board.setReset();
    }

    public void setDealer(Player dealer) {
        this.dealer = dealer;
    }

    public void setGambler(Player gambler) {
        this.gambler = gambler;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
