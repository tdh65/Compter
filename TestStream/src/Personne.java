

public class Personne {

	public double taille = 0.00d, poids = 0.00d ;
	public double getTaille() {
		return this.taille;
	}

	public void setTaille(double taille) {
		this.taille = taille;
	}

	public double getPoids() {
		return this.poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {

		this.prenom = prenom;
	}

	public Couleur getYeux() {
		return this.yeux;
	}

	public void setYeux(Couleur yeux) {
		this.yeux = yeux;
	}

	public String nom = "" , prenom = "" ;
	public Couleur yeux = Couleur.INCONNU ;
	
	public Personne() {

		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Personne [taille=" + this.taille + ", poids=" + this.poids
				+ ", nom=" + this.nom + ", prenom=" + this.prenom + ", yeux="
				+ this.yeux + "]";
	}
	

	public Personne(double taille, double poids, String nom, String prenom, Couleur yeux) {
		super() ;  // couleur ? 
		this.setTaille(taille);
		this.setPoids(poids);
		this.setNom(nom );
		this.setPrenom(prenom);
		this.setYeux(yeux);
	}
	
}
