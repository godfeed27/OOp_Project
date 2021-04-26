import java.text.SimpleDateFormat;
import java.util.Date;

public class Account {
	
	private int SoDu;
    private String STK;
    private String PassWord;
    private String name;
    private Date birthday;
	private String address;
    private String phone;
    private String email;
    
  
	public Account(String stk, String passWord,int soDu, String name,Date birthday, String address, String phone, String email) {
		this.SoDu = soDu;
		this.STK = stk;
		this.PassWord = passWord;
		this.name = name;
		this.birthday=birthday;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}



	public int getSoDu() {
		return SoDu;
	}

	public void setSoDu(int soDu) {
		SoDu = soDu;
	}

	public String getSTK() {
		return STK;
	}

	public String getPassWord() {
		return PassWord;
	}

	public void setPassWord(String passWord) {
		PassWord = passWord;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
   
	public String getBirthday() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String dateFormat = formatter.format(birthday);
		return dateFormat;
	}
}

