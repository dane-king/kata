package org.daneking;

import java.util.ArrayList;
import java.util.List;

public class Deck extends ArrayList<Card> {
    public Deck() {
        for (Card.Rank rank : Card.Rank.values()) {
            for (Card.Suit suit : Card.Suit.values()) {
                Card card = new Card(rank, suit);
                add(card);
            }
        }
    }

    public Card deal() {
        Lists.newArrayList(1,2,3);
        return this.remove(0);
    }
}
