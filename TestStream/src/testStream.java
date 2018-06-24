
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class testStream {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {


		// TODO Auto-generated method stub
		List<Personne> listP = Arrays.asList(
				new Personne(1.80,70.0,"A" , "Nicolas", Couleur.BLEU),
				new Personne(1.56,51.02,"B" , "Nicole", Couleur.MARRON),
				new Personne(1.75,65.36,"C" , "Germain", Couleur.VERT),
				new Personne(1.65,75.42,"D" , "Michel", Couleur.ROUGE),
				new Personne(1.90,93.85,"E" , "Cyrille", Couleur.MARRON),
				new Personne(1.40,70.41,"F" , "Denis", Couleur.VERRON),
				new Personne(1.96,79.36,"G" , "Denis", Couleur.MARRON)
				
				
				) ;
		System.out.println(listP.size() );
		
		int i = 1 ;
		// for( Iterator<Personne> it = listP.iterator() ; it.hasNext() ; ) {
		affiche("iteration par iterateur classique");
		for(i = 0 ; i < listP.size(); i++) {
			
			//System.out.println("Ref personne # " + i++ + " ==> " + tpers.toString()  ) ;
			
			// Personne tpers = (Personne) it ;
			
//			System.out.println("Ref personne # " + i++ + " ==> " + tpers.toString()  ) ; 
			System.out.println("Ref personne # " + i + " ==> " +  listP.get(i).toString()  ) ; 
			
		}
		affiche("Avec les stream") ;
		Stream<Personne> sp = listP.stream() ;
		//sp.forEach();
		affiche("Terminal" + " forEach ");
		sp.forEach(System.out::println) ;
		testStream.affiche("Avec Stream.iterate x*11 " + " limit 50") ;
		Stream.iterate(25L, (x) -> x*11).limit(50).forEach(System.out::println);
		testStream.affiche("Avec Stream.iterate x+3 " + " limit 100") ;
		Stream.iterate(2d, (x) -> x+3 ).limit(100).forEach(System.out::println);
		affiche("filtrage des personnes");
		
		affiche("\nApres le filtre  poids > 70") ;
		sp = listP.stream() ;
		sp.filter(x ->x.getPoids() > 70 ).forEach(System.out::println);
		
		affiche("\nApres le filtre  poids > 50 et mappage du poids ==> ne garde que ce champs") ;
		sp = listP.stream() ;
		sp.filter(x ->x.getPoids() > 70 ).map(x->x.getPoids()).forEach(System.out::println);
		
		affiche ("puis on applique le reduce (op terminale)") ;
		sp = listP.stream() ;
		double sum = sp.filter(x->x.getPoids() >70).map(x ->x.getPoids()).reduce(0.000d, (x,y)->x+y);
		affiche("total poids " + sum);
		affiche ("Meme chose mais avec optional<> == deux etats avec valeur ou sans (null)");
		sp = listP.stream() ;
		Optional<Double> dum = sp.filter(x->x.getPoids() >270).map(x ->x.getPoids()).reduce((x,y)->x+y);
		
		affiche("affiche(_\"total poids filtre > 270 \" + dum.get ==>> retourne une erreur puisque personne sup a 270" );
		affiche ("donc il faut faire si il y a une valeur nulle "); 
		if(dum.isPresent()) {
			affiche(dum.get().toString());
		}else {
			affiche("Personne d'un poids superieur a 270");
		}
		//Permet de gérer le cas d'erreur en renvoyant 0.0 si isPresent() == false
		affiche("Permet de gérer le cas d'erreur en renvoyant 0.0 si isPresent() == false");
		affiche(dum.orElse(0.0).toString());
		affiche("on peut les compter egalement");
		sp = listP.stream();
		long nb = sp.filter(x->x.getPoids()>70 ).map(x -> x.getPoids()).count() ;
		affiche("nombre : "+ nb);
		affiche ("Avec les collectors : " ) ;
		sp = listP.stream() ;
		List<Double> ld = sp.filter(x-> x.getPoids() > 50 )
								.map(x -> x.getPoids())
								.collect(Collectors.toList()); 
		affiche(ld.toString());
		affiche("ou utiliser les streams pour lire un fichier");
		String fileName = "/home/apprenti/pgadmin.log" ;
		try(Stream<String> sf = Files.lines(Paths.get(fileName))) {
			sf.forEach(System.out::println) ;
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		affiche("ou utiliser les streams pour lire un repertoire ");
		String filename = "/home/apprenti/" ;
		i = 0 ; 
		try(Stream<Path> path = Files.list(Paths.get(filename)) ){
			path.forEach(System.out::println );
			//Stream<String> fichiers = Files.lines(Paths.get(filename));
			//fichiers.forEach(System.out::println);
			nb = ++i ;
			
		}finally {
			Stream<Path> npath  = Files.list(Paths.get(filename)) ;
			affiche("nombre de fichiers :  " + npath.count() ) ;
		}
	}
	public static  void affiche(String data) {
		System.out.println(data);
	}

}
