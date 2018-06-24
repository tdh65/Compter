package TestIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class transfertFichier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			/*
			 * on instancie les objets fis lit le fichier et fos ecrit dans l enouveua
			 */
			File fffs = new File(".") ;
			System.out.println("base name et rep" + fffs.getCanonicalPath() + " -parent- " + fffs.getParent() + " getpath() " + fffs.getPath()) ;
			
			File outf = new File("testFichier.txt") ;
			fos = new FileOutputStream(outf);
			
			System.out.println(outf.getAbsolutePath());
			fis = new FileInputStream(new File("/media/Stocks/Home2Anc/dossier_161207/Telechargement/dictionnaire.txt"));
			// /media/DataTravail/ProgCentrale/Programmation/Workspace-Eclipse/coursjava/src/testIO
			// on cree u n tableau de byte pour indiquer le nobmee de byte lus à chaque tour
			// de boucle

			byte[] buf = new byte[8];

			// on cree une variable de type int pour affecter le resultat de la lecture
			// vaut -1 lorsque cest fini
			int n = 0;
			/*
			 * tant que l'affectation de la variable est possible on boucle. lorque la
			 * lecture du fichier est terminée l'affectation n est plus possible on sort
			 * donc de la boucle
			 */
			while ((n = fis.read(buf)) >= 0) {
				/*
				 * on ecrit dans le second fichier
				 */
				fos.write(buf);
				for (byte bit : buf) {
					System.out.println("\t" + bit + "(" + (char) bit + ")");

				}
				/*
				 * on reinit iale le buffer a vide au cas ou les derniers byte lus ne soient pas
				 * un multiple de 8 ceci permet d'avoir un buffer vierge a chaque lecture et de
				 * ne pas avoir de doublon en fin de fichier
				 */
				buf = new byte[8];
			}
			System.out.println("copie terminee");

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			/*
			 * on ferme lnos flux de donnees dans un bloc finally pour s assurer que ces
			 * instruction seront executee dans tous les cas meme si une exception est levée
			 * 
			 */
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}

			try {
				if (fos != null) {
					fos.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}

		}
		

	}

}
