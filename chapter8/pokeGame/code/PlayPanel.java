package chapter8.pokeGame.code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayPanel extends JPanel {
    private JButton newGameBtn;
    private JButton exitBtn;
    private JButton continueBtn;
    private JPanel gameP;


    private JLabel msgLbl;
    private JTextField msgTxt;
    private JPanel msgP;

    private Board board;
    private Player player;
    private Player computer;
    private Player gameZone;
    private Deck deck;

    private Card aCard;

    private boolean hasJQK;
    private boolean continueGame = true;

    public PlayPanel() {
        hasJQK = false;
        initPlayPanel();
    }

    private void initPlayPanel() {
        ActionListener myActionListener = new MyActionListener();

        setLayout(new GridLayout(3, 1));

        newGameBtn = new JButton("NewGame");
        newGameBtn.addActionListener(myActionListener);
        exitBtn = new JButton("Exit");
        exitBtn.addActionListener(myActionListener);
        continueBtn = new JButton("continue");
        continueBtn.addActionListener(myActionListener);
        gameP = new JPanel();
        gameP.add(continueBtn);
        gameP.add(newGameBtn);
        gameP.add(exitBtn);

        msgLbl = new JLabel("Message:");
        msgTxt = new JTextField(20);
        msgP = new JPanel();
        msgP.add(msgLbl);
        msgP.add(msgTxt);

        add(gameP);
        add(msgP);

        msgText("click NewGame to start game");

    }

    public void getJorQorK(Card card) {
        gameZone.addToDeck(card);
    }

    private class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == newGameBtn) {
                continueBtn.setEnabled(true);
                player.setHandCard();
                computer.setHandCard();
                gameZone.setHandCard();
                board.setNewGameFlag(true);
                deck.initDeck();
                player.initCard();
                player.shuffleCard();
                computer.initCard();
                computer.shuffleCard();
                msgText("click continue to continue game");

            } else if (e.getSource() == continueBtn) {
                determinWiner(player.getHandSize(), computer.getHandSize());
                if(continueGame){
                board.setContinueFlag(true);
                aCard = player.assignOneCard();
                gameZone.addToDeck(aCard);
                hasJQKValue(aCard.getValue());
                board.repaint();
                if (hasJQK) {
                    dealComputer(computer);
                }else {
                    determinWiner(player.getHandSize(), computer.getHandSize());
                    if (continueGame) {
                        board.setContinueFlag(true);
                        aCard = computer.assignOneCard();
                        board.repaint();
                        gameZone.addToDeck(aCard);
                        hasJQKValue(aCard.getValue());
                        board.repaint();
                        if (hasJQK) {
                            dealPlayer(player);
                        }
                    }
                }
                }
                } else if (e.getSource() == exitBtn) {
                    System.exit(0);
                }

            }
        }

    private void determinWiner(int handSize, int handSize1) {
        if(handSize == 0){
            msgTxt.setText("sorry,you lose");
            continueBtn.setEnabled(false);
            continueGame = false;
        }else if(handSize1 == 0){
            msgTxt.setText("good,you won");
            continueBtn.setEnabled(false);
            continueGame = false;
        }else{
            continueGame = true;
        }
    }

    public void dealPlayer(Player player) {
            player.dealJqk();
            if(!hasJQK){
                computer.addCard(gameZone.getHandCard());
                gameZone.setHandCard();
                board.setContinueFlag(true);
                msgTxt.setText("Computer is won this action");
                board.repaint();
             }else {
                dealComputer(computer);
            }
         }

        public void dealComputer(Player computer) {
            computer.dealJqk();
            if(!hasJQK){
                player.addCard(gameZone.getHandCard());
                gameZone.setHandCard();
                board.setContinueFlag(true);
                msgTxt.setText("player won this action");
                board.repaint();
            }else {
                dealPlayer(player);
            }
         }

    public void hasJQKValue(int value) {
        if((value == 11) || (value == 12) || (value == 13)){
            hasJQK = true;
        }else {
            hasJQK = false;
        }
    }

    public void msgText(String s) {
        msgTxt.setText(s);
    }


    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setComputer(Player computer) {
        this.computer = computer;
    }

    public void setGameZone(Player gameZone) {
        this.gameZone = gameZone;
    }

    public void setHasJQK(boolean b) {
        hasJQK = b;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
