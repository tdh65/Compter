package TestIO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class TestFunction {
	public static void main(String[] args) {

		List<Personne> lPersonne = Arrays.asList(new Personne("toto", 10), new Personne("titi", 20),
				new Personne("tata", 30), new Personne("tutu", 40));

		Function<Personne, String> f1 = (Personne p) -> p.getNom();
		Function<Personne, Integer> f2 = (Personne p) -> p.getAge() / 2;
		// on definit un traitemen supplementaires sur l'age
		Function<Integer, Integer> f3 = (Integer a) -> a /2;
		System.out.println(transformToListString(lPersonne, f1));
		System.out.println(transformToListInt(lPersonne, f2.andThen(f3)));

		System.out.println("le consumer");
		Consumer<Personne> c = (Personne p) -> p.setAge(p.getAge() + 13);
		for (Personne p : lPersonne)
			c.accept(p);

		System.out.println(lPersonne);
		System.out.println("test de predicate " );
		Predicate<Personne> predicate = (Personne p)->p.getAge( )> 20 ;
		for (Personne p : lPersonne) {
			if(predicate.test(p)) {
				System.out.println(p.getNom() + " a l'age requis");
			}
		}
		System.out.println("test du supplier ");
		Supplier<String> s1 = () -> new String("hello !");

        System.out.println(s1.get());

        Supplier<Personne> s2 = () -> new Personne("Dédé", 50);

        System.out.println(s2.get());
				
	}

	public static List<String> transformToListString(List<Personne> list, Function<Personne, String> func) {
		List<String> ls = new ArrayList<>();
		for (Personne p : list) {
			ls.add(func.apply(p));
			// func.apply(p) retournera ici le nom de l'objet Personne
		}
		return ls;
	}

	public static List<Integer> transformToListInt(List<Personne> list, Function<Personne, Integer> func) {
		List<Integer> ls = new ArrayList<>();
		for (Personne p : list) {
			ls.add(func.apply(p));
			// func.apply(p) retournera ici l'âge multiplié par 2 de l'objet Personne
		}
		return ls;
	}
}
