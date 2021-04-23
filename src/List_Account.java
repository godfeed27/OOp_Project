import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class List_Account {
    ArrayList<Account> lst = new ArrayList<Account>();

    public void setList(ArrayList<Account> lst) {
        this.lst = lst;
    }

    public List_Account() {
        super();
    }

    public void Create() throws IOException, ParseException {
        File Data = new File("Data/Account.txt");
        try {
            BufferedReader data = new BufferedReader(new InputStreamReader(new FileInputStream(Data), "UTF8"));
            String line = data.readLine();
            while (line != null) {
                int c =Integer.parseInt(line);
                if (c == 0) {
                    String STK = data.readLine();
                    String passWord = data.readLine();
                    double SoDu = Double.parseDouble(data.readLine());
                    double fee = Double.parseDouble(data.readLine());
                    lst.add(new Nor_Account(STK, passWord, SoDu, fee));
                }
                else {
                    String STK = data.readLine();
                    String passWord = data.readLine();
                    double SoDu = Double.parseDouble(data.readLine());
                    int rate = Integer.parseInt(data.readLine());
                    Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data.readLine());
                    lst.add(new Sav_Account(STK, passWord, SoDu, rate, date));
                }
                line = data.readLine();
            }
            data.close();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
}

    public void display() {
        for(Account i:this.lst) {
            System.out.println(i.getSTK());
        }
    }

    public int getAccount(String a) {
        int x = 0;
        for (Account i:this.lst){
            if(i.getSTK().equals(a)){
                x = lst.indexOf(i);
            }
        }
        return x;
    }

    public static void main(String[] args) throws IOException, ParseException {
        List_Account a = new List_Account();
        a.Create();
        System.out.println(a.lst.get(a.getAccount("1234")));
        a.display();
    }
}
