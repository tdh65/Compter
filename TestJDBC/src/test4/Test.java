package test4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver ok ");

			String url = "jdbc:postgresql://192.168.1.53:5432/Ecole";
			String user = "postgres";
			String passwd = "bitnami";

			Connection conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("connexion effective");
			// creation dun objet statement
			Statement state = conn.createStatement(ResultSet.CONCUR_UPDATABLE , ResultSet.TYPE_SCROLL_INSENSITIVE);

			// l objet resultset contient le resultat de la requete sql
			ResultSet result = state
					.executeQuery("SELECT PROF_ID As ID, Prof_NOM as Nom , Prof_PRENOM as Prenom FROM PROFESSEUR ");
			// on recupere les metadatas
			ResultSetMetaData resultMeta = result.getMetaData();
			int i = 1;
			System.out.println("\n\t---------------------------------------");
			System.out.println("\tLECTURE STANDARD.");
			System.out.println("\t---------------------------------------");

			while (result.next()) {
				affiche("\tNom : " + result.getString("Nom") + "\tprénom : " + result.getString("Prenom"));
				// on regarde si c est le dernier resultat (derniere ligne )
				if (result.isLast())
					affiche("\t\t* DERNIER RESULTAT !\n");
				i++;
			}
			// une fois la lecture terminee on controle si on se trouve bien a l exterieru
			// de la ligne de resultat
			if (result.isAfterLast())
				affiche("Nous venons de terminer !\n");

			System.out.println("\t---------------------------------------");

			System.out.println("\tLecture en sens contraire.");

			System.out.println("\t---------------------------------------");

			while (result.previous()) {
				affiche("\tNom : " + result.getString("Nom") + "\tprénom : " + result.getString("Prenom"));
				if (result.isFirst())
					affiche("\t\t* RETOUR AU DEBUT !\n");
			}
			// on regarde si on se trouve bien avant la premiere ligne de resultat
			if(result.isBeforeFirst())
				affiche("\tNous venons de revenir au debut !\n");
			 
			System.out.println("\t---------------------------------------");

		      System.out.println("\tAprès positionnement absolu du curseur à la place N° "+ i/2 + ".");

		      System.out.println("\t---------------------------------------");
		      result.absolute(i/2);
		      while(result.next()) {
		    	  affiche("\tNom : " + result.getString("Nom") + "\tprénom : " + result.getString("Prenom"));
		      }
		      System.out.println("\t---------------------------------------");

		      System.out.println("\tAprès positionnement relatif du curseur à la place N° "+(i-(i-2)) + ".");

		      System.out.println("\t---------------------------------------");

		      //On place le curseur à la ligne actuelle moins i-2
		      //Si on n'avait pas mis de signe moins, on aurait avancé de i-2 lignes 

		      result.relative(-(i-2));

		      while(result.next())

		        System.out.println("\tNom : "+result.getString("Nom") +" \t prénom : "+result.getString("Prenom"));

		      //On positionne le curseur sur la ligne i/2
			// On se trouve alors à la fin

			// On peut parcourir le résultat en sens contraire

			result.close();

			state.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void affiche(String str) {
		System.out.println(str);
	}

}
