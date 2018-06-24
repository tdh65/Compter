package tTableau;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Fenetre3 extends JFrame {

	private JTable tableau;

	private JButton change = new JButton("Changer la taille");

	public Fenetre3() {

		this.setLocationRelativeTo(null);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setTitle("JTable3");

		this.setSize(600, 140);

		Object[][] data = {

				{ "Cysboy", new JButton("6boy"), 1,80 , true },

				{ "BZHHydde", new JButton("BZH"), 1,78 , false },

				{ "IamBow", new JButton("BoW"), 1,90 , false },

				{ "FunMan", new JButton("Year"), 1,85 , true }

		};

		String title[] = { "Pseudo", "Age", "Taille", "OK ?" };

		this.tableau = new JTable(data, title);

		this.getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);

	}

	public static void main(String[] args) {

		Fenetre fen = new Fenetre();

		fen.setVisible(true);

	}

}
