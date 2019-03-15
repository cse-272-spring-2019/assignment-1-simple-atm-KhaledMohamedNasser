
public class ATM2 {
	private String IdNum = "1000";;
	private String password = "1000";
	private float CurrentBalance;

	

	ATM2() {
		this.CurrentBalance = (float) 0.0;

	}

	ATM2(float CurrentBalance) {
		this.CurrentBalance = CurrentBalance;
	}

	public float Withdraw(int cash) {
    if(cash>this.CurrentBalance && cash<50 && (cash%10>0) )
       {
           return 0;
					      }
	 else{
				                  this.CurrentBalance-=cash;
					          return CurrentBalance;
					          }
    }

	

	public void setCurrentBalance(float currentBalance) {
		CurrentBalance = currentBalance;
	}

	public float getCurrentBalance() {
		return CurrentBalance;
	}

	public float Deposit(int cash) {
		
			this.CurrentBalance += cash;
			return CurrentBalance;
		
	}

	public  boolean validate(String IdNum, String password) {
		return (this.IdNum.equals(IdNum) && this.password.equals(password));
	}
	public  boolean isNumericArray(String str) { 
	    for (char c : str.toCharArray())
	        if (c < '0' || c > '9')
	            return false;
	    return true;}

}
