package chapter10.Agnes.code;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JPanel;

public class GameCanvas extends JPanel {
    private Deck deck;
    private CardLayout cardLayout;
    private PlayerPanel playerPanel;
    private boolean gameTerminate;
    private boolean firstTime;
    private Card clickCard;
    private int clickCol;
    private ArrayList[] theColumn;
    private ArrayList<Card> tempList;
    private int tempLen;
    private ArrayList[] theFoundation;

    int overCol, beginCol;
    ArrayList<Integer> overColumnList;
    ArrayList<Integer> overFoundationList;

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public GameCanvas() {
        gameTerminate = false;
        firstTime = true;
        overColumnList = new ArrayList<>();
        overFoundationList = new ArrayList<>();
        addMouseMotionListener(new myMouseAdapter());
        addMouseListener(new myMouseAdapter());
        initComponent();
    }

    private void initComponent() {
        deck = new Deck();
        initCardLayout();
    }

    private void initCardLayout() {
        cardLayout = new CardLayout();
        cardLayout.setDeck(deck);
        cardLayout.initLayout();
        theColumn = cardLayout.getColumn();
        theFoundation = cardLayout.getFoundation();
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        cardLayout.paintLayout(g2d);
    }

    public void reNewGame() {
        gameTerminate = false;
        playerPanel.setGameTerminate(gameTerminate);
        deck = new Deck();
        initCardLayout();
        repaint();
    }


    class myMouseAdapter extends MouseAdapter {
        Card aCard;
        int dx, dy;
        @Override
        public void mouseDragged(MouseEvent e) {
            if (firstTime) {
                clickCol = theCol(e.getX());//获得点击列
                if ((clickCol >= 0) && (clickCol < Consts.NUM_COL)) {
                    for (int row = (theColumn[clickCol].size() - 1); row >= 0; row--) {
                        aCard = (Card) theColumn[clickCol].get(row);
                        if (dragTheCard(e.getX(), e.getY(), aCard.getX(), aCard.getY())) {
                            clickCard = aCard;
                            tempList = new ArrayList<>();
                            tempLen = (theColumn[clickCol].size() - 1) - row + 1;
                            for (int i = 0; i < tempLen; i++) {
                                aCard = (Card) theColumn[clickCol].get(row + i);
                                tempList.add(aCard);
                            }
                            break;
                        } else {
                            clickCard = null;
                        }
                    }
                }
                if (clickCard != null) {
                    dx = e.getX() - clickCard.getX();
                    dy = e.getY() - clickCard.getY();
                }
                beginCol = clickCol;
                firstTime = false;
            }
            if (tempList != null) {
                for (int k = 0; k < tempLen; k++) {
                    tempList.get(k).setX(e.getX() - dx);
                    tempList.get(k).setY((e.getY() - dy) + k * Consts.CARD_GAP_Y);
                }
            }
            Card dragCard;
            dragCard = tempList.get(0);
            if(dragCard.getY() >= Consts.COL1_Y){
                overCol = theCol(dragCard.getX() + Consts.CARD_W);
                if((overCol > beginCol) || (overCol < beginCol)){
                    overColumnList.add(overCol);
                    topColumn(overCol, tempList);
                    beginCol = overCol;
                }
            }else { // 基础列
                overCol = theCol(dragCard.getX());
                if(overCol < Consts.NUM_SUIT){
                    overFoundationList.add(overCol);
                    topFoundation(overCol, tempList);
                    beginCol = overCol;
                }
            }
            int overCol2 = theCol(dragCard.getX() + Consts.CARD_W);
            if(overCol2 > beginCol){
                if(overCol2 < Consts.NUM_SUIT){
                    overFoundationList.add(overCol2);
                    topFoundation(overCol2, tempList);
                    beginCol = overCol2;
                }
            }
            int overY = dragCard.getY();
            if(overY < (Consts.FOUNDATION_Y + Consts.CARD_H)){
                overFoundationList.add(overCol);
                topFoundation(overCol, tempList);
            }
            repaint();
        }

        private void topColumn(int aCol, ArrayList<Card> tList) {
            Card tCard;
            if(aCol < Consts.NUM_COL){
                for (int i = 0; i < tList.size(); i++) {
                    tCard = (Card)tList.get(i);
                    theColumn[aCol].add(tCard);
                }
            }
        }

        private void topFoundation(int aCol, ArrayList<Card> tList) {
            Card tCard;
            if((aCol < Consts.NUM_SUIT) && (!theFoundation[aCol].isEmpty())){
                for (int i = 0; i < tList.size(); i++) {
                    tCard = (Card)tList.get(i);
                    theFoundation[aCol].add(tCard);
                }
            }
        }

        private void removeTopColumn(int aCol, ArrayList tList){
            Card tCard;
            if((aCol >= 0) && (aCol < Consts.NUM_COL)) {
                for (int i = 0; i < tList.size(); i++) {
                    tCard = (Card) tList.get(i);
                    theColumn[aCol].remove(tCard);
                }
            }
        }

        private void removeTopFoundation(int aCol, ArrayList tList){
            Card tCard;
            if((aCol < Consts.NUM_SUIT ) && (tList != null)) {
                for (int i = 0; i < tList.size(); i++) {
                    tCard = (Card) tList.get(i);
                    theFoundation[aCol].remove(tCard);
                }
            }
        }


        @Override
        public void mouseReleased(MouseEvent e) {
            if(!overColumnList.isEmpty()){
                for(int p = 0; p < overColumnList.size(); p++){
                    removeTopColumn(overColumnList.get(p), tempList);
                }
                overColumnList.clear();
            }
            if(!overFoundationList.isEmpty()) {
                for (int p = 0; p < overFoundationList.size(); p++) {
                    removeTopFoundation(overFoundationList.get(p), tempList);
                }
            }
            if (tempList != null) {
                if (e.getY() < Consts.COL1_Y ) {
                    if (!cardToFoundation(e.getX(), tempList)) {
                        sendBackTempList(clickCol, tempList);
                    } else {
                        if (isOver()) {
                            gameTerminate = true;
                            playerPanel.setGameTerminate(gameTerminate);
                        }
                    }
                } else {
                    int destCol = theCol(e.getX());
                    if (!cardToColumn(destCol, tempList)) {
                        sendBackTempList(clickCol, tempList);
                    }
                }
                clickCard = null;
                tempList.clear();
                tempList = null;
            }
            firstTime = true;
            repaint();
        }

        private int theCol(int x) {
                int relativeX = x - columnLeft(0);
                return (relativeX / (Consts.CARD_GAP_X + Consts.CARD_W));
        }

        private boolean dragTheCard(int evtX, int evtY, int cardX, int cardY) {
            boolean inside = false;
            if (((evtX >= cardX) && (evtX <= cardX + Consts.CARD_W)) && ((evtY >= cardY) && (evtY <= cardY + Consts.CARD_H))) {//有效点击
                inside = true;
            }
            return inside;
        }

        private boolean cardToColumn(int destCol, ArrayList tList) {
            Card tCard;
            boolean success = false;
            if (theColumn[destCol].isEmpty()) {//目标列为空
                for (int i = 0; i < tList.size(); i++) {
                    tCard = tempList.get(i);
                    appendColumn(destCol, tCard);
                }
                success = true;
            } else {//不为空
                tCard = tempList.get(0);
                if ((sameColor(tCard, exploredCard(destCol))) && (decendingRank(tCard, exploredCard(destCol)))) {
                       for(Object tList1: tList){
                           tCard = (Card) tList1;
                           appendColumn(destCol, tCard);
                       }

                    success = true;
                }
            }
            removeFromColumn(clickCol, tList);
            return success;
        }


        private void removeFromColumn(int cCol, ArrayList theList) {
            Card tCard;
            for(Object tList1 : theList){
                    tCard = (Card) tList1;
                    theColumn[cCol].remove(tCard);
            }
        }

        private void appendColumn(int destCol, Card tCard) {
            if (!theColumn[destCol].isEmpty()) {
                tCard.setX(columnLeft(destCol));
                tCard.setY(exploredCard(destCol).getY() + Consts.CARD_GAP_Y);
            } else {
                tCard.setX(columnLeft(destCol));
                tCard.setY(Consts.COL1_Y + Consts.CARD_GAP_Y);
            }
            theColumn[destCol].add(tCard);
        }

        private boolean sameColor(Card card1, Card card2) {
            boolean sameColor = false;
            if ((card1.getSuit() == Consts.CARD_CLUBS) && ((card2.getSuit() == Consts.CARD_CLUBS) || (card2.getSuit() == Consts.CARD_SPADES))) {
                sameColor = true;
            } else if ((card1.getSuit() == Consts.CARD_DIAMONDS) && ((card2.getSuit() == Consts.CARD_DIAMONDS) || (card2.getSuit() == Consts.CARD_HEARTS))) {
                sameColor = true;
            } else if ((card1.getSuit() == Consts.CARD_HEARTS) && ((card2.getSuit() == Consts.CARD_HEARTS) || (card2.getSuit() == Consts.CARD_DIAMONDS))) {
                sameColor= true;
            } else if ((card1.getSuit() == Consts.CARD_SPADES) && ((card2.getSuit() == Consts.CARD_SPADES) || (card2.getSuit() == Consts.CARD_CLUBS))) {
                sameColor = true;
            }
            return sameColor;
        }

        private boolean decendingRank(Card card1, Card card2) {
            boolean rank = false;
            if (card1.getValue()  == card2.getValue() - 1) {
                rank = true;
            }
            return rank;
        }


        private void sendBackTempList(int cCol, ArrayList tList) {
            Card tCard;
            for (Object tList1 : tList) {
                tCard = (Card) tList1;
                appendColumn(cCol, tCard);
            }
        }

        private boolean cardToFoundation(int x, ArrayList tList) {
            boolean success = false;
            int fCol, theCol = 0;
            Card fCard, tCard;
            fCol = theCol(x);
            if ((fCol >= 0) && (fCol < Consts.NUM_SUIT)) {
                theFoundation = cardLayout.getFoundation();
                int aLen = theFoundation[fCol].size();
                if (aLen > 0) {
                    fCard = (Card) theFoundation[fCol].get(aLen - 1);
                    if ((fCard.getSuit() == clickCard.getSuit()) && (fCard.getValue() == clickCard.getValue() - 1)) {
                        for (Object tList1 : tList) {
                            tCard = (Card) tList1;
                            appendToFundation(tCard, fCol);
                        }
                        success = true;
                    } else {
                    }
                } else {
                    for (int col = 0; col < Consts.NUM_SUIT; col++) {
                        if (!theFoundation[col].isEmpty()) {
                            theCol = col;
                            break;
                        }
                    }
                    if (sameRank((Card) theFoundation[theCol].get(0), (Card) tList.get(0))) {
                        for (Object tList1 : tList) {
                            tCard = (Card) tList1;
                            appendToFundation(tCard, fCol);
                        }
                        success = true;
                    }
                }
            }
            removeFromColumn(clickCol, tempList);
            return success;
        }

        private void appendToFundation(Card tCard, int fCol) {
            tCard.setX(columnLeft(fCol));
            tCard.setX(Consts.FOUNDATION_Y);
            theFoundation[fCol].add(tCard);
        }

        private boolean sameRank(Card card1, Card card2) {
            boolean sameRank = false;
            if (card1.getValue() == card2.getValue()) {
                sameRank = true;
            }
            return sameRank;
        }

        private int columnLeft(int col) {
            return (Consts.COL1_X + col * Consts.CARD_W + col * Consts.CARD_GAP_X);
        }

        private int columnRight(int col){
            return columnLeft(col) + Consts.CARD_W;
        }

        private Card exploredCard(int destCol) {
            int index = theColumn[destCol].size();
            return (Card) theColumn[destCol].get(index - 1);
        }

        private boolean isOver() {
            boolean over = false;
            int count = 0;
            for (int i = 0; i < Consts.NUM_SUIT; i++) {
                if (!theFoundation[i].isEmpty()) {
                    Card aCard = (Card) theFoundation[i].get(theFoundation[i].size() - 1);
                    if (aCard.getValue() == 13) {
                        count++;
                    }
                }
            }
            if (count == Consts.NUM_SUIT) {
                over = true;
            }
            return over;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            theColumn = cardLayout.getColumn();
            int deckX = columnLeft(0) + (Consts.NUM_COL - 1) * (Consts.CARD_GAP_X + Consts.CARD_W);
            if ((e.getX() >= deckX) && (e.getX() <= deckX + Consts.CARD_W)//玩家点击了发牌
                    && (e.getY() >= Consts.FOUNDATION_Y) && (e.getY() <= (Consts.FOUNDATION_Y + Consts.CARD_H))) {
                for (int i = 0; i < Consts.NUM_COL; i++) {
                    aCard = deck.dealCard();
                    if(aCard != null){
                    aCard.setFaceUp(true);
                    appendColumn(i, aCard);
                }
            }
        }
        repaint();
    }
}

    public void setPlayerPanel(PlayerPanel playerPanel){
        this.playerPanel = playerPanel;
    }
}


