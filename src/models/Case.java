package models;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class Case extends Observable {
	
	private static final int TAILLE = 20;
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
