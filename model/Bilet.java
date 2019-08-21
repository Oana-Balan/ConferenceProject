package model;

public class Bilet {
	private String tip_bilet;
	private int pret;
	private int nr_disponibile;
	private int bilete_vandute;
	
	public Bilet(){
		
	}
	public Bilet(String tip_bilet, int pret, int nr_disponibile) {
		super();
		this.tip_bilet = tip_bilet;
		this.pret = pret;
		this.nr_disponibile = nr_disponibile;
	}

	public String getTip_bilet() {
		return tip_bilet;
	}

	public void setTip_bilet(String tip_bilet) {
		this.tip_bilet = tip_bilet;
	}

	public int getPret() {
		return pret;
	}

	public void setPret(int pret) {
		this.pret = pret;
	}

	public int getNr_disponibile() {
		return nr_disponibile;
	}

	public void setNr_disponibile(int nr_disponibile) {
		this.nr_disponibile = nr_disponibile;
	}

	public int getBilete_vandute() {
		return bilete_vandute;
	}

	public void setBilete_vandute(int bilete_vandute) {
		this.bilete_vandute = bilete_vandute;
	}
	
	@Override
	public String toString() {
		return "Bilet [tip_bilet=" + tip_bilet + ", pret=" + pret + ", nr_disponibile=" + nr_disponibile + ", bilete_vandute=" + bilete_vandute + "]";
	}
	
	
}
