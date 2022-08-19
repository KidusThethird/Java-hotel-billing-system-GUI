
package classes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Customer {
    private String firstname,lastname,phonenumber;
    private long tinnumber;
    private String ordertime;
    
    ArrayList<Commodity> purcheses;

    public Customer(String firstname, String lastname, String phonenumber, long tinnumber) {
        this.firstname = firstname;
        this.lastname = lastname;
            this.phonenumber = phonenumber;
        this.tinnumber = tinnumber;
        purcheses = new ArrayList<>();
        ordertime = ( LocalDate.now().format(DateTimeFormatter.ISO_DATE) + " " + LocalTime.now().format(DateTimeFormatter.ISO_TIME));
    }
    
    
    public void purchese(Commodity c) {
        purcheses.add(c);
    }
    public String[] getPurcheseReport() {
        String s[];
        s = new String[8+purcheses.size()];
        s[0] = "Hotel Billing System - bill report";
        s[1] = "time" + ordertime;
        s[2] = "customer info: ";
        s[3] = firstname + " " + lastname;
        s[4] = "phone: " + phonenumber;
        s[5] = "tin: " + tinnumber;
        s[6] = "";
        double totalsum = 0;
        for(int i=0;i<purcheses.size();i++) {
            s[i+7] = purcheses.get(i).getinfo();
            totalsum += purcheses.get(i).getTotalPrice();
        }
        s[7+purcheses.size()] = "total sum    " + totalsum;
        return s;
    }
    
}
