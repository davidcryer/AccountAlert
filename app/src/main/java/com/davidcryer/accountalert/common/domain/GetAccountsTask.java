package com.davidcryer.accountalert.common.domain;

class GetAccountsTask {
    private final AccountStore store;

    GetAccountsTask(AccountStore store) {
        this.store = store;
    }

    AccountList accountList() {
        return store.accountList();
    }
}
