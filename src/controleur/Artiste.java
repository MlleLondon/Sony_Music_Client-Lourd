package controleur;

public class Artiste {
	private int iduser, idagent;
	private String nom, email, mdp ,telephone, role, prenom, nomDeScene, typePrincipal;
	
	public Artiste(int iduser, String nom, String email, String mdp, String telephone, String role, String prenom,
			String nomDeScene, String typePrincipal, int idagent) {
		this.iduser = iduser;
		this.nom = nom;
		this.email = email;
		this.mdp = mdp;
		this.telephone = telephone;
		this.role = role;
		this.prenom = prenom;
		this.nomDeScene = nomDeScene;
		this.typePrincipal = typePrincipal;
		this.idagent = idagent;
	}
	public Artiste( String nom, String email, String mdp, String telephone, String role, String prenom,
			String nomDeScene, String typePrincipal, int idagent) {
		this.nom = nom;
		this.email = email;
		this.mdp = mdp;
		this.telephone = telephone;
		this.role = role;
		this.prenom = prenom;
		this.nomDeScene = nomDeScene;
		this.typePrincipal = typePrincipal;
		this.idagent = idagent;
	}
	public Artiste() {
		this.iduser = 0;
		this.nom = "";
		this.email = "";
		this.mdp = "";
		this.telephone = "";
		this.role = "";
		this.prenom = "";
		this.nomDeScene = "";
		this.typePrincipal = "";
		this.idagent = 0;
	}
	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public int getIdagent() {
		return idagent;
	}

	public void setIdagent(int idagent) {
		this.idagent = idagent;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNomDeScene() {
		return nomDeScene;
	}

	public void setNomDeScene(String nomDeScene) {
		this.nomDeScene = nomDeScene;
	}

	public String getTypePrincipal() {
		return typePrincipal;
	}

	public void setTypePrincipal(String typePrincipal) {
		this.typePrincipal = typePrincipal;
	}
	
}
