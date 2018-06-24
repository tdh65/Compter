package TestIO;

public class Personne {
	private String nom ="" ;
	private int age = 0 ;
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	public Personne(String nom , int age) {
		setNom(nom);
		setAge(age);
	}
	public Personne() {
		
	}
	
}
