package controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import models.Grille;
import views.GrilleView;

public class GrilleController implements MouseListener {

	private int iCase, jCase;
	
	public GrilleController() {
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		iCase = trouverI(e);
		jCase = trouverJ(e);
		Grille.getGrille().toucherCase(iCase, jCase);
	}
	
	private static int trouverI(MouseEvent e) {
		switch (e.getX() / (GrilleView.TAILLE_FENETRE / Grille.TAILLE)) {
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
	
	private static int trouverJ(MouseEvent e) {
		switch (e.getY() / (GrilleView.TAILLE_FENETRE / Grille.TAILLE)) {
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

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
