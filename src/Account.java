public class Account {
    private int SoDu;
    private String STK;
    private String PassWord;
    public Account(String STK, String passWord, int SoDu) {
        this.SoDu = SoDu;
        this.STK = STK;
        this.PassWord = PassWord;
    }
    public int getSoDu() {
        return this.SoDu;
    }
    public String getSTK() {
        return this.STK;
    }
}
