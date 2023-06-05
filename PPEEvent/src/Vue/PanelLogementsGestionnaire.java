package Vue;

	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;
	import java.util.ArrayList;
	import javax.swing.JPanel;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;

	import controleur.C_Logements;
	import controleur.Logements;
	import controleur.Tableau;
				
public class PanelLogementsGestionnaire extends PanelPrincipal implements ActionListener{
		private JTable tableLogements;
		private Tableau unTableau ;
		
		public PanelLogementsGestionnaire(){
			super();
			this.titre.setText("GESTION DES LOGEMENTS");
			this.titre.setBounds(530, 10, 350, 40);
			
			//construction de la JTbale 
			String entetes [] = {"ID Logements ", "Nom du logement", "Type du logement", "Ville", "Adresse", "nb étoiles", "nb notes", "description", "date arrivée", "date départ", "logements_prix"};
			Object [][] donnees = this.getDonnees (""); 
			
			this.unTableau = new Tableau (donnees, entetes);
			this.tableLogements = new JTable(this.unTableau);
			JScrollPane uneScroll = new JScrollPane(this.tableLogements); 
			uneScroll.setBounds(15, 65, 1185, 500);
			this.add(uneScroll);
			
			this.tableLogements.addMouseListener(new MouseAdapter(){

	            @Override
	            public void mouseClicked(MouseEvent e ){
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

		@Override
		public void actionPerformed(ActionEvent e) {		
		}
	}
