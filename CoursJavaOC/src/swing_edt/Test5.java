package swing_edt;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
// https://openclassrooms.com/courses/apprenez-a-programmer-en-java/mieux-gerer-les-interactions-avec-les-composants#/id/r-2185773
// SwingWorker
public class Test5 {

	static int count = 0, count2 = 0;
	static JButton bouton = new JButton("Pause");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame fen = new JFrame("EDT");
		fen.getContentPane().add(bouton);
		fen.setSize(200, 100);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.setLocationRelativeTo(null);
		fen.setVisible(true);
		updateBouton();
		System.out.println("Reprise du thread principal");

	}

	public static void updateBouton() {
		// on cree le swingworker generique cette fois
		SwingWorker sw = new SwingWorker<Integer, String>() {

			@Override
			protected Integer doInBackground() throws Exception {
				// TODO Auto-generated method stub
				int i ;
				for(i = 0 ; i < 5 ; i++) {
					try {
						// on change la propriete d 'etat
						setProgress(i);
					// on publie le resultat intermediaire 
						publish("Tour de boucle n° " + ( i+1) );
						Thread.sleep(1000);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
				return i;
			}
				public void done() {
					
					if(SwingUtilities.isEventDispatchThread())
						System.out.println("dans l'EDT");
					try {
						bouton.setText("Traitement termine au bout de " + get() + " fois !!");	
					}catch(InterruptedException e) {
						e.printStackTrace();
					}catch(ExecutionException e  ) {
						e.printStackTrace();
					}
					
				}
				public void process(List<String> list) {
					for(String str : list){
						System.out.println(str);
					}
				}
			
		};
		// on ecoute le changement de valeur pour la propriete 
		sw.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent arg0) {
				// TODO Auto-generated method stub
				if("progress".equals(arg0.getPropertyName())) {
					if(SwingUtilities.isEventDispatchThread())
						System.out.println("Dans le listener donc dans l'EDT");
					// on recupere la nouvelle valeur
					bouton.setText("Pause " + (Integer) arg0.getNewValue() );
				}
				
			}
			
		});
		// on lance le swingworker
		sw.execute();
	}
	
}


