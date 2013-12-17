/**
 * 
 */
package tickettoride.engine.ui;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Vector;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.Image;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Vector2f;
import org.jsfml.window.VideoMode;
import org.jsfml.window.WindowStyle;
import org.jsfml.window.event.Event;
import org.jsfml.window.event.Event.Type;
import org.jsfml.window.event.KeyEvent;
import org.jsfml.graphics.* ;

import tickettoride.engine.content.*;
import tickettoride.engine.core.CarteWagon;
import tickettoride.engine.core.Joueur;
import tickettoride.engine.core.PiocheCarteDestination;
import tickettoride.engine.core.PiocheCarteWagon;
import tickettoride.engine.core.TypeCarteWagon;
import tickettoride.engine.core.Uv;

/**
 * @author ella
 *
 */
public class Principale {

	private String windowsTitle ;
	private RenderWindow fenetrePrincipale ;
	private RectangleShape carte;
	private RectangleShape shapePiocheCarteWagon ;
	private RectangleShape shapePiocheCarteWagonMasquer ;
	private Vector<RectangleShape> listeShapePiocheCarteWagon ;
	private RectangleShape shapeCarteDestination ;
	private RectangleShape shapePiocheCarteDestination ;
	private Vector<RectangleShape> listeShapeCarteDestination ;
	private RectangleShape shapeCarteWagon ;
	private Vector<RectangleShape> listeShapeCarteWagon ;
	//les objet texte
	private Font police ;
	//declaration des objets
	private PiocheCarteDestination piocheCarteDestination ;
	private PiocheCarteWagon piocheCarteMasquer ;
	private PiocheCarteWagon piocheCarte1 ;
	private PiocheCarteWagon piocheCarte2 ;
	private PiocheCarteWagon piocheCarte3 ;
	private PiocheCarteWagon piocheCarte4 ;
	private PiocheCarteWagon piocheCarte5 ;
	//les valeurs des pioches
	//private 
	//les
	//autres 
	private Text nbCarteMasquerRestant ;
	private Text texteNbPiocheCarteWagonRestant ;
	private Vector<Text> listeTexteNbPiocheCarteWagonRestant ;
	private Text texteNbCarteWagonRestant ;
	private Vector<Text> listeTexteNbCarteWagonRestant ;
	
	/**
	 * 
	 */
	public Principale(String title) {
		// TODO Auto-generated constructor stub
		police = new Font() ;
		initObject() ;
		this.windowsTitle = title ;
	}
	
	private void initView(){
		fenetrePrincipale = new RenderWindow();
		fenetrePrincipale.create(new VideoMode(1366, 768), windowsTitle);

		//Limit the framerate
		fenetrePrincipale.setFramerateLimit(30);
		fenetrePrincipale.clear(Color.WHITE);
		//initObject() ;
		//dessiner();

		//Main loop
		while(fenetrePrincipale.isOpen()) {
		    //Fill the window with red
			fenetrePrincipale.clear(Color.WHITE);
			dessiner() ;
		    //Display what was drawn (... the red color!)
			fenetrePrincipale.display();
		    //Handle events
			for(Event event : fenetrePrincipale.pollEvents()) {
		        switch(event.type){
		        	case CLOSED:
		        		fenetrePrincipale.close() ;
		        		break;
		        	case KEY_PRESSED :
		        		switch(event.asKeyEvent().key){
		        			case ESCAPE :
		        				fenetrePrincipale.close() ;
		        				break ;
		        			default :
		        				break ;
		        		}
		        	break ;
		        	case MOUSE_BUTTON_PRESSED : 
		        		switch(event.asMouseButtonEvent().button){
		        			case LEFT :
		        				//fenetrePrincipale.close() ;
		        				logic(event) ;
		        				break ;
		        			default :
		        				break ;
		        		}
		        		break;
		        	default : 
		        		break ;
		        }
		    }
		}
	}
	
	private void dessiner() {
		fenetrePrincipale.draw(carte) ;
		for(int i=0; i<5; i++){
			fenetrePrincipale.draw(listeShapePiocheCarteWagon.get(i)) ;
			fenetrePrincipale.draw(listeTexteNbPiocheCarteWagonRestant.get(i)) ;
		}
		for(int i=0; i<3; i++){
			fenetrePrincipale.draw(listeShapeCarteDestination.get(i)) ;
		}
		fenetrePrincipale.draw(shapePiocheCarteDestination) ;
		fenetrePrincipale.draw(shapePiocheCarteWagonMasquer) ;
		fenetrePrincipale.draw(nbCarteMasquerRestant) ;
		for(int i=0; i<9; i++){
			fenetrePrincipale.draw(listeShapeCarteWagon.get(i)) ;
			fenetrePrincipale.draw(listeTexteNbCarteWagonRestant.get(i)) ;
		}
	}
	
	private void genererFormes(){
		carte = new RectangleShape(new Vector2f(1100, 470)) ;
		carte.setOutlineColor(Color.BLACK);
		carte.setOutlineThickness(2) ;
		carte.setPosition(new Vector2f(200, 120)) ;
		
		//creation du shape de la pioche de carte de destination
		shapePiocheCarteDestination = new RectangleShape(new Vector2f(160, 80)) ;
		shapePiocheCarteDestination.setOutlineColor(Color.BLACK);
		shapePiocheCarteDestination.setOutlineThickness(2) ;
		shapePiocheCarteDestination.setFillColor(Color.MAGENTA) ;
		shapePiocheCarteDestination.setPosition(new Vector2f(10, 475)) ;
		//generation des cartes destinations piocher
		listeShapeCarteDestination = new Vector<RectangleShape>() ;
		for(int i=0; i<3; i++){
			shapeCarteDestination = new RectangleShape(new Vector2f(160, 85)) ;
			shapeCarteDestination.setOutlineColor(Color.BLACK);
			shapeCarteDestination.setOutlineThickness(1) ;
			shapeCarteDestination.setFillColor(Color.CYAN) ;
			if(i == 0){
				shapeCarteDestination.setPosition(new Vector2f(10, 565) ) ;
			}
			else{
				shapeCarteDestination.setPosition(new Vector2f(10+(i+1), 565+(i*30))) ;
			}
			listeShapeCarteDestination.add(shapeCarteDestination) ;
		}
		
		//creation du shape de la pioche de carte Masquer
		shapePiocheCarteWagonMasquer = new RectangleShape(new Vector2f(140, 65)) ;
		shapePiocheCarteWagonMasquer.setOutlineColor(Color.BLACK);
		shapePiocheCarteWagonMasquer.setOutlineThickness(2) ;
		shapePiocheCarteWagonMasquer.setFillColor(piocheCarteMasquer.getCarteWagonActuelle().colorer()) ;
		shapePiocheCarteWagonMasquer.setPosition(new Vector2f(20, 45)) ;
		
		//shape des pioche des carte Wagon
		listeShapePiocheCarteWagon = new Vector<RectangleShape>() ;
		listeTexteNbPiocheCarteWagonRestant = new Vector<Text>() ;
		for(int i=0; i<5; i++){
			shapePiocheCarteWagon = new RectangleShape(new Vector2f(140, 65)) ;
			shapePiocheCarteWagon.setOutlineColor(Color.BLACK);
			shapePiocheCarteWagon.setOutlineThickness(1) ;
			//initialisation du texte
			texteNbPiocheCarteWagonRestant = new Text("20", police, 20) ;
			texteNbPiocheCarteWagonRestant.setColor(Color.BLACK);
			if(i == 0){
				shapePiocheCarteWagon.setPosition(new Vector2f(20, 115) ) ;
				texteNbPiocheCarteWagonRestant.setPosition(new Vector2f(20, 115)) ;
				shapePiocheCarteWagon.setFillColor(piocheCarte1.getCarteWagonActuelle().colorer()) ;
			}
			else{
				shapePiocheCarteWagon.setPosition(new Vector2f(20, 115+(i*70))) ;
				texteNbPiocheCarteWagonRestant.setPosition(new Vector2f(20, 115+(i*70))) ;
				shapePiocheCarteWagon.setFillColor(piocheCarte1.getCarteWagonActuelle().colorer()) ;
			}
			listeShapePiocheCarteWagon.add(shapePiocheCarteWagon) ;
			listeTexteNbPiocheCarteWagonRestant.add(texteNbPiocheCarteWagonRestant);
		}
		
		//les carte wagon piochées
		listeShapeCarteWagon = new Vector<RectangleShape>() ;
		listeTexteNbCarteWagonRestant = new Vector<Text>() ;
		for(int i=0; i<9; i++){
			shapeCarteWagon = new RectangleShape(new Vector2f(80, 110)) ;
			shapeCarteWagon.setOutlineColor(Color.BLACK);
			shapeCarteWagon.setOutlineThickness(1) ;
			//initialisation du texte
			texteNbCarteWagonRestant = new Text("0", police, 20) ;
			texteNbCarteWagonRestant.setColor(Color.BLACK);
			if(i == 0){
				shapeCarteWagon.setPosition(new Vector2f(200, 600) ) ;
				texteNbCarteWagonRestant.setPosition(new Vector2f(200, 600)) ;
			}
			else{
				shapeCarteWagon.setPosition(new Vector2f(200+(i*85), 600)) ;
				texteNbCarteWagonRestant.setPosition(new Vector2f(200+(i*85), 600)) ;
			}
			listeShapeCarteWagon.add(shapeCarteWagon) ;
			listeTexteNbCarteWagonRestant.add(texteNbCarteWagonRestant) ;
		}
	}
	
	private void initObject(){
		//initialisation des pioches
		piocheCarteMasquer = new PiocheCarteWagon(16) ;
		piocheCarte1 = new PiocheCarteWagon(16) ;
		piocheCarte2 = new PiocheCarteWagon(16) ;
		piocheCarte3 = new PiocheCarteWagon(16) ;
		piocheCarte4 = new PiocheCarteWagon(16) ;
		piocheCarte5 = new PiocheCarteWagon(16) ;
		
		police = new Font() ;
		try {
			police.loadFromFile(Paths.get(Police.POLICE_UBUNTU_C)) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nbCarteMasquerRestant = new Text(Integer.toString(piocheCarteMasquer.getCarteActuelle()), police, 30) ;
		nbCarteMasquerRestant.setPosition(new Vector2f(20, 40)) ;
		nbCarteMasquerRestant.setColor(Color.BLACK) ;
	}
	
	private void logic(Event event ){
		//case carteWagon heigh = 65, width = 140
		//debut des coordonnées x = 20, y = 45
		int mouseX = event.asMouseButtonEvent().position.x ;
		int mouseY = event.asMouseButtonEvent().position.y ;
		
		if((mouseX <= 160)  && (mouseX >= 21) && (mouseY <= 110)  && (mouseY>=46)){
			if(piocheCarteMasquer.getCarteActuelle() < 1 ){
				System.out.println("Vide") ;
			}
			else{
				switch (piocheCarteMasquer.getCarteWagonActuelle().getTypeCarte()) {
					case VIOLET:
						listeShapeCarteWagon.get(0).setFillColor(Color.add(Color.BLUE, Color.RED)) ;
						fenetrePrincipale.draw(listeShapeCarteWagon.get(0)) ;
						break;
					case BLANC:
						listeShapeCarteWagon.get(1).setFillColor(Color.WHITE) ;
						fenetrePrincipale.draw(listeShapeCarteWagon.get(1)) ;
						break;
					case BLEU:
						listeShapeCarteWagon.get(2).setFillColor(Color.BLUE) ;
						fenetrePrincipale.draw(listeShapeCarteWagon.get(2)) ;
						break;
					case JAUNE:
						listeShapeCarteWagon.get(3).setFillColor(Color.YELLOW) ;
						fenetrePrincipale.draw(listeShapeCarteWagon.get(3)) ;
						break;
					case ORANGE:
						listeShapeCarteWagon.get(4).setFillColor(Color.mul(Color.YELLOW, Color.RED)) ;
						fenetrePrincipale.draw(listeShapeCarteWagon.get(4)) ;
						break;
					case NOIR:
						listeShapeCarteWagon.get(5).setFillColor(Color.BLACK) ;
						fenetrePrincipale.draw(listeShapeCarteWagon.get(5)) ;
						break;
					case ROUGE :
						listeShapeCarteWagon.get(6).setFillColor(Color.RED) ;
						fenetrePrincipale.draw(listeShapeCarteWagon.get(6)) ;
						break;
					case VERT :
						listeShapeCarteWagon.get(7).setFillColor(Color.GREEN) ;
						fenetrePrincipale.draw(listeShapeCarteWagon.get(7)) ;
						break;
					default:
						listeShapeCarteWagon.get(8).setFillColor(Color.CYAN) ;
						fenetrePrincipale.draw(listeShapeCarteWagon.get(8)) ;
						break;
				}
				piocheCarteMasquer.defausser() ;
				if( piocheCarteMasquer.getCarteActuelle() >= 1){
					System.out.println(piocheCarteMasquer.getCarteActuelle()) ;
					shapePiocheCarteWagonMasquer.setFillColor(piocheCarteMasquer.getCarteWagonActuelle().colorer()) ;	
				}
				else{
					shapePiocheCarteWagonMasquer.setFillColor(Color.CYAN) ;
				}
				nbCarteMasquerRestant.setString(Integer.toString(piocheCarteMasquer.getCarteActuelle())) ;
				fenetrePrincipale.draw(nbCarteMasquerRestant);
			}
		}
	}

	public void lunch(){
		genererFormes() ;
		initView() ;
	}
}
