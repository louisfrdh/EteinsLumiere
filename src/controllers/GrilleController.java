package controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import models.Case;
import models.Etat;
import models.Grille;
import views.GrilleView;

/**
 * Contrôleur du modèle Grille
 * @author friedrich
 *
 */
public class GrilleController implements MouseListener {

	Grille g;
	private int iCase, jCase;
	
	public GrilleController(Grille g) {
		this.g = g;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		iCase = trouverI(e);
		jCase = trouverJ(e);
		g.toucherCase(iCase, jCase);
	}
	
	/**
	 * Trouve la ligne dans laquelle l'utilisateur a cliqué
	 * @param e l'événement de clic
	 * @return l'indice i
	 */
	private static int trouverI(MouseEvent e) {
		switch (e.getX() / (GrilleView.LARGEUR / Grille.TAILLE)) {
		case 0:
			return 0;
		case 1:
			return 1;
		case 2:
			return 2;
		case 3:
			return 3;
		case 4:
			return 4;
		default:
			return 0;
		}
	}
	
	/**
	 * Trouve la colonne dans laquelle l'utilisateur a cliqué
	 * @param e l'événement de clic
	 * @return l'indice j
	 */
	private static int trouverJ(MouseEvent e) {
		switch (e.getY() / (GrilleView.LARGEUR / Grille.TAILLE)) {
		case 0:
			return 0;
		case 1:
			return 1;
		case 2:
			return 2;
		case 3:
			return 3;
		case 4:
			return 4;
		default:
			return 0;
		}
	}
	
	/**
	 * Eteint toutes les lumières
	 */
	public void effacerGrille() {
		g.effacer();
	}
	
	/**
	 * Créé une disposition aléatoire de lumières
	 */
	public void melangerGrille() {
		g.melanger();
	}
	
	public void setEtat(Etat etat) {
		g.setEtat(etat);
	}
	
	public Etat getEtat() {
		return g.getEtat();
	}
	
	public int getCptClics() {
		return g.getCptClics();
	}
	
	public int getCptLumieres() {
		return g.getCptLumieres();
	}
	
	public Case getCase(int x, int y) {
		return g.getCase(x, y);
	}
	
	public Grille getGrille() {
		return g;
	}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {	}

}
