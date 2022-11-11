import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
//import java.io.*;

public class OnİkiA {

	public static final File notDefteri = new File("notlar/notDefteri");

		public static void main(String[] args) {
			vize2NotGir ("100", 100);
		}
		public static void vize2NotGir(String ogrenciNo, int not) {
			
			try {
				BufferedReader okuyucu= new BufferedReader(new FileReader(notDefteri));
				//BufferedWriter yazici= new BufferedWriter(new FileWriter(notDefteri));
				
				String satir="";
				
				while((satir=okuyucu.readLine())!= null) {
				String[] veri= satir.split("-");
				for(int i=0; i<veri.length; i++) {
					System.out.print(veri[i]+ ",");
				}
				System.out.println("");
				}
				
			}catch (IOException ioe) {
				System.out.println("IOException hatasi var.");
			}
			}
		
		public static void finalNotGir(String ogrenciNo, int not) 
			
			{
				
			}
			
		public static void sonNotHesapla(String ogrenciNo, int not) 
			
			{
				
			}	
}
			
			
