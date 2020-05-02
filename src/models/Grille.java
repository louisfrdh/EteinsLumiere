package models;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class Grille extends Observable{
	
	private static final int TAILLE = 5;
	private static int NBLUMIERES = 8;
	private Case[][] cases;
	
	public Grille() {
		cases = new Case[TAILLE][TAILLE];
		for(int i=0 ; i < TAILLE ; i++) {
			for(int j=0 ; j < TAILLE ; j++) {
				cases[i][j] = new Case(i, j);
			}
		}
	}
	
	/**
	 * Cherche les cases concernées par un clic
	 * @param c la case ciblée par le clic
	 * @return le tableau contenant les cases affectées
	 */
	public Case[] trouverAdj(Case c) {
		Case adjacentes[] = new Case[5];
		int p = 0;
		int indiceX = c.getX();
		int indiceY = c.getY();
		for(int i = indiceX-1 ; i <= indiceX+1 ; i++) {
			if (i == indiceX) {
				for(int j = indiceY-1 ; j <= indiceY+1 ; j++) {
					adjacentes[p] = cases[i][j];
					p++;
				}				
			} else {
				adjacentes[p] = cases[i][indiceY];
				p++;
			}
		}
		return adjacentes;
	}
	
	/**
	 * Modifie l'état des cases affectées par un clic
	 * @param le tableau contenant les cases affectées
	 */
	public void toucherCase(Case[] affectees) {
	}
	
	public Case[][] getCases() {
		return cases;
	}
}
