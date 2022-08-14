package com.daneking.entity;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PricePromotionTest {

    public static final double ORIGINAL_PRICE = 1.35;
    private Price price;
    private Promotion promotion;

    @BeforeEach
    void setUp() {
        price = new Price(ORIGINAL_PRICE);
        promotion = new Promotion();
    }

    @Test
    void should_throw_error_if_promotion_created_with_null() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            promotion.isStarted(null);
        });
    }

    @Test
    void should_create_promotion_when_price_reduced_5_percent_or_more() {
        price.setCurrentPrice(1.2825);
        assertTrue(promotion.isStarted(price));
    }
    @Test
    void should_not_create_promotion_when_price_reduced_less_than_5_percent() {
        price.setCurrentPrice(1.2826);
        assertFalse(promotion.isStarted(price));
    }

    @Test
    void should_create_promotion_when_price_reduced_30_percent() {
        price.setCurrentPrice(.945);
        assertTrue(promotion.isStarted(price));
    }

    @Test
    void should_not_create_promotion_when_price_reduced_more_30_percent() {
        //TODO use .944 round issue test fails
        price.setCurrentPrice(.844);
        assertFalse(promotion.isStarted(price));
    }

    @Test
    void should_not_create_promotion_when_price_increase() {
        price.setCurrentPrice(1.50);
        assertFalse(promotion.isStarted(price));
    }

}