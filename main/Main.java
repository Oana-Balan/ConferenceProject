package main;
import javax.swing.JOptionPane;
import view.Interfata;

public class Main {

	/*public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		String str1 = "2018-03-31";  
		String str2 = "2018-03-18"; 
	    Date date1 = Date.valueOf(str1);
	    Date date2 = Date.valueOf(str2);
	    @SuppressWarnings("deprecation")
		Time time1 = new Time(15, 36, 21);
	    @SuppressWarnings("deprecation")
		Time time2 = new Time(14, 36, 21);
		Casier c = new Casier(1,"ziua 1",time1,date1);
		Casier cc = new Casier(1,"ziua 1",time2,date1);
		Casier ccc = new Casier(1,"ziua 2",time1,date2);
		Bilet b = new Bilet("ziua 1", 200, 40);
		Bilet b1 = new Bilet("ziua 2", 250, 30);
		Bilet b2 = new Bilet("ziua 3", 250, 12);
		Bilet b3 = new Bilet("toate", 500, 30);
		Conferinta con1 = new Conferinta(1,"ziua 1",60);
		Conferinta con2 = new Conferinta(2,"ziua 2",60);
		Conferinta con3 = new Conferinta(3,"ziua 3",50);
		//AdministratorGatewayB.inserare_bilete(b);
		//AdministratorGatewayB.inserare_bilete(b1);
		//AdministratorGatewayB.inserare_bilete(b2);
		//AdministratorGatewayB.inserare_bilete(b3);
		//a.modificare_pret(200,"ziua 1");
		//a.modificare_nr_disponibile(20,"ziua1");
		
		//CasierGatewayC.vanzare_bilet(c);
		//CasierGatewayC.vanzare_bilet(cc);
		//CasierGatewayC.vanzare_bilet(ccc);
		
		//AdministratorGatewayB.modificare_nr_disponibile(4, "ziua 2");
		//AdministratorGatewayB.stergere_bilet("ziua 3");
		//AdministratorGatewayC.stergere_casier(1,"ziua 1");
		
		//AdministratorGatewayCon.inserare_conferinta(con3);
		AdministrareBilete.locuri(b, b3, con1);
		
		//System.out.println(AdministratorGatewayC.raport_casier(1, "ziua 2"));
		//AdministratorGatewayB.raport_zi("ziua 2");
		//AdministratorGatewayB.raport_incasari();
		
		//AdministrareCasier.vanzare(ccc);
		//ValidatorVanzareBilete.bilete_disponibile("ziua 1");
		for(Casier s : CasierGatewayC.istoric_vanzari()){
			System.out.println("Casier [id_casier=" + s.getId_casier() + ", tip_bilet=" + s.getTip_bilet() + ", timp=" + s.getTimp() + ", data=" + s.getData()
			+"]");
			}
		}*/
	
	public static void main(String[] args){
		try
		{
		Interfata frame = new Interfata();
		frame.setSize(600,400);
		frame.setVisible(true);
		}
	catch(Exception e){
		JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}

