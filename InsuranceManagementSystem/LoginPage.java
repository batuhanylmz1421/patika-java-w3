import account.AccountManager;
import account.Enterprise;
import account.Individual;
import account.User;

import java.util.Scanner;

public class LoginPage {
    Scanner input = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\n-------- Insurance Management System --------\n");
            System.out.println("1 - Log In");
            System.out.println("2 - Sign Up");
            System.out.println("0 - Exit");
            System.out.print("Enter option: ");
            int choice = input.nextInt();
            int choiceAccount;
            String emailInput;
            String passwordInput;
            boolean isExit = false;

            switch (choice) {
                case 1:
                    System.out.println();
                    System.out.println("Login Your Account");
                    System.out.println("------------------------");
                    System.out.println("1 - Individual Account");
                    System.out.println("2 - Enterprise Account");
                    System.out.println("0 - Return to Main Menu");
                    System.out.print("Enter option: ");
                    choiceAccount = input.nextInt();

                    switch (choiceAccount) {
                        case 1:
                            System.out.println("\n------Individual Account------");

                            System.out.print("Email: ");
                            emailInput = input.next();

                            System.out.print("Password: ");
                            passwordInput = input.next();

                            AccountManager.logIn(emailInput, passwordInput, choiceAccount);
                            break;
                        case 2:
                            System.out.println("\n------Enterprise Account------");

                            System.out.print("Email: ");
                            emailInput = input.next();

                            System.out.print("Password: ");
                            passwordInput = input.next();

                            AccountManager.logIn(emailInput, passwordInput, choiceAccount);
                            break;
                        case 0:
                            System.out.println("Leaving Menu.");
                            break;
                    }
                    break;
                case 2:
                    System.out.println();
                    System.out.println("Sign Up Your Account");
                    System.out.println("------------------------");
                    System.out.println("1 - Individual Account");
                    System.out.println("2 - Enterprise Account");
                    System.out.println("0 - Go Back To Main Menu");
                    System.out.print("Enter option: ");
                    choiceAccount = input.nextInt();

                    switch (choiceAccount) {
                        case 1:
                            System.out.println();
                            System.out.println("------Individual Account------");
                            Individual accountIndividual = new Individual(new User());
                            accountIndividual.signUp();
                            break;
                        case 2:
                            System.out.println();
                            System.out.println("------Enterprise Account------");
                            Enterprise accountEnterprise = new Enterprise(new User());
                            accountEnterprise.signUp();
                            break;
                        case 0:
                            System.out.println("Returning to Main Menu.");
                            break;
                    }
                    break;
                case 0:
                    isExit = true;
                    break;
                default:
                    System.out.println("Invalid Input! Please enter valid option.");

            }

            if (isExit) {
                System.out.println("Shutting down the system.");
                break;
            }
        }
    }
}
