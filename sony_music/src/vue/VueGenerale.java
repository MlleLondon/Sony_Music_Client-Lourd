package vue;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import controleur.Sony_Music;

public class VueGenerale extends JFrame implements ActionListener{
	private JPanel panelMenu= new JPanel();
	private JButton btClients= new JButton("Gestion Clients");
	private JButton btTechniciens= new JButton("Gestion Techniciens");
	private JButton btInterventions= new JButton("Gestion Interventions");
	private JButton btStats= new JButton("Statistiques");
	private JButton btProfil= new JButton("Mon Profil");
	private JButton btQuitter= new JButton("Quitter");
	
	public VueGenerale() {
		this.setTitle("Gestion des interventions");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(1, 89, 162));
		this.setBounds(100, 100, 1200, 700);
		this.setLayout(null);
		
		//Construction du panel 
		this.panelMenu.setBounds(100, 20, 1000, 40);
		this.panelMenu.setBackground(new Color(1, 89, 162));
		//1 lignes sur 5 colonnes
		this.panelMenu.setLayout(new GridLayout(1, 6));
		this.panelMenu.add(this.btProfil);
		this.panelMenu.add(this.btClients);
		this.panelMenu.add(this.btTechniciens);
		this.panelMenu.add(this.btInterventions);
		this.panelMenu.add(this.btStats);
		this.panelMenu.add(this.btQuitter);
		this.add(this.panelMenu);
		
		//Rendre les boutons ecoutables
		this.btQuitter.addActionListener(this);
		this.btClients.addActionListener(this);
		this.btProfil.addActionListener(this);
		this.btTechniciens.addActionListener(this);
		this.btInterventions.addActionListener(this);
		this.btStats.addActionListener(this);
		
		//Insertion des paneaux dans la fenêtre
		
		
		
		this.setVisible(false);
	}

	
	
	
	public static void activerPanel(int choix) {
		//Ajouter les cas de visibilité des panels
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btQuitter) {
			int retour= JOptionPane.showConfirmDialog(this, "Voulez vous quitter l'application ? ", 
					"Quitter l'application ? " ,JOptionPane.YES_NO_OPTION);
			if(retour==0) {
				this.dispose();
				Sony_Music.gererVueConnexion(true);
			}
		}
		else if(e.getSource()== this.btProfil) {
			activerPanel(1);
		}
		else if(e.getSource()== this.btClients) {
			activerPanel(2);
		}
		else if(e.getSource()== this.btTechniciens) {
			activerPanel(3);
		}
		else if(e.getSource()== this.btInterventions) {
			activerPanel(4);
		}
		else if(e.getSource()== this.btStats) {
			activerPanel(5);
		}
	}
}
