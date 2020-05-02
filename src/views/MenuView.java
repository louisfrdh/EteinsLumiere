package views;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import controllers.GrilleController;

/**
 * Vue des boutons de configuration du jeu
 * @author friedrich
 *
 */
@SuppressWarnings("serial")
public class MenuView extends JPanel{
	
	public final static int HAUTEUR = 40;
	private GrilleController gc;

	public MenuView(GrilleController gc) {
		this.gc = gc;
		setPreferredSize(new Dimension(GrilleView.LARGEUR,HAUTEUR));
		ajouteBoutonEff();
		ajouteBoutonAleatoire();
		ajouteBoutonJouer();
		ajouteBoutonConfigurer();
	}
	
	public void paintCompenent(Graphics g) {
		super.paintComponent(g);
	}
	
	public void ajouteBoutonEff() {
		JButton eff = new JButton("Recommencer");
		eff.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				gc.effacerGrille();
			}	
		});
		this.add(eff);
	}
	
	public void ajouteBoutonAleatoire() {
		JButton aleatoire = new JButton("Aleatoire");
		aleatoire.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				gc.melangerGrille();
			}	
		});
		this.add(aleatoire);
	}
	
	public void ajouteBoutonJouer() {
		JButton jouer = new JButton("Jouer");
		jouer.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				gc.setEnJeu(true);
			}	
		});
		this.add(jouer);
	}
	
	public void ajouteBoutonConfigurer() {
		JButton conf = new JButton("Configurer");
		conf.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				gc.setEnJeu(false);
			}	
		});
		this.add(conf);
	}
}
