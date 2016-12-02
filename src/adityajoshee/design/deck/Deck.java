package adityajoshee.design.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by aditya on 9/25/16.
 */
public class Deck {
    private final int SIZE = 52;
    private final List<Card> cards;

    public List<Card> getCards() {
        return cards;
    }

    public Deck(){
        cards = new ArrayList<>(SIZE);
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public static void main(String args[]){
        Deck deck = new Deck();
        Collections.shuffle(deck.cards);
        System.out.println(deck.getCards());
        // TODO deal() the cards
    }
}
