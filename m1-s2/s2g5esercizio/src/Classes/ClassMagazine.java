package Classes;

import java.io.Serializable;

public class ClassMagazine extends ClassPropShared implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
