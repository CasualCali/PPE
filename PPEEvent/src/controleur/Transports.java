package controleur;

public class Transports {
				private int transport_id;
				private String transport_name, ville_depart, ville_arrivee,transport_date,heure_depart,heure_arrivee,numero,compagnie,modele,heure_de_trajet,transport_prix;

				public Transports(int transport_id, String transport_name, String ville_depart,String ville_arrivee,String transport_date,String heure_depart,String heure_arrivee,String numero,String compagnie,String modele,String heure_de_trajet,String transport_prix) {
					this.transport_id = transport_id;
					this.transport_name = transport_name;
					this.ville_depart = ville_depart;
					this.ville_arrivee = ville_arrivee;
					this.transport_date = transport_date;
					this.heure_depart = heure_depart;
					this.heure_arrivee = heure_arrivee;
					this.numero = numero;
					this.compagnie = compagnie;
					this.modele = modele;
					this.heure_de_trajet = heure_de_trajet;
					this.transport_prix = transport_prix;
				}

				public Transports(String transport_name, String ville_depart,String ville_arrivee,String transport_date,String heure_depart,String heure_arrivee,String numero,String compagnie,String modele,String heure_de_trajet,String transport_prix) {
					this.transport_id = 0;
					this.transport_name = transport_name;
					this.ville_depart = ville_depart;
					this.ville_arrivee = ville_arrivee;
					this.transport_date = transport_date;
					this.heure_depart = heure_depart;
					this.heure_arrivee = heure_arrivee;
					this.numero = numero;
					this.compagnie = compagnie;
					this.modele = modele;
					this.heure_de_trajet = heure_de_trajet;
					this.transport_prix = transport_prix;
				}

				public Transports() {
					this.transport_id = 0;
					this.transport_name = "";
					this.ville_depart = "";
					this.ville_arrivee = "";
					this.transport_date = "";
					this.heure_depart = "";
					this.heure_arrivee = "";
					this.numero = "";
					this.compagnie = "";
					this.modele = "";
					this.heure_de_trajet = "";
					this.transport_prix = "";
				}

				// Getters and Setters
				public int gettransport_id() {
					return transport_id;
				}

				public void settransport_id(int transport_id) {
					this.transport_id = transport_id;
				}

				public String gettransport_name() {
					return transport_name;
				}

				public void settransport_name(String transport_name) {
					this.transport_name = transport_name;
				}
				
				public String getville_depart() {
					return ville_depart;
				}

				public void setville_depart(String ville_depart) {
					this.ville_depart = ville_depart;
				}
				
				public String getville_arrivee() {
					return ville_arrivee;
				}

				public void setville_arrivee(String ville_arrivee) {
					this.ville_arrivee = ville_arrivee;
				}
				
				public String gettransport_date() {
					return transport_date;
				}

				public void settransport_date(String transport_date) {
					this.transport_date = transport_date;
				}
				
				public String getheure_depart() {
					return heure_depart;
				}

				public void setheure_depart(String heure_depart) {
					this.heure_depart = heure_depart;
				}
				
				public String getheure_arrivee() {
					return heure_arrivee;
				}

				public void setheure_arrivee(String heure_arrivee) {
					this.heure_arrivee = heure_arrivee;
				}
				
				public String getnumero() {
					return numero;
				}

				public void setnumero(String numero) {
					this.numero = numero;
				}
				
				public String getcompagnie() {
					return compagnie;
				}

				public void setcompagnie(String compagnie) {
					this.compagnie = compagnie;
				}
				
				public String getmodele() {
					return modele;
				}

				public void setmodele(String modele) {
					this.modele = modele;
				}
				
				public String getheure_de_trajet() {
					return heure_de_trajet;
				}

				public void setheure_de_trajet(String heure_de_trajet) {
					this.heure_de_trajet = heure_de_trajet;
				}

				public String gettransport_prix() {
					return transport_prix;
				}

				public void settransport_prix(String transport_prix) {
					this.transport_prix = transport_prix;
				}
}
