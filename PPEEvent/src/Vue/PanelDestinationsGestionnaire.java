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

import controleur.C_Destinations;
import controleur.C_Logements;
import controleur.Destinations;
import controleur.Tableau;

public class PanelDestinationsGestionnaire extends PanelPrincipal implements ActionListener{
			
	private JPanel panelForm 						= new JPanel();
			
	private JTextField txtdestination_name 			= new JTextField();
	private JTextField txtdestination_image 		= new JTextField();
	private JTextField txtdestination_description 	= new JTextField();

	private JButton btAnnuler 						= new JButton("Annuler");
	private JButton btEnregistrer 					= new JButton("Enregistrer");
	private JButton btSupprimer 					= new JButton("Supprimer");

	JLabel NomDestination 							= new JLabel("Nom de la destination :");
	JLabel ImageDestination 						= new JLabel("Chemin de l'image de la destination :");
	JLabel DescriptionDestination 					= new JLabel("Description de la destination :");
			
	private JTable tableDestinations;
	private Tableau unTableau ;
			
	public PanelDestinationsGestionnaire(){
		super();
		this.titre.setText("GESTION DES DESTINATIONS");
		this.titre.setBounds(525, 10, 350, 40);
				
		//construction du panel Form
		this.panelForm.setBounds(60,155,450,350);
		this.panelForm.setBackground(new Color (17, 24, 39));
		this.panelForm.setLayout(new GridLayout(6,2, 10,10));
		this.panelForm.add(NomDestination);
		this.panelForm.add(this.txtdestination_name);
		NomDestination.setForeground(Color.WHITE);
		this.panelForm.add(ImageDestination);
		this.panelForm.add(this.txtdestination_image);
		ImageDestination.setForeground(Color.WHITE);
		this.panelForm.add(DescriptionDestination);
		this.panelForm.add(this.txtdestination_description);
		DescriptionDestination.setForeground(Color.WHITE);
		this.panelForm.add(this.btAnnuler);
		this.panelForm.add(this.btEnregistrer);
		this.panelForm.add(this.btSupprimer);
		//ajout du panelForm au panelDestinations
		this.add(this.panelForm);
		this.panelForm.setVisible(true);
		
		//construction de la JTbale 
		String entetes [] = {"ID Destination ", "Nom de la destination", "Description", "Chemin de l'image"};
		Object [][] donnees = this.getDonnees (""); 
		
		this.unTableau = new Tableau (donnees, entetes);
		this.tableDestinations = new JTable(this.unTableau);
		JScrollPane uneScroll = new JScrollPane(this.tableDestinations); 
		uneScroll.setBounds(590, 80, 560, 420);
		this.add(uneScroll);
				
		this.tableDestinations.addMouseListener(new MouseAdapter(){

        @Override
        public void mouseClicked(MouseEvent e ){
            int numLigne = tableDestinations.getSelectedRow();
            int destination_id = Integer.parseInt(tableDestinations.getValueAt(numLigne, 0).toString());
           
            if(e.getClickCount() ==2){
                int retour = JOptionPane.showConfirmDialog(null,"Voulez-vous supprimer cette destination ?","Suppression Destination",JOptionPane.YES_NO_OPTION);
                if(retour == 0){
                    C_Logements.DeleteLogements(destination_id);
                    unTableau.deleteLigne(numLigne);
                    JOptionPane.showMessageDialog(null, "Destination supprimé avec succès");
                }
            }else if(e.getClickCount() == 1 ){
                //on remplie les champs pour la modification
                txtdestination_name.setText(tableDestinations.getValueAt(numLigne, 1).toString());
                txtdestination_image.setText(tableDestinations.getValueAt(numLigne, 2).toString());
                txtdestination_description.setText(tableDestinations.getValueAt(numLigne, 2).toString());
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
		ArrayList<Destinations> lesDestinations = C_Destinations.selectAllDestination(); 
		Object [][] matrice = new Object [lesDestinations.size()][4]; 
		int i=0; 
		for (Destinations uneDestination : lesDestinations)
		{
			matrice[i][0]  = uneDestination.getdestination_id(); 
			matrice[i][1]  = uneDestination.getdestination_name(); 
			matrice[i][2]  = uneDestination.getdestination_description();
			matrice[i][3]  = uneDestination.getdestination_image(); 
			
			i++;
		}
		return matrice;
	}

	public void ViderChamps() {
		this.txtdestination_name.setText("");
		this.txtdestination_image.setText("");
		this.txtdestination_description.setText("");
		btEnregistrer.setText("Enregistrer");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAnnuler) {
			this.ViderChamps();
		}else if (e.getSource() == this.btEnregistrer && this.btEnregistrer.getText().equals("Enregistrer")){
			String destination_name = this.txtdestination_name.getText();
			String destination_image = this.txtdestination_image.getText();
			String destination_description = this.txtdestination_description.getText();
			
			//instancier une destination
			Destinations uneDestination = new Destinations( destination_name, destination_description, destination_image);
		     
			// on l'enregistre dans la db
			C_Destinations.InsertDestinations(uneDestination); 
			
			//ajout de la destination dans le Tableau 
			Object ligne[] = {uneDestination.getdestination_id(), uneDestination.getdestination_name(), 
					uneDestination.getdestination_description(), uneDestination.getdestination_image()};
			this.unTableau.insertLigne(ligne);
			
			JOptionPane.showMessageDialog(this, "Destination ajoutée avec succès");
			this.ViderChamps();
			
		}else if (e.getSource() == this.btEnregistrer && this.btEnregistrer.getText().equals("Modifier")){
			String destination_name = this.txtdestination_name.getText();
			String destination_image = this.txtdestination_image.getText();
			String destination_description = this.txtdestination_description.getText();
            int numLigne = tableDestinations.getSelectedRow();
            int destination_id = Integer.parseInt(tableDestinations.getValueAt(numLigne, 0).toString());

            //instancier un objet de type Destination
            Destinations uneDestination = new Destinations(destination_id, destination_name, destination_description, destination_image);
            //on l'update dans la base de données
            C_Destinations.updatedestinations(uneDestination);
            //on recharge la JTable
            Object ligne[] = {uneDestination.getdestination_id(),uneDestination.getdestination_name(), uneDestination.getdestination_description(), uneDestination.getdestination_image()};
            this.unTableau.updateLigne(numLigne, ligne);

            JOptionPane.showMessageDialog(this, "Destination modifiée avec succès");
            this.ViderChamps();
		 }else if (e.getSource() == btSupprimer){
        	int retour = JOptionPane.showConfirmDialog(null,"Voulez-vous supprimer cette destination ?","Suppression Destination",JOptionPane.YES_NO_OPTION);
            if(retour == 0){
            	String destination_name = this.txtdestination_name.getText();
				String destination_image = this.txtdestination_image.getText();
				String destination_description = this.txtdestination_description.getText();
                int numLigne = tableDestinations.getSelectedRow();
                int destination_id = Integer.parseInt(tableDestinations.getValueAt(numLigne, 0).toString());

                //instancier un objet de type Destination
                Destinations uneDestination = new Destinations(destination_id, destination_name, destination_description, destination_image);
                //on l'update dans la base de données
                C_Destinations.deletedestinations(destination_id);
                //on recharge la JTable
                Object ligne[] = {uneDestination.getdestination_id(),uneDestination.getdestination_name(), uneDestination.getdestination_description(), uneDestination.getdestination_image()};
                this.unTableau.updateLigne(numLigne, ligne);

                JOptionPane.showMessageDialog(this, "Destination supprimée avec succès");
                this.ViderChamps();
            }
        }		
	}
}
