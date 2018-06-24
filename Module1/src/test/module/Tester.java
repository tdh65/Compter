package test.module;

public class Tester {
	public void direBonjour(String mr) {
		System.out.println("Bonjour " + mr );
		System.out.println("ant de foncer tête baissée, il faut que vous sachiez que les modules Java 9 sont soumis à des règles strictes, elles ne sont pas nombreuses mais il faut impérativement les suivre :\n" + 
				"\n" + 
				"    Le nom d'un module doit être unique, tout comme pour un nom de package ;\n" + 
				"\n" + 
				"    Chaque module ne doit contenir qu'un et un seul fichier « module-info.java » et il doit être placé à la racine du module;\n" + 
				"\n" + 
				"    Un module peut contenir plusieurs packages mais un package ne peut être que dans un et un seul module.\n" + 
				"\n" + 
				"    Le fichier module-info.java doit être à la racine de votre code source Eclipse.");
	}

}
