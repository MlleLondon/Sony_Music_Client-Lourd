package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleur.C_Artiste;
import controleur.Artiste;

public class PanelArtistes extends PanelPrincipal implements ActionListener {

	private JPanel panelForm = new JPanel();
    private JPanel panelTable = new JPanel();

    private JButton btAnnuler = new JButton("Annuler");
    private JButton btEnregistrer = new JButton("Enregistrer");
    private JTextField txtNom = new JTextField();
    private JTextField txtPrenom = new JTextField();
    private JTextField txtEmail = new JTextField();
    private JTextField txtTel = new JTextField();
	private JTextField txtNomdeScene = new JTextField();
	private JTextField txtTypePrincipal = new JTextField();
	private JTextField txtIdAgent = new JTextField();

    public PanelArtistes() {
		super (Color.cyan);

        // Construction du PanelForm
        this.panelForm.setBounds(40, 40, 300, 300);
        this.panelForm.setLayout(new GridLayout(7,2));
        this.panelForm.add(new JLabel("Nom :"));
        this.panelForm.add(this.txtNom);
        this.panelForm.add(new JLabel("Prénom :"));
        this.panelForm.add(this.txtPrenom);
        this.panelForm.add(new JLabel("Email :"));
        this.panelForm.add(this.txtEmail);
        this.panelForm.add(new JLabel("Téléphone :"));
        this.panelForm.add(this.txtTel);
        this.panelForm.add(new JLabel("Nom de scène :"));
        this.panelForm.add(this.txtNomdeScene);
		this.panelForm.add(new JLabel("Type principal :"));
        this.panelForm.add(this.txtTypePrincipal);
        this.panelForm.add(this.btAnnuler);
        this.panelForm.add(this.btEnregistrer);
        this.panelForm.setBackground(Color.lightGray);
        this.panelForm.setVisible(true);

        this.add(this.panelForm);

        // Construction du PanelTable
        this.panelTable.setBounds(400, 80, 300, 300);
        this.panelTable.setBackground(new Color(255, 184, 51 ));
        this.panelTable.setLayout(null);
        String entetes [] = {"IDUser", "Nom", "Prénom", "Email", "Téléphone", "Nom de scène", "Type principal", "IDAgent"};

        this.tableArtistes = new JTable(this.obtenirArtistes(), entetes);
        JScrollPane uneScroll = new JScrollPane(this.tableArtistes);
        uneScroll.setBounds(20, 20, 250, 250);
        this.panelTable.add(uneScroll);
        
        this.add(this.panelTable);

        // Rendre les boutons écoutables
        this.btAnnuler.addActionListener(this);
        this.btEnregistrer.addActionListener(this);
	}

    // Déclaration de table des artistes
    private JTable tableArtistes;
    

    public Object[][] obtenirArtistes() {
        ArrayList<Artiste> lesArtistes = C_Artiste.selectAllArtistes();
        Object [][] matrice = new Object [lesArtistes.size()][8];
        int i = 0;
        for (Artiste unArtiste : lesArtistes)
        {
            matrice[i][0] = unArtiste.getIduser();
            matrice[i][1] = unArtiste.getNom();
            matrice[i][2] = unArtiste.getPrenom();
            matrice[i][3] = unArtiste.getEmail();
            matrice[i][4] = unArtiste.getTelephone();
            matrice[i][5] = unArtiste.getNomDeScene();
			matrice[i][6] = unArtiste.getTypePrincipal();
			matrice[i][7] = unArtiste.getIdagent();
            i++;
        }
        return matrice;
    }

    public void viderChamps() {
        this.txtNom.setText("");
        this.txtPrenom.setText("");
        this.txtEmail.setText("");
        this.txtTel.setText("");
        this.txtNomdeScene.setText("");
		this.txtTypePrincipal.setText("");
		this.txtIdAgent.setText("");
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAnnuler) {
            this.viderChamps();
        }
        else if (e.getSource() == this.btEnregistrer) {
            String nom = this.txtNom.getText();
            String prenom = this.txtPrenom.getText();
            String email = this.txtEmail.getText();
            String telephone = this.txtTel.getText();
            String nomDeScene = this.txtNomdeScene.getText();
			String typeprincipal = this.txtTypePrincipal.getText();

			try {
				int idAgent=Integer.parseInt(this.txtIdAgent.getText());

				// Instancier un artiste
				Artiste unArtiste = new Artiste(nom, email, nomDeScene, telephone, telephone, prenom, nomDeScene, typeprincipal, idAgent);
				C_Artiste.insertArtiste(unArtiste);
				JOptionPane.showMessageDialog(this, "Insertion réussie de l'artiste");
				this.viderChamps();
			}
			catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "L'ID Agent n'est pas un entier !");
			}

        }
		
	}
}
