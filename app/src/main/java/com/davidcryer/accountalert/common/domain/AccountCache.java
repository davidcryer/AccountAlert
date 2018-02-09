package com.davidcryer.accountalert.common.domain;

import java.util.List;
import java.util.Map;
import java.util.UUID;

class AccountCache {
    private List<UUID> orderedAccounts;
    private Map<UUID, Account> accountMap;

    boolean hasOrderedAccounts() {
        return orderedAccounts != null;
    }

    List<UUID> orderedAccounts() {
        return orderedAccounts;
    }

    void orderedAccounts(final List<UUID> orderedAccounts) {
        this.orderedAccounts = orderedAccounts;

    }

    boolean hasAccountMap() {
        return accountMap != null;
    }

    Map<UUID, Account> accountMap() {
        return accountMap;
    }

    void accountMap(final Map<UUID, Account> accountMap) {
        this.accountMap = accountMap;
    }

    void add(final Account account) {
        orderedAccounts.add(account.id());
        accountMap.put(account.id(), account);
    }
}
