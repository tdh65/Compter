package tTableau;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class Fenetre2 extends JFrame {
	private JTable tableau;
	private JButton change = new JButton("Changer la taille");
	private JButton retablir = new JButton("Rétablir");

	public Fenetre2() {
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("JTable2");
		this.setSize(300, 240);

		Object[][] data = { { "Cysboy", "28 ans", "1.80 m" }, { "BZHHydde", "28 ans", "1.80 m" },
				{ "IamBow", "24 ans", "1.90 m" }, { "FunMan", "32 ans", "1.85 m" } };

		String title[] = { "Pseudo", "Age", "Taille" };
		this.tableau = new JTable(data, title);
		// c est identique a fenetre precedent
		JPanel pan = new JPanel();
		change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changeSize(200, 80);
				change.setEnabled(false);
				retablir.setEnabled(true);
			}
		});
		retablir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				changeSize(75, 16);
				change.setEnabled(true);
				retablir.setEnabled(false);

			}
		});
		retablir.setEnabled(false);
		pan.add(change);
		pan.add(retablir);
		this.getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
		this.getContentPane().add(pan, BorderLayout.SOUTH);

	}

	/*
	 * change la taille d'une ligne et d une colonne a mis deux boucles pour pouvoir
	 * voir comment parcourir les colonnes et les lignes
	 */
	public void changeSize(int width, int height) {
		// oon cree l objet tablecolumn afin de travailler sur notre colonne
		TableColumn col;
		for (int i = 0; i < tableau.getColumnCount(); i++) {
			if (i == 1) {
				// on recupere la modele de la colonne
				col = tableau.getColumnModel().getColumn(i);
				// on lui affecte la nouvelle valeur
				col.setPreferredWidth(width);
			}
		}
		for (int i = 0; i < tableau.getRowCount(); i++) {
			// on affecte la taille de la ligne a l indice specifie
			if (i == 1)
				tableau.setRowHeight(height);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fenetre2 fen2 = new Fenetre2();
		fen2.setVisible(true);

	}

}
