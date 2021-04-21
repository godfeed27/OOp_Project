import java.util.ArrayList;

public class List_Account {
    ArrayList<Account> lst = new ArrayList<Account>();

    public void setList(ArrayList<Account> lst) {
        this.lst = lst;
    }

    public List_Account() {
        super();
    }

    public void Create() {
        ArrayList<Account> lst = new ArrayList<Account>();
        Account a = new Account("22210003865667", "123456" , 1000000.0);
        Account b = new Account("22210003865668", "123456" , 1000000.0);
        lst.add(a);
        lst.add(b);
    }

    public void display() {
        for(Account i:this.lst) {
            System.out.println(i.getSTK());
        }
    }

    public Account getAccount(String a, List_Account list) {
        Account x = new Account("0", "0",0.0);
        for (Account i:this.lst){
            if(i.getSTK().equals(a)){
                x = i;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        List_Account a = new List_Account();
        // System.out.println(a);
        a.Create();
        a.display();
    }
}
