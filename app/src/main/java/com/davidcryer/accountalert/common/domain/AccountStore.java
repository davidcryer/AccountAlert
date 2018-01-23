package com.davidcryer.accountalert.common.domain;

import java.util.List;
import java.util.Map;
import java.util.UUID;

class AccountStore {
    private final AccountDb db;
    private final AccountCache cache;

    public AccountStore(AccountDb db, AccountCache cache) {
        this.db = db;
        this.cache = cache;
    }

    AccountList accountList() {
        return new AccountList(orderedAccounts(), accountMap());
    }

    private List<UUID> orderedAccounts() {
        final List<UUID> orderedAccounts;
        if (cache.hasOrderedAccounts()) {
            orderedAccounts = cache.orderedAccounts();
        } else {
            orderedAccounts = db.orderedAccounts();
            cache.orderedAccounts(orderedAccounts);
        }
        return orderedAccounts;
    }

    private Map<UUID, Account> accountMap() {
        final Map<UUID, Account> accountMap;
        if (cache.hasAccountMap()) {
            accountMap = cache.accountMap();
        } else {
            accountMap = db.accountMap();
            cache.accountMap(accountMap);
        }
        return accountMap;
    }

    Account add(final AccountSubmission submission) {
        final Account account = db.add(submission);
        cache.add(account);
        return account;
    }
}
