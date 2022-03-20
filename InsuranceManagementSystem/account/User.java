package account;

import address.Address;

import java.util.ArrayList;
import java.util.Date;

public class User {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String job;
    private int age;
    private ArrayList<Address> HomeAddressList;
    private ArrayList<Address> BusinessAddressList;
    private Date lastSignIn;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Address> getHomeAddressList() {
        return HomeAddressList;
    }

    public void setHomeAddressList(ArrayList<Address> homeAddressList) {
        HomeAddressList = homeAddressList;
    }

    public ArrayList<Address> getBusinessAddressList() {
        return BusinessAddressList;
    }

    public void setBusinessAddressList(ArrayList<Address> businessAddressList) {
        BusinessAddressList = businessAddressList;
    }

    public Date getLastSignIn() {
        return lastSignIn;
    }

    public void setLastSignIn(Date lastSignIn) {
        this.lastSignIn = lastSignIn;
    }
}
