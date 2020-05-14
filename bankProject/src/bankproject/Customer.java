package bankproject;

import java.util.ArrayList;

public class Customer {
    int customerID ;
    String name, address, email, phone;
    ArrayList<Account> accountList;

    static int autoCountCustomerId;

    public Customer(String name, String address, String email, String phone) {
        this.customerID = autoCountCustomerId ++;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public void apendAccount(Account ac){
        this.accountList.add(ac);
    }
}
