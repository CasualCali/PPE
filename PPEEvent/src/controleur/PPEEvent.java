package controleur;
import Vue.VueConnexion;
import Vue.VueGenerale;
import Vue.VueGeneraleGestionnaire;

public class PPEEvent {
	private static VueGenerale uneVueGenerale;
	private static VueGeneraleGestionnaire uneVueGeneraleGestionnaire;
	private static VueConnexion uneVueConnexion;
		
	public static void main(String[] args) {
		uneVueConnexion = new VueConnexion();
		uneVueGenerale = new VueGenerale();
		uneVueGeneraleGestionnaire = new VueGeneraleGestionnaire();
	}
	public static void rendreVisibleVueGenerale (boolean action)
	{
		uneVueGenerale.setVisible(action);
	}
	public static void rendreVisibleVueGeneraleGestionnaire (boolean action)
	{
		uneVueGeneraleGestionnaire.setVisible(action);
	}
	public static void rendreVisibleVueConnexion (boolean action)
	{
		uneVueConnexion.setVisible(action);
	}
}

