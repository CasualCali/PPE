package Vue;

	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;
	import java.util.ArrayList;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;

	import controleur.C_Transports;
	import controleur.Tableau;
	import controleur.Transports;

public class PanelTransportsGestionnaire extends PanelPrincipal implements ActionListener{
		
		private JTable tableTransport;
		private Tableau unTableau ;
		
		public PanelTransportsGestionnaire(){
			super();
			this.titre.setText("GESTION DES TRANSPORTS");
			this.titre.setBounds(530, 10, 350, 40);
			
			//construction de la JTbale
			String entetes [] = {"ID Transport", "Nom du transport", "ville de départ", "ville d'arrivée", "date du transport", "heure de départ", "heure d'arrivée", "numero", "compagnie", "modèle", "heure de trajet", "Prix"};
			Object [][] donnees = this.getDonnees (""); 
			
			this.unTableau = new Tableau (donnees, entetes);
			this.tableTransport = new JTable(this.unTableau);
			JScrollPane uneScroll = new JScrollPane(this.tableTransport); 
			uneScroll.setBounds(15, 65, 1185, 500);
			this.add(uneScroll);
			
			this.tableTransport.addMouseListener(new MouseAdapter(){

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
		
		@Override
		public void actionPerformed(ActionEvent e) {
		}
	}
