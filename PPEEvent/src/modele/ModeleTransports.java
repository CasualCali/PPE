package modele;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import controleur.Transports;

public class ModeleTransports {
	    private static Bdd unBdd = new Bdd("localhost:3307", "travelin_Event", "root", "");

	    public static void inserttransports(Transports unTransport) {
	        String requete = "INSERT INTO transport VALUES ( null,'"
	                + unTransport.gettransport_name() + "', '"
	                + unTransport.getville_depart() + "', '"
	    	        + unTransport.getville_arrivee() + "', '"
	    	    	+ unTransport.gettransport_date() + "', '"
	    	        + unTransport.getheure_depart() + "', '"
	    	    	+ unTransport.getheure_arrivee() + "', '"
	    	    	+ unTransport.getnumero() + "', '"
	    	    	+ unTransport.getcompagnie() + "', '"
	    	    	+ unTransport.getmodele() + "', '"
	    	    	+ unTransport.getheure_de_trajet() + "', '"
	                + unTransport.gettransport_prix() + "');";
	        try {
	            unBdd.seConnecter();
	            Statement unStat = unBdd.getMaConnexion().createStatement();
	            unStat.execute(requete);
	            unStat.close();
	            unBdd.seDeconnecter();
	        } catch (SQLException exp) {
	            System.out.println("Erreur d'execution de la requete : " + requete);
	        }
	    }

	    public static void updatetransports(Transports unTransport) {
	        String requete = "UPDATE transport SET"
	                + " transport_name = '" + unTransport.gettransport_name() + "',"
            		+ " ville_depart = '" + unTransport.getville_depart() + "',"
    				+ " ville_arrivee = '" + unTransport.getville_arrivee() + "',"
					+ " transport_date = '" + unTransport.gettransport_date() + "',"
					+ " heure_depart = '" + unTransport.getheure_depart() + "',"
					+ " heure_arrivee = '" + unTransport.getheure_arrivee() + "',"
					+ " numero = '" + unTransport.getnumero() + "',"
					+ " compagnie = '" + unTransport.getcompagnie() + "',"
					+ " modele = '" + unTransport.getmodele() + "',"
					+ " heure_de_trajet = '" + unTransport.getheure_de_trajet() + "',"
	                + " transport_prix = '" + unTransport.gettransport_prix() + "'"
	                + " WHERE transport_id = " + unTransport.gettransport_id() + ";";
	        try {
	            unBdd.seConnecter();
	            Statement unStat = unBdd.getMaConnexion().createStatement();
	            unStat.execute(requete);
	            unStat.close();
	            unBdd.seDeconnecter();
	        } catch (SQLException exp) {
	            System.out.println("Erreur d'execution de la requete : " + requete);
	        }
	    }

	    public static void deletetransports(int transport_id) {
	        String requete = "DELETE FROM transport WHERE transport_id = " + transport_id + ";";
	        try {
	            unBdd.seConnecter();
	            Statement unStat = unBdd.getMaConnexion().createStatement();
	            unStat.execute(requete);
	            unStat.close();
	            unBdd.seDeconnecter();
	        } catch (SQLException exp) {
	            System.out.println("Erreur d'execution de la requete : " + requete);
	        }
	    }

	    public static ArrayList<Transports> selectAllTransports() {
	        ArrayList<Transports> lesTransports = new ArrayList<Transports>();
	        String requete = "SELECT * FROM transport;";
	        try {
	            unBdd.seConnecter();
	            Statement unStat = unBdd.getMaConnexion().createStatement();
	            // récupération des résultats
	            java.sql.ResultSet desResultats = unStat.executeQuery(requete);
	            // on parcourt les résultats et on instancie les Transports
	            while (desResultats.next()) {
	                Transports unTransport = new Transports(desResultats.getInt("transport_id"),
	                        desResultats.getString("transport_name"),
	                        desResultats.getString("ville_depart"),
	                        desResultats.getString("ville_arrivee"),
	                        desResultats.getString("transport_date"),
	                        desResultats.getString("heure_depart"),
	                        desResultats.getString("heure_arrivee"),
	                        desResultats.getString("numero"),
	                        desResultats.getString("compagnie"),
	                        desResultats.getString("modele"),
	                        desResultats.getString("heure_de_trajet"),
	                        desResultats.getString("transport_prix"));
	                // on ajoute le transport dans l'ArrayList
	                lesTransports.add(unTransport);
	            }
	            unStat.close();
	            unBdd.seDeconnecter();
	        } catch (SQLException exp) {
	            System.out.println("Erreur d'execution de la requete : " + requete);
	        }
	        return lesTransports;
	    }

	    public static Transports selectWhereTransport(int transport_id) {
	    	Transports unTransport = null;
	        String requete = "SELECT * FROM transport WHERE transport_id = " + transport_id + ";";
	        try {
	            unBdd.seConnecter();
	            Statement unStat = unBdd.getMaConnexion().createStatement();
	            // récupération du Transport
	            java.sql.ResultSet unResultat = unStat.executeQuery(requete);
	            // on teste si le Transport existe
	            if (unResultat.next()) {
	            	unTransport = new Transports(unResultat.getInt("transport_id"),
	            			unResultat.getString("transport_name"),
	            			unResultat.getString("ville_depart"),
	            			unResultat.getString("ville_arrivee"),
	            			unResultat.getString("transport_date"),
	            			unResultat.getString("heure_depart"),
	            			unResultat.getString("heure_arrivee"),
	            			unResultat.getString("numero"),
	            			unResultat.getString("compagnie"),
	            			unResultat.getString("modele"),
	            			unResultat.getString("heure_de_trajet"),
	            			unResultat.getString("transport_prix"));
	            }
	            unStat.close();
	            unBdd.seDeconnecter();
	        } catch (SQLException exp) {
	            System.out.println("Erreur d'execution de la requete : " + requete);
	        }
	        return unTransport;
	    }
}
