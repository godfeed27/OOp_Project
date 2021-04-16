import javax.xml.namespace.QName;

public class Inform {
    private String name;
    private String address;
    private String phone;
    private String email;
    public Inform(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
    public String toString() {
        return "name: " + this.name + "     phone: " + this.phone  + "\naddress: " + this.address + "\nemail: " + this.email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static void main(String[] args) {
        Inform a = new Inform("QA", "address", "phone", "email");
        System.out.println(a.toString());
    }
}
