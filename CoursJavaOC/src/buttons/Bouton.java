package buttons;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class Bouton extends JButton implements MouseListener {
	/*
	 * fields
	 */
	private String name ;
	private Image img = null ;
	private Color plainColor = Color.blue ;
	private Color degradedColor = Color.CYAN ;
	 /*
	  * methods getter and setter 
	  */
	public Image getImg() {
		return img;
	}
	public void setImg(Image img) {
		this.img = img;
	}
	public String getName() {	
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Color getPlainColor() {
		return plainColor;
	}
	public void setPlainColor(Color plainColor) {
		this.plainColor = plainColor;
	}
	public Color getDegradedColor() {
		return degradedColor;
	}
	public void setDegradedColor(Color degradedColor) {
		this.degradedColor = degradedColor;
	}
	/*
	 * methods
	 */
	public Bouton(String str) {
		super(str);
		this.name = str ;
		try {
			this.setImg( ImageIO.read(new File("comminge.jpg")) ) ;
			
		}catch (IOException ex) {
			ex.printStackTrace();
		}
		// grace a cette instruction non objet va s ecouter 
		// des qu un evenement de la souris sera intercepte il en sera averti
		this.addMouseListener(this);
	}
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g ; 
		GradientPaint gp = new GradientPaint(0,0, this.getPlainColor() , 0,20, this.getDegradedColor(), true ) ;
		g2d.setPaint(gp) ;
		g2d.drawImage(this.getImg() , 0, 0, this.getWidth() , this.getHeight() , this) ;
		//g2d.fillRect(0, 0,  this.getWidth(), this.getHeight());
		g2d.setColor(Color.black);
		g2d.drawString(this.name, this.getWidth() / 2 - (this.getWidth()/ 2 /4), (this.getHeight() / 2) + 5 );
		
	}
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		// a priori aps utile de l utiliser ici
		affiche("Mouse Clicked  X " + e.getX() + " y " + e.getY());
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		/*
		 * on change le fond du bouton lorsque on le survole
		 */
		try {
			this.setImg(ImageIO.read(new File("fondBoutonHover.jpg")));
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		affiche("mouse entered  X " + e.getX() + " y " + e.getY()) ;
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		/*
		 * on change le fond du bouton lorsque lorsqu on quitte le bouton
		 */
		try {
			this.setImg(ImageIO.read(new File("fondBouton.jpg")));
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		affiche("mouse Exited  X " + e.getX() + " y " + e.getY()) ;
		
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		/*
		 * lorsque on clique sur le bouton gauche on change la couleur ou l image
		 */
		try {
			this.setImg(ImageIO.read(new File("fondBoutonClic.jpg")));
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		affiche("mouse Pressed  X " + e.getX() + " y " + e.getY()) ;
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		/*
		 * on change le fond lorsque on lache le bouton gauche
		 */
		String vFileName  = "" ;
		if ( (e.getY() > 0 && e.getY() < this.getHeight()) && (e.getX()> 0 && e.getX() < this.getWidth())) {
			vFileName = "fondBoutonHover.jpg" ;
		}else {
			vFileName = "fondBouton.jpg";
		}
		try {
			this.setImg(ImageIO.read(new File(vFileName)));
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		affiche("Mouse Released X " + e.getX() + " y " + e.getY() + " filename : " + vFileName );
	}
	public void affiche(String str) {
		System.out.println(str);
	}

}
