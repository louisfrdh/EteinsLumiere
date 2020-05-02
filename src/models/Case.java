package models;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class Case extends Observable {
	
	private static final int TAILLE = 20;
	private int x, y;
	private boolean on;
	
	/**
	 * Constructeur avec indices de la case
	 * @param i l'indice de colonne x
	 * @param j l'indice de ligne y
	 */
	public Case(int i, int j) {
		x = i;
		y = j;
		on = false;
	}
	
	public void changerEtat() {
		if(getOn()) {
			on = false;
		} else {
			on = true;
		}
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
