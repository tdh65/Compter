/** 
 * 
 */
package l96;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  * @author T D classe abstraite destinee a decrire un listing et au debut ses
 *  *         modalite d extraction et description d entete  *  
 */
abstract class ListingAbstrait {
	private String m_NomFichier;
	private String m_Form, m_Description;
	private String m_User, m_Report;
	private int m_NbLignes, m_NbEnregistrement;
	private String m_DateExtraction, m_DateTraitement, m_TimeExtraction,
			m_DateCapture, m_DateQuantieme;
	Pattern p1 = Pattern
			.compile("^\\*\\s+REPORT\\s=\\s([\\w|\\d]+)\\s+USER\\s=\\s(\\w{8})\\*$");
	// .compile("^*\\s+REPORT\\s=\\s\\.(\\w[\\w|\\s]{34})\\s+USER\\s=\\s(\\w{8})\\s+\\*$");

	// ligne Desc
	Pattern p2 = Pattern
			.compile("^*\\s+DESC\\.\\s+=\\s(\\w.+)\\s+FORM\\s=\\s(\\w.+)\\s.*$");
	// ligne capture date
	Pattern p3 = // Pattern.compile("^*\s+\w{7}\s\w{4}\s{2}=\s(\d{2}/\d{2}/\d{2})\s.(\d{2}\.\d{3}).\s{3}\w{4}\s.\s(\d{2}\.\d{2}\.\d{2}).$");
	Pattern.compile("^\\*\\s+\\w{7}\\s\\w{4}\\s\\s=\\s(\\d\\d/\\d\\d/\\d\\d)\\s\\((\\d{2}\\.\\d{3})\\)\\s+TIME\\s+=\\s(\\d{2}\\.\\d{2}\\.\\d{2})\\s\\s+.*$");
	private String m_ExtensionFichier = ".txt";

	public String getM_ExtensionFichier() {
		return m_ExtensionFichier;
	}

	/*
	 *      * methode destinee a reconnaitre et a extraire les valeurs d'entetes
	 * des      * formulaires basee sur les regexp. les classes concretes
	 * peuvent ameliorer ou      * ajouter des données      
	 */
	protected boolean extraireEntete(File pFileNomFichier) {
		boolean vResultat = false;
		List<Pattern> listePatterns = new ArrayList<Pattern>();
		String vTmp = "";
		String pStrNomFichier = pFileNomFichier.getName();
		int i = 0, j = 0;
		Matcher m;
		listePatterns.add(p1);
		listePatterns.add(p2);
		listePatterns.add(p3);
		/*
		 *      * l extraction des entetes on ne lit que 12 premieres lignes    
		 *  
		 */
		i = 0;
		j = 0;
		if (pFileNomFichier.exists()) {
			this.setM_NomFichier(pStrNomFichier);
			// on lit le fichier avec un Buffered reader et on stocke la valeurs
			// dans les champs
			BufferedReader vFileIn = null;
			try {
				vFileIn = new BufferedReader(new FileReader(pFileNomFichier));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				while (((vTmp = vFileIn.readLine()) != null) && (j < 13)
						&& (i < 3)) {
					// chaque fois que l on trouve un pattern on incremente le
					// compteur, stocke les valeurs
					// et on passe au suivant
					j++; // compteur de lignes lues
					// System.out.println("i : " + i + " vtmp : " + vTmp);
					m = listePatterns.get(i).matcher(vTmp);

					if (m.find()) {
						// System.out.println("M.find () i : " + i + " vtmp : "
						// + vTmp);

						if (i == 0) {

							this.setReportUser(m.group(1), m.group(2));
							// System.out.println("1 trouve ");
						}
						if (i == 1) {

							this.setDescForm(m.group(1), m.group(2));
							// System.out.println("2 trouve ");
						}
						if (i == 2) {

							// System.out.println(m.group());
							this.setCaptureTime(m.group(1), m.group(2), m
									.group(3).replace('.', ':'));
							// System.out.println("3 trouve ");
							vResultat = true;
						}
						i++;
					}

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				vFileIn.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		return vResultat;

	}

	protected String creeNomFichier() {
		String result = "";
		result = this.getM_Report() + "-" + this.getM_DateCapture() + "-"
				+ this.getM_TimeExtraction() + "-" + this.getM_User() + "-"
				+ this.getM_ExtensionFichier() ;
		this.setM_NomFichier(result);
		System.out.println("creeNomFicher" + result );
		return result;
	}

	public String toString() {
		return "Nom Fichier : " + this.getM_NomFichier() + "\n Form : "
				+ this.getM_Form() + "\n User : " + this.getM_User()
				+ "\n Report : " + this.getM_Report() + "\n Description : "
				+ this.getM_Description() + "\n Date Capture : "
				+ this.getM_DateCapture() + "\n Date Quantieme  : "
				+ this.getM_DateQuantieme() + "\n Time : "
				+ this.getM_TimeExtraction() + "\n Nom fichier : "
				+ this.creeNomFichier() ;
		
	}

	protected void setCaptureTime(String pStrDate, String pStrQuantieme,
			String pStrTime) {
		this.setM_DateCapture(pStrDate);
		this.setM_TimeExtraction(pStrTime);
		this.setM_DateQuantieme(pStrQuantieme);
	}

	protected void setDescForm(String pStrDescription, String pStrForm) {
		this.setM_Description(pStrDescription);
		this.setM_Form(pStrForm);
	}

	protected void setReportUser(String pStrReport, String pStrUser) {
		this.setM_Report(pStrReport);
		this.setM_User(pStrUser);
	}

	public String getM_NomFichier() {
		return m_NomFichier;
	}

	public void setM_NomFichier(String m_NomFichier) {
		this.m_NomFichier = m_NomFichier;
	}

	public String getM_DateCapture() {
		return m_DateCapture;
	}

	public void setM_DateCapture(String m_DateCapture) {
		this.m_DateCapture = m_DateCapture;
	}

	public String getM_DateQuantieme() {
		return m_DateQuantieme;
	}

	public void setM_DateQuantieme(String m_DateQuantieme) {
		this.m_DateQuantieme = m_DateQuantieme;
	}

	public String getM_DateExtraction() {
		return m_DateExtraction;
	}

	public void setM_DateExtraction(String m_DateExtraction) {
		this.m_DateExtraction = m_DateExtraction;
	}

	public String getM_DateTraitement() {
		return m_DateTraitement;
	}

	public void setM_DateTraitement(String m_DateTraitement) {
		this.m_DateTraitement = m_DateTraitement;
	}

	public String getM_TimeExtraction() {
		return m_TimeExtraction;
	}

	public void setM_TimeExtraction(String m_TimeExtraction) {
		this.m_TimeExtraction = m_TimeExtraction;
	}

	public String getM_Form() {
		return m_Form;
	}

	public void setM_Form(String m_Form) {
		this.m_Form = m_Form;
	}

	public String getM_Description() {
		return m_Description;
	}

	public void setM_Description(String m_Description) {
		this.m_Description = m_Description;
	}

	public String getM_User() {
		return m_User;
	}

	public void setM_User(String m_User) {
		this.m_User = m_User;
	}

	public String getM_Report() {
		return m_Report;
	}

	public void setM_Report(String m_Report) {
		this.m_Report = m_Report;
	}

	public int getM_NbLignes() {
		return m_NbLignes;
	}

	public void setM_NbLignes(int m_NbLignes) {
		this.m_NbLignes = m_NbLignes;
	}

	public int getM_NbEnregistrement() {
		return m_NbEnregistrement;
	}

	public void setM_NbEnregistrement(int m_NbEnregistrement) {
		this.m_NbEnregistrement = m_NbEnregistrement;
	}

}
