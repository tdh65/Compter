package buttons;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * classe de construction dun jframe par defaut
 */
public class Fenetre extends JFrame {
	private Panneau pan = new Panneau();
	private String nameFenetre = "Balls with Layout";
	private JButton bouton2 = new JButton("Bouton 2");

	private BoutonAmeliore bouton = new BoutonAmeliore("Mon Bouton");
	// private JButton bouton = new JButton("Mon Bouton" );
	private JPanel container = new JPanel();
	private JLabel label1 = new JLabel();
	private int compteurClics1 = 0, compteurClics2 = 0;
	private boolean animated = true;
	private boolean backX, backY;
	private int x, y;

	public Fenetre() {
		JPanel panelBouton = new JPanel();
		this.setTitle(nameFenetre);
		this.setLocationRelativeTo(null);
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*
		 * on ajoute le JPanel qui remplace le ContentPane du JFrame
		 */
		// JPanel pan = new JPanel() ;

		// on definit sa couleur de fonds
		// pan.setBackground(Color.ORANGE);
		// on definit le label Nord
		this.getLabel1().setText("Le JLabel : 1 ");
		this.getLabel1().setBackground(Color.GRAY);
		Font font = new Font("Tahoma", Font.BOLD + Font.ITALIC, 16);
		this.getLabel1().setFont(font);
		// la couleur du texte est bleue
		this.getLabel1().setForeground(Color.BLUE);
		// on modifie l alignement du texte avec les attributs statique du label
		this.getLabel1().setHorizontalAlignment(JLabel.CENTER);

		bouton.setPreferredSize(new Dimension(170, 120));
		// Nous ajoutons notre fenêtre à la liste des auditeurs de notre bouton

		bouton.addActionListener(new BoutonListener());
		bouton2.addActionListener(new Bouton2Listener());
		// deuxieme classe ecoutant le bouton
		bouton2.addActionListener(new Bouton3Listener());
		bouton.setEnabled(false);
		// on ajoute les deux boutons au panelBouton
		panelBouton.add(bouton);
		panelBouton.add(bouton2);

		// on previent le JFrame que le JPanel sera son contentPane

		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		container.add(pan, BorderLayout.CENTER);
		// rajoute le panel boutonPanel au sud
		container.add(panelBouton, BorderLayout.SOUTH);
		container.add(this.getLabel1(), BorderLayout.NORTH);
		this.setContentPane(container);
		this.setVisible(true);
		go();
	}

	/*
	 * deuxieme version
	 */
	/*
	 * classe ecoutant le premier bouton
	 */
	class BoutonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			// this.setCompteurClics1(this.getCompteurClics1() + 1);

			// label1.setText("Vous avez cliqué sur Bouton " + this.compteurClics1++ + "
			// Fois");
			compteurClics1++;
			label1.setText("Vous avez cliqué sur Bouton 1 : " + compteurClics1 + " !");
			animated = true;
			bouton.setEnabled(false);
			bouton2.setEnabled(true);
			go();
		}

	}

	class Bouton2Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			compteurClics2++;
			label1.setText("Vous avez clique sur le bouton 2 " + compteurClics2 + "Fois !!! ");
			animated = false;
			bouton.setEnabled(true);
			bouton2.setEnabled(false);

		}

	}

	class Bouton3Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("je suis " + e.getSource().toString());

		}

	}

	/*
	 * // premiere version de transfert des actions clics
	 * 
	 * @Override public void actionPerformed(ActionEvent arg0) { // TODO
	 * Auto-generated method stub // lorsque l on clique sur le bouton on met a jour
	 * le label // int nb = this.getCompteurClics() ;
	 * 
	 * if (arg0.getSource() == bouton) {
	 * this.setCompteurClics1(this.getCompteurClics1() + 1);
	 * 
	 * this.getLabel1().setText("Vous avez cliqué sur Bouton " +
	 * this.getCompteurClics1() + " Fois"); } else {
	 * this.setCompteurClics2(this.getCompteurClics2() + 1);
	 * this.getLabel1().setText("Vous avez cliqué Bouton2 " +
	 * this.getCompteurClics2() + " Fois"); }
	 * 
	 * }
	 */

	/*
	 * premiere version il s arrete a la fin du cadre
	 */
	/*
	 * private void go() { for (int i = -50; i < pan.getWidth(); i++) { int x =
	 * pan.getPosX(), y = pan.getPosy() ; x++; y++; pan.setPosX(x); pan.setPosy(y) ;
	 * pan.repaint(); try { Thread.sleep(10); }catch(InterruptedException ex) {
	 * ex.printStackTrace(); }
	 * 
	 * } }
	 */
	/*
	 * private void go() { for (; ;) { int x = pan.getPosX(), y = pan.getPosy() ;
	 * x++; y++; pan.setPosX(x); pan.setPosy(y) ; pan.repaint(); try {
	 * Thread.sleep(10); }catch(InterruptedException ex) { ex.printStackTrace(); }
	 * // Pour les instructions qui vont suivre, gardez en mémoire que les
	 * coordonnées du rond // correspondent en réalité aux coordonnées du coin
	 * supérieur gauche du carré entourant le rond.
	 * 
	 * 
	 * // si la boule arrive au bord du composant on le reinitialise if(x==
	 * pan.getWidth() || y == pan.getHeight()) { pan.setPosX(-50); pan.setPosy(-50);
	 * }
	 * 
	 * }
	 */
	// troisieme version
	/*
	 * private void go() { for (;;) { int x = pan.getPosX(), y = pan.getPosy(); //
	 * booleen pour savoir si on recule ou non sur laxe x boolean backX = false; //
	 * booleen pour savoir si on recule su l axe des Y boolean backY = false;
	 * 
	 * while (true) { // si la coordonnee x est inferieure a 1 on avance if (x < 1)
	 * backX = false;
	 * 
	 * // si la coordonne x est superieure a la taille du panneua moins le taille du
	 * // rond on recule if (x > pan.getWidth() - 50) backX = true;
	 * 
	 * // idem pour Y if (y < 1) backY = false; if (y > pan.getHeight() - 50) backY
	 * = true; // Si on avance, on incrémente la coordonnée // backX est un booléen,
	 * donc !backX revient à écrire // if (backX == false) if (!backX)
	 * pan.setPosX(++x); // sinon on decremente else pan.setPosX(--x); // idem pour
	 * l axe y if (!backY) pan.setPosy(++y); else pan.setPosy(--y); // on redessinne
	 * le panneau pan.repaint();
	 * 
	 * // petite pause try { Thread.sleep(3); } catch (InterruptedException ex) {
	 * ex.printStackTrace(); }
	 * 
	 * } // Pour les instructions qui vont suivre, gardez en mémoire que les
	 * coordonnées // du rond // correspondent en réalité aux coordonnées du coin
	 * supérieur gauche du carré // entourant le rond.
	 * 
	 * // si la boule arrive au bord du composant on le reinitialise
	 * 
	 * } }
	 */
	/*
	 * quatrieme version
	 */
	private void go() {
		// les coordonnes de depart du rond

		x = pan.getX();
		y = pan.getY();

		// booleen pour savoir si on recule ou non sur laxe x
		backX = false;
		// booleen pour savoir si on recule su l axe des Y
		backY = false;

		while (this.animated) {

			// si la coordonnee x est inferieure a 1 on avance
			if (x < 1)
				backX = false;

			// si la coordonne x est superieure a la taille du panneua moins le taille du
			// rond on recule
			if (x > pan.getWidth() - 50)
				backX = true;

			// idem pour Y
			if (y < 1)
				backY = false;
			if (y > pan.getHeight() - 50)
				backY = true;
			// Si on avance, on incrémente la coordonnée
			// backX est un booléen, donc !backX revient à écrire
			// if (backX == false)
			if (!backX)
				pan.setPosX(++x);
			// sinon on decremente
			else
				pan.setPosX(--x);
			// idem pour l axe y
			if (!backY)
				pan.setPosy(++y);
			else
				pan.setPosy(--y);
			// on redessinne le panneau
			pan.repaint();

			// petite pause
			try {
				Thread.sleep(3);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}

		}
		// Pour les instructions qui vont suivre, gardez en mémoire que les coordonnées
		// du rond
		// correspondent en réalité aux coordonnées du coin supérieur gauche du carré
		// entourant le rond.

		// si la boule arrive au bord du composant on le reinitialise

	}

	public void affiche(String str) {
		System.out.println(str);
	}

	/**
	 * @return the label1
	 */
	public JLabel getLabel1() {
		return label1;
	}

	/**
	 * @param label1
	 *            the label1 to set
	 */
	public void setLabel1(JLabel label1) {
		this.label1 = label1;
	}

	public JButton getBouton2() {
		return bouton2;
	}

	/**
	 * @return the compteurClics2
	 */
	public int getCompteurClics2() {
		return compteurClics2;
	}

	/**
	 * @param compteurClics2
	 *            the compteurClics2 to set
	 */
	public void setCompteurClics2(int compteurClics2) {
		this.compteurClics2 = compteurClics2;
	}

	/**
	 * @return the compteurClics1
	 */
	public int getCompteurClics1() {
		return compteurClics1;
	}

	/**
	 * @param compteurClics1
	 *            the compteurClics1 to set
	 */
	public void setCompteurClics1(int compteurClics1) {
		this.compteurClics1 = compteurClics1;
	}

}
