package animation;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Panneau extends JPanel {
	private int posX = - 50 ;
	private int posy = -50 ;
	
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosy() {
		return posy;
	}

	public void setPosy(int posy) {
		this.posy = posy;
	}


	
	public void paintComponent(Graphics g) {
		// on choisit une couleur de fonds du rectangle
		g.setColor(Color.white);
		// on remplit le cadre de la couleur
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		// on redefinit la couleur du rond
		g.setColor(Color.RED);
		// on le redessine
		g.fillOval(posX, posy, 50, 50);
		
	}
}
