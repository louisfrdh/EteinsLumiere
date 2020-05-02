package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import controllers.GrilleController;
import models.Grille;

@SuppressWarnings({ "deprecation", "serial" })
public class GrilleView extends JPanel implements Observer{
	
	public static final int TAILLE_FENETRE = 500;

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}

	public GrilleView() {
		setPreferredSize(new Dimension(TAILLE_FENETRE+Grille.TAILLE-1,TAILLE_FENETRE+Grille.TAILLE-1));
		Grille.getGrille().addObserver(this);
		GrilleController gc = new GrilleController();
		addMouseListener(gc);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int lCase = TAILLE_FENETRE / Grille.TAILLE;
		int x=0;
		int y=0;
		for(int i=0 ; i < Grille.TAILLE ; i++) {
			y=0;
			for(int j=0 ; j < Grille.TAILLE ; j++) {
				boolean etatCase = Grille.getGrille().getCase(i, j).getOn();
				if(etatCase) {
					g.setColor(Color.green);
				} else {
					g.setColor(Color.black);
				}
				g.fillRect(x, y, lCase, lCase);
				y += lCase+1;
			}
			x += lCase+1;
		}
	}
}
