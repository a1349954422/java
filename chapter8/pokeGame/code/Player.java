package chapter8.pokeGame.code;

import java.awt.*;
import java.util.ArrayList;

public class Player {
    private ArrayList<Card> handCard;
    private Deck deck;
    private PlayPanel playPanel;
    private Board board;

    public Player() {
        handCard = new ArrayList<>();
    }

    public void initCard() {
        Card tCard = new Card();
        for (int i = 0; i < 26; i++) {
            tCard = deck.dealHandCard();
            handCard.add(tCard);
        }
    }

    public Card assignOneCard() {
        Card aCard = handCard.get(0);
        handCard.remove(0);
        return aCard;
    }

    public void addToDeck(Card aCard) {
        handCard.add(aCard);
    }

    public void paintPlayerHand(Graphics2D g2d) {
        int x = 70, y = 280;
        for (int i = handCard.size() - 1; i > 0; i--) {
            x += 10;
            handCard.get(i).setX(x);
            handCard.get(i).setY(y);
            handCard.get(i).paintCard(g2d);
        }
        board.setContinueFlag(false);
    }

    public void paintComputerHand(Graphics2D g2d) {
        int x = 70, y = 15;
        for (int i = 0; i < handCard.size(); i++) {
            x += 10;
            handCard.get(i).setX( x);
            handCard.get(i).setY(y);
            handCard.get(i).paintComputer(g2d);
        }
    }

    public void paintGameZoneHand(Graphics2D g2d) {
        int x = 70, y = 130;
        for (int i = 0; i < handCard.size(); i++) {
            x += 10;
            handCard.get(i).setX(x);
            handCard.get(i).setY(y);
            handCard.get(i).paintCard(g2d);
        }
    }

    public void dealJqk() {
        for (int i = handCard.size() - 1; i > handCard.size() - 4; i--) {
            int value = handCard.get(i).getValue();
            if((value == 11) || (value == 12) || (value == 13)){
                playPanel.setHasJQK(true);
                playPanel.getJorQorK(handCard.get(i));
                handCard.remove(handCard.get(i));
                break;
            }else{
                playPanel.setHasJQK(false);
            }
        }
    }

    public void addCard(ArrayList<Card> arrayList) {
        int volvoValue = arrayList.size();
        for (int i = 0; i < volvoValue; i++) {
            handCard.add(arrayList.get(0));
            arrayList.remove(0);
        }
    }

    public void shuffleCard() {
        int randIdx1;
        int randIdx2;
        for (int i = 0; i < 1000; i++) {
            randIdx1 = (int) (Math.random() * 10000 % 26);
            randIdx2 = (int) (Math.random() * 10000 % 26);
            swap(randIdx1,randIdx2);
        }
    }

    private void swap(int randIdx1, int randIdx2) {
        Card acard = handCard.get(randIdx1);
        handCard.set(randIdx1, handCard.get(randIdx2));
        handCard.set(randIdx2, acard);
    }

    public ArrayList<Card> getHandCard() {
        return handCard;
    }

    public void setHandCard() {
        handCard = new ArrayList<>();
        handCard.clear();
    }


    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setPlayPanel(PlayPanel playPanel) {
        this.playPanel = playPanel;
    }

    public int getHandSize(){
        return handCard.size();
    }
}
