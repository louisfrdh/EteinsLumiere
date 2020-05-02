package models;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class Grille extends Observable{
	
	private static final int TAILLE = 5;
	private static int NBLUMIERES = 8;
	private Case[][] cases;
	
	/**
	 * Constructeur avec taille par défaut
	 */
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
	 * @param indiceX ligne de la case ciblée
	 * @param indiceY colonne de la case ciblée
	 * @return le tableau contenant les cases affectées
	 */
	public Case[] trouverAdj(int indiceX, int indiceY) {
		Case adjacentes[] = new Case[5];
		int p = 0;
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
	public static void toucherCase(Case[] affectees) {
		for(Case c : affectees) {
			c.changerEtat();
		}
	}
	
	public Case[][] getCases() {
		return cases;
	}
	
	public Case getCase(int x, int y) {
		return cases[x][y];
	}
}
