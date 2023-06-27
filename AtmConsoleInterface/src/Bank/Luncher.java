package Bank;

import java.io.IOException;

public class Luncher {

	public static void main(String[] args) throws IOException{
		
		
		Account ac=new Account(12345);
		AcHolder ah=new AcHolder("XXXX",ac);
		
		Bankk bank=new Bankk(ah);
		bank.display();
		
		if(bank.atmLogin())
			bank.showMenu();
		
		
	}

}
