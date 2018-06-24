package gerertransaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) {
	    try {
	        Class.forName("org.postgresql.Driver");
	        String url = "jdbc:postgresql://192.168.1.53:5432/Ecole";
	        String user = "postgres";
	        String passwd = "bitnami";

	        Connection conn = DriverManager.getConnection(url, user, passwd);
	        // on desactive l autocommit
	        conn.setAutoCommit(false);
	        
	        //On autorise la mise à jour des données 
	        //Et la mise à jour de l'affichage

	        Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

	        PreparedStatement prepare = conn.prepareStatement("UPDATE PROFESSEUR SET prof_prenom = ? WHERE prof_nom= 'MAMOU'");
	        //On va chercher une ligne dans la base de données
	        //String query = "SELECT prof_id, prof_nom, prof_prenom FROM professeur " + "WHERE prof_nom = 'MAMOU'";
	        String query = "SELECT prof_id, prof_nom, prof_prenom FROM professeur ";
	        
	        ResultSet res = state.executeQuery(query);
	        res.first();
	        
	        //On affiche

	        System.out.println("\n\tDONNEES D'ORIGINE : ");

	        System.out.println("\t-------------------");

	        System.out.println("\tNOM : " + res.getString("prof_nom") + " - PRENOM : " +  res.getString("prof_prenom"));
	        
	        // on modifie les valeurs avec les parametres
	        prepare.setString(1,"Gérard");
	        // on execute 
	        prepare.executeUpdate();
	        
	        //On affiche

	        System.out.println("\n\tDONNEES D'ORIGINE : ");

	        System.out.println("\t-------------------");

	        System.out.println("\tNOM : " + res.getString("prof_nom") + " - PRENOM : " +  res.getString("prof_prenom"));
	        
	        
	        prepare.setString(1, "Daniel");
	        prepare.executeUpdate();
	        state.executeUpdate("INSERT INTO professeur (prof_nom, prof_prenom) VALUES('SALMON', 'Dylan')");
	        
	        
	        res = state.executeQuery(query);
	        res.first();
	        
	        System.out.println("\n\tDONNEES D'ORIGINE : ");

	        System.out.println("\t-------------------");

	        System.out.println("\tNOM : " + res.getString("prof_nom") + " - PRENOM : " +  res.getString("prof_prenom"));
	        
	        
	        
	        
	        res.close();
	        state.close();

	      } catch (Exception e) {
	        e.printStackTrace();
	      }
	    }
	public static void affiche(String str) {
		System.out.println(str);
	}

}
