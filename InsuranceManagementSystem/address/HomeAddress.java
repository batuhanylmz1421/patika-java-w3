package address;

public class HomeAddress implements Address {
    private String city;
    private String country;
    private String street;
    private int houseNo;
    private int id;
    private static int HomeAdressCount = 1;

    @Override
    public void printAddress() {
        System.out.println("User's Home Address: (Unique ID: "+ this.getId() + ")");
        System.out.println(this.street + ", House No: " + this.houseNo + this.city + "/" + this.country);
        System.out.println("------------------------");
    }

    public HomeAddress(String city, String country, String street, int houseNo) {
        this.city = city;
        this.country = country;
        this.houseNo = houseNo;
        this.street = street;
        this.id = HomeAdressCount++;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        if (this.getClass().getName().equals("HomeAddress")) {
            HomeAddress homeAddress = (HomeAddress) obj;
            return (homeAddress.getId() != this.getId());
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        return this.id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
