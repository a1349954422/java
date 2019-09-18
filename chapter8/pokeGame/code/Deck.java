package chapter8.pokeGame.code;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> deck;
    private Card card;

    public Deck() {
        deck = new ArrayList<>();
        initDeck();
    }

    public void initDeck() {
        for (int i = 0; i < 52; i++) {
            card = initCard(i);
            deck.add(card);
        }
        shuffleCard();
    }



    private Card initCard(int idx) {
        Card acard = new Card();
        Image img = null;
        try{
            img = ImageIO.read(getClass().getResource("../card/" + (idx + 1) + ".jpg" ));
        } catch (IOException e) {
        }
        acard.setImage(img);

        int value = idx + 1;

        if(value % 13 == 0) {
            value = 13;
        }else{
            value = value % 13;
        }
        acard.setValue(value);
        return acard;
    }

    private void shuffleCard() {
        int randIdx1;
        int randIdx2;
        for (int i = 0; i < 1000; i++) {
            randIdx1 = (int) (Math.random() * 10000 % 52);
            randIdx2 = (int) (Math.random() * 10000 % 52);
            swap(randIdx1,randIdx2);
        }
    }

    private void swap(int randIdx1, int randIdx2) {
        Card acard = deck.get(randIdx1);
        deck.set(randIdx1, deck.get(randIdx2));
        deck.set(randIdx2, acard);
    }

    public ArrayList<Card> initCard(){
        ArrayList<Card> halfCard = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            halfCard.add(deck.get(i));
            deck.remove(i);
        }
        return halfCard;
    }

    public Card dealHandCard(){
        Card tCard = deck.get(0);
        deck.remove(0);
        return tCard;
    }
}
