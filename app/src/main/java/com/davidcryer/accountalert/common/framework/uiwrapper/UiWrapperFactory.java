package com.davidcryer.accountalert.common.framework.uiwrapper;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.davidc.uiwrapper.UiWrapperInitializer;
import com.davidcryer.accountalert.accountlist.AccountListUiModelImpl;
import com.davidcryer.accountalert.accountlist.AccountListUiWrapper;
import com.davidcryer.accountalert.addaccount.AddAccountUiModelImpl;
import com.davidcryer.accountalert.addaccount.AddAccountUiWrapper;
import com.davidcryer.accountalert.common.domain.AddAccountInteractor;
import com.davidcryer.accountalert.common.domain.GetAccountsInteractor;

public class UiWrapperFactory {
    private final GetAccountsInteractor getAccountsInteractor;
    private final AddAccountInteractor addAccountInteractor;

    public UiWrapperFactory(GetAccountsInteractor getAccountsInteractor, AddAccountInteractor addAccountInteractor) {
        this.getAccountsInteractor = getAccountsInteractor;
        this.addAccountInteractor = addAccountInteractor;
    }

    public AccountListUiWrapper accountList(@Nullable final Bundle savedState) {
        return UiWrapperInitializer.from(
                savedState,
                () -> AccountListUiWrapper.newInstance(new AccountListUiModelImpl(), getAccountsInteractor),
                nonNullSavedState -> AccountListUiWrapper.savedInstance(nonNullSavedState, getAccountsInteractor)
        );
    }

    public AddAccountUiWrapper addAccount(@Nullable final Bundle savedState) {
        return UiWrapperInitializer.from(
                savedState,
                () -> AddAccountUiWrapper.newInstance(new AddAccountUiModelImpl(), addAccountInteractor),
                nonNullSavedState -> AddAccountUiWrapper.savedInstance(nonNullSavedState, addAccountInteractor)
        );
    }
}
