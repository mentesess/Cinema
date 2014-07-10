package cinema.model;

import cinema.exceptions.OutOfBoundery;

public class Ticket {
	private int id;

	private int rows, cols;
	private Hours hour;
	private Hall hall;

	public Ticket(int rows, int cols, Hours hour, Hall hall) {
		super();
		if (rows >= hall.getRows() || cols >= hall.getCols()) {
			throw new OutOfBoundery();
		} else {
			this.rows = rows;
			this.cols = cols;
			this.hour = hour;
			this.hall = hall;
		}
	}

	public Ticket(int id, int rows, int cols, Hours hour, Hall hall) {
		super();
		if (rows >= hall.getRows() || cols >= hall.getCols()) {
			throw new OutOfBoundery();
		} else {
			this.id = id;
			this.rows = rows;
			this.cols = cols;
			this.hour = hour;
			this.hall = hall;
		}	}

	@Override
	public String toString() {
		return "Ticket [rows=" + rows + ", cols=" + cols + ", hour=" + hour
				+ ", hall=" + hall.getName() + "]";
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

	public Hours getHour() {
		return hour;
	}

	public Hall getHall() {
		return hall;
	}

}
