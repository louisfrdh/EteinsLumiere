import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controllers.GrilleController;
import models.Grille;
import views.CompteurView;
import views.GrilleView;
import views.MenuView;

public class Main {
	@SuppressWarnings("deprecation")
	public static void main (String[] args) {
		
		Grille g = Grille.getGrille();
		GrilleView gv = new GrilleView();
		MenuView mv = new MenuView();
		CompteurView cv = new CompteurView();
		
		JPanel jeu = new JPanel();
		jeu.setLayout(new BoxLayout(jeu, BoxLayout.Y_AXIS));
		jeu.add(cv);
		jeu.add(gv);
		jeu.add(mv);
		
		JFrame fenetre = new JFrame("Eteins la lumière !");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		fenetre.setContentPane(jeu);
		fenetre.pack();
		fenetre.setVisible(true);
	}
}
