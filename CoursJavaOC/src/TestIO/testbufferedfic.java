package TestIO;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
public class testbufferedfic {
	
	public static void main(String[] args) {
		
		DataInputStream dis ;
		DataOutputStream dos; 
		try {
			dos = new DataOutputStream( 
					new BufferedOutputStream(
							new FileOutputStream(
									new File("sdz.txt")
									
									)
							)
					);
					// on ecrit chaque type primitif 
					dos.writeBoolean(true);
			dos.writeByte(100);
			dos.writeChar('C');
			dos.writeDouble(12.25);
			dos.writeFloat(12.4587f);
			dos.writeLong(123345656532311554L);
			dos.writeShort(12);
			dos.close();
			// on recupere les donnees 
			dis = new DataInputStream(
					new BufferedInputStream(
							new FileInputStream( 
									new File("sdz.txt"))
							)
					
					);
			System.out.println(dis.readBoolean());
			System.out.println(dis.readByte());
			System.out.println(dis.readChar());
			System.out.println(dis.readDouble());
			System.out.println(dis.readFloat());
			System.out.println(dis.readLong());
			System.out.println(dis.readShort());
			dis.close();
					
			
		}catch (FileNotFoundException ex ) {
			ex.printStackTrace();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
	}

}
