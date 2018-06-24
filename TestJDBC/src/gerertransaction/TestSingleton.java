package gerertransaction;
//import gerertransaction.SdzConnection;
public class TestSingleton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < 4 ; i++)
			System.out.println("appel du N° " + i + " : " + SdzSingleton.getInstance().getName());

	}

}

