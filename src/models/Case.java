package models;

/**
 * Modèle d'une case de grille
 * @author friedrich
 *
 */
public class Case {
	
	private int x, y;
	private boolean on;
	
	/**
	 * Constructeur avec indices de la case
	 * @param i l'indice de ligne x
	 * @param j l'indice de colonne y
	 */
	public Case(int i, int j) {
		x = i;
		y = j;
		on = false;
	}
	
	/**
	 * Inverse l'état de la case
	 * @return si une lumière a été allumée ou non
	 */
	public boolean changerEtat() {
		boolean allume = true;
		if(getOn()) {
			on = false;
			allume = false;
		} else {
			on = true;
		}
		return allume;
	}
	
	/**
	 * Eteint ou allume la lumière dans la case
	 * @param etat allumé ou éteint
	 */
	public void setOn(boolean etat) {
		on = etat;
	}
	
	public boolean getOn() {
		return on;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
