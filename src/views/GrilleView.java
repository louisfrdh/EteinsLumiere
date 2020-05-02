package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import controllers.GrilleController;
import models.Grille;

/**
 * Vue de la grille de jeu
 * @author friedrich
 *
 */
@SuppressWarnings({ "deprecation", "serial" })
public class GrilleView extends JPanel implements Observer{
	
	public static final int LARGEUR = 500;
	private GrilleController gc;

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}

	public GrilleView(GrilleController gc) {
		this.gc = gc;
		setPreferredSize(new Dimension(LARGEUR+Grille.TAILLE-1,LARGEUR+Grille.TAILLE-1));
		gc.getGrille().addObserver(this);
		addMouseListener(gc);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int lCase = LARGEUR / Grille.TAILLE;
		int x=0;
		int y=0;
		for(int i=0 ; i < Grille.TAILLE ; i++) {
			y=0;
			for(int j=0 ; j < Grille.TAILLE ; j++) {
				boolean etatCase = gc.getCase(i, j).getOn();
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
