package com.davidcryer.accountalert.common.domain;

public class GetAccountsTask {
    private final AccountStore store;

    public GetAccountsTask(AccountStore store) {
        this.store = store;
    }

    AccountList accountList() {
        return store.accountList();
    }
}
