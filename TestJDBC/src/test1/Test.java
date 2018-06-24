package test1;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test {
	

	public static void main(String[] args)  {
	try
	{
		Class.forName("org.postgresql.Driver");
		System.out.println("Driver ok ");

		String url = "jdbc:postgresql://192.168.1.53:5432/Ecole";
		String user = "postgres";
		String passwd = "bitnami";

		Connection conn = DriverManager.getConnection(url, user, passwd);
		System.out.println("connexion effective");
	}catch(Exception e)
	{
		e.printStackTrace();
	}
}

}
