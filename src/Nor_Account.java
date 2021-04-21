import java.util.ArrayList;

public class Nor_Account extends Account {
    private double fee;
    public Nor_Account(String STK, String passWord, Double SoDu, Double fee) {
        super(STK, passWord, SoDu);
        this.fee = fee;
    }

    public boolean banking(Account other, Double TienGui) {
        if(other.getClass().getName().equals("Nor_Account")) {
            this.setSoDu(this.getSoDu() - TienGui - this.fee);
            other.setSoDu(other.getSoDu() + TienGui);
            return true;
        }
        return false;
    }

}
