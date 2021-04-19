import java.util.ArrayList;

public class Nor_Account extends Account {
    private double fee;
    public Nor_Account(String STK, String passWord, Double SoDu, Double fee) {
        super(STK, passWord, SoDu);
        this.fee = fee;
    }

    public void banking(Nor_Account other, Double TienGui) {
        this.setSoDu(this.getSoDu() - TienGui - this.fee);
        other.setSoDu(other.getSoDu() + TienGui);
    }

    public static Nor_Account getAccount(String a, ArrayList<Nor_Account> lst) {
        Nor_Account x = new Nor_Account("0", "0", 0.0, 0.0);
        for (Nor_Account i:lst){
            if(i.getSTK().equals(a)){
                x = i;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        ArrayList<Nor_Account> listAccount = new ArrayList<Nor_Account>();
        Nor_Account a = new Nor_Account("22210003865667", "123456" , 1000000.0, 500.0);
        Nor_Account b = new Nor_Account("22210003865668", "123456" , 1000000.0, 500.0);
        listAccount.add(a);
        listAccount.add(b);
        a.banking(b, 50000.0);
        System.out.println(getAccount("22210003865667", listAccount));
        System.out.println(a);
        for(Nor_Account i:listAccount){
            System.out.println(i.getSoDu());
        }
    }
}
