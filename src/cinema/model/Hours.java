package cinema.model;

public enum Hours {
	TEN(10), TWELVE(12), FOURTEEN(14), SIXTEEN(16), EIGHTEEN(18), TWENTY(20), TWENTYTWO(22);
	
	public int hour;
	private Hours(int hour){
		this.hour=hour;
	}
}
