import models.Grille;

public class Main {
	public static void main (String[] args) {
		Grille g = new Grille();
		Grille.toucherCase(g.trouverAdj(2,2));
		for(int i=0 ; i < 5 ; i++) {
			for(int j=0 ; j < 5 ; j++) {
				System.out.println("Case (" + i + " ; " + j + ") : " + g.getCase(i,j).getOn());
			}
		}
	}
}
