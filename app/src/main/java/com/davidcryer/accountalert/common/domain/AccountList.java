package com.davidcryer.accountalert.common.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Stream;

public class AccountList {
    private final List<UUID> accounts;
    private final Map<UUID, Account> accountMap;

    AccountList(List<UUID> accounts, Map<UUID, Account> accountMap) {
        this.accounts = new ArrayList<>(accounts);
        this.accountMap = new HashMap<>(accountMap);
    }

    public Stream<Account> accounts() {
        return accounts.stream().map(accountMap::get);
    }
}
