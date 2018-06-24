package TestAWT;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * classe de construction dun jframe par defaut
 */
public class Fenetre extends JFrame {
	public Fenetre() {
		this.setTitle("Ma premiere fenetre java");
		this.setLocationRelativeTo(null);
		this.setSize(100, 150 );
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/* 
		 * on ajoute le JPanel qui remplace le ContentPane du JFrame
		 */
		JPanel pan = new JPanel() ;
		
		// on definit sa couleur de fonds
		pan.setBackground(Color.ORANGE);
		
		//on previent le JFrame que le JPanel sera son contentPane
		this.setContentPane(new Panneau());
		this.setVisible(true);
	}

}
