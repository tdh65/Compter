import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ReqFrame extends JFrame {
	private String m_Requete = "" ;
	private JButton m_ok = new JButton("Go") ;
	private JTable m_jTable = new JTable(2, 5);
	private JTextArea jtextArea = new JTextArea(20 , 10) ;
	private long timeElapsed = 0 , time_deb, time_fin ;
	private JTextField jtextField = new JTextField("Duree : "  + timeElapsed ); 
	private Connection conn = null ;
	private ResultSetMetaData rsmd = null ;
	private JPanel panel = new JPanel() ;
	public ReqFrame() {
		
		// TODO Auto-generated constructor stub

		this.setTitle("TP Requete testeur");
		this.setLocationRelativeTo(null);
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(new BoxLayout(panel , BoxLayout.PAGE_AXIS ));
		//panel.setLayout(new BorderLayout());
		panel.add(m_ok);
		JPanel panel2 = new JPanel() ;
		panel2.setLayout(new GridLayout(2, 1));
		panel2.add(jtextArea );
		panel2.add(new JScrollPane(m_jTable) );
		panel.add( panel2 );
		//panel.add(m_jTable);
		panel.add(jtextField);
		this.getContentPane().add(panel);
		
		
		
		
	}
	private void excuteRequete(String pRequete ) {
		this.time_deb = System.currentTimeMillis();
		
		try {
			Class.forName("sun.jdbc.mysqlDriver") ;
		}catch(ClassNotFoundException cf) {
			cf.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection("jdbc:mysql://144.208.24.181:3306/test", "root", "bitnami") ;
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		try {
			Statement stmt = conn.prepareStatement(pRequete)  ;
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			/*
			 * message d erreur a traitrer dans le popup
			 */
			
		} 
		
		
		
	}

}
