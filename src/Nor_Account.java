import java.util.Date;

public class Nor_Account extends Account {
	
	private int fee;
	
	public Nor_Account(String stk, String passWord, int soDu, String name, Date birthday, String address, String phone, String email,int fee) {
		super(stk, passWord, soDu, name, birthday, address, phone, email);
		this.fee=fee;
	}
    
	public int getFee(int TienGui) {
		return Math.max(5000, (int)(0.03*TienGui));
	}
	
	public void banking(Account other, int TienGui) {
    	this.fee=Math.max(5000, (int)(0.03*TienGui));
        this.setSoDu(this.getSoDu() - TienGui - this.fee);
        other.setSoDu(other.getSoDu() + TienGui); 
    }
}