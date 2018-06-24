package TestAWT;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panneau extends JPanel {
	public void  paintComponent(Graphics g) {
		// on voit cette phrase chaque fois la methode est executee
		
		// g.fillOval(20, 20, 75, 75);
		// on veut parfaitement centrer le ronds
		int x1 = this.getWidth()/4; 
		int y1 = this.getHeight()/4;
		int x2 = this.getWidth()/2;
		int y2 = this.getHeight()/2;
		// g.fillOval(x1, y1, x2, y2 );
		String t = ("je suis executee x : " + x1 + " y1 : " + y1  + " X2 : " + x2 + " y2 : " + y2  );
		g.drawOval(x1, y1, x2, y2);
		g.drawRect(x1 *2 , y1*2, x2*2, y2*2);
		g.drawLine(0, 0, x2*2, y2*2);
		g.drawLine(0,y2*2, x2*2 ,0);
		Font font = new Font("Courrier", Font.BOLD, 10 );
		g.setFont(font);
		g.setColor(Color.RED);
		
		g.drawString(t , 10 , 20 );
		affiche(t);
		/*
		 * importation d'un fichier image 
		 * 
		 */
		try {
			File ff = new File(".");
			affiche (ff.getAbsolutePath()) ;
			Image img = ImageIO.read(new File ("comminge.jpg")) ;
			g.drawImage(img, 0, 0, this) ;
			// pour une image de fonds : 
			// g.drawImage(img, 0 ,0 , this.getWidth() , this.getHeight() , this ) ;
			
		}catch(IOException ex ) {
			ex.printStackTrace();
		}
		Graphics2D g2d = (Graphics2D) g ;
		GradientPaint gp = new GradientPaint(0, 0, Color.RED, x2, y2, Color.CYAN, false ) ;
		g2d.setPaint(gp);
		g2d.fillRect(0, 0 , this.getWidth(), this.getHeight());
	}
	protected void affiche(String str ) {
		System.out.println(str);
	}

}
