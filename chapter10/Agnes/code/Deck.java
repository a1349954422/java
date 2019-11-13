package chapter10.Agnes.code;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;


public class Deck {
    private ArrayList<Card> deck;
    private Card card;

    public Deck() {
        deck = new ArrayList<>();
        initDeck();
        shuffleCard();
    }



    private void initDeck() {
        deck.clear();
        for (int i = 0; i < Consts.DECK_LEN; i++) {
            card = initNewCard(i);
            deck.add(card);
        }
    }

    private Card initNewCard(int idx) {
        Image img = null ;
        try {
            img = ImageIO.read(getClass().getResource("../card/" + (idx + 1) + ".jpg"));
        } catch (Exception e) {
        }
        Card aCard = new Card();
        aCard.setValue((idx % 13 ) + 1 );
        aCard.setSuit(idx / 13);
        aCard.setCardFront(img);
        return aCard;
        
    }

    private void shuffleCard() {
        int randIdex1, randIdex2;
        for (int i = 0; i < 1000; i++) {
            randIdex1 = (int)(Math.random() * 10000) % Consts.DECK_LEN;
            randIdex2 = (int)(Math.random() * 10000) % Consts.DECK_LEN;
            swapCard(randIdex1, randIdex2);
        }

    }

    private void swapCard(int randIdex1, int randIdex2) {
        Card tCard = deck.get(randIdex1);
        deck.set(randIdex1, deck.get(randIdex2));
        deck.set(randIdex2, tCard);
    }

    public Card dealCard(){
        Card theCard = null;
        try{
            theCard = deck.get(0);
            deck.remove(0);
        }catch (IndexOutOfBoundsException ex){
        }
        return theCard;
    }

    public ArrayList<Card> getDeck(){
        return deck;
    }
}
