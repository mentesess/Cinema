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

		boolean[][] emptySeat;
		Hall hall = new Hall(1, 5,5, "ErolEgemen");
		Session movie = new Session("Kaybedenler Kulubu", hall, Hours.EIGHTEEN);
		//new Ticket(1, 3, movie);
		//new Ticket(2, 4, movie);
		movie.takeTicket(5, true);
		movie.takeTicket(3, true);
		movie.takeTicket(3, true);
		movie.takeTicket(3, true);

		movie.takeTicket(4, false);
		emptySeat = movie.getEmptySeats();
		
		for (int i = 0; i < emptySeat.length; i++) {
			for (int j = 0; j < emptySeat[i].length; j++) {
				System.out.print(emptySeat[i][j]+" ");
			}
			System.out.println();
		}
	}

}
