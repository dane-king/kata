package com.conway;

import static org.junit.Assert.assertNotSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GridTest {
	private Grid underTest;

	@Before
	public void setup() {
		List<Cell> seed = new ArrayList<Cell>();
		underTest = new Grid(seed);
	}

	@Test
	public void generateCreatesNewCells() {
		List<Cell> unexpectedCells = underTest.getCells();
		underTest.generate();
		assertNotSame(unexpectedCells, underTest.getCells());

	}

}
