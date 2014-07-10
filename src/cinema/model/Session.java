package cinema.model;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

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
				if (tickets.containsKey((i+1) * emptySeats[i].length + j+1)) {
					emptySeats[i][j] = true;
				} else {
					emptySeats[i][j] = false;
				}
			}
		}
		return emptySeats;
	}
}
