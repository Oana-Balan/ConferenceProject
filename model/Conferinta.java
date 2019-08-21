package model;

public class Conferinta {
	private int nr_sali;
	private String ziua;
	private int capacitate_maxima;
	
	public Conferinta(){
		
	}
	public Conferinta(int nr_sali, String ziua, int capacitate_maxima) {
		super();
		this.nr_sali = nr_sali;
		this.ziua = ziua;
		this.capacitate_maxima = capacitate_maxima;
	}

	public int getNr_sali() {
		return nr_sali;
	}

	public void setNr_sali(int nr_sali) {
		this.nr_sali = nr_sali;
	}

	public int getCapacitate_maxima() {
		return capacitate_maxima;
	}

	public void setCapacitate_maxima(int capacitate_maxima) {
		this.capacitate_maxima = capacitate_maxima;
	}
	public String getZiua() {
		return ziua;
	}
	public void setZiua(String ziua) {
		this.ziua = ziua;
	}
	
	
}
