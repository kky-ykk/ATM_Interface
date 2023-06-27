package Bank;

import java.io.IOException;
import java.util.Scanner;

public class Bankk {
	
	AcHolder ah;
	private String u="kishan123";
	private String p="123";
	int balance=10000;
	int amount;
	ATM atm=new ATM(u,p,balance);
	
	public String getU() {
		return u;
	}

	public void setU(String u) {
		this.u = u;
	}

	public String getP() {
		return p;
	}

	public void setP(String p) {
		this.p = p;
	}

	public Bankk(AcHolder ah) {
		this.ah=ah;
	}
	

	void display() {
		System.out.println("-----WELCOME----");
		System.out.println("Name :"+ah.getName());
		System.out.println("Account no:"+ah.getAccount().getAccount());
	}
	
	boolean atmLogin() {
		boolean flag=false;
		if(atm.login()) {
			System.out.println("Successfull login");
			flag=true;
		}
		else
			System.out.println("Unsuccessfull");
		return flag;
	}
	
	void showMenu() throws IOException {
		while(true) {
			System.out.println("----------CHOOSE ONE OPTION AMONG BELOW----");
			System.out.println("1)History");
			System.out.println("2)withdraw");
			System.out.println("3)Deposit");
			System.out.println("4)Transfer");
			System.out.println("5)Quite");
			
			int option;
			Scanner s=new Scanner(System.in);
			System.out.println("Enter here👉👉 ::");
			option=s.nextInt();
			
			switch(option) {
				case 1:
					atm.history();
					break;
				case 2:
					System.out.println("Enter Amount to withdraw:\t\t\tAvl."+balance);
					amount=s.nextInt();
					atm.withdraw(amount);
					break;
				case 3: 
					System.out.println("Enter Amount ot deposit:\t\t\tAvl."+balance);
					amount=s.nextInt();
					atm.deposit(amount);
					break;
				case 4:
					System.out.println("Enter receiver name:\t\t\tAvl."
							+ ""+balance);
					String name=s.next();
					System.out.println("Enter Amount ot transfer:");
					amount=s.nextInt();
					atm.transfer(name,amount);
					break;
					
				case 5:
					System.out.println("------------Thank you------");
					System.exit(0);
				default:
					System.out.println("Select valid option!");
			}
		}
	}
	
	
}
