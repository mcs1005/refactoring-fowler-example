package ubu.gii.dass.refactoring;

public class Regular extends MovieType {

	@Override
	public double getCharge(Rental rental) {
		int result = 2;
		if (rental.getDaysRented() > 2)
			result += (rental.getDaysRented() - 2) * 1.5;

		return result;
	}

	@Override
	public int getType() {
		return MovieType.REGULAR;
	}

}
