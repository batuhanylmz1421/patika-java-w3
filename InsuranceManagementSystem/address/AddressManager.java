package address;

import java.util.HashSet;

public class AddressManager {
    static HashSet<HomeAddress> homeAddressList = new HashSet<>();
    static HashSet<BusinessAddress> businessAddressList = new HashSet<>();

    public static HashSet<HomeAddress> getHomeAddressList() {
        return homeAddressList;
    }

    public static void addHomeAddress(HomeAddress HomeAddress) {
        homeAddressList.add(HomeAddress);
    }

    public static HashSet<BusinessAddress> getBusinessAddressList() {
        return businessAddressList;
    }

    public static void addBusinessAddress(BusinessAddress BusinessAddress) {
        businessAddressList.add(BusinessAddress);
    }
}
