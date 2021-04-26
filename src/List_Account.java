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
        File Data = new File("File Input/Account.txt");
        try {
            BufferedReader data = new BufferedReader(new InputStreamReader(new FileInputStream(Data), "UTF8"));
            String line = data.readLine();
            while (line != null) {
                int c =Integer.parseInt(line);
                if (c == 0) {
                    String stk = data.readLine();
                    String passWord = data.readLine();
                    int SoDu = Integer.parseInt(data.readLine());
                    String name=data.readLine();
                    Date birthday = new SimpleDateFormat("dd/MM/yyyy").parse(data.readLine());
                    String address=data.readLine();
                    String phone=data.readLine();
                    String email=data.readLine();
                    int fee = Integer.parseInt(data.readLine());
                    lst.add(new Nor_Account(stk, passWord,SoDu, name, birthday, address, phone, email, fee));
                }
                else {
                    String stk = data.readLine();
                    String passWord = data.readLine();
                    int SoDu = Integer.parseInt(data.readLine());
                    String name=data.readLine();
                    Date birthday = new SimpleDateFormat("dd/MM/yyyy").parse(data.readLine());
                    String address=data.readLine();
                    String phone=data.readLine();
                    String email=data.readLine();
                    double rate = Double.parseDouble(data.readLine());
                    Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data.readLine());
                    lst.add(new Sav_Account(stk, passWord, SoDu, name, birthday, address, phone, email, rate, date));
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
    
    public int getAccount(String a) {
        int x = -1;
        for (Account i:this.lst){
            if(i.getSTK().equals(a)){
                x = lst.indexOf(i);
            }
        }
        return x;
    }
}
