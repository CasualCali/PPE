package controleur;
import java.util.Date;

public class Reservations {
				private int reservation_id;
				private String reservation_type, ville_depart, destination_name, date_depart, nb_personnes, logement_id, logement_name, logement_type, logement_nb_etoiles, logement_date_debut, logement_date_fin, numero, heure_depart, heure_arrivee, reservations_prix, nom, prenom, email;

				public Reservations(int reservation_id, String reservation_type, String ville_depart, String destination_name, String date_depart, String nb_personnes, String logement_id, String logement_name, String logement_type, String logement_nb_etoiles, String logement_date_debut, String logement_date_fin, String numero, String heure_depart, String heure_arrivee, String reservations_prix, String nom, String prenom,  String email) {
					this.reservation_id = reservation_id;
					this.reservation_type = reservation_type;
					this.ville_depart = ville_depart;
					this.destination_name = destination_name;
					this.date_depart = date_depart;
					this.nb_personnes = nb_personnes;
					this.logement_id = logement_id;
					this.logement_name = logement_name;
					this.logement_type = logement_type;
					this.logement_nb_etoiles = logement_nb_etoiles;
					this.logement_date_debut = logement_date_debut;
					this.logement_date_fin = logement_date_fin;
					this.numero = numero;
					this.heure_depart = heure_depart;
					this.heure_arrivee = heure_arrivee;
					this.reservations_prix = reservations_prix;
					this.nom = nom;
					this.prenom = prenom;
					this.email = email;
				}

				public Reservations(String reservation_type, String ville_depart, String destination_name, String date_depart, String nb_personnes, String logement_id, String logement_name, String logement_type, String logement_nb_etoiles, String logement_date_debut, String logement_date_fin, String numero, String heure_depart, String heure_arrivee, String reservations_prix, String nom, String prenom,  String email) {
					this.reservation_id = 0;
					this.reservation_type = reservation_type;
					this.ville_depart = ville_depart;
					this.destination_name = destination_name;
					this.date_depart = date_depart;
					this.nb_personnes = nb_personnes;
					this.logement_id = logement_id;
					this.logement_name = logement_name;
					this.logement_type = logement_type;
					this.logement_nb_etoiles = logement_nb_etoiles;
					this.logement_date_debut = logement_date_debut;
					this.logement_date_fin = logement_date_fin;
					this.numero = numero;
					this.heure_depart = heure_depart;
					this.heure_arrivee = heure_arrivee;
					this.reservations_prix = reservations_prix;
					this.nom = nom;
					this.prenom = prenom;
					this.email = email;
				}

				public Reservations() {
					this.reservation_id = 0;
					this.reservation_type = "";
					this.ville_depart = "";
					this.destination_name = "";
					this.date_depart = "";
					this.nb_personnes = "";
					this.logement_id = "";
					this.logement_name = "";
					this.logement_type = "";
					this.logement_nb_etoiles = "";
					this.logement_date_debut = "";
					this.logement_date_fin = "";
					this.numero = "";
					this.heure_depart = "";
					this.heure_arrivee = "";
					this.reservations_prix = "";
					this.nom = "";
					this.prenom = "";
					this.email = "";
				}

				// Getters and Setters
				public int getreservation_id() {
					return reservation_id;
				}

				public void setreservation_id(int reservation_id) {
					this.reservation_id = reservation_id;
				}
				
				public String getreservation_type() {
					return reservation_type;
				}

				public void setreservation_type(String reservation_type) {
					this.reservation_type = reservation_type;
				}
				
				public String getville_depart() {
					return ville_depart;
				}

				public void setville_depart(String ville_depart) {
					this.ville_depart = ville_depart;
				}
				
				public String getdestination_name() {
					return destination_name;
				}

				public void setdestination_namee(String destination_name) {
					this.destination_name = destination_name;
				}
				
				public String getdate_depart() {
					return date_depart;
				}

				public void setdate_depart(String date_depart) {
					this.date_depart = date_depart;
				}
				
				public String getnb_personnes() {
					return nb_personnes;
				}

				public void setnb_personnes(String nb_personnes) {
					this.nb_personnes = nb_personnes;
				}
				
				public String getlogement_id() {
					return logement_id;
				}

				public void setlogement_id(String logement_id) {
					this.logement_id = logement_id;
				}
				
				public String getlogement_name() {
					return logement_name;
				}

				public void setlogement_name(String logement_name) {
					this.logement_name = logement_name;
				}
				
				public String getlogement_type() {
					return logement_type;
				}

				public void setlogement_type(String logement_type) {
					this.logement_type = logement_type;
				}
				
				public String getlogement_nb_etoiles() {
					return logement_nb_etoiles;
				}

				public void setlogement_nb_etoiles(String logement_nb_etoiles) {
					this.logement_nb_etoiles = logement_nb_etoiles;
				}
				
				public String getlogement_date_debut() {
					return logement_date_debut;
				}

				public void setlogement_date_debut(String logement_date_debut) {
					this.logement_date_debut = logement_date_debut;
				}
				
				public String getlogement_date_fin() {
					return logement_date_fin;
				}

				public void setlogement_date_fin(String logement_date_fin) {
					this.logement_date_fin = logement_date_fin;
				}
				
				public String getnumero() {
					return numero;
				}

				public void setnumero(String numero) {
					this.numero = numero;
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
				
				public String getreservations_prix() {
					return reservations_prix;
				}

				public void setreservations_prix(String reservations_prix) {
					this.reservations_prix = reservations_prix;
				}
				
				public String getnom() {
					return nom;
				}

				public void setnom(String nom) {
					this.nom = nom;
				}
				
				public String getprenom() {
					return prenom;
				}

				public void setprenom(String prenom) {
					this.prenom = prenom;
				}
				
				public String getemail() {
					return email;
				}

				public void setemail(String email) {
					this.email = email;
				}

}
