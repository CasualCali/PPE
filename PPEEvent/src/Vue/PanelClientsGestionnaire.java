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

public class PanelClientsGestionnaire extends PanelPrincipal implements ActionListener{
				
		private JPanel panelForm 			= new JPanel();
		
		private JTextField txtNom 			= new JTextField();
		private JTextField txtPrenom 		= new JTextField();
		private JTextField txtEmail 		= new JTextField();
		private JTextField txtTelephone 	= new JTextField();
		
		private JButton btEnregistrer 		= new JButton("Enregistrer");
	    private JButton btPrivé 			= new JButton("Privé");
	    private JButton btPublique			= new JButton("Publique");
		
		JLabel NomClient 					= new JLabel("Nom du client :");
		JLabel PrenomClient 				= new JLabel("Prénom du client :");
		JLabel Email 						= new JLabel("Email :");
		JLabel Telephone 					= new JLabel("Téléphone :");
		
		private JTable tableClient;
		private Tableau unTableau ;
		
		public PanelClientsGestionnaire(){
			super();
			this.titre.setText("GESTION DES CLIENTS");
			this.titre.setBounds(530, 10, 350, 40);
			
			//construction du panel Form
			this.panelForm.setBounds(60,115,450,350);
			this.panelForm.setBackground(new Color (17, 24, 39));
			this.panelForm.setLayout(new GridLayout(6,2, 10,10));
			this.panelForm.add(this.btPrivé);
			this.panelForm.add(this.btPublique);
			this.panelForm.add(NomClient);
			this.panelForm.add(this.txtNom);
			NomClient.setForeground(Color.WHITE);
			this.panelForm.add(PrenomClient);
			this.panelForm.add(this.txtPrenom);
			PrenomClient.setForeground(Color.WHITE);
			this.panelForm.add(Email);
			this.panelForm.add(this.txtEmail);
			Email.setForeground(Color.WHITE);
			this.panelForm.add(Telephone);
			this.panelForm.add(this.txtTelephone);
			Telephone.setForeground(Color.WHITE);
			this.panelForm.add(this.btEnregistrer);
			//ajout du panelForm au panelClients
			this.add(this.panelForm);
			this.panelForm.setVisible(true);
			
			//construction de la JTbale 
			String entetes [] = {"ID Client ", "Nom", "Prénom", "Email", "Téléphone", "Siret"};
			Object [][] donnees = this.getDonnees ("");
	        
			this.unTableau = new Tableau (donnees, entetes);
			this.tableClient = new JTable(this.unTableau);
			JScrollPane uneScroll = new JScrollPane(this.tableClient); 
			uneScroll.setBounds(590, 80, 560, 420);
			this.add(uneScroll);
		
	        this.tableClient.addMouseListener(new MouseAdapter(){

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

	        //rendre les boutons cliquables
	        this.btEnregistrer.addActionListener(this);
	        this.btPrivé.addActionListener(this);
	        this.btPublique.addActionListener(this);
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
		    Object[][] matrice = new Object[lesUsers.size()][6];
		    int i = 0;
		    for (Users unUser : lesUsers) {
		    	if(unUser.getrole_client().equals("users")) {// Vérifie si l'utilisateur est un admin
		            matrice[i][0] = unUser.getid_client();
		            matrice[i][1] = unUser.getnom();
		            matrice[i][2] = unUser.getprenom();
		            matrice[i][3] = unUser.getemail();
		            matrice[i][4] = unUser.gettelephone();
		            matrice[i][5] = unUser.getsiret();
		            i++;
		        }
		    }
		    // Réduire la taille de la matrice si elle contient des lignes vides
		    return Arrays.copyOf(matrice, i);
		}

		public void ViderChamps() {
			this.txtNom.setText("");
			this.txtPrenom.setText("");
			this.txtEmail.setText("");
			this.txtTelephone.setText("");
		}
		
		@Override
	    public void actionPerformed(ActionEvent e) {
	        if(e.getSource() == this.btEnregistrer){
	        	String nom = this.txtNom.getText();
				String telephone = this.txtTelephone.getText();
				String email = this.txtEmail.getText();
				String role_client = "users";
				if (this.PrenomClient.getText().equals("Prénom du client :")) {
					String statut = "privé";
					String siret = "";
					String prenom = this.txtPrenom.getText();
					//instancier un objet de type Client
	                Users unUser = new Users( nom, prenom, telephone, email, null, role_client, statut, siret);
	                //on l'enregistre dans la base de données
	                C_Users.insertUser(unUser);
	                
	                unUser = C_Users.selectWhereUserClient(nom, prenom);
	                
	                Object ligne[] = {unUser.getid_client(), unUser.getnom(), 
							unUser.getprenom(), unUser.gettelephone(),
							unUser.getemail(),"",
							unUser.getrole_client()};
	                this.unTableau.insertLigne(ligne);

	                JOptionPane.showMessageDialog(this, "Client ajouté avec succès");
	                this.ViderChamps();
				}else if (this.PrenomClient.getText().equals("N° SIRET :")) {
					String statut = "publique";
					String siret = this.txtPrenom.getText();
					String prenom = "";
					//instancier un objet de type Client
	                Users unUser = new Users( nom, prenom, telephone, email, null, role_client, statut, siret);
	                //on l'enregistre dans la base de données
	                C_Users.insertUser(unUser);
	                
	                Object ligne[] = {unUser.getid_client(), unUser.getnom(), 
							unUser.getprenom(), unUser.gettelephone(),
							unUser.getemail(),null,
							unUser.getrole_client()};
	                this.unTableau.insertLigne(ligne);

	                JOptionPane.showMessageDialog(this, "Client ajouté avec succès");
	                this.ViderChamps();
				}
	        }
	        else if(e.getSource() == this.btPrivé){
	        	PrenomClient.setText("Prénom du client :");
	        }
	        else if(e.getSource() == this.btPublique){
	        	PrenomClient.setText("N° SIRET :");
	        }
	    }
	}
