package com.davidcryer.accountalert.common.domain;

class AccountStore {
    private final AccountCache cache;

    AccountStore(AccountCache cache) {
        this.cache = cache;
    }

    AccountList accountList() {
        return cache.accountList();
    }

    void add(final Account account) {
        //TODO save to db
        cache.add(account);
    }
}
