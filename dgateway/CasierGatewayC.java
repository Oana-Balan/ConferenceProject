package dgateway;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import dconnection.ConnectionConferinta;
import model.Casier;

public class CasierGatewayC {
	protected static final Logger LOGGER = Logger.getLogger(CasierGatewayC.class.getName());
	
	public static int vanzare_bilet(Casier c){
		int status = 0;
		String tip_bilet = c.getTip_bilet();
		try{
			Connection connection = ConnectionConferinta.getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO conferintadb.casier (id_casier,tip_bilet,timp,data) VALUES(?,?,?,?)");
			ps.setInt(1, c.getId_casier());
			ps.setString(2, c.getTip_bilet());
			ps.setTime(3, c.getTimp());
			ps.setDate(4, c.getData());
			status = ps.executeUpdate();
			if(status > 0){
				CasierGatewayB.modificare_bilete_vandute(tip_bilet);
			}
			connection.close();
		}catch(Exception e){
			System.out.println(e);
			}
		return status;
	}
	
	public static List<Casier> istoric_vanzari(){
		List<Casier> lista = new ArrayList<Casier>();
		try{
			Connection connection = ConnectionConferinta.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM conferintadb.casier ORDER BY data,timp ASC");
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
	
	public static List<Casier> istoric_bilete(){
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
	
	
}
