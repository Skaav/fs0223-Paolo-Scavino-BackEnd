package Classes;

import java.io.Serializable;

public abstract class ClassPropShared implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String isbn;
	protected String title;
	protected Integer yP;
	protected Integer nPag;
	
	public ClassPropShared(String isbn, String title, Integer yP, Integer nPag) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.yP = yP;
		this.nPag = nPag;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getyP() {
		return yP;
	}

	public void setyP(Integer yP) {
		this.yP = yP;
	}

	public Integer getnPag() {
		return nPag;
	}

	public void setnPag(Integer nPag) {
		this.nPag = nPag;
	}
	
	@Override
	public String toString() {
		return "ISBN: " + isbn + 
				" " + "Title: " + title + 
				" " + "Publish year: " + yP + 
				" " + "Page numbers: " + nPag;
	}
}
