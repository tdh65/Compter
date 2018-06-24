package tpcalculatrice;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Panneau extends JPanel {
	
	public void repaint(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(0, 0 , this.getWidth(), this.getHeight());
		
		
	}

}
