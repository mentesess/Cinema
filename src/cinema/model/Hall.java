package cinema.model;

public class Hall {
	private int id;
	private int rows;
	private int cols;
	private String name;
	public int getRows() {
		return rows;
	}
	public int getCols() {
		return cols;
	}
	public String getName() {
		return name;
	}
	public Hall(int rows, int cols, String name) {
		super();
		this.rows = rows;
		this.cols = cols;
		this.name = name;
	}
	public Hall(int id,int rows, int cols, String name) {
		super();
		this.id= id;
		this.rows = rows;
		this.cols = cols;
		this.name = name;
	}
}
