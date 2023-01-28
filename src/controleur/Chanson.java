package controleur;

public class Chanson {
	private int idchanson; 
	private String titre;
	private String date;
	private String duree;
	private int idcategorie;
	private int idalbum;
	public Chanson(int idchanson, String titre, String date, String duree, int idcategorie, int idalbum) 
	{
		this.idchanson = idchanson;
		this.titre = titre;
		this.date = date;
		this.duree = duree;
		this.idcategorie = idcategorie;
		this.idalbum = idalbum;
	}
	public Chanson( String titre, String date, String duree, int idcategorie, int idalbum) 
	{
		this.titre = titre;
		this.date = date;
		this.duree = duree;
		this.idcategorie = idcategorie;
		this.idalbum = idalbum;
	}
	public Chanson() 
	{
		this.idchanson = 0;
		this.titre = "";
		this.date = "";
		this.duree = "";
		this.idcategorie = 0;
		this.idalbum = 0;
	}
	public int getIdchanson() {
		return idchanson;
	}
	public void setIdchanson(int idchanson) {
		this.idchanson = idchanson;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDuree() {
		return duree;
	}
	public void setDuree(String duree) {
		this.duree = duree;
	}
	public int getIdcategorie() {
		return idcategorie;
	}
	public void setIdcategorie(int idcategorie) {
		this.idcategorie = idcategorie;
	}
	public int getIdalbum() {
		return idalbum;
	}
	public void setIdalbum(int idalbum) {
		this.idalbum = idalbum;
	}
	
}
