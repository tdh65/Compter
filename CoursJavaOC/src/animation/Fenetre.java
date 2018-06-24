package animation;

import javax.swing.JFrame;

/*
 * classe de construction dun jframe par defaut
 */
public class Fenetre extends JFrame {
	private Panneau pan = new Panneau();

	public Fenetre() {
		this.setTitle("Animation");
		this.setLocationRelativeTo(null);
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*
		 * on ajoute le JPanel qui remplace le ContentPane du JFrame
		 */
		// JPanel pan = new JPanel() ;

		// on definit sa couleur de fonds
		// pan.setBackground(Color.ORANGE);

		// on previent le JFrame que le JPanel sera son contentPane
		this.setContentPane(pan);
		this.setVisible(true);
		go();
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
	private void go() {
			for (; ;) {
				int x = pan.getPosX(), y = pan.getPosy() ;
				// booleen pour savoir si on recule ou non sur laxe x
				boolean backX = false ;
				// booleen pour savoir si on recule su l axe des Y
				boolean backY = false ;
				
				while(true) {
					// si la coordonnee x est inferieure a 1 on avance 
					if (x < 1 )
						backX = false ;
					
					// si la coordonne x est superieure a la taille du panneua moins le taille du rond on recule 
					if(x > pan.getWidth() -50 )
						backX = true ;
					
					// idem pour Y
					if (y< 1) 
						backY = false; 
					if(y > pan.getHeight() -50)
						backY = true ;
					 //Si on avance, on incrémente la coordonnée
				    //backX est un booléen, donc !backX revient à écrire
				    //if (backX == false)
					if(!backX)
						pan.setPosX(++x);
					//sinon on decremente
					else
						pan.setPosX(--x);
					// idem pour l axe y
					if (!backY)
						pan.setPosy(++y);
					else
						pan.setPosy(--y);
					//on redessinne le panneau
					pan.repaint();
					
					// petite pause 
					try {
						Thread.sleep(3);
					}catch(InterruptedException ex) {
						ex.printStackTrace();
					}
					
					
				}
		//				Pour les instructions qui vont suivre, gardez en mémoire que les coordonnées du rond 
//				correspondent en réalité aux coordonnées du coin supérieur gauche du carré entourant le rond.


				// si la boule arrive au bord du composant on le reinitialise
			
		}
	}

}
