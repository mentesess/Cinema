package cinema;

import cinema.model.Hall;
import cinema.model.Hours;
import cinema.model.Ticket;

public class Admin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Hall hall = new Hall(1, 3, 4, "ErolEgemen");
		Ticket ticket = new Ticket(3, 3, Hours.EIGHTEEN, hall);
		System.out.println(ticket);
		
	}

}
