package car;

public class Electronique  extends Coli{

	public Electronique() {
		// TODO Auto-generated constructor stub
	}
	public Electronique (String NomPe,String PrenomPe,String NomPr,String PrenomPr,String Dest,String Src,String Numcolis ,String Prix,String Quantité,String Type,String Etat ){
	        
			this.NomPe = NomPe ;
			this.PrenomPe = PrenomPe ;
	        this.NomPr = NomPr ;
	        this.PrenomPr = PrenomPr ;
	        this.Dest = Dest ;
	        this.Src = Src ;
	        this.NumColis = Numcolis ;
	        this.Prix = Prix ;
	        this.Quantité = Quantité ;
	        this.Type = Type ;
	        this.Etat = Etat ;
	        
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

