package controleur;

import java.util.ArrayList;

import modele.ModeleChanson;


public class C_Chanson {
	public static void insertChanson (Chanson unChanson) {
		//on controle les donn�es
		ModeleChanson.insertChanson(unChanson);
	}
	public static ArrayList<Chanson> selectAllChansons() {
		//on controle les donn�es
		return ModeleChanson.selectAllChansons();
	}
	public static void deleteChanson (int idinter) {
		//on controle les donn�es
		ModeleChanson.deleteChanson(idinter);;
	}
	public static void updateChanson (Chanson unChanson) {
		//on controle les donn�es
		ModeleChanson.updateChanson(unChanson);
	}
	public static Chanson selectWhereChanson(int idChanson) {
		//on controle les donn�es
		return ModeleChanson.selectWhereChanson(idChanson);
	}
	
}