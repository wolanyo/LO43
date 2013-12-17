/**
 * 
 */
package tickettoride.engine.core;

import org.jsfml.graphics.Color;

/**
 * @author Komi Wolanyo KOUDO
 *
 */
public class CarteWagon {

	private int color ;
	private TypeCarteWagon typeCarte ;
	
	public CarteWagon(){
		
	}
	
	public CarteWagon(int color){
		this.setColor(color) ;
	}

	/**
	 * @return the color
	 */
	public int getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(int color) {
		this.color = color;
	}

	/**
	 * @return the typeCarte
	 */
	public TypeCarteWagon getTypeCarte() {
		return typeCarte;
	}

	/**
	 * @param typeCarte the typeCarte to set
	 */
	public void setTypeCarte(TypeCarteWagon typeCarte) {
		this.typeCarte = typeCarte;
	}
	
	public org.jsfml.graphics.Color colorer(){
		switch (typeCarte) {
		case BLANC:
			return Color.WHITE ;
		case BLEU:
			return Color.BLUE ;
		case NOIR:
			return Color.BLACK ;
		case JAUNE:
			return Color.YELLOW ;
		case VERT:
			return Color.GREEN ;
		case ROUGE:
			return Color.RED ;
		case VIOLET :
			return Color.add(Color.BLUE, Color.RED) ;
		case ORANGE :
			return Color.mul(Color.YELLOW, Color.RED) ;
		default:
			return Color.WHITE ;
		}
	}
}
