package buttons;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * classe de construction dun jframe par defaut
 */
public class FenetreCardLayout extends JFrame {
	// private Panneau pan = new Panneau();
	// private JPanel pan = new JPanel() ;
	private JButton bouton = new JButton("Mon premier bouton");
	private JButton bouton2 = new JButton("Mon II bouton");
	private String nameFenetre = "CardLayout";
	CardLayout cl = new CardLayout();
	JPanel content = new JPanel();
	String[] listContent = { "CARD_1", "CARD_2", "CARD_3" };
	int indice = 0;

	public FenetreCardLayout() {
		this.setTitle(this.nameFenetre);
		this.setLocationRelativeTo(null);
		this.setSize(500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// on cree les trois conteneurs de couleurs differentes
		JPanel card1 = new JPanel();
		card1.setBackground(Color.BLUE);
		JPanel card2 = new JPanel();
		card2.setBackground(Color.red);
		JPanel card3 = new JPanel();
		card3.setBackground(Color.GREEN);

		JPanel boutonPane = new JPanel();
		JButton bouton = new JButton("Contenu Suivant");
		bouton.addActionListener(new ActionListener() {
			// Via cette instruction, on passe au conteneur correspondant au nom fourni en
			// paramètre
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cl.next(content);
			}
		});

		JButton bouton2 = new JButton("Contenu par indice");
		bouton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (++indice > 2)
					indice = 0;
				cl.show(content, listContent[indice]);

			}
		});
		// boutonPane.setLayout(new GridLayout(1, 2));
		boutonPane.add(bouton);
		boutonPane.add(bouton2);
		
		// on definit le layout du content 
		content.setLayout(cl);
		content.add(card1, listContent[0]) ;
		content.add(card2, listContent[1]);
		content.add(card3, listContent[2]);
		this.getContentPane().add(boutonPane, BorderLayout.NORTH);
		this.getContentPane().add(content, BorderLayout.CENTER);
		
		this.setVisible(true);

	}

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
	 * private void go() { for (; ;) { int x = pan.getPosX(), y = pan.getPosy() ; //
	 * booleen pour savoir si on recule ou non sur laxe x boolean backX = false ; //
	 * booleen pour savoir si on recule su l axe des Y boolean backY = false ;
	 * 
	 * while(true) { // si la coordonnee x est inferieure a 1 on avance if (x < 1 )
	 * backX = false ;
	 * 
	 * // si la coordonne x est superieure a la taille du panneua moins le taille du
	 * rond on recule if(x > pan.getWidth() -50 ) backX = true ;
	 * 
	 * // idem pour Y if (y< 1) backY = false; if(y > pan.getHeight() -50) backY =
	 * true ; //Si on avance, on incrémente la coordonnée //backX est un booléen,
	 * donc !backX revient à écrire //if (backX == false) if(!backX)
	 * pan.setPosX(++x); //sinon on decremente else pan.setPosX(--x); // idem pour l
	 * axe y if (!backY) pan.setPosy(++y); else pan.setPosy(--y); //on redessinne le
	 * panneau pan.repaint();
	 * 
	 * // petite pause try { Thread.sleep(3); }catch(InterruptedException ex) {
	 * ex.printStackTrace(); }
	 * 
	 * 
	 * } // Pour les instructions qui vont suivre, gardez en mémoire que les
	 * coordonnées du rond // correspondent en réalité aux coordonnées du coin
	 * supérieur gauche du carré entourant le rond.
	 * 
	 * 
	 * // si la boule arrive au bord du composant on le reinitialise
	 * 
	 * } }
	 */
}
