package TestAWT;
import java.awt.Dimension;


public class TestAwt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fenetre  fen = new Fenetre() ;
		//fen.add()
		// modifier l endroite ou est la fenetre (cad different de setLocationRelativeTo()
		// coordonnees 0,0  situe au coin superieur gauche
		fen.setLocation(700, 500);
		// empecher le redimensionnement 
		fen.setResizable(true);
		// garder la fenetre au premier plan 
		fen.setAlwaysOnTop(false);
		
		// retirer les contoures et les bootons de controles 
		//fen.setUndecorated(false);
		fen.setMaximumSize(new Dimension(1000,500));
		/*
		 * https://openclassrooms.com/courses/apprenez-a-programmer-en-java/notre-premiere-fenetre#/id/r-2182720
		 * detaille les differents objets dans une fenetre
		 */
		
		

	}

}
