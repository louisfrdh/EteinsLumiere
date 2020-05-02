import javax.swing.JFrame;

import models.Grille;
import views.GrilleView;

public class Main {
	public static void main (String[] args) {
		
		/*
		Grille g = new Grille();
		g.toucherCase(0,2);
		for(int i=0 ; i < 5 ; i++) {
			for(int j=0 ; j < 5 ; j++) {
				System.out.println("Case (" + i + " ; " + j + ") : " + g.getCase(i,j).getOn());
			}
		}*/
		

		JFrame fenetre = new JFrame("Scribble");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GrilleView gw = new GrilleView();
		fenetre.setContentPane(gw);
		fenetre.pack();
		fenetre.setVisible(true);
	}
}
