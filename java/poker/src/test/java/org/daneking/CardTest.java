package org.daneking;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.daneking.Card.Rank;
import static org.daneking.Card.Suit;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

//TODO:Separate enums?

@ExtendWith(MockitoExtension.class)
public class CardTest {
    private final Card kingHearts = new Card(Rank.King, Suit.Hearts);
    private final Card kingClubs = new Card(Rank.King, Suit.Clubs);
    private final Card queenHearts = new Card(Rank.Queen, Suit.Hearts);

    @Test
    void createCardWithSuitAndValue() {
        assertThat(kingHearts.getRank(), is(Rank.King));
        assertThat(kingHearts.getSuit(),is(Suit.Hearts));
    }

//    @Test
//    void cardsShouldHaveOrder() {
//        assertThat(kingHearts, greaterThan(queenHearts));
//    }

    @Test
    void cardsShouldOfSameRankShouldBeNotEqual() {
        assertThat(kingHearts, not(equalTo(kingClubs)));
    }


}
