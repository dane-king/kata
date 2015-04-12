package com.bowling;

public class Game {

	private final Scorer scorer;

	public Game(final Scorer scorer) {
		this.scorer = scorer;
	}

	public int getScore() {
		return scorer.getScore();
	}

	public void roll(final int pins) {
		scorer.update(pins);
	}

	public static class Scorer {

        public void update(final int pins) {

        }

        public int getScore() {
            return 0;
        }

    }
}
