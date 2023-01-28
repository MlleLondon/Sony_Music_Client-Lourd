package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameListener;

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 

import controleur.C_Album;
import controleur.C_Artiste;
import controleur.Album;
import controleur.Artiste;

public class PanelAlbums extends PanelPrincipal implements ActionListener, ItemListener {

	private JPanel panelForm = new JPanel();
    private JPanel panelTable = new JPanel();

    private JButton btAnnuler = new JButton("Annuler");
    private JButton btEnregistrer = new JButton("Enregistrer");
    private JTextField txtNom = new JTextField();
	private JTextField txtAnneeSortie = new JTextField();


	private JTextField txtIdArtiste = new JTextField();


    // Déclaration de table des artistes
    private JTable tableAlbums;

    public PanelAlbums() {
		super (Color.cyan);

        // Construction du PanelForm
        this.panelForm.setBounds(40, 40, 300, 300);
        this.panelForm.setLayout(new GridLayout(5,2));
        this.panelForm.add(new JLabel("Nom :"));
        this.panelForm.add(this.txtNom);
		this.panelForm.add(new JLabel("Année de sortie :"));
        this.panelForm.add(this.txtAnneeSortie);
        this.panelForm.add(this.btAnnuler);
        this.panelForm.add(this.btEnregistrer);
        this.panelForm.setBackground(Color.lightGray);
        this.panelForm.setVisible(true);

        this.add(this.panelForm);

        // Construction du PanelTable
        this.panelTable.setBounds(400, 80, 300, 300);
        this.panelTable.setBackground(new Color(255, 184, 51 ));
        this.panelTable.setLayout(null);
        String entetes [] = {"IDAlbum", "Nom", "AnneeSortie", "IDArtiste"};

        this.tableAlbums = new JTable(this.obtenirAlbums(), entetes);
        JScrollPane uneScroll = new JScrollPane(this.tableAlbums);
        uneScroll.setBounds(20, 20, 250, 250);
        this.panelTable.add(uneScroll);
        
        this.add(this.panelTable);

        // Rendre les boutons écoutables
        this.btAnnuler.addActionListener(this);
        this.btEnregistrer.addActionListener(this);

	}
    

    public Object[][] obtenirAlbums() {
        ArrayList<Album> lesAlbums = C_Album.selectAllAlbums();
        Object [][] matrice = new Object [lesAlbums.size()][4];
        int i = 0;
        for (Album unAlbum : lesAlbums)
        {
            matrice[i][0] = unAlbum.getIdalbum();
            matrice[i][1] = unAlbum.getNom();
            matrice[i][2] = unAlbum.getAnneeSortie();
            matrice[i][3] = unAlbum.getIdartiste();
            i++;
        }
        return matrice;
    }

	public Object[] recupererArtistes() {
        ArrayList<Artiste> lesArtistes = C_Artiste.selectAllArtistes();
        Object [] matrice = new Object [lesArtistes.size()];
        int i = 0;
        for (Artiste unArtiste : lesArtistes)
        {
            matrice[i] = unArtiste.getNom();
            i++;
        }
        return matrice;
    }

	

    public void viderChamps() {
        this.txtNom.setText("");
		this.txtAnneeSortie.setText("");
		this.txtIdArtiste.setText("");
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAnnuler) {
            this.viderChamps();
        }
        else if (e.getSource() == this.btEnregistrer) {
            String nom = this.txtNom.getText();
			Integer AnneeSortie = Integer.parseInt(this.txtAnneeSortie.getText());

			try {
				int idArtiste =Integer.parseInt(this.txtIdArtiste.getText());

				// Instancier un artiste
				Album unAlbum = new Album(nom, AnneeSortie, idArtiste);
				C_Album.insertAlbum(unAlbum);
				JOptionPane.showMessageDialog(this, "Insertion réussie de l'album");
				this.viderChamps();
			}
			catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "L'ID Artiste n'est pas un entier !");
			}

        }
		
	}


	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	

}
