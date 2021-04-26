import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Sav_Account extends Account {
	private double rate;
    private Date date;
	
    public Sav_Account(String stk, String passWord, int soDu, String name, Date birthday, String address, String phone, String email
    		,double rate,Date date) {
    	super(stk, passWord, soDu, name, birthday, address, phone, email);
		this.date=date;
		this.rate=rate;
	}
    
	
    
    public double getRate() {
		return rate;
	}



	public void setRate(double rate) {
		this.rate = rate;
	}



	public String getDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String dateFormat = formatter.format(date);
		return dateFormat;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public long countDay()  {
        Date date;
        long noDay=-1;
		try {
			date = new SimpleDateFormat("yyy-MM-dd").parse(LocalDate.now().toString());
			noDay = (date.getTime() - this.date.getTime()) / (24 * 3600 * 1000);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return noDay;
    }

    public long interestCalc()  {
        double x = 0;
        if (this.rate == 6) {
            x = this.getSoDu()/(Math.pow(1 + 0.004, this.countDay()/30));
			x = x*(Math.pow(1 + 0.004, this.rate));
        }
        else if (this.rate == 12) {
            x = this.getSoDu()/(Math.pow(1 + 0.005, this.countDay()/30));
			x = x*(Math.pow(1 + 0.005, this.rate));
        }
        else {
            x = this.getSoDu()/(Math.pow(1 + 0.006, this.countDay()/30));
			x = x*(Math.pow(1 + 0.006, this.rate));
        }
        return Math.round(x);
    }
}