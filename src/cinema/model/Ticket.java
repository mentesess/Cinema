package cinema.model;

public class Ticket {
	private int id;
	
	private int rows,cols;
	private Hours hour;
	private Hall hall;
	
	public Ticket(int rows, int cols, Hours hour, Hall hall) {
		super();
		this.rows = rows;
		this.cols = cols;
		this.hour = hour;
		this.hall = hall;
	}
	
	public Ticket(int id, int rows, int cols, Hours hour, Hall hall) {
		super();
		this.id = id;
		this.rows = rows;
		this.cols = cols;
		this.hour = hour;
		this.hall = hall;
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
