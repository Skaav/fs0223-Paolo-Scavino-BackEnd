package Classi;

public abstract class Elementi {

	protected String title;

	public Elementi(String title) {
		super();
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
	
	public abstract void play();
	
	public abstract void gestioneLum();
	
	public abstract void gestioneVol();

}
