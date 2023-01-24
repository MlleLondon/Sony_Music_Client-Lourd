package controleur;

import java.util.ArrayList;

import modele.ModeleAgent;


public class C_Agent {
	public static void insertIntervention (Agent unAgent) {
		//on controle les données
		ModeleAgent.insertAgent(unAgent);
	}
	public static ArrayList<Agent> selectAllAgents() {
		//on controle les données
		return ModeleAgent.selectAllAgents();
	}
	public static void deleteAgent (int idinter) {
		//on controle les données
		ModeleAgent.deleteAgent(idinter);;
	}
	public static void updateAgent (Agent unAgent) {
		//on controle les données
		ModeleAgent.updateAgent(unAgent);
	}
	public static Agent selectWhereAgent(int idAgent) {
		//on controle les données
		return ModeleAgent.selectWhereAgent(idAgent);
	}
	public static Agent selectWhereAgent(String email, String mdp) {
		//on controle les données
		return ModeleAgent.selectWhereAgent(email, mdp);
	}
}
