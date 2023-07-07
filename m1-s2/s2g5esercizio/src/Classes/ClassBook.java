package Classes;

public class ClassBook extends ClassPropShared {
	
	private String autor;
	private String genre;
	
	public ClassBook(String isbn, String title, Integer yP, Integer nPag, String autor, String genre) {
		super(isbn, title, yP, nPag);
		this.autor = autor;
		this.genre = genre;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}

	
	
}
