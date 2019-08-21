package dgateway;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import dconnection.ConnectionConferinta;
import model.Casier;
import model.Conferinta;

public class AdministratorGatewayCon {
	protected static final Logger LOGGER = Logger.getLogger(AdministratorGatewayC.class.getName());
	
	public static int inserare_conferinta(Conferinta c){
		int status = 0;
		try{
			Connection connection = ConnectionConferinta.getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO conferintadb.conferinta (nr_sali,ziua,capacitate_maxima) VALUES(?,?,?)");
			ps.setInt(1, c.getNr_sali());
			ps.setString(2, c.getZiua());
			ps.setInt(3, c.getCapacitate_maxima());
			status = ps.executeUpdate();
			connection.close();
		}catch(Exception e){
			System.out.println(e);
			}
		return status;
	}
	
	public static int modificare_capacitate(String ziua, int capacitate){
		int status = 0;
		try{
			Connection connection = ConnectionConferinta.getConnection();
			PreparedStatement ps = connection.prepareStatement("UPDATE conferintadb.conferinta SET capacitate_maxima=? WHERE ziua=?");
			ps.setInt(1, capacitate);
			ps.setString(2, ziua);
			status = ps.executeUpdate();
			connection.close();
		}catch(Exception e){
			System.out.println(e);
			}
		return status;
	}
	
	public static Conferinta conferinta(String ziua){
		Conferinta c = new Conferinta();
		try{
			Connection connection = ConnectionConferinta.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT capacitate_maxima FROM conferintadb.conferinta WHERE ziua=?");
			ps.setString(1, ziua);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				c.setCapacitate_maxima(rs.getInt("capacitate_maxima"));
			}
			connection.close();
		}catch(Exception e){
			System.out.println(e);
			}
		System.out.println("confe "+c.getZiua()+c.getCapacitate_maxima());
		return c;
	}
	
	public static Conferinta afis_conf(String ziua){
		Conferinta c = new Conferinta();
		try{
			Connection connection = ConnectionConferinta.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM conferintadb.conferinta WHERE ziua=?");
			ps.setString(1, ziua);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				c.setNr_sali(rs.getInt(1));
				c.setZiua(rs.getString(2));
				c.setCapacitate_maxima(rs.getInt(3));
			}
			connection.close();
		}catch(Exception e){
			System.out.println(e);
			}
		return c;
	}
	
	public static List<Conferinta> lista_conferinta(){
		List<Conferinta> lista = new ArrayList<Conferinta>();
		try{
			Connection connection = ConnectionConferinta.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM conferintadb.conferinta");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Conferinta c = new Conferinta();
				c.setNr_sali(rs.getInt("nr_sali"));
				c.setZiua(rs.getString("ziua"));
				c.setCapacitate_maxima(rs.getInt("capacitate_maxima"));
				lista.add(c);
			}
			connection.close();
		}catch(Exception e){
			System.out.println(e);
			}
		return lista;
	}
}
