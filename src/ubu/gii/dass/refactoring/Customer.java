package ubu.gii.dass.refactoring;

/**
* Tema  Refactorizaciones 
*
* Ejemplo de aplicaci�n de refactorizaciones. Actualizado para colecciones gen�ricas de java 1.5
*
* @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
* @version 1.1
* @see java.io.File
*
*/
import java.util.*;

public class Customer {
	private String _name;
	private List<Rental> _rentals;

	public Customer(String name) {
		_name = name;
		_rentals = new ArrayList<Rental>();

	};

	public void addRental(Rental arg) {
		_rentals.add(arg);
	}

	public String getName() {
		return _name;
	};

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentals = _rentals.iterator();

		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasNext()) {
			double thisAmount = 0;
			Rental rental = rentals.next();
			// determine amounts for each line
			thisAmount = rental.getCharge();

			// show figures for this rental
			result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
			frequentRenterPoints += rental.getFrecuentRenterPoints();
		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		return result;
	}

	public String htmlStatement(String statementString) {
		String htmlStatementString = "";
		String[] parts = statementString.split("\n");
		
		for (String part : parts) {
			if (part.indexOf("Rental Record")> -1) {
				part = "<H1>" + part + "</H1>";
			} else if (part.indexOf("Amount owed") > -1 || part.indexOf("You earned") > -1) {
				part = "<P>" + part + "</P>";
			} else {
				part = part.replaceFirst("\t", "");
				part = part.replaceAll("\t", " ");
				part = "<H2>" + part + "</H2>";
			}
			htmlStatementString += part;
		}
		return htmlStatementString;
	}
}
