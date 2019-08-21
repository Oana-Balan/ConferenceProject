package dgateway;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import dconnection.ConnectionConferinta;
import model.Bilet;

public class AdministratorGatewayB {
protected static final Logger LOGGER = Logger.getLogger(AdministratorGatewayB.class.getName());
	
	public static int inserare_bilete(Bilet b){
		int status = 0;
		try{
			Connection connection = ConnectionConferinta.getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO conferintadb.bilet (tip_bilet,pret,nr_disponibile,bilete_vandute) VALUES(?,?,?,?)");
			ps.setString(1, b.getTip_bilet());
			ps.setInt(2, b.getPret());
			ps.setInt(3, b.getNr_disponibile());
			ps.setInt(4, 0);
			status = ps.executeUpdate();
			connection.close();
		}catch(Exception e){
			System.out.println(e);
			}
		return status;
	}
	
	public static int modificare_pret(int pret, String tip_bilet){
		int status = 0;
		try{
			Connection connection = ConnectionConferinta.getConnection();
			PreparedStatement ps = connection.prepareStatement("UPDATE conferintadb.bilet SET pret=? WHERE tip_bilet=?");
			ps.setInt(1, pret);
			ps.setString(2, tip_bilet);
			status = ps.executeUpdate();
			connection.close();
		}catch(Exception e){
			System.out.println(e);
			}
		return status;
	}

	public static int modificare_nr_disponibile(int nr_disponibile, String tip_bilet){
		int status = 0;
		try{
			Connection connection = ConnectionConferinta.getConnection();
			PreparedStatement ps = connection.prepareStatement("UPDATE conferintadb.bilet SET nr_disponibile=? WHERE tip_bilet=?");
			ps.setInt(1, nr_disponibile);
			ps.setString(2, tip_bilet);
			status = ps.executeUpdate();
			connection.close();
		}catch(Exception e){
			System.out.println(e);
			}
		return status;
	}
	
	public static int gasire_bilet(String tip_bilet){
		int status = 0;
		try{
			Connection connection = ConnectionConferinta.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM conferintadb.bilet WHERE tip_bilet=?");
			ps.setString(1, tip_bilet);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				status = rs.getInt("bilete_vandute");
			}
			connection.close();
		}catch(Exception e){
			System.out.println(e);
			}
		return status;
	}
	
	
	public static int modificare_bilete_vandute(String tip_bilet, int nr){
		int status = 0;
		try{
			Connection connection = ConnectionConferinta.getConnection();
			PreparedStatement ps = connection.prepareStatement("UPDATE conferintadb.bilet SET bilete_vandute=? WHERE tip_bilet=?");
			ps.setInt(1, gasire_bilet(tip_bilet)-nr);
			ps.setString(2, tip_bilet);
			status = ps.executeUpdate();
			connection.close();
		}catch(Exception e){
			System.out.println(e);
			}
		return status;
	}
	
	public static List<Bilet> lista_bilete_zi(String tip_bilet){
		List<Bilet> lista = new ArrayList<Bilet>();
		try{
			Connection connection = ConnectionConferinta.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM conferintadb.bilet WHERE tip_bilet=?");
			ps.setString(1, tip_bilet);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Bilet b = new Bilet();
				b.setTip_bilet(rs.getString(1));
				b.setPret(rs.getInt(2));
				b.setNr_disponibile(rs.getInt(3));
				b.setBilete_vandute(rs.getInt(4));
				lista.add(b);
			}
			connection.close();
		}catch(Exception e){
			System.out.println(e);
			}
		return lista;
	}
	
	public static List<Bilet> lista_bilete(){
		List<Bilet> lista = new ArrayList<Bilet>();
		try{
			Connection connection = ConnectionConferinta.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM conferintadb.bilet");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Bilet b = new Bilet();
				b.setTip_bilet(rs.getString("tip_bilet"));
				b.setPret(rs.getInt("pret"));
				b.setNr_disponibile(rs.getInt("nr_disponibile"));
				b.setBilete_vandute(rs.getInt("bilete_vandute"));
				lista.add(b);
			}
			connection.close();
		}catch(Exception e){
			System.out.println(e);
			}
		return lista;
	}
	
	public static Bilet cauta_bilete_pret(String tip_bilet){
		Bilet b = new Bilet();
		try{
			Connection connection = ConnectionConferinta.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM conferintadb.bilet WHERE tip_bilet=?");
			ps.setString(1, tip_bilet);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				b.setTip_bilet(rs.getString(1));
				b.setPret(rs.getInt(2));
				b.setNr_disponibile(rs.getInt(3));
				b.setBilete_vandute(rs.getInt(4));
			}
			connection.close();
		}catch(Exception e){
			System.out.println(e);
			}
		return b;
	}
	
	public static Bilet bilet(){
		Bilet b = new Bilet();
		try{
			Connection connection = ConnectionConferinta.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT tip_bilet FROM conferintadb.bilet WHERE tip_bilet='toate'");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				b.setTip_bilet(rs.getString("tip_bilet"));
			}
			connection.close();
		}catch(Exception e){
			System.out.println(e);
			}
		return b;
	}
	
	public static int gasire_bilet_zi(String tip_bilet){
		int status = 0;
		try{
			Connection connection = ConnectionConferinta.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM conferintadb.bilet WHERE tip_bilet=?");
			ps.setString(1, tip_bilet);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				status = rs.getInt("nr_disponibile");
			}
			connection.close();
		}catch(Exception e){
			System.out.println(e);
			}
		return status;
	}
	
	public static int stergere_bilet(String tip_bilet){
		int status = 0;
		try{
			Connection connection = ConnectionConferinta.getConnection();
			PreparedStatement ps = connection.prepareStatement("DELETE FROM conferintadb.bilet WHERE tip_bilet=?");
			ps.setString(1, tip_bilet);
			status = ps.executeUpdate();
			connection.close();
		}catch(Exception e){
			System.out.println(e);
			}
		return status;
	}
}
