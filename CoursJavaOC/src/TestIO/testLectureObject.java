package TestIO;
//Packages à importer afin d'utiliser l'objet File
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class testLectureObject {

	public static void main(String[] args) {
		ObjectOutputStream oos ; 
		ObjectInputStream ois ; 
		
		try {
			oos = new ObjectOutputStream(   new BufferedOutputStream( new FileOutputStream( new File("game.txt")) )) ;
			// on ecrite les objet game dasn le fichier
			oos.writeObject(new Game("Assassion creed" , "Aventure " , 12.35));
			oos.writeObject(new Game("Age of empire II" , "strategie",  41.36));
			oos.writeObject(new Game("Tetris " , "Strategie" , 14.36 ));
			// on ferme le flux
			oos.close();
		
			
			
			
			/*
			 * on recupere les donnees 
			 * 
			 */
			ois = new ObjectInputStream( 
					new BufferedInputStream(
							new FileInputStream(
									new File("game.txt"))));
			try {
				System.out.println("Affichage des jeux : " );
				System.out.println("****************************");
				System.out.println( ((Game)ois.readObject()).toString() ) ;
				System.out.println( ((Game)ois.readObject()).toString() ) ;
				System.out.println( ((Game)ois.readObject()).toString() ) ;
				System.out.println("****************************");
			}catch(ClassNotFoundException ex) {
				ex.printStackTrace();
				
			}
			ois.close();
		}catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
	}
}
