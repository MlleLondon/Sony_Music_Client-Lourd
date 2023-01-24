package controleur;

import java.util.ArrayList;

import modele.ModeleChanson;


public class C_Chanson {
	public static void insertIntervention (Chanson unChanson) {
		//on controle les données
		ModeleChanson.insertChanson(unChanson);
	}
	public static ArrayList<Chanson> selectAllChansons() {
		//on controle les données
		return ModeleChanson.selectAllChansons();
	}
	public static void deleteChanson (int idinter) {
		//on controle les données
		ModeleChanson.deleteChanson(idinter);;
	}
	public static void updateChanson (Chanson unChanson) {
		//on controle les données
		ModeleChanson.updateChanson(unChanson);
	}
	public static Chanson selectWhereChanson(int idChanson) {
		//on controle les données
		return ModeleChanson.selectWhereChanson(idChanson);
	}
	
}