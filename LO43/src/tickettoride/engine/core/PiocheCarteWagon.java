/**
 * 
 */
package tickettoride.engine.core;

import java.util.Vector;

import org.jsfml.graphics.Color;

/**
 * @author ella
 *
 */

public class PiocheCarteWagon {

	/**
	 * 
	 */
	private int nombreDeCarte;
	private TypeCarteWagon[] piocheDeCarte ;
	private int carteActuelle ;
	private Vector<CarteWagon> listeCarteWagons ;
	private CarteWagon carteWagon ;
	private static int piocheActuelle ;
	
	//liste de pioche
	private TypeCarteWagon[] listeCartePioche1 = new TypeCarteWagon[]{TypeCarteWagon.VIOLET, TypeCarteWagon.VIOLET, 
			TypeCarteWagon.BLANC, TypeCarteWagon.BLANC,TypeCarteWagon.BLEU, TypeCarteWagon.BLEU, 
			TypeCarteWagon.JAUNE, TypeCarteWagon.JAUNE, TypeCarteWagon.ORANGE, TypeCarteWagon.ORANGE,
			TypeCarteWagon.NOIR, TypeCarteWagon.NOIR, TypeCarteWagon.ROUGE, TypeCarteWagon.ROUGE,
			TypeCarteWagon.VERT, TypeCarteWagon.VERT} ;

	
	public PiocheCarteWagon() {
	
	}
	
	/*public PiocheCarteWagon(int nbCarte) {
		// TODO Auto-generated constructor stub
		this.nombreDeCarte = nbCarte ;
		this.carteActuelle = nbCarte;
		//genererListe() ;
	}*/
	
	public PiocheCarteWagon(int nbCarte) {
		// TODO Auto-generated constructor stub
		//initialisation
		listeCarteWagons = new Vector<CarteWagon>() ;
		//assignation 
		this.nombreDeCarte = nbCarte ;
		this.carteActuelle = nbCarte;
		this.piocheDeCarte = listeCartePioche1 ;
		genererListe() ;
	}

	/**
	 * @return the nombreDeCarte
	 */
	public int getNombreDeCarte() {
		return nombreDeCarte;
	}

	/**
	 * @param nombreDeCarte the nombreDeCarte to set
	 */
	public void setNombreDeCarte(int nombreDeCarte) {
		this.nombreDeCarte = nombreDeCarte;
	}

	/**
	 * @return the piocheDeCarte
	 */
	public TypeCarteWagon[] getPiocheDeCarte() {
		return piocheDeCarte;
	}

	/**
	 * @param piocheDeCarte the piocheDeCarte to set
	 */
	public void setPiocheDeCarte(TypeCarteWagon[] piocheDeCarte) {
		this.piocheDeCarte = piocheDeCarte;
	}

	/**
	 * @return the carteActuelle
	 */
	public int getCarteActuelle() {
		return carteActuelle;
	}

	/**
	 * @param carteActuelle the carteActuelle to set
	 */
	public void setCarteActuelle(int carteActuelle) {
		this.carteActuelle = carteActuelle;
	}
	
	public void defausser(){
		if(carteActuelle > 0)
			this.carteActuelle-- ;
		else 
			this.carteActuelle = 0 ;
	}

	/**
	 * @return the carteWagons
	 */
	public CarteWagon getCarteWagonActuelle() {
		if(carteActuelle < 1)
			return null ;
		else
			return listeCarteWagons.get(carteActuelle-1);
	}

	/**
	 * @param carteWagons the carteWagons to set
	 */
	/*public void setCarteWagons(CarteWagon[] carteWagons) {
		this.carteWagons = carteWagons;
	}*/
	
	private void genererListe(){
		for(int i=0; i<nombreDeCarte; i++){
			carteWagon = new CarteWagon() ;
			carteWagon.setTypeCarte(piocheDeCarte[i]) ;
			listeCarteWagons.add(carteWagon) ;
		}
	}
}
