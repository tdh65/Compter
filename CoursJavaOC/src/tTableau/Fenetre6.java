package tTableau;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

import tTableau.Fenetre5.ButtonEditor;
import tTableau.Fenetre5.ButtonRenderer;
import tTableau.Fenetre5.ButtonEditor.ButtonListener;

public class Fenetre6 extends JFrame {

	private JTable tableau;
	private JButton change = new JButton("Changer la taille");
	// Contenu de notre combo
	private String[] comboData = { "Très bien", "Bien", "Mal" };
	private JButton ajouterRow = new JButton("Ajouter Ligne");

	public Fenetre6() {
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("JTable");
		this.setSize(600, 180);
		// Données de notre tableau
		Object[][] data = { { "Cysboy", "6boy", comboData[0], new Boolean(true) },
				{ "BZHHydde", "BZH", comboData[0], new Boolean(false) },
				{ "IamBow", "BoW", comboData[0], new Boolean(false) },
				{ "FunMan", "Year", comboData[0], new Boolean(true) } };
		String title[] = { "Pseudo", "Age", "Taille", "OK ?" };
		JComboBox combo = new JComboBox(comboData);

		// Nous devons utiliser un modèle d'affichage spécifique pour pallier les bugs
		// d'affichage !
		ZModel zModel = new ZModel(data, title);

		this.tableau = new JTable(zModel);
		this.tableau.setRowHeight(30);
		this.tableau.getColumn("Age").setCellRenderer(new ButtonRenderer());
		this.tableau.getColumn("Age").setCellEditor(new ButtonEditor(new JCheckBox()));
		// On définit l'éditeur par défaut pour la cellule
		// En lui spécifiant quel type d'affichage prendre en compte
		this.tableau.getColumn("Taille").setCellEditor(new DefaultCellEditor(combo));
		this.getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
		this.getContentPane().add(change, BorderLayout.NORTH);
		this.getContentPane().add(ajouterRow, BorderLayout.SOUTH);
	}

	public class ButtonRenderer extends JButton implements TableCellRenderer {
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean isFocus,
				int row, int col) {
			// on ecrite dans le bouton ce que contient la cellule
			// https://openclassrooms.com/courses/apprenez-a-programmer-en-java/les-interfaces-de-tableaux#/id/r-2185031
			setText((value != null) ? value.toString() : "");
			return this;

		}
	}

	public class ComboBoxRenderer extends JComboBox implements TableCellRenderer {
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean isFocus,
				int row, int col) {
			// on ecrite dans le bouton ce que contient la cellule
			// https://openclassrooms.com/courses/apprenez-a-programmer-en-java/les-interfaces-de-tableaux#/id/r-2185031
			this.addItem("Très bien");
			this.addItem("Bien");
			this.addItem("Mal");
			return this;

		}
	}

	/*
	 * https://openclassrooms.com/courses/apprenez-a-programmer-en-java/les-
	 * interfaces-de-tableaux#/id/r-2185045
	 */
	public class ButtonEditor extends DefaultCellEditor {

		protected JButton button;
		private boolean isPushed;
		private ButtonListener bListener = new ButtonListener();

		// constructeur avec une checkbox
		public ButtonEditor(JCheckBox checkBox) {
			// Par défaut, ce type d'objet travaille avec un JCheckBox
			super(checkBox);
			// TODO Auto-generated constructor stub
			// on cree un nouveau bouton
			button = new JButton();
			button.setOpaque(true);
			// on lui attribue un listener
			button.addActionListener(bListener);
		}

		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			// on precise le numero le ligne au listener
			bListener.setRow(row);
			// on precise le numero de la colonne
			bListener.setColumn(column);

			// on passe aussi le tableau en parametre pour des actions potentielles
			bListener.setTable(table);

			// on reaffecte le libelle du bouton
			button.setText((value == null) ? "" : value.toString());
			// on renvoie le bouton
			return button;
		}

		// notre listener pour le bouton
		class ButtonListener implements ActionListener {
			private int column, row;
			private JTable table;
			private int nbre = 0;
			private JButton button;

			public void setColumn(int col) {
				this.column = col;

			}

			public void setRow(int row) {
				this.row = row;
			}

			public void setTable(JTable table) {
				this.table = table;
			}

			public JButton getButton() {
				return this.button;
			}

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				// on affiche un message mais on peut faire les traitements qu on veut
				System.out.println("coucou du bouton : " + ((JButton) arg0.getSource()).getText());

				// on affecte un nouveau libelle a une autre cellule de la ligne
				((AbstractTableModel) table.getModel()).setValueAt("New Value " + (++nbre), this.row, this.column - 1);
				// Permet de dire à notre tableau qu'une valeur a changé à l'emplacement
				// déterminé par les valeurs passées en paramètres
				((AbstractTableModel) table.getModel()).fireTableCellUpdated(this.row, this.column - 1);
				// this.button = ((JButton) arg0).getSource();

			}

		}
	}

	class ZModel extends AbstractTableModel {
		private Object[][] data;
		private String[] title;

		// Constructeur
		public ZModel(Object[][] data, String[] title) {
			this.data = data;
			this.title = title;
		}

		// Retourne le titre de la colonne à l'indice spécifié
		public String getColumnName(int col) {
			return this.title[col];
		}

		// Retourne le nombre de colonnes
		public int getColumnCount() {
			return this.title.length;
		}

		// Retourne le nombre de lignes
		public int getRowCount() {
			return this.data.length;
		}

		// Retourne la valeur à l'emplacement spécifié
		public Object getValueAt(int row, int col) {
			return this.data[row][col];
		}

		// Définit la valeur à l'emplacement spécifié
		public void setValueAt(Object value, int row, int col) {
			// On interdit la modification sur certaines colonnes !
			if (!this.getColumnName(col).equals("Age") && !this.getColumnName(col).equals("Suppression"))
				this.data[row][col] = value;
		}

		// Retourne la classe de la donnée de la colonne
		public Class getColumnClass(int col) {
			// On retourne le type de la cellule à la colonne demandée
			// On se moque de la ligne puisque les types de données sont les mêmes quelle
			// que soit la ligne
			// On choisit donc la première ligne
			return this.data[0][col].getClass();
		}

		public boolean isCellEditable(int row, int col) {
			return true;
		}
	}

	public static void main(String[] args) {
		Fenetre6 fen = new Fenetre6();
		fen.setVisible(true);
	}
}