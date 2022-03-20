package account;

public class Enterprise extends Account {

    private User user;

    public Enterprise(User user) {
        super(user);
    }

    @Override
    public void signUp() {
        System.out.println("    CREATE A NEW ACCOUNT    ");
        System.out.println("============================");
        // Get input for new account.
        System.out.print("First Name: ");
        String firstname = input.next();
        this.getUser().setFirstname(firstname);

        System.out.print("Last Name: ");
        String lastname = input.next();
        this.getUser().setLastname(lastname);

        System.out.print("Email: ");
        String email = input.next();
        this.user.setEmail(email);

        System.out.print("Password: ");
        String password = input.next();
        this.user.setPassword(password);

        System.out.print("Job: ");
        String job = input.next();
        this.getUser().setJob(job);

        System.out.print("Age: ");
        int age = input.nextInt();
        this.getUser().setAge(age);

        // Check duplicate emails.
        for (Account account:AccountManager.getAccountsEnterprise()) {
            if (email.equals(account.getUser().getEmail())) {
                System.out.println("There is an account with this email. You may try Login.");
                return;
            }
        }

        // Adding to the list.
        AccountManager.addAccountsEnterprise(this);
        System.out.println("You've signed up the system.");
    }
}
