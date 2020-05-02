import models.Case;
import models.Grille;

public class Main {
	public static void main (String[] args) {
		Grille g = new Grille();
		g.toucherCase(g.trouverAdj(g.getCases()[2][2]));
		Case adjacentes[] = g.trouverAdj(g.getCases()[2][2]);
		int i = 0;
		for (Case c : adjacentes) {
			System.out.println("Case n°" + i);
			System.out.println("x : " + c.getX());
			System.out.println("y : " + c.getY());
			i++;
		}
	}
}
