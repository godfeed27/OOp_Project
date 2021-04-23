import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Sav_Account extends Account {
    private int rate;
    private Date date;
    public Sav_Account(String STK, String passWord, Double SoDu, int rate, Date date) {
        super(STK, passWord, SoDu);
        this.rate = rate;
        this.date = date;
    }

    public long countDay() throws ParseException {
        Date date = new SimpleDateFormat("yyy-MM-dd").parse(LocalDate.now().toString());
        long noDay = (date.getTime() - this.date.getTime()) / (24 * 3600 * 1000);
        return noDay;
    }

    public long interestCalc() throws ParseException {
        double x = 0;
        if (this.rate == 4) {
            x = this.getSoDu()*Math.pow(1 + 0.001, this.countDay()/30);
        }
        else if (this.rate == 12) {
            x = this.getSoDu()*Math.pow(1 + 0.002, this.countDay()/30);
        }
        else {
            x = this.getSoDu()*Math.pow(1 + 0.003, this.countDay()/30);
        }
        return Math.round(x);
    }
}
