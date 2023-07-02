package esercizio2Day2;

import java.util.ArrayList;
import java.util.List;

public class SIM {
	public String nTelefono;
	public double credito;
	public List<Chiamate> registro;
	
	public SIM(String nTelefono, double credito) {
		this.nTelefono = nTelefono;
		this.credito = credito;
		this.registro = new ArrList<>();
	}
	public String getNumero() {
		return nTelefono;
	}
	public double getCredito() {
		return credito;
	}
	public List<Chiamate> getRegistro(){
		return registro;
	}
}
