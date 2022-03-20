package account;

import account.Account;

import java.util.Comparator;

public class AccountComparator  implements Comparator<Account> {
    @Override
    public int compare(Account o1, Account o2) {
        return o1.getUser().getLastname().compareTo(o2.getUser().getLastname());
    }
}