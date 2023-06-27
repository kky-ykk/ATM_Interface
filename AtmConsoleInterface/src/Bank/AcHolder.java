package Bank;

public class AcHolder {
		String name;
		Account account;
		
		AcHolder(String name,Account account){
			this.name=name;
			this.account=account;
		}

		public String getName() {
			return name;
		}

		public Account getAccount() {
			return account;
		}
		
		
}
