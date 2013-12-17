package tickettoride.engine.core;

public class Joueur {

	private String pseudo ;
	private int color ;
	private int score;
	private int nbWagon ;
	
	public Joueur(){
		
	}
	
	public Joueur(String pseudo, int color, int score){
		this.pseudo = pseudo ;
		this.color = color ;
		this.score = score ;
		this.nbWagon = 45 ;
	}

	/**
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * @param pseudo the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
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
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the nbWagon
	 */
	public int getNbWagon() {
		return nbWagon;
	}

	/**
	 * @param nbWagon the nbWagon to set
	 */
	public void setNbWagon(int nbWagon) {
		this.nbWagon = nbWagon;
	}
}
