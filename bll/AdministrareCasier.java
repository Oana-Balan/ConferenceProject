package bll;

import java.util.List;

import bll.validators.ValidatorVanzareBilete;
import dgateway.AdministratorGatewayB;
import dgateway.AdministratorGatewayC;
import dgateway.AdministratorGatewayCon;
import dgateway.CasierGatewayC;
import model.Bilet;
import model.Casier;
import model.Conferinta;

public class AdministrareCasier {
	
	public static boolean vanzare(Casier c){
		boolean verificat = false;
		ValidatorVanzareBilete validator = new ValidatorVanzareBilete();
		boolean value = validator.validare(c.getTip_bilet());
		if( value == true){
				CasierGatewayC.vanzare_bilet(c);
				verificat = true;
		}
		else{
			verificat = false;
		}
		return verificat;
	}
	
	public static List<Casier> lista_cas(){
		return AdministratorGatewayC.lista_casieri();
	}
	
	public static List<Conferinta> lista_conf(){
		return AdministratorGatewayCon.lista_conferinta();
	}
	
	public static int modificare(int pret, String tip_bilet){
		return AdministratorGatewayB.modificare_pret(pret, tip_bilet);
	}
	
	public static Bilet cauta_pret(String str){
		return AdministratorGatewayB.cauta_bilete_pret(str);
	}
	
	public static int modificare_disp(int disp, String tip_bilet){
		return AdministratorGatewayB.modificare_nr_disponibile(disp, tip_bilet);
	}
	
	public static int modificare_cap(String ziua, int cap){
		return AdministratorGatewayCon.modificare_capacitate(ziua, cap);
	}
	
	public static Conferinta afis_con(String ziua){
		return AdministratorGatewayCon.afis_conf(ziua);
	}
	
	public static int stergere_cas(int id_casier, String tip_bilet){
		return AdministratorGatewayC.stergere_casier(id_casier, tip_bilet);
	}
	
	public static int raport_casier(int id_casier, String tip_bilet){
		int nr = AdministratorGatewayC.lista_casieri_zi(id_casier,tip_bilet).size();
		return nr;
	}
	public static List<Casier> istoric_vanzari(){
		return CasierGatewayC.istoric_vanzari();
	}
	
	public static int inserare_casier(Casier c){
		return AdministratorGatewayC.inserare_casier(c);
	}
}
