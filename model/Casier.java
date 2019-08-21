package model;

import java.sql.Time;
import java.sql.Date;

public class Casier {
	private int id_casier;
	private String tip_bilet;
	private Time timp;
	private Date data;
	
	public Casier(){
		
	}
	
	public Casier(int id_casier, String tip_bilet, Time timp, Date data) {
		super();
		this.id_casier = id_casier;
		this.tip_bilet = tip_bilet;
		this.timp = timp;
		this.data = data;
	}

	public int getId_casier() {
		return id_casier;
	}

	public void setId_casier(int id_casier) {
		this.id_casier = id_casier;
	}

	public String getTip_bilet() {
		return tip_bilet;
	}

	public void setTip_bilet(String tip_bilet) {
		this.tip_bilet = tip_bilet;
	}

	public Time getTimp() {
		return timp;
	}

	public void setTimp(Time timp) {
		this.timp = timp;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Casier [id_casier=" + id_casier + ", tip_bilet=" + tip_bilet + ", timp=" + timp + ", data=" + data
				+"]";
	}
	
}
