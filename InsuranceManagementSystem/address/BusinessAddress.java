package address;

public class BusinessAddress implements Address {
    private String city;
    private String country;
    private String street;
    private int buildingNo;
    private int id;
    private static int BusinessAdressCount = 1;

    @Override
    public void printAddress() {
        System.out.println("User's Business Address: (Unique ID: "+ this.getId() + ")");
        System.out.println("Street: " + this.street + ", Building No: " + this.buildingNo + " " + this.city + "/" + this.country);
        System.out.println("------------------------");
    }

    public BusinessAddress(String city, String country, String street, int buildingNo) {
        this.city = city;
        this.country = country;
        this.street = street;
        this.buildingNo = buildingNo;
        this.id = BusinessAdressCount++;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        if (this.getClass().getName().equals("BusinessAddress")) {
            BusinessAddress businessAddress = (BusinessAddress) obj;
            return (businessAddress.getId() != this.getId());
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

    public int getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(int buildingNo) {
        this.buildingNo = buildingNo;
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
