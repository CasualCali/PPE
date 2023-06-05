package Vue;

	import java.awt.Color;   
	import java.awt.GridLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.MouseEvent;
	import java.awt.event.MouseListener;

	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import controleur.PPEEvent;

public class VueGeneraleGestionnaire extends JFrame implements ActionListener, MouseListener{
	
			private JPanel panelMenu = new JPanel();
			private JButton btClient = new JButton("Clients");
			private JButton btDestinations = new JButton("Destinations");
			private JButton btReservations = new JButton("Réservations");
			private JButton btTransports = new JButton("Transports");
			private JButton btLogements = new JButton("Logements");
			private JButton btAdministrateurs = new JButton("Administrateurs");
			private static JButton btQuitter = new JButton("Me déconnecter");

			
			//liste des Panels
			private PanelClientsGestionnaire unPanelClientGestionnaire = new PanelClientsGestionnaire();
			private PanelDestinationsGestionnaire unPanelDestinationGestionnaire = new PanelDestinationsGestionnaire();
			private PanelReservationsGestionnaire unPanelReservationsGestionnaire = new PanelReservationsGestionnaire();
			private PanelTransportsGestionnaire unPanelTransportsGestionnaire = new PanelTransportsGestionnaire();
			private PanelLogementsGestionnaire unPanelLogementsGestionnaire = new PanelLogementsGestionnaire();
			private PanelAdminGestionnaire unPanelAdminGestionnaire = new PanelAdminGestionnaire();

			public VueGeneraleGestionnaire() {
				this.setTitle("Gestion");
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.setResizable(false);
				this.setBounds(100, 100, 1250, 700);
				this.setLocationRelativeTo(null);
				this.getContentPane().setBackground(new Color (46, 147, 214));
				this.setLayout(null);
				
				//installation du panel Menu
				this.panelMenu.setBounds(0, 0, 1250, 50);
				this.panelMenu.setBackground(new Color (17, 24, 39));
				this.panelMenu.setLayout(new GridLayout(1, 6));
				this.panelMenu.add(this.btClient);
				this.panelMenu.add(this.btDestinations);
				this.panelMenu.add(this.btReservations);
				this.panelMenu.add(this.btTransports);
				this.panelMenu.add(this.btLogements);
				this.panelMenu.add(this.btAdministrateurs);
				this.panelMenu.add(VueGeneraleGestionnaire.btQuitter);
				
				this.add(this.panelMenu);

				//rendre les boutons écoutables
				this.btClient.addActionListener(this);
				this.btDestinations.addActionListener(this);
				this.btReservations.addActionListener(this);
				this.btTransports.addActionListener(this);
				this.btLogements.addActionListener(this);
				this.btAdministrateurs.addActionListener(this);
				VueGeneraleGestionnaire.btQuitter.addActionListener(this);
				
				//ajout des Panels dans la fenêtre
				this.add(this.unPanelClientGestionnaire);
				this.add(this.unPanelDestinationGestionnaire);
				this.add(this.unPanelReservationsGestionnaire);
				this.add(this.unPanelTransportsGestionnaire);
				this.add(this.unPanelLogementsGestionnaire);
				this.add(this.unPanelAdminGestionnaire);
				
				this.setVisible(false);
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == VueGeneraleGestionnaire.btQuitter)
				{
					int retour = JOptionPane.showConfirmDialog(this, 
							"Souhaitez-vous être déconnecter ?", "Quitter l'application", 
							JOptionPane.YES_NO_OPTION);
					if (retour == 0) {
						PPEEvent.rendreVisibleVueGeneraleGestionnaire(false);
						PPEEvent.rendreVisibleVueConnexion(true);
					}

				}
				else if (e.getSource() == this.btClient)
				{
					this.afficherPanel (1);
				}
				else if (e.getSource() == this.btDestinations)
				{
					this.afficherPanel (2);
				}
				else if (e.getSource() == this.btReservations)
				{
					this.afficherPanel (3);
				}
				else if (e.getSource() == this.btTransports)
				{
					this.afficherPanel (4);
				}
				else if (e.getSource() == this.btLogements)
				{
					this.afficherPanel (5);
				}
				else if (e.getSource() == this.btAdministrateurs)
				{
					this.afficherPanel (6);
				}
			}
			
			public static void main(String[] args) {
				VueGeneraleGestionnaire PanelAccueilConnecte = new VueGeneraleGestionnaire();
				PanelAccueilConnecte.setVisible(true);
		    }
			
			public void afficherPanel (int numero)
			{
				this.unPanelClientGestionnaire.setVisible(false);
				this.unPanelDestinationGestionnaire.setVisible(false);
				this.unPanelReservationsGestionnaire.setVisible(false);
				this.unPanelTransportsGestionnaire.setVisible(false);
				this.unPanelLogementsGestionnaire.setVisible(false);
				this.unPanelAdminGestionnaire.setVisible(false);
				
				switch(numero) {
				case 1:
					this.unPanelClientGestionnaire.setVisible(true);
					break;
				case 2:
					this.unPanelDestinationGestionnaire.setVisible(true);
					break;
				case 3:
					this.unPanelReservationsGestionnaire.setVisible(true);
					break;
				case 4:
					this.unPanelTransportsGestionnaire.setVisible(true);
					break;
				case 5:
					this.unPanelLogementsGestionnaire.setVisible(true);
					break;
				case 6:
					this.unPanelAdminGestionnaire.setVisible(true);
					break;
				}
			}
			
			/*public String getTypeUserLoged(){
				return this.typeUserLoged;
			}
			
			public void setTypeUserLoged(String type) {
				this.typeUserLoged = type ;
			}*/
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
				
			}
	}
