package com.conway;

import java.util.ArrayList;
import java.util.List;

public class Grid {
	private List<Cell> cells;

	public Grid(final List<Cell> seed) {
		cells = createSeededList(seed);
	}

	public void generate() {
		this.cells = createNewGeneration();
	}

	private List<Cell> createNewGeneration() {
		List<Cell> newGeneration = new ArrayList<Cell>();
		for (Cell cell : cells) {
			if (cell.numberNeighbors() == 2 || cell.numberNeighbors() == 2)
				newGeneration.add(cell);
		}
		return newGeneration;
	}

	private List<Cell> createSeededList(final List<Cell> seed) {
		return new ArrayList<Cell>(seed);
	}

	public boolean isEmpty() {
		return cells.isEmpty();
	}

	public List<Cell> getCells() {
		return this.cells;
	}

}
