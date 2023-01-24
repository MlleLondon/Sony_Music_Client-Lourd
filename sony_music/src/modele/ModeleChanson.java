package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Chanson;

public class ModeleChanson {
	private static Bdd uneBdd = new Bdd ("localhost", "sony_music_CL", "root", "");
	public static void insertChanson(Chanson uneChanson) 
	{
		String requete="insert into Chanson values(null,('"
				+uneChanson.getTitre()+"', '"
				+uneChanson.getDate()+"', '"
				+uneChanson.getDuree()+"', '"
				+uneChanson.getIdcategorie()+"', '"
				+uneChanson.getIdalbum()+"');";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}catch(SQLException exp) {
			System.out.println("Erreur d'exécution de : "+requete);
		}
	}
	
	public static ArrayList<Chanson> selectAllChansons(){
		String requete="select * from chanson;";
		ArrayList<Chanson> lesChansons= new ArrayList<Chanson>();
		try {
			uneBdd.seConnecter();
			Statement unStat= uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats=unStat.executeQuery(requete);
			
			//Parcourir les résultats et construire des objets
			while(desResultats.next() ) {
				Chanson uneChanson = new Chanson(
						desResultats.getInt("idchanson"), desResultats.getString("titre"),
						desResultats.getString("date"), desResultats.getString("duree"), 
						desResultats.getInt("idcategorie"), desResultats.getInt("idalbum"));
				lesChansons.add(uneChanson); 
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur d'execution de: "+requete);
		}
		return lesChansons;
	}
	
	public static void deleteChanson(int idchanson) 
	{
		String requete="delete from chanson where idchanson="+idchanson+";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}catch(SQLException exp) {
			System.out.println("Erreur d'exécution de : "+requete);
		}
	}
	
	public static void updateChanson(Chanson uneChanson) 
	{
		String requete="update chanson set titre='"+uneChanson.getTitre()+
				"', date='"+uneChanson.getDate()+
				"', duree='"+uneChanson.getDuree()+
				"', idcategorie='"+uneChanson.getIdcategorie()+"' where idchanson='"
				+uneChanson.getIdchanson()+"';";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}catch(SQLException exp) {
			System.out.println("Erreur d'exécution de : "+requete);
		}
	}
	public static Chanson selectWhereChanson (int idchanson) 
	{
		String requete ="select * from Chanson where idchanson="+idchanson+";";
		Chanson uneChanson=null;
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet unResultat = unStat.executeQuery(requete); 
			//parcourir les resultats et construire des objets chanson 
			if (unResultat.next()) {
				 uneChanson = new Chanson(
						 unResultat.getInt("idchanson"), unResultat.getString("titre"),
						 unResultat.getString("date"), unResultat.getString("duree"), 
						 unResultat.getInt("idcategorie"), unResultat.getInt("idalbum"));
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}catch(SQLException exp) {
			System.out.println("Erreur d'exécution de : "+requete);
		}
		return uneChanson;
	}
	
}
