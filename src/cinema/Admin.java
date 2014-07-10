package cinema;

import cinema.model.Hall;
import cinema.model.Hours;
import cinema.model.Session;
import cinema.model.Ticket;

public class Admin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Hall hall = new Hall(1, 3, 4, "ErolEgemen");
		Session movie = new Session("Kaybedenler Kulubu",hall, Hours.EIGHTEEN);
		new Ticket(3, 3,movie);
		new Ticket(3, 4,movie);
		System.out.println(movie);
		
	}

}
