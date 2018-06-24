package dragndrop;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.TransferHandler;

public class LabelContentDemo2 extends JFrame {
	public LabelContentDemo2(){
		setTitle("drag n drop avec un Jlabel ") ;
		setSize(300,100);
		setLocationRelativeTo(null) ;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(2, 2));
		pan.setBackground(Color.white);
		
		JLabel srclib = new JLabel("Source de drag : ", JLabel.RIGHT );
		JLabel src = new JLabel("Texte a deplacer !" );
		
		//-----------------------------------------------------------
		// on cree le nouvel objet pur activer le drag'ndrop
		src.setTransferHandler(new MyTransferHandler());
		
		// on specifie au composant qu il doit envoyer ses donnees via son objat transferhandler
		src.addMouseListener(new MouseAdapter() {
			// on utlise cet evenemeent pour que les actions soit visibles des le clic de souris
			// nous aurions pu utliser mouseReleased , mais niveau IHM nous n 'aurions rien vu
			public void mousePressed(MouseEvent e ) {
				System.out.println("Event" );
				// on recupere le JComponent 
				JComponent lab = (JComponent) e.getSource() ;
				// du composant on reucpere l'objet de transfert : le notre
				TransferHandler handle = lab.getTransferHandler();
				// on lui ordonne d'amorcer la procedure de drag'n drop 
				handle.exportAsDrag(lab, e, TransferHandler.COPY );
				/*
				 * UnJavaBean est un objet Java répondant à certains critères de construction :

    					- la classe doit être Serializable pour pouvoir sauvegarder et 
    						restaurer l'état des instances de cette classe ;

    					- la classe doit posséder un constructeur sans arguments (constructeur par défaut) ;

    					- les propriétés privées de la classe (variables d'instance) doivent être accessibles publiquement 
    						via des méthodes accesseurs (getouset) suivies du nom de la propriété avec la première lettre 
    						transformée en majuscule ;
						- la classe doit contenir les méthodes d'interception d'événements nécessaires.
				 */
				
			}
			
		});
		//--------------------------------------------------------------
		JLabel destLib = new JLabel("Destination de drag : ");
		JTextField dest = new JTextField();
		// on active le comportement par defaut 
		dest.setDragEnabled(true);
		
		pan.add(srclib);
		pan.add(src);
		pan.add(destLib);
		pan.add(dest);
		setContentPane(pan);
		setVisible(true);

		
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LabelContentDemo2();
	
	}

}
