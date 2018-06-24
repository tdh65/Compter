package l96;

import java.io.File;
import java.io.Serializable;

import compte.Compte;
import compte.InvalidFormalCompte;

/*
 * decrit un enregistremetn de compte  / bgp / cf
 */
public class L96 extends ListingAbstrait implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Compte mCompte;
	private String mBGP;
	private String mCF;
	private String m_CentreFinancier ; // l entite ayant le compte auparavant

	public String getM_CentreFinancier() {
		return m_CentreFinancier;
	}

	public void setM_CentreFinancier(String m_CentreFinancier) {
		this.m_CentreFinancier = m_CentreFinancier;
	}

	public L96() {

	}

	public L96(Compte pCompte, String pBGP, String pCF)
			throws InvalidFormalCompte {

		this.mCompte = new Compte(pCompte.getmSerie(), pCompte.getmCompte(),
				pCompte.getmCle());
		// doit verifier 6 chiffres faire le throws + exceptions
		this.mBGP = pBGP;
		this.mCF = pCF;

	}

	public L96 setL96(Compte pCompte, String pBGP, String pCF) {
		L96 tmp = null;
		try {
			tmp = new L96(pCompte, pBGP, pCF);
		} catch (InvalidFormalCompte e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tmp;
	}
	@Override
	protected String creeNomFichier() {
		
		String result = "";
		result = this.getM_CentreFinancier() + "-" + this.getM_DateCapture().replace("/","-") 
				+ this.getM_ExtensionFichier();
		this.setM_NomFichier(result);
		return result;
	}
	protected String setM_CentreFinancier(){
		affiche ("avant equals " + this.getM_User());
		if (this.getM_User().equalsIgnoreCase("GWBLA903") ){
			this.setM_CentreFinancier( new String("BORDEAUX")  );
			affiche("Bordeaux / getmcf = " + this.getM_CentreFinancier());
		} else if(this.getM_User().equalsIgnoreCase("GWTLA903") ){
			this.setM_CentreFinancier( "TOULOUSE" );
			
		} else if(this.getM_User().equalsIgnoreCase("GWCLA903") ){
			this.setM_CentreFinancier(  "CHALONS" );
			
		} else if(this.getM_User().equalsIgnoreCase("GWALA903") ){
			this.setM_CentreFinancier( "CLERMONT" ) ;
			
		}
		System.out.println("Setm_centrefinancier + " + this.getM_CentreFinancier());
		return this.getM_CentreFinancier();
	}
	public String getL96() {
		return mCompte.toString() + " * " + mBGP + " * " + mCF;
	}
	/*
	 * fonction support destinee  a normaliser et adapter les valeurs des champs 
	 */
	private void normaliseChamps(){
		
		
	}

	public boolean tester(File pFileNomFichier) {
		boolean result = false ;
		result =this.extraireEntete(pFileNomFichier) ; 
		if(result)
			 this.setM_CentreFinancier() ;
		
		return result ;
	//	return true;
	}
	public static void affiche(String str ){
		System.out.println("Classe L96 / " + str);
	}

}
