//Abstract class to reduce redundant code shared with Customers, Drivers, and Restaurants
public abstract class User {
    protected String name;
    protected String address;
    protected String county;

    public User(String name, String address, String county) {
        this.name = name;
        this.address = address;
        this.county = county;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCounty() {
        return county;
    }
}