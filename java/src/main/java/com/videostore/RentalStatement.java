package com.videostore;

import java.util.ArrayList;
import java.util.List;

public class RentalStatement {
	public void addRental(final Rental rental) {
		rentals.add(rental);
	}

	final List<Rental> rentals = new ArrayList<Rental>();

	String createRentalStatement(final String customerName) {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		String result = createHeader(customerName);

		for (Rental rental : rentals) {
			frequentRenterPoints += rental.calculateFrequentRenterPoints();
			final double thisAmount = rental.calculateAmount();
			result += getRentalStatementLine(rental.getTitle(), thisAmount);
			totalAmount += thisAmount;
		}

		result += createFooter(totalAmount, frequentRenterPoints);
		return result;
	}

	private String getRentalStatementLine(final String title, final double thisAmount) {
		return "\t" + title + "\t" + String.valueOf(thisAmount) + "\n";
	}

	private String createHeader(final String customerName) {
		String result = "Rental Record for " + customerName + "\n";
		return result;
	}

	private String createFooter(final double totalAmount, final int frequentRenterPoints) {
		String result = "";
		result += "You owed " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points\n";
		return result;
	}

}
