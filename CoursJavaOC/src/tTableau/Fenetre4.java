package tTableau;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class Fenetre4 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTable tableau;

	private JButton change = new JButton("Changer la taille");

	public Fenetre4() {
		this.setLocationRelativeTo(null);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setTitle("JTable4");

		this.setSize(600, 140);
		Object[][] data = {
				{ "Cysboy", new JButton("6boy"), new JComboBox(new String[] { "toto", "titi", "tata" }),
						new Boolean(true) },
				{ "BZHHydde", new JButton("BZH"), new JComboBox(new String[] { "toto", "titi", "tata" }),
						new Boolean(false) },
				{ "IamBow", new JButton("BoW"), new JComboBox(new String[] { "toto", "titi", "tata" }),
						new Boolean(false) },
				{ "FunMan", new JButton("Year"), new JComboBox(new String[] { "toto", "titi", "tata" }),
						new Boolean(true) } };

		/*
		 * Object[][] data = {
		 * 
		 * { "Cysboy", new JButton("6boy"), new Double(1.80), new Boolean(true) },
		 * 
		 * { "BZHHydde", new JButton("BZH"), new Double(1.78), new Boolean(false) },
		 * 
		 * { "IamBow", new JButton("BoW"), new Double(1.90), new Boolean(false) },
		 * 
		 * { "FunMan", new JButton("Year"), new Double(1.85), new Boolean(true) }
		 * 
		 * };
		 */

		String title[] = { "Pseudo", "Age", "Taille", "OK ?" };

		ZModel model = new ZModel(data, title);
		System.out.println("nombre de colonne " + model.getColumnCount());
		System.out.println("nombre de lignes " + model.getRowsCount());
		this.tableau = new JTable(model);
		this.tableau.setDefaultRenderer(JButton.class, new TableComponent());
		this.tableau.setDefaultRenderer(JComboBox.class, new TableComponent());
		this.getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);

	}
	// classe modele persnnalisee
	// https://openclassrooms.com/courses/apprenez-a-programmer-en-java/les-interfaces-de-tableaux#/id/r-2184975

	class ZModel extends AbstractTableModel {
		/*
		 * Vous devez bien distinguer un TableModel d'un DefaultTableCellRenderer. Le
		 * premier fait le lien entre les données et le tableau tandis que le second
		 * s'occupe de gérer l'affichage dans les cellules !
		 */
		private Object[][] data;
		private String[] title;

		// constructeur
		public ZModel(Object[][] data, String[] title) {
			this.data = data;
			this.title = title;
		}

		// retourne le nombre de colonnes
		public int getColumnCount() {
			return this.title.length;
		}

		// retourne le nombre de lignes
		public int getRowsCount() {
			return this.data.length;
		}

		// retourne la valeur a l emplacement specifié
		public Object getValueAt(int row, int col) {
			return this.data[row][col];
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return this.getRowsCount();
		}

		public String getColummnName(int col) {
			return this.title[col];
		}
		/*
		 * (non-Javadoc)
		 * 
		 * @see javax.swing.table.AbstractTableModel#isCellEditable(int, int)
		 */
		// Les modèles font un pont entre ce qu'affiche JTable et les actions de
		// l'utilisateur.
		// Pour modifier l'affichage des cellules, nous devrons utiliser
		// DefaultCellRenderer.

		// retourne vrai si la cellule est editable : sera donc editable
		@Override
		public boolean isCellEditable(int row, int col) {
			// si c est un bouton n est pas editable
			boolean result = false;
			System.out.println(getValueAt(0, col));
			if (getValueAt(0, col) instanceof JButton) {
				// https://openclassrooms.com/courses/apprenez-a-programmer-en-java/les-interfaces-de-tableaux#/id/r-2184997

			} else {
				result = true;
			}
			System.out.println("iscell editable " + result);
			return result;
		}

		/*
		 * https://openclassrooms.com/courses/apprenez-a-programmer-en-java/les-
		 * interfaces-de-tableaux#/id/r-2184992
		 * 
		 */
		public Class getColumnClass(int col) {
			/*
			 * on retourne le type de la cellule de la colonne demandee on se smoque de la
			 * ligne puisque tous les types de données sont tous les memes quelle que soit
			 * la ligne on choisit donc la premiere
			 */
			System.out.println("appel getColumnClass" + col + " val = " + this.data[0].getClass());
			return this.data[0].getClass();
		}
	}

	public class TableComponent extends DefaultTableCellRenderer {
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			// si la valeur est un bouton on transtype la valeur,
			if (value instanceof JButton) {
				return (JButton) value;
			} else if (value instanceof JComboBox)
				return (JComboBox) value;
			else {
				return this;
			}
		}

	}

	public static void main(String[] args) {

		Fenetre4 fen = new Fenetre4();
		fen.setVisible(true);
	}
	// TODO Auto-generated method stub

}
