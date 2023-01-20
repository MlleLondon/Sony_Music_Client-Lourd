package src.controleur;

import java.util.ArrayList;

import src.modele.ModeleArtiste;


public class C_Artiste {
	public static void insertIntervention (Artiste unArtiste) {
		//on controle les donn�es
		ModeleArtiste.insertArtiste(unArtiste);
	}
	public static ArrayList<Artiste> selectAllArtistes() {
		//on controle les donn�es
		return ModeleArtiste.selectAllArtistes();
	}
	public static void deleteArtiste (int idinter) {
		//on controle les donn�es
		ModeleArtiste.deleteArtiste(idinter);;
	}
	public static void updateArtiste (Artiste unArtiste) {
		//on controle les donn�es
		ModeleArtiste.updateArtiste(unArtiste);
	}
	public static Artiste selectWhereArtiste(int idArtiste) {
		//on controle les donn�es
		return ModeleArtiste.selectWhereArtiste(idArtiste);
	}
	
}