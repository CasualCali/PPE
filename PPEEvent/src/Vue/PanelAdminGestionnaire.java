package Vue;

	import java.awt.Color; 
	import java.awt.GridLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;
	import java.util.ArrayList;
	import java.util.Arrays;

	import javax.swing.JButton;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
	import javax.swing.JTextField;

	import controleur.C_Users;
	import controleur.Tableau;
	import controleur.Users;

public class PanelAdminGestionnaire extends PanelPrincipal implements ActionListener{
		
		private JTable tableAdmin;
		private Tableau unTableau ;
		
		public PanelAdminGestionnaire(){ 
			super();
			this.titre.setText("GESTION DES ADMINISTRATEURS");
			this.titre.setBounds(510, 10, 350, 40);
			
			//construction de la JTbale 
			String entetes [] = {"ID Admin ", "Nom", "Prénom", "Email", "Téléphone"};
			Object [][] donnees = this.getDonnees ("");
	        
			this.unTableau = new Tableau (donnees, entetes);
			this.tableAdmin = new JTable(this.unTableau);
			JScrollPane uneScroll = new JScrollPane(this.tableAdmin); 
			uneScroll.setBounds(15, 65, 1185, 500);
			this.add(uneScroll);
		
	        this.tableAdmin.addMouseListener(new MouseAdapter(){

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
		
		
		public Object[][] getDonneesFiltre(String filtre) {
		    ArrayList<Users> lesUsers = C_Users.selectAlluser();
		    ArrayList<Users> UsersFiltres = new ArrayList<>();

		    // Filtrer les administrateurs en fonction du texte de filtre
		    for (Users user : lesUsers) {
		        if (user.getnom().toLowerCase().contains(filtre.toLowerCase()) ||
		            user.getprenom().toLowerCase().contains(filtre.toLowerCase()) ||
		            user.getemail().toLowerCase().contains(filtre.toLowerCase()) ||
		            user.gettelephone().toLowerCase().contains(filtre.toLowerCase())) {
		        	UsersFiltres.add(user);
		        }
		    }

		    Object[][] matrice = new Object[UsersFiltres.size()][5];
		    int i = 0;
		    for (Users user : UsersFiltres) {
		        matrice[i][0] = user.getid_client();
		        matrice[i][1] = user.getnom();
		        matrice[i][2] = user.getprenom();
		        matrice[i][3] = user.getemail();
		        matrice[i][4] = user.gettelephone();
		        i++;
		    }

		    return matrice;
		}
			public Object[][] getDonnees(String filtre) {
			    ArrayList<Users> lesUsers = C_Users.selectAlluser();
			    Object[][] matrice = new Object[lesUsers.size()][5];
			    int i = 0;	
			    for (Users unUser : lesUsers) {
			    	if(unUser.getrole_client().equals("admin")) {// Vérifie si l'utilisateur est un admin
			            matrice[i][0] = unUser.getid_client();
			            matrice[i][1] = unUser.getnom();
			            matrice[i][2] = unUser.getprenom();
			            matrice[i][3] = unUser.getemail();
			            matrice[i][4] = unUser.gettelephone();
			            i++;
			        }
			    }
			    // Réduire la taille de la matrice si elle contient des lignes vides
			    return Arrays.copyOf(matrice, i);
			}
		
		@Override
	    public void actionPerformed(ActionEvent e) {
	    }
	}
