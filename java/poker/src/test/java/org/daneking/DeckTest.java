package org.daneking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/*
Should shuffle
Should deal to hand
Should deal to hands in round robin
What happens dealing when no more cards
 */
public class DeckTest {

    private Deck deck;

    @BeforeEach
    void setUp() {
        deck = new Deck();
    }

    @Test
    void deckShouldHave52Cards() {
        assertEquals(52, deck.size(), "Should have 52 cards");
    }

    @Test
    void deckCanDealOneCard() {
        assertNotNull(deck.deal());
    }

    @Test
    void dealingOneCardShrinksSizeOfDeck() {
        int beforeSize=deck.size();
        Card card=deck.deal();
        assertEquals(beforeSize-1, deck.size());

    }
}
