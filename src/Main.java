import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controllers.GrilleController;
import models.Grille;
import views.CompteurView;
import views.GrilleView;
import views.MenuView;

public class Main {
	public static void main (String[] args) {
		
		Grille g = new Grille();
		GrilleController gc = new GrilleController(g);
		GrilleView gv = new GrilleView(gc);
		MenuView mv = new MenuView(gc);
		CompteurView cv = new CompteurView(gc);
		
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
