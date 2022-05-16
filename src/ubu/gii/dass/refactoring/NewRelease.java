package ubu.gii.dass.refactoring;

public class NewRelease extends MovieType {

	@Override
	public double getCharge(Rental rental) {
		return rental.getDaysRented() * 3;
	}

	@Override
	public int getType() {
		return MovieType.NEW_RELEASE;
	}

	@Override
	public int getFrecuentRenterPoints(Rental rental) {
		int frequentRenterPoints = 1;
		
		// add bonus for a two day new release rental
		if (rental.getDaysRented() > 1)
			frequentRenterPoints++;

		return frequentRenterPoints;
	}

}
