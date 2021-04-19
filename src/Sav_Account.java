public class Sav_Account extends Account {
    private double rate;
    public Sav_Account(String STK, String passWord, Double SoDu, Double rate) {
        super(STK, passWord, SoDu);
        this.rate = rate;
    }
}
