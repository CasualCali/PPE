 package modele;
import java.sql.SQLException; 
import java.sql.Statement;
import java.util.ArrayList;
import controleur.Reservations;
	

public class ModeleReservations {
		    private static Bdd uneBdd = new Bdd("localhost:3307", "travelin_Event", "root", "");

		    public static void insertReservations(Reservations uneReservation) {
		        String requete = "INSERT INTO reservations VALUES ( null,'"
		                + uneReservation.getreservation_type() + "', '"
		                + uneReservation.getville_depart() + "', '"
		                + uneReservation.getdestination_name() + "', '"
		                + uneReservation.getdate_depart() + "', '"
		          		+ uneReservation.getnb_personnes() + "', '"
		          		+ uneReservation.getlogement_id() + "', '"
		          		+ uneReservation.getlogement_name() + "', '"
		           		+ uneReservation.getlogement_type() + "', '"
           				+ uneReservation.getlogement_nb_etoiles() + "', '"
   						+ uneReservation.getlogement_date_debut() + "', '"
						+ uneReservation.getlogement_date_fin() + "', '"
						+ uneReservation.getnumero() + "', '"
						+ uneReservation.getheure_depart() + "', '"
						+ uneReservation.getheure_arrivee() + "', '"
						+ uneReservation.getreservations_prix() + "', '"
						+ uneReservation.getnom() + "', '"
						+ uneReservation.getprenom() + "', '"
						+ uneReservation.getemail() + "');";
		        try {
		            uneBdd.seConnecter();
		            Statement unStat = uneBdd.getMaConnexion().createStatement();
		            unStat.execute(requete);
		            unStat.close();
		            uneBdd.seDeconnecter();
		        } catch (SQLException exp) {
		            System.out.println("Erreur d'execution de la requete : " + requete);
		        }
		    }

		    public static void updateReservations(Reservations uneReservation) {
		        String requete = "UPDATE reservations SET"
		                + " reservation_type = '" + uneReservation.getreservation_type() + "',"
		                + " ville_depart = '" + uneReservation.getville_depart() + "',"
                		+ " destination_name = '" + uneReservation.getdestination_name() + "',"
        				+ " date_depart = '" + uneReservation.getdate_depart() + "',"
						+ " nb_personnes = '" + uneReservation.getnb_personnes() + "',"
						+ " logement_id = '" + uneReservation.getlogement_id() + "',"
						+ " logement_name = '" + uneReservation.getlogement_name() + "',"
						+ " logement_type = '" + uneReservation.getlogement_type() + "',"
						+ " logement_nb_etoiles = '" + uneReservation.getlogement_nb_etoiles() + "',"
						+ " logement_date_debut = '" + uneReservation.getlogement_date_debut() + "',"
						+ " logement_date_fin = '" + uneReservation.getlogement_date_fin() + "',"
						+ " numero = '" + uneReservation.getnumero() + "',"
						+ " heure_depart = '" + uneReservation.getheure_depart() + "',"
						+ " heure_arrivee = '" + uneReservation.getheure_arrivee() + "',"
						+ " reservations_prix = '" + uneReservation.getreservations_prix() + "',"
						+ " nom = '" + uneReservation.getnom() + "',"
						+ " prenom = '" + uneReservation.getprenom() + "',"
				        + " email = '" + uneReservation.getemail() + "'"
		                + " WHERE reservation_id = " + uneReservation.getreservation_id() + ";";
		        try {
		            uneBdd.seConnecter();
		            Statement unStat = uneBdd.getMaConnexion().createStatement();
		            unStat.execute(requete);
		            unStat.close();
		            uneBdd.seDeconnecter();
		        } catch (SQLException exp) {
		            System.out.println("Erreur d'execution de la requete : " + requete);
		        }
		    }

		    public static void deleteReservations(int reservation_id) {
		        String requete = "DELETE FROM reservations WHERE reservation_id = " + reservation_id + ";";
		        try {
		            uneBdd.seConnecter();
		            Statement unStat = uneBdd.getMaConnexion().createStatement();
		            unStat.execute(requete);
		            unStat.close();
		            uneBdd.seDeconnecter();
		        } catch (SQLException exp) {
		            System.out.println("Erreur d'execution de la requete : " + requete);
		        }
		    }

		    public static ArrayList<Reservations> selectAllReservations() {
		        ArrayList<Reservations> lesReservations = new ArrayList<Reservations>();
		        String requete = "SELECT * FROM reservations;";
		        try {
		            uneBdd.seConnecter();
		            Statement unStat = uneBdd.getMaConnexion().createStatement();
		            // récupération des résultats
		            java.sql.ResultSet desResultats = unStat.executeQuery(requete);
		            // on parcourt les résultats et on instancie les destinations
		            while (desResultats.next()) {
		            	Reservations uneReservation = new Reservations(desResultats.getInt("reservation_id"),
		            			desResultats.getString("reservation_type"),
		            			desResultats.getString("ville_depart"),
		                        desResultats.getString("destination_name"),
		                        desResultats.getString("date_depart"),
		                        desResultats.getString("nb_personnes"),
		                        desResultats.getString("logement_id"),
		                        desResultats.getString("logement_name"),
		                        desResultats.getString("logement_type"),
		                        desResultats.getString("logement_nb_etoiles"),
		                        desResultats.getString("logement_date_debut"),
		                        desResultats.getString("logement_date_fin"),
		                        desResultats.getString("numero"),
		                        desResultats.getString("heure_depart"),
		                        desResultats.getString("heure_arrivee"),
		                        desResultats.getString("reservations_prix"),
		                        desResultats.getString("nom"),
		                        desResultats.getString("prenom"),
		                        desResultats.getString("email"));
		                // on ajoute la destination dans l'ArrayList
		            	lesReservations.add(uneReservation);
		            }
		            unStat.close();
		            uneBdd.seDeconnecter();
		        } catch (SQLException exp) {
		            System.out.println("Erreur d'execution de la requete : " + requete);
		        }
		        return lesReservations;
		    }

		    public static Reservations selectWhereReservations(int reservation_id) {
		    	Reservations uneReservation = null;
		        String requete = "SELECT * FROM reservations WHERE reservation_id = " + reservation_id + ";";
		        try {
		            uneBdd.seConnecter();
		            Statement unStat = uneBdd.getMaConnexion().createStatement();
		            // récupération de la destination
		            java.sql.ResultSet unResultat = unStat.executeQuery(requete);
		            // on teste si la destination existe
		            if (unResultat.next()) {
		            	uneReservation = new Reservations(unResultat.getInt("reservation_id"),
		            			unResultat.getString("reservation_type"),
		            			unResultat.getString("ville_depart"),
		            			unResultat.getString("destination_name"),
		            			unResultat.getString("date_depart"),
		            			unResultat.getString("nb_personnes"),
		            			unResultat.getString("logement_id"),
		            			unResultat.getString("logement_name"),
		                        unResultat.getString("logement_type"),
		                        unResultat.getString("logement_nb_etoiles"),
		                        unResultat.getString("logement_date_debut"),
		                        unResultat.getString("logement_date_fin"),
		                        unResultat.getString("numero"),
		                        unResultat.getString("heure_depart"),
		                        unResultat.getString("heure_arrivee"),
		                        unResultat.getString("reservations_prix"),
		                        unResultat.getString("nom"),
		                        unResultat.getString("prenom"),
		                        unResultat.getString("email"));
		            }
		            unStat.close();
		            uneBdd.seDeconnecter();
		        } catch (SQLException exp) {
		            System.out.println("Erreur d'execution de la requete : " + requete);
		        }
		        return uneReservation;
		    }
}
