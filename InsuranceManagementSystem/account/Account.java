package account;

import address.AddressManager;
import address.BusinessAddress;
import address.HomeAddress;
import insurance.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public abstract class Account {
    private User user;
    AuthenticationStatus authStatus;
    Scanner input = new Scanner(System.in);
    private ArrayList<Insurance> insuranceList = new ArrayList<>();

    public Account(User user) {
        this.user = user;
    }

    public void accountMenu() {
        boolean isExit = false;

        while (!isExit) {
            System.out.println("Main Menu for " + this.getUser().getFirstname() + " " + this.getUser().getLastname() + ".");
            System.out.println("---------------------------------------");
            System.out.println("1 - Show Account Information");
            System.out.println("2 - Show Addresses");
            System.out.println("3 - Add Addresses");
            System.out.println("4 - Add Insurance");
            System.out.println("5 - Show Insurance");
            System.out.println("6 - Calculate the total cost of your insurances");
            System.out.println("0 - Logout the account");
            System.out.print("Enter option: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    this.showUserInfo();
                    break;
                case 2:
                    this.showAddresses();
                    break;
                case 3:
                    this.addAddress();
                    break;
                case 4:
                    this.addInsurance();
                    break;
                case 5:
                    this.showInsuranceList();
                    break;
                case 6:
                    this.calculateTotalCost();
                    break;
                case 0:
                    System.out.println("Logging out.");
                    isExit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    public void addAddress() {
        String street, city, country;
        int houseNo, buildingNo;
        boolean isExit = false;

        while (!isExit) {
            System.out.println("\n1 - Home Addresses");
            System.out.println("2 - Business Addresses");
            System.out.println("0 - Go Back To Menu");
            System.out.print("Enter option: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    // Getting home address details.
                    System.out.println("For Home Address:");

                    System.out.print("Street Name: ");
                    street = input.next();

                    System.out.print("House No: ");
                    houseNo = input.nextInt();

                    System.out.print("City: ");
                    city = input.next();

                    System.out.print("Country: ");
                    country = input.next();

                    HomeAddress newHomeAddress = new HomeAddress(city, country, street, houseNo);

                    AddressManager.addHomeAddress(newHomeAddress);
                    break;
                case 2:
                    System.out.println("For Home Address:");

                    System.out.print("Street Name: ");
                    street = input.next();

                    System.out.print("Building No: ");
                    buildingNo = input.nextInt();

                    System.out.print("City: ");
                    city = input.next();

                    System.out.print("Country: ");
                    country = input.next();

                    BusinessAddress newBusinessAddress = new BusinessAddress(city, country, street, buildingNo);

                    AddressManager.addBusinessAddress(newBusinessAddress);
                    break;
                case 0:
                    System.out.println("Returning to Account Menu.");
                    isExit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public void addInsurance() {
        boolean isExit = false;

        while (!isExit) {
            System.out.println("\nInsurance Types");
            System.out.println("1 - Car Insurance");
            System.out.println("2 - Health Insurance");
            System.out.println("3 - Residence Insurance");
            System.out.println("4 - Travel Insurance");
            System.out.println("0 - Back To Account Menu");
            System.out.print("Enter option: ");
            int choice = input.nextInt();

            // Getting today's date.
            Date today = Calendar.getInstance().getTime();
            Date dueDate = null;

            switch (choice) {
                case 1:
                    // 60 days later
                    dueDate = new Date(today.getTime() + (1000 * 60 * 60 * 24 * 60));
                    insuranceList.add(new CarInsurance("InsuranceCar", 60.0, today, dueDate));
                    break;
                case 2:
                    // 100 days later
                    dueDate = new Date(today.getTime() + (1000 * 60 * 60 * 24 * 100));
                    insuranceList.add(new HealthInsurance("InsuranceHealth", 80.0, today, dueDate));
                    break;
                case 3:
                    // 360 days later
                    dueDate = new Date(today.getTime() + (1000 * 60 * 60 * 24 * 360));
                    insuranceList.add(new ResidenceInsurance("InsuranceResidence", 90.0, today, dueDate));
                    break;
                case 4:
                    // 30 days later
                    dueDate = new Date(today.getTime() + (1000 * 60 * 60 * 24 * 30));
                    insuranceList.add(new TravelInsurance("InsuranceTravel", 40.0, today, dueDate));
                    break;
                case 0:
                    System.out.println("Returning to Account Menu.");
                    isExit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public void showInsuranceList() {
        int count = 1;
        System.out.println("Users Insurances: ");
        for (Insurance insurance : insuranceList) {
            System.out.println(count++ + " - " + insurance.getClass().getSimpleName());
        }
    }

    public final void showUserInfo() {
        System.out.println("User Information: ");
        System.out.println("First Name : " + user.getFirstname());
        System.out.println("Last Name  : " + user.getLastname());
        System.out.println("Email      : " + user.getEmail());
        System.out.println("Job        : " + user.getJob());
        System.out.println("Age        : " + user.getAge());
        System.out.println("Last Login : " + Calendar.getInstance().getTime());
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void login(String email, String password) throws InvalidAuthenticationException {
        // Getting authentication Status
        if (email.equals(this.getUser().getEmail()) && password.equals(user.getPassword())) {
            authStatus = AuthenticationStatus.SUCCESS;
        } else {
            authStatus = AuthenticationStatus.FAIL;
        }

        if(authStatus == AuthenticationStatus.SUCCESS) {
            System.out.println("You've succeeded in logging in your account.");
            this.accountMenu();
        }
        else {
            throw new InvalidAuthenticationException("Invalid Authentication");
        }
    }

    public void showAddresses() {
        boolean isExit = false;

        while (!isExit) {
            System.out.println("\n1 - Home Addresses");
            System.out.println("2 - Business Addresses");
            System.out.println("0 - Return To Menu");
            System.out.print("Enter option: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("\nHome Addressess");
                    System.out.println("------------------------");

                    for (HomeAddress homeAddress : AddressManager.getHomeAddressList()) {
                        homeAddress.printAddress();
                    }
                    break;
                case 2:
                    System.out.println("\nBusiness Addressess");
                    System.out.println("------------------------");

                    for (BusinessAddress businessAddress : AddressManager.getBusinessAddressList()) {
                        businessAddress.printAddress();
                    }
                    break;
                case 0:
                    System.out.println("Returning to Account Menu.");
                    isExit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public void calculateTotalCost() {
        int totalFee = 0;
        for (Insurance insurance : insuranceList) {
            totalFee += insurance.calculate();
        }

        // Print total cost.
        System.out.println("\nYour total insurance cost : " + totalFee + " TL.");
    }

    public void signUp() {
    }

}
