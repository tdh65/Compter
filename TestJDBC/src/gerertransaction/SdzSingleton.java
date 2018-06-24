package gerertransaction;
// voir https://openclassrooms.com/courses/apprenez-a-programmer-en-java/limiter-le-nombre-de-connexions#/id/r-2186333
public class SdzSingleton {

	// Le singleton
// voir https://openclassrooms.com/courses/apprenez-a-programmer-en-java/limiter-le-nombre-de-connexions#/id/r-2186333
	private volatile static SdzSingleton single;
	
	// Variable d'instance

	private String name = "";

	// Constructeur privé

	private SdzSingleton() {

		this.name = "Mon singleton";

		System.out.println("\t\tCRÉATION DE L'INSTANCE ! ! !");

	}

	// Méthode d'accès au singleton

	public static SdzSingleton getInstance() {

		if (single == null) {
			synchronized(SdzSingleton.class) {
				if(single == null )
					single = new SdzSingleton();
					
			}
		}

			

		return single;

	}

	// Accesseur

	public String getName() {

		return this.name;

	}
}
