package chapter8.BlackJack1.code;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cards;
    private Card card;

    public Deck() {
        cards = new ArrayList<>();
        initCards();
    }

    private void initCards() {
        cards.clear();
        for (int i = 0; i < Consts.DECK_LEN; i++) {
            card = initNewCard(i);
            cards.add(card);
        }
        shuffleCard();
    }

    private Card initNewCard(int i) {
        Image image = null;
        int aValue;
        try{
            image = ImageIO.read(getClass().getResource("../card/" + (i + 1) + ".jpg"));
        } catch (IOException e) {
        }
        Card acard = new Card();
        acard.setCardFace(image);
        aValue = i % 13;
        if(aValue >= 10){
            aValue = 10;
        }else if(aValue == 0){
            aValue = 11;
        }else {
            aValue += 1;
        }
        acard.setValue(aValue);

        return acard;
    }

    public void shuffleCard(){
        int randIndex1, randIndex2;
        for (int i = 0; i < 1000; i++) {
            randIndex1 = (int)(Math.random() * 10000 % Consts.DECK_LEN);
            randIndex2 = (int)(Math.random() * 10000 % Consts.DECK_LEN);
            swap(randIndex1,randIndex2);
        }

    }

    private void swap(int index1, int index2) {
        Card tCard = cards.get(index1);
        cards.set(index1,cards.get(index2));
        cards.set(index2,tCard);
    }

    public Card dealCard(){
        Card theCard;
        theCard = cards.get(0);
        cards.remove(0);
        if(cards.size() < Consts.DECK_RENEW){
            initCards();
        }
        return theCard;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
