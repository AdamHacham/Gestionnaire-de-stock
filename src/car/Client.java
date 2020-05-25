package car;

public class Client {

	private String Id;
	private String Nom;
	private String Prenom;
	private String Tel;
	private String Mail;
	
public Client(String nom,String prenom,String tel,String mail) {
		super();
		this.Nom = nom;
		this.Prenom = prenom;
		this.Tel = tel;
		this.Mail = mail;
}
public Client(String index, String nom, String prenom, String tel, String mail) {
		super();
		this.Id = index;
		this.Nom = nom;
		this.Prenom = prenom;
		this.Tel = tel;
		this.Mail = mail;
}
public Client() {
		super();
}
public String getId() {
		return this.Id;
}
public void setIndex(String index) {
		this.Id = index;
}
public String getNom() {
		return Nom;
}
public void setNom(String nom) {
		Nom = nom;
}
public String getPrenom() {
		return Prenom;
}
public void setPrenom(String prenom) {
		Prenom = prenom;
}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	public String getMail() {
		return Mail;
	}
	public void setMail(String mail) {
		Mail = mail;
	}

}
