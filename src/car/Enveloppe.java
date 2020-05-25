package car;

public class Enveloppe extends Diver{
    
	public Enveloppe(String nomPe, String prenomPe, String nomPr, String prenomPr, String dest, String src,
			String numColis, String prix, String quantité, String type, String etat, String poids) {
		super(nomPe, prenomPe, nomPr, prenomPr, dest, src, numColis, prix, quantité, type, etat, poids);
		// TODO Auto-generated constructor stub
	}
	private static String Poids = null;
	
    
	public String getPoids() {
		return Poids;
	}
	public static void setPoids(String poids) {
		Poids = poids;
	}


}