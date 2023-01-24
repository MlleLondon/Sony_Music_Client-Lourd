package vue;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controleur.Agent;
import controleur.C_Agent;
import controleur.Sony_Music;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VueConnexion extends JFrame implements ActionListener, KeyListener{
    private JTextField txtEmail= new JTextField();
	private JPasswordField txtMdp= new JPasswordField();
	private JButton btAnnuler= new JButton("Annuler");
	private JButton btSeConnecter= new JButton("Connexion");
	private JPanel panelCon=new JPanel();

    public VueConnexion(){
        this.setTitle("Connexion des utilisateurs");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(1, 89, 162) );
		this.setBounds(200, 200, 700, 350);
		this.setLayout(null);
		
		ImageIcon logo= new ImageIcon("src/images/sonyMusic_logo.png");
		JLabel monLogo= new JLabel(logo);
		monLogo.setBounds(5, 5, 270, 270);
		this.add(monLogo);
		
		
		//Construction du panel connexion
		this.panelCon.setBounds(350, 20, 280, 240);
		this.panelCon.setBackground(new Color(1, 89, 162));
		
		//3 lignes sur 2 colonnes
		this.panelCon.setLayout(new GridLayout(3, 2));
		//Premiere grille ligne 1 colonne 1 on met l'email
		this.panelCon.add(new JLabel("Email"));
		this.panelCon.add(this.txtEmail);
		//Premiere grille ligne 1 colonne 2 on met le mdp
		this.panelCon.add(new JLabel("MDP"));
		this.panelCon.add(this.txtMdp);
		//Premiere grille ligne 2 colonne 1 on met le boutton Annuler
		this.panelCon.add(this.btAnnuler);
		//Premiere grille ligne 2 colonne 2 on met le boutton Se Connecter
		this.panelCon.add(this.btSeConnecter);
		this.add(this.panelCon);
		
		//Rendre les boutons écoutable
		this.btAnnuler.addActionListener(this);
		this.btSeConnecter.addActionListener(this);
		
		//Ajout evenements frappe de touche
		this.txtEmail.addKeyListener(this);
		this.txtMdp.addKeyListener(this);
		
		
		this.setVisible(true);
		
    }

    public void traitement() {
    	String email=this.txtEmail.getText();
    	String mdp= new String(this.txtMdp.getPassword());
    	
    	//Si email ou mdp vide on indique de remplir correctement les champs de connexion
    	if(email.equals("") || mdp.equals("")) {
    		JOptionPane.showMessageDialog(this, "Veuillez remplir vos identifiants !");
    	}
    	//Sinon on vérifie que les identifiants de connexion sont corrects
    	else {
    		Agent unAgent= C_Agent.selectWhereAgent(email, mdp);
    		//On vérifie si l'agent existe
    		if(unAgent==null) {
    			JOptionPane.showMessageDialog(this, "Veuillez remplir vos identifiants !");
    		}
    		else {
    			JOptionPane.showMessageDialog(this, "Bienvenue Mr./Mme. "+unAgent.getNom()+" - "+unAgent.getPrenom());
    			this.txtEmail.setText("");
    			this.txtMdp.setText("");
    			Sony_Music.gererVueConnexion(false);
    			Sony_Music.gererVueGenerale(true);
    		}
    	}
    }
    
    
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btAnnuler) {
			this.txtEmail.setText("");
			this.txtMdp.setText("");
		}
		else if(e.getSource()==this.btSeConnecter) {
			this.traitement();
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar()== KeyEvent.VK_ENTER) {
			this.traitement();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
