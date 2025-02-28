package ubu.gii.dass.refactoring;

public class Children extends MovieType {

	@Override
	public double getCharge(Rental rental) {
		double result = 1.5;
		if (rental.getDaysRented() > 3)
			result += (rental.getDaysRented() - 3) * 1.5;

		return result;
	}

	@Override
	public int getType() {
		return MovieType.CHILDRENS;
	}

}
