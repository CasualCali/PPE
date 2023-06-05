package Vue;

import java.awt.Color; 
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleur.C_Logements;
import controleur.Logements;
import controleur.Tableau;

public class PanelLogements extends PanelPrincipal implements ActionListener{
			
	private JPanel panelForm = new JPanel();
	
	private JTextField txtlogements_name = new JTextField();
	private JTextField txtlogement_type = new JTextField();
	private JTextField txtlogement_lieu = new JTextField();
	private JTextField txtlogement_adresse = new JTextField();
	private JTextField txtlogement_nb_etoiles = new JTextField();
	private JTextField txtlogement_nb_notes = new JTextField();
	private JTextField txtlogement_description = new JTextField();
	private JTextField txtlogement_date_debut = new JTextField();
	private JTextField txtlogement_date_fin = new JTextField();
	private JTextField txtlogements_prix = new JTextField();
	
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btEnregistrer = new JButton("Enregistrer");
    private JButton btSupprimer = new JButton("Supprimer");
    	
	JLabel NomLogements = new JLabel("Nom du logement :");
	JLabel TypeLogements = new JLabel("Type du logement :");
	JLabel VilleLogements = new JLabel("Ville du logement :");
	JLabel AdresseLogements = new JLabel("Adresse du logement :");
	JLabel NbEtoilesLogements = new JLabel("Nombre d'étoiles du logement :");
	JLabel NbNotesLogements = new JLabel("Nombre d'avis sur le logement :");
	JLabel DescriptionLogements = new JLabel("Description du logement :");
	JLabel DateDebutLogements = new JLabel("Date d'arrivée au logement :");
	JLabel DateFinLogements = new JLabel("Date de départ du logement :");
	JLabel PrixLogements = new JLabel("Prix du logement :");
	
	private JTable tableLogements;
	private Tableau unTableau ;
	
	public PanelLogements(){
		super();
		this.titre.setText("GESTION DES LOGEMENTS");
		this.titre.setBounds(530, 10, 350, 40);
		
		//construction du panel Form
		this.panelForm.setBounds(60,100,450,400);
		this.panelForm.setBackground(new Color (17, 24, 39));
		this.panelForm.setLayout(new GridLayout(12,2, 10,10));
		this.panelForm.add(NomLogements);
		this.panelForm.add(this.txtlogements_name);
		NomLogements.setForeground(Color.WHITE);
		this.panelForm.add(TypeLogements);
		this.panelForm.add(this.txtlogement_type);
		TypeLogements.setForeground(Color.WHITE);
		this.panelForm.add(VilleLogements);
		this.panelForm.add(this.txtlogement_lieu);
		VilleLogements.setForeground(Color.WHITE);
		this.panelForm.add(AdresseLogements);
		this.panelForm.add(this.txtlogement_adresse);
		AdresseLogements.setForeground(Color.WHITE);	
		this.panelForm.add(NbEtoilesLogements);
		this.panelForm.add(this.txtlogement_nb_etoiles);
		NbEtoilesLogements.setForeground(Color.WHITE);
		this.panelForm.add(NbNotesLogements);
		this.panelForm.add(this.txtlogement_nb_notes);
		NbNotesLogements.setForeground(Color.WHITE);
		this.panelForm.add(DescriptionLogements);
		this.panelForm.add(this.txtlogement_description);
		DescriptionLogements.setForeground(Color.WHITE);
		this.panelForm.add(DateDebutLogements);
		this.panelForm.add(this.txtlogement_date_debut);
		DateDebutLogements.setForeground(Color.WHITE);
		this.panelForm.add(DateFinLogements);
		this.panelForm.add(this.txtlogement_date_fin);
		DateFinLogements.setForeground(Color.WHITE);	
		this.panelForm.add(PrixLogements);
		this.panelForm.add(this.txtlogements_prix);
		PrixLogements.setForeground(Color.WHITE);
		this.panelForm.add(this.btAnnuler);
		this.panelForm.add(this.btEnregistrer);
		this.panelForm.add(this.btSupprimer);
		//ajout du panelForm au panelClients
		this.add(this.panelForm);
		this.panelForm.setVisible(true);
		
		//construction de la JTbale 
		String entetes [] = {"ID Logements ", "Nom du logement", "Type du logement", "Ville", "Adresse", "nb étoiles", "nb notes", "description", "date arrivée", "date départ", "logements_prix"};
		Object [][] donnees = this.getDonnees (""); 
		
		this.unTableau = new Tableau (donnees, entetes);
		this.tableLogements = new JTable(this.unTableau);
		JScrollPane uneScroll = new JScrollPane(this.tableLogements); 
		uneScroll.setBounds(590, 80, 560, 420);
		this.add(uneScroll);
		
		this.tableLogements.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent e ){
                int numLigne = tableLogements.getSelectedRow();
                int logements_id = Integer.parseInt(tableLogements.getValueAt(numLigne, 0).toString());
               
                if(e.getClickCount() ==2){
                    int retour = JOptionPane.showConfirmDialog(null,"Voulez-vous supprimer ce logement ?","Suppression Logement",JOptionPane.YES_NO_OPTION);
                    if(retour == 0){
                        C_Logements.DeleteLogements(logements_id);
                        unTableau.deleteLigne(numLigne);
                        JOptionPane.showMessageDialog(null, "Logement supprimé avec succès");
                    }
                }else if(e.getClickCount() == 1 ){
                    //on remplie les champs pour la modification
                    txtlogements_name.setText(tableLogements.getValueAt(numLigne, 1).toString());
                    txtlogement_type.setText(tableLogements.getValueAt(numLigne, 2).toString());
                    txtlogement_lieu.setText(tableLogements.getValueAt(numLigne, 3).toString());
                    txtlogement_adresse.setText(tableLogements.getValueAt(numLigne, 4).toString());
                    txtlogement_nb_etoiles.setText(tableLogements.getValueAt(numLigne, 5).toString());
                    txtlogement_nb_notes.setText(tableLogements.getValueAt(numLigne, 6).toString());
                    txtlogement_description.setText(tableLogements.getValueAt(numLigne, 7).toString());
                    txtlogement_date_debut.setText(tableLogements.getValueAt(numLigne, 8).toString());
                    txtlogement_date_fin.setText(tableLogements.getValueAt(numLigne, 9).toString());
                    txtlogements_prix.setText(tableLogements.getValueAt(numLigne, 10).toString());
                    btEnregistrer.setText("Modifier");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
            }});

        //rendre les boutons cliquables
        this.btAnnuler.addActionListener(this);
        this.btEnregistrer.addActionListener(this);
        this.btSupprimer.addActionListener(this);
	}
	
	public Object [][] getDonnees(String filtre)
	{
		ArrayList<Logements> lesLogements = C_Logements.SelectAllLogements(); 
		Object [][] matrice = new Object [lesLogements.size()][11]; 
		int i=0; 
		for (Logements unLogement : lesLogements)
		{
			matrice[i][0]  = unLogement.getlogement_id(); 
			matrice[i][1]  = unLogement.getlogement_name();
			matrice[i][2]  = unLogement.getlogement_type();
			matrice[i][3]  = unLogement.getlogement_lieu();
			matrice[i][4]  = unLogement.getlogement_adresse();
			matrice[i][5]  = unLogement.getlogement_nb_etoiles();
			matrice[i][6]  = unLogement.getlogement_nb_notes();
			matrice[i][7]  = unLogement.getlogement_description();
			matrice[i][8]  = unLogement.getlogement_date_debut();
			matrice[i][9]  = unLogement.getlogement_date_fin();
			matrice[i][10]  = unLogement.getlogement_prix();
			i++;
		}
		return matrice;
	}

	public void ViderChamps() {
		this.txtlogements_name.setText("");
		this.txtlogement_type.setText("");
		this.txtlogement_lieu.setText("");
		this.txtlogement_adresse.setText("");
		this.txtlogement_nb_etoiles.setText("");
		this.txtlogement_nb_notes.setText("");
		this.txtlogement_description.setText("");
		this.txtlogement_date_debut.setText("");
		this.txtlogement_date_fin.setText("");
		this.txtlogements_prix.setText("");
		btEnregistrer.setText("Enregistrer");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAnnuler) {
			this.ViderChamps();
		}else if (e.getSource() == this.btEnregistrer && this.btEnregistrer.getText().equals("Enregistrer")){
			String logements_name = this.txtlogements_name.getText();
			String logement_type = this.txtlogement_type.getText();
			String logement_lieu = this.txtlogement_lieu.getText();
			String logement_adresse = this.txtlogement_adresse.getText();
			String logement_nb_etoiles = this.txtlogement_nb_etoiles.getText();
			String logement_nb_notes = this.txtlogement_nb_notes.getText();
			String logement_description = this.txtlogement_description.getText();
			String logement_date_debut = this.txtlogement_date_debut.getText();
			String logement_date_fin = this.txtlogement_date_fin.getText();
			String logements_prix = this.txtlogements_prix.getText();
			
			//instancier un client
			Logements unLogement = new Logements( logements_name, logement_type, logement_lieu, logement_adresse, logement_nb_etoiles, logement_nb_notes, logement_description, logement_date_debut, logement_date_fin, logements_prix);
		     
			// on l'enregistre dans la db
			C_Logements.InsertLogements(unLogement); 
			
			//ajout du client dans le Tableau 
			Object ligne[] = {unLogement.getlogement_id(), unLogement.getlogement_name(),
					unLogement.getlogement_type(),
					unLogement.getlogement_lieu(),
					unLogement.getlogement_adresse(),
					unLogement.getlogement_nb_etoiles(),
					unLogement.getlogement_nb_notes(),
					unLogement.getlogement_description(),
					unLogement.getlogement_date_debut(),
					unLogement.getlogement_date_fin(),
					unLogement.getlogement_prix()};
			this.unTableau.insertLigne(ligne);
			
			JOptionPane.showMessageDialog(this, "Logement ajouté avec succès");
			this.ViderChamps();
			
		}
        else if (e.getSource() == this.btEnregistrer && this.btEnregistrer.getText().equals("Modifier")){
        	String logements_name = this.txtlogements_name.getText();
        	String logement_type = this.txtlogement_type.getText();
			String logement_lieu = this.txtlogement_lieu.getText();
			String logement_adresse = this.txtlogement_adresse.getText();
			String logement_nb_etoiles = this.txtlogement_nb_etoiles.getText();
			String logement_nb_notes = this.txtlogement_nb_notes.getText();
			String logement_description = this.txtlogement_description.getText();
			String logement_date_debut = this.txtlogement_date_debut.getText();
			String logement_date_fin = this.txtlogement_date_fin.getText();
			String logements_prix = this.txtlogements_prix.getText();
            int numLigne = tableLogements.getSelectedRow();
            int logements_id = Integer.parseInt(tableLogements.getValueAt(numLigne, 0).toString());

            //instancier un objet de type Client
            Logements unLogement = new Logements(logements_name, logement_type, logement_lieu, logement_adresse, logement_nb_etoiles, logement_nb_notes, logement_description, logement_date_debut, logement_date_fin, logements_prix);
            //on l'update dans la base de données
            C_Logements.UpdateLogements(unLogement);
            //on recharge la JTable
            Object ligne[] = {unLogement.getlogement_id(),unLogement.getlogement_name(),
            		unLogement.getlogement_type(),
					unLogement.getlogement_lieu(),
					unLogement.getlogement_adresse(),
					unLogement.getlogement_nb_etoiles(),
					unLogement.getlogement_nb_notes(),
					unLogement.getlogement_description(),
					unLogement.getlogement_date_debut(),
					unLogement.getlogement_date_fin(),
            		unLogement.getlogement_prix()};
            this.unTableau.updateLigne(numLigne, ligne);

            JOptionPane.showMessageDialog(this, "Logement modifié avec succès");
            this.ViderChamps();
        }
        else if (e.getSource() == btSupprimer){
        	int retour = JOptionPane.showConfirmDialog(null,"Voulez-vous supprimer ce logement ?","Suppression Logement",JOptionPane.YES_NO_OPTION);
            if(retour == 0){
        	String logements_name = this.txtlogements_name.getText();
        	String logement_type = this.txtlogement_type.getText();
			String logement_lieu = this.txtlogement_lieu.getText();
			String logement_adresse = this.txtlogement_adresse.getText();
			String logement_nb_etoiles = this.txtlogement_nb_etoiles.getText();
			String logement_nb_notes = this.txtlogement_nb_notes.getText();
			String logement_description = this.txtlogement_description.getText();
			String logement_date_debut = this.txtlogement_date_debut.getText();
			String logement_date_fin = this.txtlogement_date_fin.getText();
			String logements_prix = this.txtlogements_prix.getText();
            int numLigne = tableLogements.getSelectedRow();
            int logements_id = Integer.parseInt(tableLogements.getValueAt(numLigne, 0).toString());

            //instancier un objet de type Client
            Logements unLogement = new Logements(logements_name, logement_type, logement_lieu, logement_adresse, logement_nb_etoiles, logement_nb_notes, logement_description, logement_date_debut, logement_date_fin, logements_prix);
            //on l'update dans la base de données
            C_Logements.DeleteLogements(logements_id);
            //on recharge la JTable
            Object ligne[] = {unLogement.getlogement_id(),unLogement.getlogement_name(),
            		unLogement.getlogement_type(),
					unLogement.getlogement_lieu(),
					unLogement.getlogement_adresse(),
					unLogement.getlogement_nb_etoiles(),
					unLogement.getlogement_nb_notes(),
					unLogement.getlogement_description(),
					unLogement.getlogement_date_debut(),
					unLogement.getlogement_date_fin(),
            		unLogement.getlogement_prix()};
            this.unTableau.updateLigne(numLigne, ligne);

            JOptionPane.showMessageDialog(this, "Logement supprimé avec succès");
            this.ViderChamps();
            }
        }			
	}
}
