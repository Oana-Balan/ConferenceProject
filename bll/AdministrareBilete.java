package bll;

import java.util.List;

import bll.validators.ValidatorLocuriConferinta;
import dgateway.AdministratorGatewayB;
import dgateway.CasierGatewayB;
import model.Bilet;
import model.Conferinta;

public class AdministrareBilete {
	public static boolean locuri(Bilet b1,Bilet b2,Conferinta c){
		boolean verificare = false;
		ValidatorLocuriConferinta validator = new ValidatorLocuriConferinta();
		boolean value = validator.validare(b1, b2, c);
		if(value == true){
			AdministratorGatewayB.inserare_bilete(b1);
			Bilet b = AdministratorGatewayB.bilet();
			if(b.getTip_bilet() == null)
					AdministratorGatewayB.inserare_bilete(b2);
			verificare = true;
		}else{
			verificare = false;
		}
		return verificare;
	}
	
	public static List<Bilet> lista_bil(){
		return AdministratorGatewayB.lista_bilete();
	}
	
	public static int raport_zi(String tip_bilet){
		int nr = 0;
		for(Bilet b : AdministratorGatewayB.lista_bilete_zi(tip_bilet)){
				nr = b.getPret() * b.getBilete_vandute();
		}
		System.out.println(nr);
		return nr;
	}
		
	public static int raport_incasari(){
		int nr = 0;
		int nr1 = raport_zi("ziua 1");
		int nr2 = raport_zi("ziua 2");
		int nr3 = raport_zi("ziua 3");
		int nr4 = raport_zi("toate");
		nr = nr1 + nr2 + nr3 + nr4;
		System.out.println(nr);
		return nr;
	}
	
	public static int obtinere_pret(String tip_bilet){
		return CasierGatewayB.obtinere_pret(tip_bilet);
	}
}
