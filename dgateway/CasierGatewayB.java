package dgateway;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Logger;

import dconnection.ConnectionConferinta;
public class CasierGatewayB {
	protected static final Logger LOGGER = Logger.getLogger(CasierGatewayB.class.getName());
	
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
	
	public static int modificare_bilete_vandute(String tip_bilet){
		int status = 0;
		try{
			Connection connection = ConnectionConferinta.getConnection();
			PreparedStatement ps = connection.prepareStatement("UPDATE conferintadb.bilet SET bilete_vandute=? WHERE tip_bilet=?");
			ps.setInt(1, gasire_bilet(tip_bilet)+1);
			ps.setString(2, tip_bilet);
			status = ps.executeUpdate();
			connection.close();
		}catch(Exception e){
			System.out.println(e);
			}
		return status;
	}
	
	public static int obtinere_pret(String tip_bilet){
		int status = 0;
		try{
			Connection connection = ConnectionConferinta.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM conferintadb.bilet WHERE tip_bilet=?");
			ps.setString(1, tip_bilet);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				status = rs.getInt("pret");
			}
			connection.close();
		}catch(Exception e){
			System.out.println(e);
			}
		return status;
	}
}
