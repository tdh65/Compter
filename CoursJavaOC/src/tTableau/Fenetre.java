package tTableau;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Fenetre extends JFrame {
	public Fenetre() {
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("JTable");
		this.setSize(300, 120);
		// les donnéées du tableau
		Object[][] data = { { "Cysboy", "28 ans", "1.80 m" }, { "BZHHYde", "28 ans", "1.61 m" },
				{ "IamBow", "28 ans", "1.96 m" }, { "FunMan", "26 ans", "1.78 m" } };

		// les titres des colonnes
		String title[] = { "Pseudo", "Age", "Taille" };
		JTable tableau = new JTable(data, title);
		// on ajoute le tableau dans le contentpane et avec un scroll
		// sinon les titres ne s affichent pas
		
		/*
		 * https://openclassrooms.com/courses/apprenez-a-programmer-en-java/les-interfaces-de-tableaux#/id/r-2184951
		 */
		/* En effet, le scroll indique automatiquement au tableau l'endroit où il doit afficher ses titres ! Sans lui, vous seriez obligés de préciser où afficher l'en-tête du tableau, comme ceci :

			//On indique que l'en-tête doit être au nord, donc au-dessus

			this.getContentPane().add(tableau.getTableHeader(), BorderLayout.NORTH);

			//Et le corps au centre !

			this.getContentPane().add(tableau, BorderLayout.CENTER);

			Je pense que nous avons fait le tour des préliminaires… Entrons dans le vif du sujet !
*/
		this.getContentPane().add(new JScrollPane(tableau));

	}

	public static void main(String[] args) {
		Fenetre fen = new Fenetre();
		fen.setVisible(true);
	}
}