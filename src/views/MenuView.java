package views;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

import controllers.GrilleController;
import models.Etat;

/**
 * Vue des boutons de configuration du jeu
 * @author friedrich
 *
 */
@SuppressWarnings({ "serial", "deprecation" })
public class MenuView extends JPanel implements Observer {
	
	public final static int HAUTEUR = 35;
	private GrilleController gc;
	JButton eff;
	JButton aleatoire;
	JButton jouer;
	JButton conf;

	@Override
	public void update(Observable obs, Object arg1) {
		repaint();
		switch (gc.getEtat()) {
		case JEU:
			eff.setEnabled(true);
			aleatoire.setEnabled(false);
			jouer.setEnabled(false);
			conf.setEnabled(false);
			break;
		case CONF:
			eff.setEnabled(true);
			aleatoire.setEnabled(true);
			if(gc.getCptLumieres() < 1) {
				jouer.setEnabled(false);
			} else {
				jouer.setEnabled(true);
			}
			conf.setEnabled(true);
			break;
		case FINI:
			eff.setEnabled(true);
			aleatoire.setEnabled(false);
			jouer.setEnabled(false);
			conf.setEnabled(false);
			break;
		}
	}
	
	public MenuView(GrilleController gc) {
		this.gc = gc;
		setPreferredSize(new Dimension(GrilleView.LARGEUR,HAUTEUR));
		ajouteBoutonAleatoire();
		ajouteBoutonConfigurer();
		ajouteBoutonJouer();
		ajouteBoutonEff();
		gc.getGrille().addObserver(this);
	}
	
	
	public void paintCompenent(Graphics g) {
		super.paintComponent(g);
	}
	
	/**
	 * Ajoute au menu un bouton permettant
	 *  d'éteindre toutes les lumières
	 */
	public void ajouteBoutonEff() {
		eff = new JButton("Recommencer");
		eff.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				gc.effacerGrille();
				gc.setEtat(Etat.CONF);
			}	
		});
		this.add(eff);
	}
	
	/**
	 * Ajoute un menu à la vue permettant
	 *  de créer une disposition aléatoire de lumières
	 */
	public void ajouteBoutonAleatoire() {
		aleatoire = new JButton("Aleatoire");
		aleatoire.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				gc.melangerGrille();
			}	
		});
		this.add(aleatoire);
	}
	
	/**
	 * Ajoute un menu à la vue permettant
	 *  de commencer le jeu
	 */
	public void ajouteBoutonJouer() {
		jouer = new JButton("Jouer");
		jouer.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				gc.setEtat(Etat.JEU);
			}	
		});
		this.add(jouer);
	}
	
	/**
	 * Ajoute un menu à la vue permettant
	 *  de personnaliser sa configuration de jeu
	 */
	public void ajouteBoutonConfigurer() {
		conf = new JButton("Configurer");
		conf.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				gc.setEtat(Etat.CONF);
			}	
		});
		this.add(conf);
	}

}
