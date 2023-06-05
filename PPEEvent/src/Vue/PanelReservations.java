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

import controleur.C_Reservations;
import controleur.Reservations;
import controleur.Tableau;

public class PanelReservations extends PanelPrincipal implements ActionListener{
			
	private JPanel panelForm 					= new JPanel();
	
	private JTextField txtreservation_type		= new JTextField();
	private JTextField txtville_depart 			= new JTextField();
	private JTextField txtdestination_name 		= new JTextField();
	private JTextField txtdate_depart 			= new JTextField();
	private JTextField txtnb_personnes 			= new JTextField();
	private JTextField txtlogement_id 			= new JTextField();
	private JTextField txtlogement_name 		= new JTextField();
	private JTextField txtlogement_type 		= new JTextField();
	private JTextField txtlogement_nb_etoiles 	= new JTextField();
	private JTextField txtlogement_date_debut 	= new JTextField();
	private JTextField txtlogement_date_fin 	= new JTextField();
	private JTextField txtnumero 				= new JTextField();
	private JTextField txtheure_depart 			= new JTextField();
	private JTextField txtheure_arrivee 		= new JTextField();
	private JTextField txtreservations_prix 	= new JTextField();
	private JTextField txtnom 					= new JTextField();
	private JTextField txtprenom 				= new JTextField();
	private JTextField txtemail 				= new JTextField();
	
	private JButton btAnnuler 			= new JButton("Annuler");
	private JButton btEnregistrer	 	= new JButton("Enregistrer");
    private JButton btSupprimer 		= new JButton("Supprimer");
	
	JLabel TypeReservation 				= new JLabel("Type de reservation :");
	JLabel VilleDepart 					= new JLabel("Ville de départ :");
	JLabel VilleArrivee 				= new JLabel("Ville d'arrivée :");
	JLabel DateTrajet 					= new JLabel("Date du trajet :");
	JLabel NbPersonnes 					= new JLabel("Nombres de personne :");
	JLabel IDLogement 					= new JLabel("Logement id:");
	JLabel LogementNom 					= new JLabel("Nom du logement :");
	JLabel LogementType 				= new JLabel("Type de logement :");
	JLabel NBEtoiles 					= new JLabel("Nombre d'étoiles :");
	JLabel DateDebut 					= new JLabel("Date d'arrivée au logement :");
	JLabel DateFin						= new JLabel("Date de départ du logement :");
	JLabel NumeroTrajet					= new JLabel("Numero du trajet :");
	JLabel HeureDepart					= new JLabel("Heure de départ du trajet :");
	JLabel HeureArrivee					= new JLabel("Heure d'arrivée du trajet :");
	JLabel ReservationsPrix				= new JLabel("Prix :");
	JLabel Nom							= new JLabel("Nom :");
	JLabel Prenom						= new JLabel("Prénom :");
	JLabel Email						= new JLabel("Email :");
	
	private JTable tableReservations;
	private Tableau unTableau ;
				
	public PanelReservations(){
		super();
		this.titre.setText("GESTION DES RESERVATIONS");
		this.titre.setBounds(525, 10, 350, 40);
		
		//construction du panel Form
		this.panelForm.setBounds(60,50,450,540);
		this.panelForm.setBackground(new Color (17, 24, 39));
		this.panelForm.setLayout(new GridLayout(20,2, 10,10));
		this.panelForm.add(TypeReservation);
		this.panelForm.add(this.txtreservation_type);
		TypeReservation.setForeground(Color.WHITE);
		this.panelForm.add(VilleDepart);
		this.panelForm.add(this.txtville_depart);
		VilleDepart.setForeground(Color.WHITE);
		this.panelForm.add(VilleArrivee);
		this.panelForm.add(this.txtdestination_name);
		VilleArrivee.setForeground(Color.WHITE);
		this.panelForm.add(DateTrajet);
		this.panelForm.add(this.txtdate_depart);
		DateTrajet.setForeground(Color.WHITE);
		this.panelForm.add(NbPersonnes);
		this.panelForm.add(this.txtnb_personnes);
		NbPersonnes.setForeground(Color.WHITE);	
		this.panelForm.add(IDLogement);
		this.panelForm.add(this.txtlogement_id);
		IDLogement.setForeground(Color.WHITE);
		this.panelForm.add(LogementNom);
		this.panelForm.add(this.txtlogement_name);
		LogementNom.setForeground(Color.WHITE);		
		this.panelForm.add(LogementType);
		this.panelForm.add(this.txtlogement_type);
		LogementType.setForeground(Color.WHITE);	
		this.panelForm.add(NBEtoiles);
		this.panelForm.add(this.txtlogement_nb_etoiles);
		NBEtoiles.setForeground(Color.WHITE);		
		this.panelForm.add(DateDebut);
		this.panelForm.add(this.txtlogement_date_debut);
		DateDebut.setForeground(Color.WHITE);	
		this.panelForm.add(DateFin);
		this.panelForm.add(this.txtlogement_date_fin);
		DateFin.setForeground(Color.WHITE);		
		this.panelForm.add(NumeroTrajet);
		this.panelForm.add(this.txtnumero);
		NumeroTrajet.setForeground(Color.WHITE);		
		this.panelForm.add(HeureDepart);
		this.panelForm.add(this.txtheure_depart);
		HeureDepart.setForeground(Color.WHITE);		
		this.panelForm.add(HeureArrivee);
		this.panelForm.add(this.txtheure_arrivee);
		HeureArrivee.setForeground(Color.WHITE);		
		this.panelForm.add(ReservationsPrix);
		this.panelForm.add(this.txtreservations_prix);
		ReservationsPrix.setForeground(Color.WHITE);		
		this.panelForm.add(Nom);
		this.panelForm.add(this.txtnom);
		Nom.setForeground(Color.WHITE);		
		this.panelForm.add(Prenom);
		this.panelForm.add(this.txtprenom);
		Prenom.setForeground(Color.WHITE);		
		this.panelForm.add(Email);
		this.panelForm.add(this.txtemail);
		Email.setForeground(Color.WHITE);	
		this.panelForm.add(this.btAnnuler);
		this.panelForm.add(this.btEnregistrer);
		this.panelForm.add(this.btSupprimer);
		//ajout du panelForm au panelReservations
		this.add(this.panelForm);
		this.panelForm.setVisible(true);
		
		//construction de la JTbale 
		String entetes [] = {"reservation_type", "ville_depart", "destination_name", "date_depart", "nb_personnes", "logement_id", "logement_name", "logement_type", "logement_nb_etoiles", "logement_date_debut", "logement_date_fin", "numero","heure_depart","heure_arrivee", "reservations_prix", "nom", "prenom", "email"};
		Object [][] donnees = this.getDonnees (""); 
        
		this.unTableau = new Tableau (donnees, entetes);
		this.tableReservations = new JTable(this.unTableau);
		JScrollPane uneScroll = new JScrollPane(this.tableReservations); 
		uneScroll.setBounds(590, 80, 560, 420);
		this.add(uneScroll);
	
        this.tableReservations.addMouseListener(new MouseAdapter(){

        @Override
        public void mouseClicked(MouseEvent e ){
            int numLigne = tableReservations.getSelectedRow();
            int reservation_id = Integer.parseInt(tableReservations.getValueAt(numLigne, 0).toString());
           
            if(e.getClickCount() ==2){
                int retour = JOptionPane.showConfirmDialog(null,"Voulez-vous supprimer cette reservation ?","Suppression Reservation",JOptionPane.YES_NO_OPTION);
                if(retour == 0){
                    C_Reservations.deleteReservations(reservation_id);
                    unTableau.deleteLigne(numLigne);
                    JOptionPane.showMessageDialog(null, "Reservation supprimée avec succès");
                }
            }else if(e.getClickCount() == 1 ){
            	txtreservation_type.setText(tableReservations.getValueAt(numLigne, 1).toString());
            	txtville_depart.setText(tableReservations.getValueAt(numLigne, 2).toString());
            	txtdestination_name.setText(tableReservations.getValueAt(numLigne, 3).toString());
            	txtdate_depart.setText(tableReservations.getValueAt(numLigne, 3).toString());
            	txtnb_personnes.setText(tableReservations.getValueAt(numLigne, 4).toString());
            	txtlogement_id.setText(tableReservations.getValueAt(numLigne, 5).toString());
            	txtlogement_name.setText(tableReservations.getValueAt(numLigne, 6).toString());
            	txtlogement_type.setText(tableReservations.getValueAt(numLigne, 7).toString());
            	txtlogement_nb_etoiles.setText(tableReservations.getValueAt(numLigne, 8).toString());
            	txtlogement_date_debut.setText(tableReservations.getValueAt(numLigne, 9).toString());
            	txtlogement_date_fin.setText(tableReservations.getValueAt(numLigne, 10).toString());
            	txtnumero.setText(tableReservations.getValueAt(numLigne, 11).toString());
            	txtheure_depart.setText(tableReservations.getValueAt(numLigne, 12).toString());
            	txtheure_arrivee.setText(tableReservations.getValueAt(numLigne, 13).toString());
            	txtreservations_prix.setText(tableReservations.getValueAt(numLigne, 14).toString());
            	txtnom.setText(tableReservations.getValueAt(numLigne, 15).toString());
            	txtprenom.setText(tableReservations.getValueAt(numLigne, 16).toString());
            	txtemail.setText(tableReservations.getValueAt(numLigne, 17).toString());
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
		ArrayList<Reservations> lesReservations = C_Reservations.selectAllReservations(); 
		Object [][] matrice = new Object [lesReservations.size()][18]; 
		int i=0; 
		for (Reservations uneReservation : lesReservations)
		{
			matrice[i][0]  	= uneReservation.getreservation_type(); 
			matrice[i][1]  	= uneReservation.getville_depart(); 
			matrice[i][2]  	= uneReservation.getdestination_name(); 
			matrice[i][3]  	= uneReservation.getdate_depart();  
			matrice[i][4]  	= uneReservation.getnb_personnes();  
			matrice[i][5]  	= uneReservation.getlogement_id(); 
			matrice[i][6]  	= uneReservation.getlogement_name();  
			matrice[i][7]  	= uneReservation.getlogement_type();  
			matrice[i][8]  	= uneReservation.getlogement_nb_etoiles();
			matrice[i][9]  	= uneReservation.getlogement_date_debut();
			matrice[i][10]  = uneReservation.getlogement_date_fin();
			matrice[i][11]  = uneReservation.getnumero();
			matrice[i][12]  = uneReservation.getheure_depart();
			matrice[i][13]  = uneReservation.getheure_arrivee();
			matrice[i][14]  = uneReservation.getreservations_prix();
			matrice[i][15]  = uneReservation.getnom();
			matrice[i][16]  = uneReservation.getprenom();
			matrice[i][17]  = uneReservation.getemail();
			i++;
		}
		return matrice;
	}

	public void ViderChamps() {
		this.txtreservation_type.setText("");
		this.txtville_depart.setText("");
		this.txtdestination_name.setText("");
		this.txtdate_depart.setText("");
		this.txtnb_personnes.setText("");
		this.txtlogement_id.setText("");
		this.txtlogement_name.setText("");
		this.txtlogement_type.setText("");
		this.txtlogement_nb_etoiles.setText("");
		this.txtlogement_date_debut.setText("");
		this.txtlogement_date_fin.setText("");
		this.txtnumero.setText("");
		this.txtheure_depart.setText("");
		this.txtheure_arrivee.setText("");
		this.txtreservations_prix.setText("");
		this.txtnom.setText("");
		this.txtprenom.setText("");
		this.txtemail.setText("");
	}
	
	@Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.btAnnuler){
        	this.ViderChamps();
        }else if (e.getSource() == this.btEnregistrer && this.btEnregistrer.getText().equals("Enregistrer")){
        	String reservation_type = this.txtreservation_type.getText();
			String ville_depart = this.txtreservation_type.getText();
			String destination_name = this.txtdestination_name.getText();
			String date_depart = this.txtdate_depart.getText();
			String nb_personnes = this.txtnb_personnes.getText();
			String logement_id = this.txtlogement_id.getText();
			String logement_name = this.txtlogement_name.getText();
			String logement_type = this.txtlogement_type.getText();
			String logement_nb_etoiles = this.txtlogement_nb_etoiles.getText();
			String logement_date_debut = this.txtlogement_date_debut.getText();
			String logement_date_fin = this.txtlogement_date_fin.getText();
			String numero = this.txtnumero.getText();
			String heure_depart = this.txtheure_depart.getText();
			String heure_arrivee = this.txtheure_arrivee.getText();
			String reservations_prix = this.txtreservations_prix.getText();
			String nom = this.txtnom.getText();
			String prenom = this.txtprenom.getText();
			String email = this.txtemail.getText();

            //instancier un objet de type Reservation
            Reservations uneReservation = new Reservations( reservation_type, ville_depart, destination_name, date_depart, nb_personnes, logement_id,
            		logement_name, logement_type, logement_nb_etoiles, logement_date_debut, logement_date_fin, 
            		numero, heure_depart, heure_arrivee, reservations_prix, nom, prenom, email);
            //on l'enregistre dans la base de données
            C_Reservations.insertReservations(uneReservation);
            //on recharge la JTable
            Object ligne[] = {uneReservation.getreservation_type(), uneReservation.getville_depart(), 
            		uneReservation.getdestination_name(), uneReservation.getdate_depart(),
            		uneReservation.getnb_personnes(),uneReservation.getlogement_id(),
            		uneReservation.getlogement_name(),uneReservation.getlogement_type(),
            		uneReservation.getlogement_nb_etoiles(), uneReservation.getlogement_date_debut(),
            		uneReservation.getlogement_date_fin(), uneReservation.getnumero(),
            		uneReservation.getheure_depart(), uneReservation.getheure_arrivee(),
            		uneReservation.getreservations_prix(),uneReservation.getnom(),
            		uneReservation.getprenom(), uneReservation.getemail()};
	                this.unTableau.insertLigne(ligne);

            JOptionPane.showMessageDialog(this, "Reservation ajoutée avec succès");
            this.ViderChamps();
        }
        else if (e.getSource() == this.btEnregistrer && this.btEnregistrer.getText().equals("Modifier")){
        	String reservation_type = this.txtreservation_type.getText();
        	String ville_depart = this.txtville_depart.getText();
			String destination_name = this.txtdestination_name.getText();
			String date_depart = this.txtdate_depart.getText();
			String nb_personnes = this.txtnb_personnes.getText();
			String logement_id = this.txtlogement_id.getText();
			String logement_name = this.txtlogement_name.getText();
			String logement_type = this.txtlogement_type.getText();
			String logement_nb_etoiles = this.txtlogement_nb_etoiles.getText();
			String logement_date_debut = this.txtlogement_date_debut.getText();
			String logement_date_fin = this.txtlogement_date_fin.getText();
			String numero = this.txtnumero.getText();
			String heure_depart = this.txtheure_depart.getText();
			String heure_arrivee = this.txtheure_arrivee.getText();
			String reservations_prix = this.txtreservations_prix.getText();
			String nom = this.txtnom.getText();
			String prenom = this.txtprenom.getText();
			String email = this.txtemail.getText();
            int numLigne = tableReservations.getSelectedRow();
            int id_reservation = Integer.parseInt(tableReservations.getValueAt(numLigne, 0).toString());

            //instancier un objet de type Reservation
            Reservations uneReservation = new Reservations(id_reservation, reservation_type, ville_depart, destination_name, date_depart, nb_personnes, logement_id,
            		logement_name, logement_type, logement_nb_etoiles, logement_date_debut, logement_date_fin, 
            		numero, heure_depart, heure_arrivee, reservations_prix, nom, prenom, email);
            //on l'update dans la base de données
            C_Reservations.updateReservations(uneReservation);
            //on recharge la JTable
            Object ligne[] = {uneReservation.getreservation_type(), uneReservation.getville_depart(), 
            		uneReservation.getdestination_name(), uneReservation.getdate_depart(),
            		uneReservation.getnb_personnes(),uneReservation.getlogement_id(),
            		uneReservation.getlogement_name(),uneReservation.getlogement_type(),
            		uneReservation.getlogement_nb_etoiles(), uneReservation.getlogement_date_debut(),
            		uneReservation.getlogement_date_fin(), uneReservation.getnumero(),
            		uneReservation.getheure_depart(), uneReservation.getheure_arrivee(),
            		uneReservation.getreservations_prix(),uneReservation.getnom(),
            		uneReservation.getprenom(), uneReservation.getemail()};

            JOptionPane.showMessageDialog(this, "Reservation modifiée avec succès");
            this.ViderChamps();
        }
        else if (e.getSource() == btSupprimer){
        	int retour = JOptionPane.showConfirmDialog(null,"Voulez-vous supprimer cette reservation ?","Suppression Reservation",JOptionPane.YES_NO_OPTION);
            if(retour == 0){
            	String reservation_type = this.txtreservation_type.getText();
            	String ville_depart = this.txtville_depart.getText();
    			String destination_name = this.txtdestination_name.getText();
    			String date_depart = this.txtdate_depart.getText();
    			String nb_personnes = this.txtnb_personnes.getText();
    			String logement_id = this.txtlogement_id.getText();
    			String logement_name = this.txtlogement_name.getText();
    			String logement_type = this.txtlogement_type.getText();
    			String logement_nb_etoiles = this.txtlogement_nb_etoiles.getText();
    			String logement_date_debut = this.txtlogement_date_debut.getText();
    			String logement_date_fin = this.txtlogement_date_fin.getText();
    			String numero = this.txtnumero.getText();
    			String heure_depart = this.txtheure_depart.getText();
    			String heure_arrivee = this.txtheure_arrivee.getText();
    			String reservations_prix = this.txtreservations_prix.getText();
    			String nom = this.txtnom.getText();
    			String prenom = this.txtprenom.getText();
    			String email = this.txtemail.getText();
            int numLigne = tableReservations.getSelectedRow();
            int id_reservation = Integer.parseInt(tableReservations.getValueAt(numLigne, 0).toString());

          //instancier un objet de type Reservation
            Reservations uneReservation = new Reservations(id_reservation, reservation_type, ville_depart, destination_name, date_depart, nb_personnes, logement_id, logement_name, logement_type, logement_nb_etoiles, logement_date_debut, logement_date_fin, numero, heure_depart, heure_arrivee, reservations_prix, nom, prenom, email);
            //on l'update dans la base de données
            C_Reservations.deleteReservations(id_reservation);
            //on recharge la JTable
            Object ligne[] = {uneReservation.getreservation_type(), uneReservation.getville_depart(), 
            		uneReservation.getdestination_name(), uneReservation.getdate_depart(),
            		uneReservation.getnb_personnes(),uneReservation.getlogement_id(),
            		uneReservation.getlogement_name(),uneReservation.getlogement_type(),
            		uneReservation.getlogement_nb_etoiles(), uneReservation.getlogement_date_debut(),
            		uneReservation.getlogement_date_fin(), uneReservation.getnumero(),
            		uneReservation.getheure_depart(), uneReservation.getheure_arrivee(),
            		uneReservation.getreservations_prix(),uneReservation.getnom(),
            		uneReservation.getprenom(), uneReservation.getemail()};

            JOptionPane.showMessageDialog(this, "Reservation supprimée avec succès");
            this.ViderChamps();
            }
        }
    }
}












