package controleur;

import java.util.ArrayList;

import modele.ModeleAlbum;


public class C_Album {
	public static void insertIntervention (Album unAlbum) {
		//on controle les données
		ModeleAlbum.insertAlbum(unAlbum);
	}
	public static ArrayList<Album> selectAllAlbums() {
		//on controle les données
		return ModeleAlbum.selectAllAlbums();
	}
	public static void deleteAlbum (int idinter) {
		//on controle les données
		ModeleAlbum.deleteAlbum(idinter);;
	}
	public static void updateAlbum (Album unAlbum) {
		//on controle les données
		ModeleAlbum.updateAlbum(unAlbum);
	}
	public static Album selectWhereAlbum(int idAlbum) {
		//on controle les données
		return ModeleAlbum.selectWhereAlbum(idAlbum);
	}
	
}