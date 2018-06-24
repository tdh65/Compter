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
import javax.swing.table.TableCellRenderer;

public class Fenetre5 extends JFrame {
	private JTable tableau;

	private JButton change = new JButton("Changer la taille");
	private String[] comboData = {"Très Bien", "Bien" , "Mal" };

	public Fenetre5() {

		this.setLocationRelativeTo(null);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setTitle("JTable");

		this.setSize(600, 180);

		Object[][] data = {

				{ "Cysboy", "6boy", "Combo", new Boolean(true) },

				{ "BZHHydde", "BZH", "Combo", new Boolean(false) },

				{ "IamBow", "BoW", "Combo", new Boolean(false) },

				{ "FunMan", "Year", "Combo", new Boolean(true) }

		};

		String title[] = { "Pseudo", "Age", "Taille", "OK ?" };
		JComboBox combo = new JComboBox(comboData) ;
		
		this.tableau = new JTable(data, title);

		this.tableau.setRowHeight(30);
		this.tableau.getColumn("Age").setCellRenderer(new ButtonRenderer());
		this.tableau.getColumn("Age").setCellEditor(new ButtonEditor(new JCheckBox()));
		// on definit l'editeur par defaut pour la cellule en lui spécifiant quel type d'affichage 
		// prendre en compte
		this.tableau.getColumn("Taille").setCellEditor(new DefaultCellEditor(combo));
		//this.tableau.getColumn("Taille").setCellRenderer(new ComboBoxRenderer());

		this.getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);

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

			public void setColumn(int col) {
				this.column = col;

			}

			public void setRow(int row) {
				this.row = row;
			}

			public void setTable(JTable table) {
				this.table = table;
			}

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				// on affiche un message mais on peut faire les traitements qu on veut
				System.out.println("coucou du bouton : " + ((JButton) arg0.getSource()).getText());

				// on affecte un nouveau libelle a une autre cellule de la ligne
				table.setValueAt("New Value " + (++nbre), this.row, this.column - 1);

			}

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fenetre5 fen = new Fenetre5();
		fen.setVisible(true);

	}

}
