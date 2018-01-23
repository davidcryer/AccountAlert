package com.davidcryer.accountreminder.accountlist;

import android.support.annotation.NonNull;

import java.util.List;

interface AccountListUi {
    void accounts(@NonNull List<UiAccount> accounts);
    void add(@NonNull UiAccount account);
    void showAddAccountUi();

    interface Listener {
        void onClickAddAccount(AccountListUi ui);
    }
}
