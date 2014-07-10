package cinema.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import cinema.exceptions.SameTicketException;

public class Session {

	private Hall hall;
	private Hours hour;
	private String movieName;
	private HashMap<Integer, Ticket> tickets;
	private int counter;

	public Hours getHour() {
		return hour;
	}

	public String getMovieName() {
		return movieName;
	}

	public Session(String movieName, Hall hall, Hours hour) {
		super();
		this.hall = hall;
		this.tickets = new HashMap<>();
		counter = 0;
		this.movieName = movieName;
		this.hour = hour;
		this.hall = hall;
	}

	public boolean addTicket(Ticket newTicket) {
		if (tickets.containsKey(newTicket.getRows() * this.getHall().getCols()
				+ newTicket.getCols())) {
			return false;
		} else {
			tickets.put(newTicket.getRows() * this.getHall().getCols()
					+ newTicket.getCols(), newTicket);
			counter++;
			return true;
		}
	}

	public int getCounter() {
		return counter;
	}

	public void print() {
		for (int i = 0; i < hall.getRows(); i++) {
			for (int j = 0; j < hall.getCols(); j++) {
				// if(tickets.get(i))
			}
		}
	}

	public Hall getHall() {
		return hall;
	}

	public HashMap<Integer, Ticket> getTickets() {
		return tickets;
	}

	@Override
	public String toString() {
		return "Session [hall=" + hall + ", hour=" + hour + ", movieName="
				+ movieName + ", tickets=" + tickets + ", Tickets count="
				+ counter + "]";
	}

	public boolean[][] getEmptySeats() {
		boolean[][] emptySeats = new boolean[hall.getRows()][hall.getCols()];
		for (int i = 0; i < emptySeats.length; i++) {
			for (int j = 0; j < emptySeats[i].length; j++) {
				if (tickets.containsKey((i) * emptySeats[i].length + j)) {
					emptySeats[i][j] = false;
				} else {
					emptySeats[i][j] = true;
				}
			}
		}
		return emptySeats;
	}

	/**
	 * 
	 * @return all available seats
	 */
	public int getAvailable() {
		boolean[][] emptySeats = getEmptySeats();
		int counter = 0;
		for (int i = 0; i < emptySeats.length; i++) {
			for (int j = 0; j < emptySeats[i].length; j++) {
				if (emptySeats[i][j]) {
					counter++;
				}
			}
		}
		return counter;
	}

	/**
	 * 
	 * @param order
	 *            seats order
	 * @return all available seats in this order
	 */
	private boolean getAvailable(int numPeople) {
		boolean[][] emptySeats = getEmptySeats();
		int counter = 0;
		for (int i = 0; i < emptySeats.length; i++) {
			for (int j = 0; j < emptySeats[i].length; j++) {
				if (emptySeats[i][j] == false) {
					counter = 0;
				} else {
					counter++;
				}
				if (counter == numPeople) {
					while (counter > 0) {
						new Ticket(i, j - counter+1, this);
						counter--;
					}
					return true;
				}
			}
			counter = 0;
		}
		return false;
	}

	private boolean getSeat(int numPeople) {
		boolean[][] emptySeats = getEmptySeats();
		for (int i = 0; i < emptySeats.length; i++) {
			for (int j = 0; j < emptySeats[i].length; j++) {
				if (numPeople == 0) {
					return true;
				} 
				else{
					if (emptySeats[i][j] == true) {
						numPeople--;
						new Ticket(i, j, this);
					}
				}
			}
		}
		return false;
	}

	public boolean takeTicket(int numPeople, boolean separate) {
		if (separate == true) {
			return getAvailable(numPeople);
		} else {
			return getSeat(numPeople);
		}

	}

}
