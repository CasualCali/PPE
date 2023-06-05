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

import controleur.C_Transports;
import controleur.Tableau;
import controleur.Transports;

public class PanelTransports extends PanelPrincipal implements ActionListener{
	
	private JPanel panelForm 				= new JPanel();
	
	private JTextField txttransport_name 	= new JTextField();
	private JTextField txtville_depart 		= new JTextField();
	private JTextField txtville_arrivee 	= new JTextField();
	private JTextField txttransport_date 	= new JTextField();
	private JTextField txtheure_depart 		= new JTextField();
	private JTextField txtheure_arrivee 	= new JTextField();
	private JTextField txtnumero 			= new JTextField();
	private JTextField txtcompagnie 		= new JTextField();
	private JTextField txtmodele 			= new JTextField();
	private JTextField txtheure_de_trajet 	= new JTextField();
	private JTextField txttransport_prix 	= new JTextField();
	
	private JButton btAnnuler 				= new JButton("Annuler");
	private JButton btEnregistrer 			= new JButton("Enregistrer");
    private JButton btSupprimer 			= new JButton("Supprimer");
	
	JLabel NomTransport 					= new JLabel("Nom du transport :");
	JLabel VilleDepart 						= new JLabel("Ville de départ :");
	JLabel VilleArrivee 					= new JLabel("Ville d'arrivée :");
	JLabel TransportDate 					= new JLabel("Date du trajet :");
	JLabel HeureDepart 						= new JLabel("Heure de départ :");
	JLabel HeureArrivee 					= new JLabel("Heure d'arrivée :");
	JLabel Numero 							= new JLabel("Numéro du moyen de transport :");
	JLabel Compagnie 						= new JLabel("Compagnie :");
	JLabel Modele 							= new JLabel("Modele du moyen de transport :");
	JLabel HeureTrajet 						= new JLabel("Nombres d'heures du trajet :");
	JLabel PrixTransport 					= new JLabel("Prix du transport :");
	
	private JTable tableTransport;
	private Tableau unTableau ;
	
	public PanelTransports(){
		super();
		this.titre.setText("GESTION DES TRANSPORTS");
		this.titre.setBounds(530, 10, 350, 40);
		
		//construction du panel Form
		this.panelForm.setBounds(60,90,450,450);
		this.panelForm.setBackground(new Color (17, 24, 39));
		this.panelForm.setLayout(new GridLayout(14,2, 10,10));
		this.panelForm.add(NomTransport);
		this.panelForm.add(this.txttransport_name);
		NomTransport.setForeground(Color.WHITE);
		this.panelForm.add(VilleDepart);
		this.panelForm.add(this.txtville_depart);
		VilleDepart.setForeground(Color.WHITE);
		this.panelForm.add(VilleArrivee);
		this.panelForm.add(this.txtville_arrivee);
		VilleArrivee.setForeground(Color.WHITE);
		this.panelForm.add(TransportDate);
		this.panelForm.add(this.txttransport_date);
		TransportDate.setForeground(Color.WHITE);
		this.panelForm.add(HeureDepart);
		this.panelForm.add(this.txtheure_depart);
		HeureDepart.setForeground(Color.WHITE);
		this.panelForm.add(HeureArrivee);
		this.panelForm.add(this.txtheure_arrivee);
		HeureArrivee.setForeground(Color.WHITE);
		this.panelForm.add(Numero);
		this.panelForm.add(this.txtnumero);
		Numero.setForeground(Color.WHITE);
		this.panelForm.add(Compagnie);
		this.panelForm.add(this.txtcompagnie);
		Compagnie.setForeground(Color.WHITE);
		this.panelForm.add(Modele);
		this.panelForm.add(this.txtmodele);
		Modele.setForeground(Color.WHITE);
		this.panelForm.add(HeureTrajet);
		this.panelForm.add(this.txtheure_de_trajet);
		HeureTrajet.setForeground(Color.WHITE);
		this.panelForm.add(PrixTransport);
		this.panelForm.add(this.txttransport_prix);
		PrixTransport.setForeground(Color.WHITE);
		this.panelForm.add(this.btAnnuler);
		this.panelForm.add(this.btEnregistrer);
		this.panelForm.add(this.btSupprimer);
		//ajout du panelForm au panelTransports
		this.add(this.panelForm);
		this.panelForm.setVisible(true);
		
		//construction de la JTbale 
		String entetes [] = {"ID Transport", "Nom du transport", "ville de départ", "ville d'arrivée", "date du transport", "heure de départ", "heure d'arrivée", "numero", "compagnie", "modèle", "heure de trajet", "Prix"};
		Object [][] donnees = this.getDonnees (""); 
		
		this.unTableau = new Tableau (donnees, entetes);
		this.tableTransport = new JTable(this.unTableau);
		JScrollPane uneScroll = new JScrollPane(this.tableTransport); 
		uneScroll.setBounds(590, 80, 560, 420);
		this.add(uneScroll);
		
		this.tableTransport.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent e ){
                int numLigne = tableTransport.getSelectedRow();
                int transport_id = Integer.parseInt(tableTransport.getValueAt(numLigne, 0).toString());
               
                if(e.getClickCount() ==2){
                    int retour = JOptionPane.showConfirmDialog(null,"Voulez-vous supprimer ce transport ?","Suppression Transport",JOptionPane.YES_NO_OPTION);
                    if(retour == 0){
                        C_Transports.deletetransports(transport_id);
                        unTableau.deleteLigne(numLigne);
                        JOptionPane.showMessageDialog(null, "Transport supprimé avec succès");
                    }
                }else if(e.getClickCount() == 1 ){
                    //on remplie les champs pour la modification
                    txttransport_name.setText(tableTransport.getValueAt(numLigne, 1).toString());
                    txtville_depart.setText(tableTransport.getValueAt(numLigne, 2).toString());
                    txtville_arrivee.setText(tableTransport.getValueAt(numLigne, 3).toString());
                    txttransport_date.setText(tableTransport.getValueAt(numLigne, 4).toString());
                    txtheure_depart.setText(tableTransport.getValueAt(numLigne, 5).toString());
                    txtheure_arrivee.setText(tableTransport.getValueAt(numLigne, 6).toString());
                    txtnumero.setText(tableTransport.getValueAt(numLigne, 7).toString());
                    txtcompagnie.setText(tableTransport.getValueAt(numLigne, 8).toString());
                    txtmodele.setText(tableTransport.getValueAt(numLigne, 9).toString());
                    txtheure_de_trajet.setText(tableTransport.getValueAt(numLigne, 10).toString());
                    txttransport_prix.setText(tableTransport.getValueAt(numLigne, 11).toString());
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
		ArrayList<Transports> lesTransports = C_Transports.selectAllTransports(); 
		Object [][] matrice = new Object [lesTransports.size()][12]; 
		int i=0; 
		for (Transports unTransport : lesTransports)
		{
			matrice[i][0]  = unTransport.gettransport_id(); 
			matrice[i][1]  = unTransport.gettransport_name();
			matrice[i][2]  = unTransport.getville_depart();
			matrice[i][3]  = unTransport.getville_arrivee();
			matrice[i][4]  = unTransport.gettransport_date();
			matrice[i][5]  = unTransport.getheure_depart();
			matrice[i][6]  = unTransport.getheure_arrivee();
			matrice[i][7]  = unTransport.getnumero();
			matrice[i][8]  = unTransport.getcompagnie();
			matrice[i][9]  = unTransport.getmodele();
			matrice[i][10]  = unTransport.getheure_de_trajet();
			matrice[i][11]  = unTransport.gettransport_prix();
			i++;
		}
		return matrice;
	}

	public void ViderChamps() {
		this.txttransport_name.setText("");
		this.txtville_depart.setText("");
		this.txtville_arrivee.setText("");
		this.txttransport_date.setText("");
		this.txtheure_depart.setText("");
		this.txtheure_arrivee.setText("");
		this.txtnumero.setText("");
		this.txtcompagnie.setText("");
		this.txtmodele.setText("");
		this.txtheure_de_trajet.setText("");
		this.txttransport_prix.setText("");
		btEnregistrer.setText("Enregistrer");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAnnuler) {
			this.ViderChamps();
		}else if (e.getSource() == this.btEnregistrer && this.btEnregistrer.getText().equals("Enregistrer")){
			String transport_name = this.txttransport_name.getText();
			String ville_depart = this.txtville_depart.getText();
			String ville_arrivee = this.txtville_arrivee.getText();
			String transport_date = this.txttransport_date.getText();
			String heure_depart = this.txtheure_depart.getText();
			String heure_arrivee = this.txtheure_arrivee.getText();
			String numero = this.txtnumero.getText();
			String compagnie = this.txtcompagnie.getText();
			String modele = this.txtmodele.getText();
			String heure_de_trajet = this.txtheure_de_trajet.getText();
			String transport_prix = this.txttransport_prix.getText();
			
			//instancier un transport
			Transports unTransport = new Transports( transport_name, ville_depart, ville_arrivee, transport_date, heure_depart, heure_arrivee, numero, compagnie, modele, heure_de_trajet, transport_prix);
		     
			// on l'enregistre dans la db
			C_Transports.inserttransport(unTransport); 
			
			//ajout du transport dans le Tableau 
			Object ligne[] = {unTransport.gettransport_id(), unTransport.gettransport_name(), 
					unTransport.getville_depart(),
					unTransport.getville_arrivee(),
					unTransport.gettransport_date(),
					unTransport.getheure_depart(),
					unTransport.getheure_arrivee(),
					unTransport.getnumero(),
					unTransport.getcompagnie(),
					unTransport.getmodele(),
					unTransport.getheure_de_trajet(),
					unTransport.gettransport_prix()};
			this.unTableau.insertLigne(ligne);
			
			JOptionPane.showMessageDialog(this, "Transport ajouté avec succès");
			this.ViderChamps();
			
		}
        else if (e.getSource() == this.btEnregistrer && this.btEnregistrer.getText().equals("Modifier")){
        	String transport_name = this.txttransport_name.getText();
        	String ville_depart = this.txtville_depart.getText();
			String ville_arrivee = this.txtville_arrivee.getText();
			String transport_date = this.txttransport_date.getText();
			String heure_depart = this.txtheure_depart.getText();
			String heure_arrivee = this.txtheure_arrivee.getText();
			String numero = this.txtnumero.getText();
			String compagnie = this.txtcompagnie.getText();
			String modele = this.txtmodele.getText();
			String heure_de_trajet = this.txtheure_de_trajet.getText();
			String transport_prix = this.txttransport_prix.getText();
            int numLigne = tableTransport.getSelectedRow();
            int transport_id = Integer.parseInt(tableTransport.getValueAt(numLigne, 0).toString());

            //instancier un objet de type transport
            Transports unTransport = new Transports(transport_name, ville_depart, ville_arrivee, transport_date, heure_depart, heure_arrivee, numero, compagnie, modele, heure_de_trajet, transport_prix);
            //on l'update dans la base de données
            C_Transports.updatetransports(unTransport);
            //on recharge la JTable
            Object ligne[] = {unTransport.gettransport_id(),unTransport.gettransport_name(),
            		unTransport.getville_depart(),
					unTransport.getville_arrivee(),
					unTransport.gettransport_date(),
					unTransport.getheure_depart(),
					unTransport.getheure_arrivee(),
					unTransport.getnumero(),
					unTransport.getcompagnie(),
					unTransport.getmodele(),
					unTransport.getheure_de_trajet(),
					unTransport.gettransport_prix()};
            this.unTableau.updateLigne(numLigne, ligne);

            JOptionPane.showMessageDialog(this, "Transport modifié avec succès");
            this.ViderChamps();
        }
        else if (e.getSource() == btSupprimer){
        	int retour = JOptionPane.showConfirmDialog(null,"Voulez-vous supprimer ce transport ?","Suppression transport",JOptionPane.YES_NO_OPTION);
            if(retour == 0){
            	String transport_name = this.txttransport_name.getText();
            	String ville_depart = this.txtville_depart.getText();
    			String ville_arrivee = this.txtville_arrivee.getText();
    			String transport_date = this.txttransport_date.getText();
    			String heure_depart = this.txtheure_depart.getText();
    			String heure_arrivee = this.txtheure_arrivee.getText();
    			String numero = this.txtnumero.getText();
    			String compagnie = this.txtcompagnie.getText();
    			String modele = this.txtmodele.getText();
    			String heure_de_trajet = this.txtheure_de_trajet.getText();
    			String transport_prix = this.txttransport_prix.getText();
            int numLigne = tableTransport.getSelectedRow();
            int transport_id = Integer.parseInt(tableTransport.getValueAt(numLigne, 0).toString());

            //instancier un objet de type transport
            Transports unTransport = new Transports(transport_name, ville_depart, ville_arrivee, transport_date, heure_depart, heure_arrivee, numero, compagnie, modele, heure_de_trajet, transport_prix);
            //on l'update dans la base de données
            C_Transports.updatetransports(unTransport);
            //on recharge la JTable
            Object ligne[] = {unTransport.gettransport_id(),unTransport.gettransport_name(),
            		unTransport.getville_depart(),
					unTransport.getville_arrivee(),
					unTransport.gettransport_date(),
					unTransport.getheure_depart(),
					unTransport.getheure_arrivee(),
					unTransport.getnumero(),
					unTransport.getcompagnie(),
					unTransport.getmodele(),
					unTransport.getheure_de_trajet(),
					unTransport.gettransport_prix()};
            this.unTableau.updateLigne(numLigne, ligne);

            JOptionPane.showMessageDialog(this, "Transport supprimé avec succès");
            this.ViderChamps();
            }
        }
	}
}
