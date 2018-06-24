package dragndrop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TestDragnDrop extends JFrame {
	public TestDragnDrop() {
		super("Test du drag n drop ");
		setSize(300, 200);

		JPanel pan = new JPanel();
		pan.setBackground(Color.WHITE);
		pan.setLayout(new BorderLayout());

		// notre textarea avec son contenu deplacable
		JTextArea label = new JTextArea("Texte deplacable");
		label.setPreferredSize(new Dimension(300, 130));
		// ---------------------------------------------------------
		// c'est cette instruction qui permet le drag n drop
		label.setDragEnabled(true);
		// ---------------------------------------------------------

		pan.add(new JScrollPane(label), new BorderLayout().NORTH);

		JPanel pan2 = new JPanel();
		pan2.setBackground(Color.WHITE);
		pan2.setLayout(new BorderLayout());

		// on cree le premier txtfield avec le contenu deplacable
		JTextField text = new JTextField();
		// ---------------------------------------------------------
		// c'est cette instruction qui permet le drag n drop
		text.setDragEnabled(true);
		// ---------------------------------------------------------

		// et le second sans
		// on cree le premier txtfield avec le contenu deplacable
		JTextField text2 = new JTextField();
		// ---------------------------------------------------------
		// c'est cette instruction qui permet le drag n drop
		text2.setDragEnabled(false);
		// ---------------------------------------------------------
		
		pan2.add(text2, BorderLayout.SOUTH);
		pan2.add(text, BorderLayout.NORTH );
		
		pan.add(pan2, BorderLayout.SOUTH);
		add(pan,BorderLayout.CENTER);
		
		setVisible(true);
		
		

	}

	public static void main(String[] args) {

		new TestDragnDrop();

	}

}
