package dgateway;

import java.sql.*;
import java.util.*;
import java.util.logging.Logger;

import dconnection.ConnectionConferinta;
import model.Casier;

public class AdministratorGatewayC {
	protected static final Logger LOGGER = Logger.getLogger(AdministratorGatewayC.class.getName());
	
	public static List<Casier> lista_casieri(){
		List<Casier> lista = new ArrayList<Casier>();
		try{
			Connection connection = ConnectionConferinta.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM conferintadb.casier");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Casier c = new Casier();
				c.setId_casier(rs.getInt("id_casier"));
				c.setTip_bilet(rs.getString("tip_bilet"));
				c.setTimp(rs.getTime("timp"));
				c.setData(rs.getDate("data"));
				lista.add(c);
			}
			connection.close();
		}catch(Exception e){
			System.out.println(e);
			}
		return lista;
	}
	
	public static List<Casier> lista_casieri_zi(int id_casier, String tip_bilet){
		List<Casier> lista = new ArrayList<Casier>();
		try{
			Connection connection = ConnectionConferinta.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM conferintadb.casier WHERE id_casier=? AND tip_bilet=?");
			ps.setInt(1, id_casier);
			ps.setNString(2, tip_bilet);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Casier c = new Casier();
				c.setId_casier(rs.getInt(1));
				c.setTip_bilet(rs.getString(2));
				c.setTimp(rs.getTime(3));
				c.setData(rs.getDate(4));
				lista.add(c);
			}
			connection.close();
		}catch(Exception e){
			System.out.println(e);
			}
		return lista;
	}
	
	public static int stergere_casier(int id_casier, String tip_bilet){
		int status = 0;
		int nr = lista_casieri_zi(id_casier,tip_bilet).size();
		try{
			Connection connection = ConnectionConferinta.getConnection();
			PreparedStatement ps = connection.prepareStatement("DELETE FROM conferintadb.casier WHERE id_casier=? AND tip_bilet=?");
			ps.setInt(1, id_casier);
			ps.setString(2, tip_bilet);
			status = ps.executeUpdate();
			if(status > 0){
				AdministratorGatewayB.modificare_bilete_vandute(tip_bilet, nr);
			}
			connection.close();
		}catch(Exception e){
			System.out.println(e);
			}
		return status;
	}
	
	public static int inserare_casier(Casier c){
		int status = 0;
		try{
			Connection connection = ConnectionConferinta.getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO conferintadb.casier (id_casier,tip_bilet,timp,data) VALUES(?,?,?,?)");
			ps.setInt(1, c.getId_casier());
			ps.setString(2, c.getTip_bilet());
			ps.setTime(3, c.getTimp());
			ps.setDate(4, c.getData());
			status = ps.executeUpdate();
			connection.close();
		}catch(Exception e){
			System.out.println(e);
			}
		return status;
	}
	
	public static int modificare_tip_bilet(String tip_bilet, int id_casier){
		int status = 0;
		try{
			Connection connection = ConnectionConferinta.getConnection();
			PreparedStatement ps = connection.prepareStatement("UPDATE conferintadb.casier SET tip_bilet=? WHERE id_casier=?");
			ps.setString(1, tip_bilet);
			ps.setInt(2, id_casier);
			status = ps.executeUpdate();
			connection.close();
		}catch(Exception e){
			System.out.println(e);
			}
		return status;
	}
	
}
