package chapter8.FourPlayers.code;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Cards {
    private ArrayList<Card> deck;
    private Card card;

    public Cards() {
        deck = new ArrayList<>();
        initCards();
    }

    public void initCards() {
        deck.clear();
        for (int i = 0; i < 52; i++) {
            card = initCard(i);
            deck.add(card);
        }

        shuffleCard();

    }

    private void shuffleCard() {
        int randIdx1, randIdx2;
        for (int i = 0; i < 500; i++) {
            randIdx1 = (int) (Math.random() * 10000 % 52);
            randIdx2 = (int) (Math.random() * 10000 % 52);
            swapCard(randIdx1, randIdx2);
        }
    }

    private void swapCard(int randIdx1, int randIdx2) {
        Card aCard = deck.get(randIdx1);
        deck.set(randIdx1, deck.get(randIdx2));
        deck.set(randIdx2, aCard);

    }

    private Card initCard(int idx) {
        Image image = null;
        try {
            image = ImageIO.read(getClass().getResource("../card/" + (idx + 1) + ".jpg"));
        } catch (IOException e) {
        }

        Card tCard = new Card();
        tCard.setCardFace(image);

        int value;
        value = idx + 1;
        if(value > 13){
            value = value % 13;
        }
        if(value == 0){
            value = 13;
        }
       if(value == 1){
           value = 14;
       }
        tCard.setValue(value);
        return tCard;
    }

    public Card dealCard(){
        Card theCard = deck.get(0);
        deck.remove(0);
        if(deck.size() < 15){
            initCards();
        }
        return theCard;
    }
}
