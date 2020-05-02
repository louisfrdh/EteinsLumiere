package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.Grille;

@SuppressWarnings("serial")
public class MenuView extends JPanel{
	
	public final static int HAUTEUR = 40;

	public MenuView() {
		setPreferredSize(new Dimension(GrilleView.TAILLE_FENETRE,HAUTEUR));
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
				Grille.getGrille().effacer();
			}	
		});
		this.add(eff);
	}
	
	public void ajouteBoutonAleatoire() {
		JButton aleatoire = new JButton("Aleatoire");
		aleatoire.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Grille.getGrille().melanger();
			}	
		});
		this.add(aleatoire);
	}
	
	public void ajouteBoutonJouer() {
		JButton jouer = new JButton("Jouer");
		jouer.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Grille.getGrille().setEnJeu(true);
			}	
		});
		this.add(jouer);
	}
	
	public void ajouteBoutonConfigurer() {
		JButton conf = new JButton("Configurer");
		conf.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Grille.getGrille().setEnJeu(false);
			}	
		});
		this.add(conf);
	}
}
