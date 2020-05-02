package models;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class Grille extends Observable{
	
	public static final int TAILLE = 5;
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
					if(j >= TAILLE) {
						adjacentes[p] = cases[i][0];
						p++;
					} else if(j < 0) {
						adjacentes[p] = cases[i][TAILLE-1];
						p++;
					} else {
						adjacentes[p] = cases[i][j];
						p++;
					}
				}				
			} else if(i >= TAILLE){
				adjacentes[p] = cases[0][indiceY];
				p++;
			} else if(i < 0){
				adjacentes[p] = cases[TAILLE-1][indiceY];
				p++;
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
	public void toucherCase(int indiceX, int indiceY) {
		Case affectees[] = this.trouverAdj(indiceX, indiceY);
		for(Case c : affectees) {
			c.changerEtat();
		}
		this.setChanged();
		this.notifyObservers();
	}
	
	public Case[][] getCases() {
		return cases;
	}
	
	public Case getCase(int x, int y) {
		return cases[x][y];
	}
}
