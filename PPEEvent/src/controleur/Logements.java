package controleur;

public class Logements {
			private int logement_id;
			private String logement_name, logement_type, logement_lieu, logement_adresse, logement_nb_etoiles, logement_nb_notes, logement_description, logement_date_debut, logement_date_fin, logement_prix;
			
			public Logements(int logement_id, String logement_name, String logement_type, String logement_lieu, String logement_adresse, String logement_nb_etoiles, String logement_nb_notes, String logement_description, String logement_date_debut, String logement_date_fin, String logement_prix) {
				this.logement_id = logement_id;
				this.logement_name = logement_name;
				this.logement_type = logement_type;
				this.logement_lieu = logement_lieu;
				this.logement_adresse = logement_adresse;
				this.logement_nb_etoiles = logement_nb_etoiles;
				this.logement_nb_notes = logement_nb_notes;
				this.logement_description = logement_description;
				this.logement_date_debut = logement_date_debut;
				this.logement_date_fin = logement_date_fin;
				this.logement_prix = logement_prix;
			}

			public Logements(String logement_name, String logement_type, String logement_lieu, String logement_adresse, String logement_nb_etoiles, String logement_nb_notes, String logement_description, String logement_date_debut, String logement_date_fin, String logement_prix) {
				this.logement_id = 0;
				this.logement_name = logement_name;
				this.logement_type = logement_type;
				this.logement_lieu = logement_lieu;
				this.logement_adresse = logement_adresse;
				this.logement_nb_etoiles = logement_nb_etoiles;
				this.logement_nb_notes = logement_nb_notes;
				this.logement_description = logement_description;
				this.logement_date_debut = logement_date_debut;
				this.logement_date_fin = logement_date_fin;
				this.logement_prix = logement_prix;
			}

			public Logements() {
				this.logement_id = 0;
				this.logement_name = "";
				this.logement_type = "";
				this.logement_lieu = "";
				this.logement_adresse = "";
				this.logement_nb_etoiles = "";
				this.logement_nb_notes = "";
				this.logement_description = "";
				this.logement_date_debut = "";
				this.logement_date_fin = "";
				this.logement_prix = "";
			}

			// Getters and Setters
			public int getlogement_id() {
				return logement_id;
			}

			public void setlogement_id(int logement_id) {
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
			
			public String getlogement_lieu() {
				return logement_lieu;
			}

			public void setlogement_lieu(String logement_lieu) {
				this.logement_lieu = logement_lieu;
			}
			
			public String getlogement_adresse() {
				return logement_adresse;
			}

			public void setlogement_adresse(String logement_adresse) {
				this.logement_adresse = logement_adresse;
			}
			
			public String getlogement_nb_etoiles() {
				return logement_nb_etoiles;
			}

			public void setlogement_nb_etoiles(String logement_nb_etoiles) {
				this.logement_nb_etoiles = logement_nb_etoiles;
			}
			
			public String getlogement_nb_notes() {
				return logement_nb_notes;
			}

			public void setlogement_nb_notes(String logement_nb_notes) {
				this.logement_nb_notes = logement_nb_notes;
			}
			
			public String getlogement_description() {
				return logement_description;
			}

			public void setlogement_description(String logement_description) {
				this.logement_description = logement_description;
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

			public String getlogement_prix() {
				return logement_prix;
			}

			public void setlogement_prix(String logement_prix) {
				this.logement_prix = logement_prix;
			}
}
