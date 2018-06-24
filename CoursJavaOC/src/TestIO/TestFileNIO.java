package TestIO;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


public class TestFileNIO {
	public static void main(String[] arg) {
		File f = new File("testfichier.txt");
		System.out.println("Test de fonctionnalite de l'objet File");
		System.out.println("Chemin absolu " + f.getAbsolutePath());
		System.out.println("Nom du fichier " + f.getName());
		System.out.println("Est ce qu il existe " + f.exists());
		System.out.println("Est ce un repertoire ?" + f.isDirectory());
		System.out.println("est un fichier ? " + f.isFile());

		System.out.println("Affichage des lecteurs à la racine du Pc : ");
		for (File file : f.listRoots()) {
			System.out.println(file.getAbsolutePath());
			try {
				int i = 1;
				// on parcours la liste de fichiers et de repertoire
				for (File nom : file.listFiles()) {
					System.out.print("\t\t" + ((nom.isDirectory() ? nom.getName() + "/" : nom.getName())));
					if ((i % 4) == 0) {
						System.out.println("\n");
					}
					i++;
				}
				System.out.println("\n");
			} catch (NullPointerException ex) {
				ex.printStackTrace();
			}
		}

		Path cible = Paths.get("test2.txt");
		System.out.println(cible.toAbsolutePath());
		Path source = Paths.get("testfichier.txt");
		System.out.println(source.toAbsolutePath());
		
		try {
//			Files.move(source, cible , StandardCopyOption.REPLACE_EXISTING) ;
			Files.move(source , cible , StandardCopyOption.REPLACE_EXISTING ) ;
//			Files.move(source, cible ) ;
			
			//Files.copy(source, cible, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		/*
		 * openclassroom -- > files.ZipFiles 
		 * https://openclassrooms.com/courses/apprenez-a-programmer-en-java/les-flux-d-entree-sortie#/id/r-2182485
		 */
		// deja defini
		// Path source = Path.get("testfichier.txt") ;
		
		// ouverture en lecture 
		// try(InputStream input = Files.newInputStream(source)){
		
		/*
		 * ZipFile : 
		 * https://openclassrooms.com/courses/apprenez-a-programmer-en-java/les-flux-d-entree-sortie#/id/r-2182485
		 */
			
		try ( FileSystem zipFS = FileSystems.newFileSystem(Paths.get("testzip.zip") , null) ){
			
			/*
			 * suppresiion d'un fichier dans le zip 
			 */
			Files.deleteIfExists(zipFS.getPath("bonjour.php")) ;
			
			// creation d'un nouveau fichier a l interieur
			Path path = zipFS.getPath("nvphp.php") ;
			String message = "Hello World !!!!!!!" ;
			Files.write(path, message.getBytes()) ;
			
			
			// Parcours des elements a l'interieur du ZIP
			try( DirectoryStream<Path> stream = Files.newDirectoryStream(zipFS.getPath("/"))){
				for(Path entry : stream) {
					System.out.println(entry.getFileName());
					System.out.println(entry);
				}
			}
			// copie d un fichier du disque dans l'archive ZiP
			Files.copy(Paths.get("game.txt"), zipFS.getPath("testgame.txt") ) ;
			Iterable<Path> zipf = zipFS.getRootDirectories();
			for (Path p : zipf) {
				System.out.println(p);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
