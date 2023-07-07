package Classes;

public class ClassMagazine extends ClassPropShared {
	
	private Periodicity period;
	
	public ClassMagazine(String isbn, String title, Integer yP, Integer nPag, Periodicity period) {
		super(isbn, title, yP, nPag);
		this.period = period;
	}

	public Periodicity getPeriod() {
		return period;
	}

	public void setPeriod(Periodicity period) {
		this.period = period;
	}
	

}
