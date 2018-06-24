package tpcalculatrice;
import java.text.DecimalFormat;
public class TestCalc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main0");
		String c  ="145696.2111425232336659" ;
		double a = 145696.2111425232;
		double b = a - Math.rint(a) ; 
		 
		System.out.println("rint " + Math.rint(a)  + " decimale : "  + (b) );
		System.out.println("Floor a " + Math.floor(a) + " floor rint a " + Double.valueOf(c).doubleValue() )  ;
		System.out.println("maximumFractionDigit  a " + FenCalc.decimal(a) + " floor rint a " + Double.valueOf(c).doubleValue() )  ;
		
		//FenetreGridLayout fen = new FenetreGridLayout();
		//FenCalc fec = new FenCalc();
		System.out.println("main1");

	}
   
}
