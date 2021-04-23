import java.util.Date;

public class Sav_Account extends Account {
    private double rate;
    private Date date;
    public Sav_Account(String STK, String passWord, Double SoDu, int rate, Date date) {
        super(STK, passWord, SoDu);
        this.rate = rate;
        this.date = date;
    }
    
}
