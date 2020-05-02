package models;

@SuppressWarnings("deprecation")
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
	 */
	public void changerEtat() {
		if(getOn()) {
			on = false;
		} else {
			on = true;
		}
	}
	
	/**
	 * Eteint ou allume la lampe de la case
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
