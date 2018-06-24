package dragndrop;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.TransferHandler;

public class MyTransferHandler extends TransferHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * Méthode permettant à l'objet de savoir si les données reçues
	 * 
	 * via un drop sont autorisées à être importées
	 * 
	 * @param info
	 * 
	 * @return boolean
	 * 
	 */

	public boolean canImport(TransferHandler.TransferSupport info) {
		// on onctole si les donnees sont d'un type autorise ici STRING
		if (!(info.isDataFlavorSupported(DataFlavor.stringFlavor))) {
			return false;
		}
		return true;

	}

	/**
	 * 
	 * C'est ici que l'insertion des données dans notre composant est réalisée
	 * 
	 * @param support
	 * 
	 * @return boolean
	 * 
	 */

	public boolean importData(TransferHandler.TransferSupport support) {
		if (!canImport(support))
			return false;
		// on recupere notre objet transferable celui qui contient les donnees en
		// transit
		Transferable data = support.getTransferable();
		String str = "";
		try {
			// on recupere les données en specifiant ce qu'on attend
			str = (String) data.getTransferData(DataFlavor.stringFlavor);

		} catch (UnsupportedFlavorException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		// via le transferSupport on peut recuperer le composant
		JLabel lab = (JLabel) support.getComponent();
		// afin de lui affecter la nouvelle valeur
		lab.setText(str);

		return true;
	}

	/**
	 * 
	 * Cette méthode est invoquée à la fin de l'action DROP
	 * 
	 * Si des actions sont à faire ensuite, c'est ici qu'il faudra coder le
	 * comportement désiré
	 * 
	 * @param c
	 * 
	 * @param t
	 * 
	 * @param action
	 * 
	 */

	protected void exportDone(JComponent c, Transferable t, int action) {
		// Une fois le drop effectué nous effaçons le contenu de notre JLabel

		if (action == MOVE) {

			JLabel lab = (JLabel) c;
			String text = lab.getText();
			int indice = Integer.parseInt(text.substring(text.length() - 1, text.length()));
			lab.setText(text.substring(0, text.length() - 1) + (++indice));
		}
	}

	/**
	 * 
	 * Dans cette méthode, nous allons créer l'objet utilisé par le système de
	 * drag'n drop
	 * 
	 * afin de faire circuler les données entre les composants
	 * 
	 * Vous pouvez voir qu'il s'agit d'un objet de type Transferable
	 * 
	 * @param c
	 * 
	 * @return
	 * 
	 */

	protected Transferable createTransferable(JComponent c) {
		// On retourne un nouvel objet implémentant l'interface Transferable

		// StringSelection implémente cette interface, nous l'utilisons donc

		return new StringSelection(((JLabel) c).getText());
	}

	/**
	 * 
	 * Cette méthode est utilisée afin de déterminer le comportement
	 * 
	 * du composant vis-à-vis du drag'n drop : nous retrouverons
	 * 
	 * nos variables statiques COPY, MOVE, COPY_OR_MOVE, LINK ou NONE
	 * 
	 * @param c
	 * 
	 * @return int
	 * 
	 */

	public int getSourceActions(JComponent c) {
		// on n autorise que le deplacement
		return TransferHandler.MOVE;
	}

}
