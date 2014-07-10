package cinema.model;

import cinema.exceptions.OutOfBoundery;
import cinema.exceptions.SameTicketException;

public class Ticket implements Comparable<Ticket> {
	private int id;

	private int rows, cols;
	private Session session;

	public Ticket(int rows, int cols, Session session) {
		super();
		this.rows = rows;
		this.cols = cols;
		
		if(!session.addTicket(this))
		{
			throw new SameTicketException();
		}
		else if (rows > session.getHall().getRows()
				|| cols > session.getHall().getCols()) {
			throw new OutOfBoundery();
		} else {
			this.session = session;

		}
	}

	public Ticket(int rows, int cols, Hours hour, Hall hall) {
		super();
		if (rows > hall.getRows() || cols > hall.getCols()) {
			throw new OutOfBoundery();
		} else {
			this.rows = rows;
			this.cols = cols;

		}
	}

	public Ticket(int id, int rows, int cols, Hours hour, Hall hall) {
		super();
		if (rows > hall.getRows() || cols > hall.getCols()) {
			throw new OutOfBoundery();
		} else {
			this.id = id;
			this.rows = rows;
			this.cols = cols;
		}
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}

	@Override
	public int compareTo(Ticket other) {
		int orderNumber = this.rows * session.getHall().getCols() + this.cols;
		int orderNumberOther = other.rows * session.getHall().getCols()
				+ other.cols;
		if (orderNumber > orderNumberOther)
			return 1;
		else if (orderNumber < orderNumberOther)
			return -1;
		else
			return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cols;
		result = prime * result + id;
		result = prime * result + rows;
		result = prime * result + ((session == null) ? 0 : session.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Ticket) {
			Ticket other = (Ticket)obj;
			if(this.session.getHall()==other.session.getHall()
					&&this.session.getHour()==other.session.getHour()
					&&this.getCols()==other.getCols()
					&&this.getRows()==other.getRows())
				return true;
			else
				return false;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Ticket [rows=" + rows + ", cols=" + cols + ", Hall="
				+ session.getHall().getName() + "]";
	}
}
