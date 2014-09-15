package com.conway;

public class Universe {

	private final Grid grid;

	public Universe(final Grid grid) {
		this.grid = grid;
	}

	public boolean isEmpty() {
		return grid.isEmpty();
	}

	public void tick() {
		grid.generate();
	}

}
