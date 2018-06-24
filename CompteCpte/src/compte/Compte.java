package compte;

import java.io.Serializable;

/*
 * classe destine a supporter un compte
 * cree un compte , le dump, .... 
 */
public class Compte implements Serializable {
	private String mSerie, mCompte, mCle;

	public String getmSerie() {
		return mSerie;
	}

	private void setmSerie(String mSerie) {
		this.mSerie = mSerie;
	}

	public String getmCompte() {
		return mCompte;
	}

	private void setmCompte(String mCompte) {
		this.mCompte = mCompte;
	}

	public String getmCle() {
		return mCle;
	}

	private void setmCle(String mCle) {
		this.mCle = mCle;
	}

	public Compte() {
		this.mSerie = "";
		this.mCle = "";
		this.mCompte = "";
	}

	/*
	 * constructeur parametre : verifie validite du compte serie 3 chiffres, compte
	 * max 7 chiffres, cle une lettre compte ordinaire
	 */
	public Compte(String pSerie, String pCompte, String pCle) throws InvalidFormalCompte {
		//System.out.println("pserie " + pSerie + " lg " + pSerie.length() );
		if ((pSerie.length() != 3) || !(pSerie.matches("\\d{3}"))) {
			//System.out.println("Erreur dans serie ");
			throw new InvalidFormalCompte("Erreur dans serie ");
		}
		if (((pCompte.length() > 7) || (pCompte.length() < 1)) || !(pCompte.matches("\\d{1,7}"))) {

			throw new InvalidFormalCompte("Erreur dans le compte ");
		}
		pCle = pCle.toUpperCase();
		if ((pCle.length() != 1) && !(pCompte.matches("[A-Z]"))) {

			throw new InvalidFormalCompte("Erreur dans la cle ");
		}
		this.setmSerie(pSerie);
		this.setmCompte(pCompte);
		this.setmCle(pCle);
	//	System.out.println("constructeur " + this.getCompte()  );
	}

	/*
	 * setter
	 */
	public Compte setCompte(String pSerie, String pCompte, String pCle) {
		Compte tmp = null;
		System.out.println(pSerie + " " + pCompte + " " + pCle);
		try {
			tmp = new Compte(pSerie, pCompte, pCle);
		} catch (InvalidFormalCompte e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tmp;
	}

	protected String getCompte() {
		String tmp = this.getmSerie() + " " + this.getmCompte() + " " + this.getmCle() ; 
	
		return tmp;
	}

	public String toString() {
		return getCompte();
	}

}
