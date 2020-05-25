package car;
public class Diver extends Coli {

    private String Poids ;
    
    
    public Diver(String nomPe, String prenomPe, String nomPr, String prenomPr, String dest, String src, String numColis,String prix) {
    	
    	this.NomPe = nomPe ;
		this.PrenomPe = prenomPe ;
    	this.NomPr = nomPr ;
        this.PrenomPr = prenomPr ;
        this.Dest = dest ;
        this.Src = src ;
        this.NumColis = numColis ;
        this.Prix = prix ;
        this.Quantité = null ;
        this.Type = null ;
        this.Etat = null ;
		this.Poids = null;

	}
    
    public Diver() {
		super();
		this.NomPe = null ;
		this.PrenomPe = null ;
    	this.NomPr = null ;
        this.PrenomPr = null ;
        this.Dest = null ;
        this.Src = null ;
        this.NumColis = null ;
        this.Prix = null ;
        this.Quantité = null ;
        this.Type = null ;
        this.Etat = null ;
		this.Poids = null;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return ""+this.NomPe+"|"+this.PrenomPe+"|"+this.NomPr+"|"+this.PrenomPr+"|"+this.Dest+"|"+this.Src+"|"+this.NumColis+"|"+this.Prix; 
	}

	public Diver(String nomPe, String prenomPe, String nomPr, String prenomPr, String dest, String src, String numColis,String prix, String quantité, String type, String etat,String poids) {
    	
    	this.NomPe = nomPe ;
		this.PrenomPe = prenomPe ;
    	this.NomPr = nomPr ;
        this.PrenomPr = prenomPr ;
        this.Dest = dest ;
        this.Src = src ;
        this.NumColis = numColis ;
        this.Prix = prix ;
        this.Quantité = quantité ;
        this.Type = type ;
        this.Etat = etat ;
		this.Poids = poids;
	}

	protected String getPoids(){
	
    return this.Poids;
    }
    
	@Override
	String getPrix() {
		
		return this.Prix;
	}
	@Override
	void setPrix(String Prix) {
		
		this.Prix=Prix;
	}
	
   }