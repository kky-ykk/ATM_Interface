package Bank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class checking {

	public static void main(String[] args) throws IOException {
		
		PrintWriter pw=new PrintWriter("transaction.txt");
		
		pw.println("10/2/2000 \t withdraw \t 1000 \t 9000");
		pw.println("11/2/2000 \t withdraw \t 2000 \t 7000");
		
		
		pw.close();
		
		//--------------------------------------
//		BufferedReader bw=new BufferedReader(new FileReader ("transaction.txt"));
//		
////		System.out.println("Name \t Type \t Dr\\Cr Amount \t Aval. Amount ");
//		
//		String transaction=bw.readLine();
//		
//		while(transaction!=null){
//			System.out.println(transaction);
//			transaction=bw.readLine();
//		}
//		
//		bw.close();
	}

}
