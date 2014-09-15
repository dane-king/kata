package com.conway;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UniverseTest {

	private Universe underTest;
	@Mock
	private Grid grid;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		underTest = new Universe(grid);

	}

	@Test
	public void isEmptyShouldCallIsEmpty() {
		underTest.isEmpty();
		verify(grid).isEmpty();
	}

	@Test
	public void tickShouldCallGridGenerate() {
		underTest.tick();
		verify(grid).generate();
	}

}
