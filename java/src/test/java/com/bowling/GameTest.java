package com.bowling;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class GameTest {

	@Mock
	private Game.Scorer scorer;

	private Game game;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		game = new Game(scorer);
	}

	@Test
	public void shouldReturn0ScoreWhenGameIsCreated() {
		assertEquals(0, game.getScore());
	}

	@Test
	public void shouldCallUpdateScoreWhenRollIsCalled() {
		int pins = 0;
		game.roll(pins);
		verify(scorer).update(0);
	}
}
