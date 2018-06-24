package compte;
/*
 * Classe d exception personnalisee pour la classe compte
 */

public class InvalidFormalCompte extends Exception {

	public InvalidFormalCompte(String string) {
		// TODO Auto-generated constructor stub
		super(string);
		
		
	}

	public InvalidFormalCompte() {
		super("Le compte ne correspond pas aux critères");
		
	}
	
}
