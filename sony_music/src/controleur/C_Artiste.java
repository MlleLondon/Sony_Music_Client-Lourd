package controleur;

import java.util.ArrayList;

import modele.ModeleArtiste;


public class C_Artiste {
	public static void insertIntervention (Artiste unArtiste) {
		//on controle les données
		ModeleArtiste.insertArtiste(unArtiste);
	}
	public static ArrayList<Artiste> selectAllArtistes() {
		//on controle les données
		return ModeleArtiste.selectAllArtistes();
	}
	public static void deleteArtiste (int idinter) {
		//on controle les données
		ModeleArtiste.deleteArtiste(idinter);;
	}
	public static void updateArtiste (Artiste unArtiste) {
		//on controle les données
		ModeleArtiste.updateArtiste(unArtiste);
	}
	public static Artiste selectWhereArtiste(int idArtiste) {
		//on controle les données
		return ModeleArtiste.selectWhereArtiste(idArtiste);
	}
	
}