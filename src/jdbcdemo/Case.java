package jdbcdemo;


import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Case extends Parent {

	public String lettre;
    private int positionX = 0; // abscisse
    private int positionY = 0; // ordonnée de la touche
    
    Rectangle fond_touche;
    Text lettre_touche;
    
    Boolean finDuJeu = false;
    
	public Case(int posX, int posY) {
        positionX = posX;
        positionY = posY;
        
        fond_touche = new Rectangle(75,75,Color.WHITE);
        fond_touche.setArcHeight(10);
        fond_touche.setArcWidth(10);
        this.getChildren().add(fond_touche); //ajout du rectangle de fond de la touche
        
        //------ touche
        lettre_touche = new Text("");
        lettre_touche.setFont(new Font(25));
        lettre_touche.setFill(Color.RED);
        lettre_touche.setX(25);
        lettre_touche.setY(45);
        this.getChildren().add(lettre_touche); //ajout de la lettre de la touche
        
        this.setTranslateX(positionX); //positionnement de la touche sur le clavier
        this.setTranslateY(positionY);
        
        //---------- Souris
        this.setOnMouseEntered(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
            	fond_touche.setFill(Color.LIGHTGREY);
            }
        });
        this.setOnMouseExited(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
            	fond_touche.setFill(Color.WHITE);
            }
        });
        
        //---------CLICK
        this.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
            	
            	//System.out.println("case : setOnMouseClicked");
            	
            	if(!finDuJeu) {
            		lettre_touche.setText(lettre);
            	}
          }
        });
        
	}
	
	public void setFinDuJeu(Boolean finDuJeu) {
		this.finDuJeu = finDuJeu;
	}
	
	public void setLettre(String lettre) {
		this.lettre = lettre;
	}
	
	public String getLettre() {
		return lettre;
	}
	
	public void setText(String texte) {
		lettre_touche.setText(texte);
	}
	
	public String getText() {
		return lettre_touche.getText();
	}
	
	public void setColor(Color couleur) {
		lettre_touche.setFill(couleur);
	}
}
