public abstract class Account {
    private Double SoDu;
    private String STK;
    private String PassWord;
    public Account(String STK, String passWord, Double SoDu) {
        this.SoDu = SoDu;
        this.STK = STK;
        this.PassWord = PassWord;
    }
    public void setSoDu(Double SoDu) {
        this.SoDu = SoDu;
    }
    public Double getSoDu() {
        return this.SoDu;
    }
    public String getSTK() {
        return this.STK;
    }
}
