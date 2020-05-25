package car;

public abstract class Coli {

    
    protected String NomPe ;
	protected String PrenomPe ;
    protected String NomPr ;
    protected String PrenomPr ;
    protected String Dest ;
    protected String Src ;
    protected String NumColis ;
    protected String Prix ;
    protected String Quantité ;
    protected String Type;
    protected String Etat ;
    protected String Jour;
    protected String Mois;
    protected String Ans;
    
    
    public Coli() {
		super();
		
	}

    abstract String getPrix();
    abstract void setPrix(String Prix) ;
    
    protected String getNomPe(){
	return this.NomPe ;
    }
    protected void setNomPe(String nom){
	this.NomPe=nom;
    }   
    protected String getNomPr(){
	return this.NomPr;
    }
    protected void setNomPr(String nom){
	this.NomPr = nom ;
    }
    protected String getDest(){
	return this.Dest ;
    }
    protected void setDest(String Dest){
	this.Dest = Dest;
    }
    protected String getSrc(){
	return this.Src;
    }
    protected void setSrc(String Src){
	this.Src = Src ;;
    }
    protected String getPrenomPr(){
	return this.PrenomPr;
    }
    protected void setPrenomPr(String nom){
	this.PrenomPr = nom ;
    }
    protected String getPrenomPe(){
	return this.PrenomPe;
    }
    protected void setPrenomPe(String nom){
	this.PrenomPe = nom ;
    }
    protected String getNumColis(){
	return this.NumColis;
    }
    protected void setNumColis(String Numero){
	this.NumColis = Numero ;
    }
    protected Class<? extends Coli> getType(){
	return this.getClass() ;
    }
    protected void setType(String Type){
	this.Type = Type;
    }
    protected String getEtat(){
        return this.Etat ;
    }
    protected void setEtat(String Etat){
	this.Etat = Etat;
    }
    protected String getQuantité(){
        return this.Quantité ;
    }
    protected void setQuantité(String Quantité){
	this.Quantité = Quantité;
    }


}