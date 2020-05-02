package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import controllers.GrilleController;
import models.Grille;

@SuppressWarnings({ "deprecation", "serial" })
public class CompteurView extends JPanel implements Observer {

	public final static int HAUTEUR = 40;
	private GrilleController gc;
	
	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();		
	}
	
	public CompteurView(GrilleController gc) {
		this.gc = gc;
		setPreferredSize(new Dimension(GrilleView.TAILLE_FENETRE,HAUTEUR));
		gc.getGrille().addObserver(this);
		ajouteAffCpt();
	}
	
	public void ajouteAffCpt() {
		JPanel jp = new JPanel();
		JLabel titre = new JLabel("Nb de clic(s) : ");
		String strCpt = Integer.toString(gc.getCpt());
		JLabel cpt = new JLabel(strCpt);
		jp.add(titre,BorderLayout.WEST);
		jp.add(cpt,BorderLayout.EAST);
		this.add(jp);
	}

}
