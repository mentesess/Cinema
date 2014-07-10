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
		new Ticket(1, 3, movie);
		new Ticket(2, 4, movie);
		emptySeat = movie.getEmptySeats();
		for (int i = 0; i < emptySeat.length; i++) {
			for (int j = 0; j < emptySeat[i].length; j++) {
				System.out.print(emptySeat[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(movie.getAvailable(2));
		System.out.println(movie);

	}

}
