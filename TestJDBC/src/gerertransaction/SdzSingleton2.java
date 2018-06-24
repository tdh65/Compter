package gerertransaction;

public class SdzSingleton2 {

	// Le singleton

	private static SdzSingleton2 single;

	// Variable d'instance

	private String name = "";

	// Constructeur privé

	private SdzSingleton2() {

		this.name = "Mon singleton";

		System.out.println("\t\tCRÉATION DE L'INSTANCE ! ! !");

	}

	// Méthode d'accès au singleton

	public static SdzSingleton2 getInstance() {

		if (single == null)

			single = new SdzSingleton2();

		return single;

	}

	// Accesseur

	public String getName() {

		return this.name;

	}
}
