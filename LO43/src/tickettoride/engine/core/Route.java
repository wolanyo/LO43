package tickettoride.engine.core;

public class Route {
	
	private int nbWagonNecessaire ;
	private boolean etat ;
	private int couleur ;
	private Uv uvDepart ;
	private Uv uvArrivee ;
	
	public Route(){
		
	}
	
	public Route(int nbWagonNecessaire){
		this.setNbWagonNecessaire(nbWagonNecessaire) ;
	}

	/**
	 * @return the nbWagonNecessaire
	 */
	public int getNbWagonNecessaire() {
		return nbWagonNecessaire;
	}

	/**
	 * @param nbWagonNecessaire the nbWagonNecessaire to set
	 */
	public void setNbWagonNecessaire(int nbWagonNecessaire) {
		this.nbWagonNecessaire = nbWagonNecessaire;
	}

	/**
	 * @return the etat
	 */
	public boolean isEtat() {
		return etat;
	}

	/**
	 * @param etat the etat to set
	 */
	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	/**
	 * @return the couleur
	 */
	public int getCouleur() {
		return couleur;
	}

	/**
	 * @param couleur the couleur to set
	 */
	public void setCouleur(int couleur) {
		this.couleur = couleur;
	}

	/**
	 * @return the uvDepart
	 */
	public Uv getUvDepart() {
		return uvDepart;
	}

	/**
	 * @param uvDepart the uvDepart to set
	 */
	public void setUvDepart(Uv uvDepart) {
		this.uvDepart = uvDepart;
	}

	/**
	 * @return the uvArrivee
	 */
	public Uv getUvArrivee() {
		return uvArrivee;
	}

	/**
	 * @param uvArrivee the uvArrivee to set
	 */
	public void setUvArrivee(Uv uvArrivee) {
		this.uvArrivee = uvArrivee;
	}

}
