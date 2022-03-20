package account;

import java.util.TreeSet;

public class AccountManager {
    private static TreeSet<Individual> accountsIndividual = new TreeSet<>(new AccountComparator());
    private static TreeSet<Enterprise> accountsEnterprise = new TreeSet<>(new AccountComparator());

    public static void login(String email, String password, int choice) {
        if (choice == 1) {
            for (Individual account : accountsIndividual) {
                try {
                    account.login(email, password);
                } catch (InvalidAuthenticationException e) {
                    if (email.equals(account.getUser().getEmail()) && !password.equals(account.getUser().getPassword())) {
                        System.out.println("The email or password wrong, Try again..");
                    } else {
                        System.out.println();
                        System.out.println("Such an account does not exist in the system.");
                        System.out.println("If you don't have an account, you need to sign up.");
                    }
                }
            }
        } else if (choice == 2){
            for (Enterprise account:accountsEnterprise) {
                try {
                    account.login(email, password);
                } catch (InvalidAuthenticationException e) {
                    if (email.equals(account.getUser().getEmail()) && !password.equals(account.getUser().getPassword())) {
                        System.out.println("The email exists in the system. However, password is wrong. Please, enter password again.");
                    } else {
                        System.out.println();
                        System.out.println("Account not found.");
                        System.out.println("If you don't have an account, you need to sign up.");
                    }
                }
            }
        }
        if (accountsIndividual.isEmpty() && accountsEnterprise.isEmpty()) {
            System.out.println("Account not found.");
            System.out.println("If you don't have an account, you need to sign up.");
        }
    }

    public static TreeSet<Individual> getAccountsIndividual() {
        return accountsIndividual;
    }

    public static void addAccountsIndividual(Individual account) {
        accountsIndividual.add(account);
    }

    public static TreeSet<Enterprise> getAccountsEnterprise() {
        return accountsEnterprise;
    }

    public static void addAccountsEnterprise(Enterprise account) {
        accountsEnterprise.add(account);
    }
}
