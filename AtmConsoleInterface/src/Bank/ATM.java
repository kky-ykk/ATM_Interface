package Bank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

//-------user define exception
class invalid extends Exception{
	public invalid(String str) {
		super(str);
	}
}

//----login checking classes -----------
class Check{
	String user_id;
	String password;
	
	void take() {
		System.out.println("Enter user name :");
		Scanner s=new Scanner(System.in);
		user_id=s.next();
		System.out.println("Enter password :");
		password=s.next();
	}
	
	boolean verify(String u,String p) throws invalid {
		boolean result=false;
		
		if(user_id.equals(u) && password.equals(p))
			result=true;
		else {
			throw new invalid("Invalid User name or password!"); 
		}
		return result;
	}
	
	
}

public class ATM {
	
	String u,p;
	int balance;
	
	//----file opeening for storing transactions
	PrintWriter pw;
	
	
	public ATM(String u,String p,int balance) {
		this.u=u;
		this.p=p;
		this.balance=balance;	
		
		//------------deleting transaction.txt file if already exist there
		try{
			File file=new File("transaction.txt");
			if(file.exists())
				file.delete();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public boolean login() {
		Check c=new Check();
		int option=2;
		boolean result=false;
		
		try {
			c.take();
			result=c.verify(u, p);
		} catch (invalid e) {
			System.out.println(e.getMessage()+" :"+(option--)+" available");
			try {				
				c.take();
				result=c.verify(u, p);
			}catch(invalid e1) {
				System.out.println(e.getMessage()+" :"+(option--)+" available");
				try {
					c.take();
					result=c.verify(u, p);
				}catch(invalid e2){
					System.out.println(e.getMessage()+" :"+(option--)+" available");
					System.out.println("Account BLOCKED!");
				}
				
			}
		}
		
		return result;
	}

	public void history() {
		System.out.println("history!");
		try(BufferedReader bw=new BufferedReader(new FileReader ("transaction.txt"))) {	
			String transaction=bw.readLine();
			
			while(transaction!=null){
				System.out.println(transaction);
				transaction=bw.readLine();
			}
		}catch(Exception e) {
			System.out.println("No transaction yet!");
		}
		
				
	}

	public void withdraw(int amount) {
		System.out.println("withdraw");
		if(balance>=amount) {			
			balance-=amount;
			writeToFile("withdraw",amount,balance);
		}else
			System.out.println("no sufficient!");
	}

	public void deposit(int amount) {
		System.out.println("deposit");
		balance+=amount;
		writeToFile("deposit",amount,balance);
		
		
	}

	public void transfer(String to,int amount) {
		System.out.println("transfer");
		if(balance>=amount) {
			balance-=amount;
			writeToFile(to,amount,balance);
		}
		else
			System.out.println("No Sufficient Balance!");
	}
	
	public void writeToFile(String to,int amount,int balance) {
		
		try {
			if(new File("transaction.txt").exists())
				pw=new PrintWriter(new FileWriter("transaction.txt",true));
			else
				pw=new PrintWriter(new FileWriter("transaction.txt"));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		pw.println( LocalDate.now() +"\t\t "+to+" \t\t "+amount+" \t\t"+balance);
		pw.close();
	}
	
	
}
