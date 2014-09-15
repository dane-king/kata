package com.videostore;

public class Rental {
	public Rental(final Movie movie, final int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	int calculateFrequentRenterPoints() {
		int frequentRenterPoints = 0;
		frequentRenterPoints++;

		if (movie.isNewRelease(daysRented))
			frequentRenterPoints++;
		return frequentRenterPoints;
	}

	String getTitle() {
		return movie.getTitle();
	}

	double calculateAmount() {
		return movie.calculate(daysRented);
	}

	final Movie movie;
	final int daysRented;
}