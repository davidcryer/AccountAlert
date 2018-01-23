package com.davidcryer.accountreminder.common.domain;

import java.util.List;
import java.util.Map;
import java.util.UUID;

class AccountCache {
    private List<UUID> accountList;
    private Map<UUID, Account> accountMap;

    AccountList accountList() {
        return new AccountList(accountList, accountMap);
    }

    void accountList(final List<UUID> accountList, final Map<UUID, Account> accountMap) {
        this.accountList = accountList;
        this.accountMap = accountMap;
    }

    void add(final Account account) {
        accountList.add(account.id());
        accountMap.put(account.id(), account);
    }
}
