package tpcalculatrice;
import java.math.*;
import java.text.DecimalFormat;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FenCalc extends JFrame {

	private Panneau panGlob; // le panneau global qui remplit le contentPane
	private Panneau panChiffre; // contient les chiffres
	private Panneau panOperateur;
	private Panneau panAfficheur;
	private JLabel afficheur;
	private byte operation; // l'operateur selectionne
	private double valEnCours = 0; // le resultat intermediaire
	private double saisie = 0;
	private boolean efface = false;
	boolean decimal = false; // indique si le signe "." est presse et donc on concatene apres la virgule
	private JButton bouton = new JButton("Mon premier bouton");
	private JButton bouton2 = new JButton("Mon II bouton");
	private String nameFenetre = "Bouton";

	/*
	 * constructeur par defaut definit les 3 panneaux chiffre -> gridlayout
	 * operateur ->boxlayout vertical agencement des trois par borderlayout centre
	 * est nord
	 */
	public FenCalc() {
		System.out.println("fenetre ; ");

		this.setTitle("Calculatrice");
		this.setLocationRelativeTo(null);
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// construit le panneau chiffre
		this.construitPanneauChiffre();
		// construit le panneau afficheur
		this.construitPanneauAfficheur();
		// construit le panneau operateur
		this.construitPanneauOperateur();
		// ajoute les panneaux au panneau ppal
		this.getContentPane().add(this.panChiffre, BorderLayout.CENTER);
		this.getContentPane().add(panAfficheur, BorderLayout.NORTH);
		this.getContentPane().add(this.panOperateur, BorderLayout.EAST);
		this.pack();
		this.setVisible(true);

	}

	/*
	 * construit le panneau d'operateurs
	 */
	private void construitPanneauOperateur() {
		int vHeight = 0;
		int vWidth = 0;
		this.panOperateur = new Panneau();
		this.panOperateur.setLayout(new BoxLayout(panOperateur, BoxLayout.PAGE_AXIS));
		String[] t = { "C", "+", "-", "*", "/" };
		for (String v : t) {
			JButton b = new JButton(v);
			if (v == "C") {
				b.setForeground(Color.RED);
				/*
				 * on affecte par defaut la valeur de taille du btn C
				 */
				// vWidth = b.getWidth() ;
				// vHeight = b.getHeight() ;
			}
			// b.setPreferredSize(new Dimension(vWidth,vHeight));
			b.setMnemonic(v.charAt(0));
			this.panOperateur.add(b);
			System.out.println(b.getText() + " h " + b.getHeight() + " w " + b.getWidth());

		}

	}

	/*
	 * construit le panneau afficheur sur un seul panel pas de layout particulier
	 * 
	 */
	private void construitPanneauAfficheur() {
		this.panAfficheur = new Panneau();
		this.afficheur = new JLabel();
		// this.afficheur.setBackground(Color.LIGHT_GRAY);
		this.afficheur.setPreferredSize(new Dimension(250, 50));
		// this.afficheur.setForeground(Color.orange);
		Font ft = new Font("Tahoma", Font.LAYOUT_RIGHT_TO_LEFT, 16);
		this.afficheur.setFont(ft);
		this.afficheur.setHorizontalAlignment(JLabel.RIGHT);

		String t = String.valueOf(valEnCours);

		this.afficheur.setText(t);
		this.panAfficheur.add(afficheur);

	}

	/*
	 * construit le panneau contenant les chiffres et le gridlayout
	 */
	private void construitPanneauChiffre() {
		this.panChiffre = new Panneau();

		GridLayout gl = new GridLayout();
		// on definit les colonnes et lignes
		gl.setColumns(3);
		gl.setRows(4);
		// on definit lespacement entre les colonnes et les lignes
		gl.setHgap(5); // 5 pixels H orizontal
		gl.setVgap(3); // 3 pixels V ertical

		this.panChiffre.setLayout(gl);

		String[] t = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ".", "=" };
		for (String v : t) {
			affiche("v " + v);
			JButton b = new JButton(v);
			b.setName(v);
			b.setMnemonic(v.charAt(0));
			b.addActionListener(new ChiffrePannListener());
			affiche("nom bouton " + b.getName());
			this.panChiffre.add(b);

		}
		// this.panChiffre.addActionListener(new ChiffrePannListener());
		// this.panChiffre.addInputMethodListener(new ChiffrePannListener());
		// go() ;
	}
	/*
	 * protected void go() { Scanner sc = new Scanner(System.in) ; while()
	 * 
	 * }
	 */

	/*
	 * effectue les calculs
	 */
	protected double calcule(double valEncours, double saisie, byte operation) {
		double res = 0;
		if (operation == '/') {
			try {
				res = valEncours / saisie;

			} catch (ArithmeticException e) {
				res = 0;
			}

		} else if (operation == '+') {
			res = valEncours + saisie;
		} else if (operation == '-') {
			res = valEncours - saisie;
		} else if (operation == '*') {
			res = valEncours * saisie;
		}
		return res;
	}

	/*
	 * on constuit la classe anonyme ecoutant le panneau chiffre
	 * 
	 */
	class ChiffrePannListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			// cas special du "="
			double resultat;
			// nom du bouton qui est egal a un chiffre ou un operateur
			String sourceArg = arg0.getSource().toString().substring(20, 21);
			affiche("arg0 " + arg0.getSource() + " Name : ");
			// recupere la derniere valeur de la saisie
			affiche("arg0 + modif source " + sourceArg);
			try {
				saisie = Double.valueOf(afficheur.getText());
			} catch (NumberFormatException ex) {
				affiche("exception " + ex.getMessage());
				// ex.printStackTrace();
				saisie = 0;
				return;
			}

			affiche("Saisie = " + saisie);
			if ((sourceArg == "=") || (sourceArg.equals("="))) {

				resultat = calcule(valEnCours, saisie, operation);
			} else {
				// ce sont les chiffres ou les virgules on concatene
				// on verifie qu il n y a pas deja une virgule et qu il a appuye sur une virgule
				// on faite rien dans ce cas
				if ((sourceArg == ".") || (sourceArg.equals("."))) {
					decimal = true; // le signe decimal est deja presse
					if (verifieVirgule(afficheur.getText()) == true) {

						// on fait rien
						affiche("deja une virgule ");

					}
				} else {
					// ce sont des chiffres on les concatene
					affiche("ajout chiffre nom bouton  " + arg0.getSource());
					String res = concateneChiffre(afficheur.getText(), sourceArg);
					affiche("res = " + res);
					try {
						saisie = Double.valueOf(res) ;
					} catch (NumberFormatException ex) {
						ex.printStackTrace();
						
					}
						
					
					mettreAJourAfficheur(res);
					afficheur.setText(res);
				}
			}

		}

	}

	// remete à zero les compteurs et les valeurs
	private void raz() {
		this.saisie = 0;
		this.valEnCours = 0;
	}

	/*
	 * verifie si un signe '.' est deja insere et donc c'est un nombre deja decimal
	 */
	private boolean verifieVirgule(String saisie) {
		boolean trouve = false;
		if (saisie.length() < 1) {
			trouve = false;

		} else {
			for (int i = 0; i < saisie.length(); i++) {
				if (saisie.charAt(i) == '.') {
					trouve = true;
					break; // on sort inutile de continuer
				}
			}
		}
		affiche("pour saisie : " + saisie + " trouve : " + trouve);
		return trouve;
	}

	/*
	 * concatene a un string saisie la valeur strAConcat : si c'est 0 alors on
	 * change le 0 par le chiffre
	 */
	private String concateneChiffre(String saisie, String strAConcat) {
		String resultat = "";

		// est un nombre decimal si a virgule et un chiffre <>0
		// on parcourt la saisie : si virgule et 000 n est pas decimal on decale les
		// unites
		// si virgule et un chiffre different de zero est decimal et on
		affiche("Avant split saisie = " + saisie  + " strconcat = " + strAConcat);
		String[] val = saisie.split(".",2);
		String[] val3 = saisie.split(".", 3) ;
		/*for(int i=0; va
		forEach(String a : val3){
			affiche("val3 + " a) ;
		}*/
		affiche("val 0 "  + val[0] + " val 1 " + val[1] ) ;
		affiche ("test avec cast numerique");
		double partieEntiere ; 
		double saisieDouble ; 
		double x = 0 , y = 0 , z = 0 ;
		try {
			saisieDouble = Double.parseDouble(saisie);
			partieEntiere  =  Double.parseDouble(saisie) ;
			
			x = Math.rint(saisieDouble) ;
			y = saisieDouble - partieEntiere ;
			z = Integer.parseInt(strAConcat) ;
		}catch(NumberFormatException ex) {
			
			affiche("Erreur conversion saisie " + saisie );
			ex.printStackTrace();
		}
		affiche("partie entiere " +  x );
		
		affiche("partie decimale saisie-l " + y) ;
		if (decimal) {
			if (y == 0.0)
				y= z/10 ;
			else
				y = z ;
		}else {
			x = x*10 + z ;
		}
		
		// val 0 est la partie entiere
		// val 1 est la partie decimale
	/*
		if (this.decimal == true) {
			// est decimal
			if (val[1].equals(".00")) {
				val[1] = strAConcat;

			} else {
				val[1] = val[1] + strAConcat;
			}

		} else {
			val[0] = val[0] + (strAConcat);
		}
		resultat = val[0].concat(val[1]);
		affiche("fin concatene res = " + resultat );
		*/
		resultat = String.valueOf(x+y) ;
		return resultat;

	}

	public void affiche(String str) {
		System.out.println(str);
	}
	/*
	 * rafraichit l afficheur 
	 */
	protected String  mettreAJourAfficheur(String val) {
		affiche(" dans mettreAJourAfficheur val : " + val + " saisie " + saisie );
		String valeurafficheur ; 
		
		if (!decimal) {
			// n affiche pas le .00
			return  new String(val.split(".", 2)[0] );
		} else
			return  new String( val ) ;
/*
		affiche("dans mettreAJourAfficheur getText " + this.afficheur.getText() + " valeurafficheur " + valeurafficheur) ;
		
		this.afficheur.setText(valeurafficheur);
		this.afficheur.repaint();
		repaint();
	*/	
		
		

	}
	 public static double decimal (double d) {
	        // on crée un DecimalFormat pour formater le double en chaine :
	        DecimalFormat df = new DecimalFormat();
	        df.setGroupingUsed(false);            // Pas de regroupement dans la partie entière
	        df.setMinimumFractionDigits(1);        // Au minimum 1 décimale
	        df.setMaximumFractionDigits(340);    // Au maximum 340 décimales (valeur max. pour les doubles / voir la doc)
	 
	        // On formate le double en chaine
	        String str = df.format(d);
	        // On récupère le caractère séparateur entre la partie entière et décimale :
	        char separator = df.getDecimalFormatSymbols().getDecimalSeparator();
	        // On ne récupère que la partie décimale :
	        str = str.substring( str.indexOf(separator) + 1 );
	        // Que l'on transforme en double :
	        return Double.parseDouble(str);
	    }

}
