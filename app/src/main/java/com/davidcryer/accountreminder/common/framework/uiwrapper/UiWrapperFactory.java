package com.davidcryer.accountreminder.common.framework.uiwrapper;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.davidc.uiwrapper.UiWrapper;
import com.davidcryer.accountreminder.accountlist.AccountListUiModelImpl;
import com.davidcryer.accountreminder.accountlist.AccountListUiWrapper;
import com.davidcryer.accountreminder.addaccount.AddAccountUiModelImpl;
import com.davidcryer.accountreminder.addaccount.AddAccountUiWrapper;
import com.davidcryer.accountreminder.common.domain.AddAccountInteractor;
import com.davidcryer.accountreminder.common.domain.GetAccountsInteractor;

public class UiWrapperFactory {
    private final GetAccountsInteractor getAccountsInteractor;
    private final AddAccountInteractor addAccountInteractor;

    public UiWrapperFactory(GetAccountsInteractor getAccountsInteractor, AddAccountInteractor addAccountInteractor) {
        this.getAccountsInteractor = getAccountsInteractor;
        this.addAccountInteractor = addAccountInteractor;
    }

    public AccountListUiWrapper accountList(@Nullable final Bundle savedState) {
        return wrapper(
                savedState,
                () -> AccountListUiWrapper.newInstance(new AccountListUiModelImpl(), getAccountsInteractor),
                nonNullSavedState -> AccountListUiWrapper.savedInstance(nonNullSavedState, getAccountsInteractor)
        );
    }

    public AddAccountUiWrapper addAccount(@Nullable final Bundle savedState) {
        return wrapper(
                savedState,
                () -> AddAccountUiWrapper.newInstance(new AddAccountUiModelImpl(), addAccountInteractor),
                nonNullSavedState -> AddAccountUiWrapper.savedInstance(nonNullSavedState, addAccountInteractor)
        );
    }

    private static <T extends UiWrapper> T wrapper(@Nullable final Bundle savedState, final NewWrapperProvider<T> newWrapperProvider, final SavedWrapperProvider<T> savedWrapperProvider) {
        if (savedState != null) {
            final T savedWrapper = savedWrapperProvider.from(savedState);
            if (savedWrapper != null) {
                return savedWrapper;
            }
        }
        return newWrapperProvider.get();
    }

    private interface NewWrapperProvider<T extends UiWrapper> {
        T get();
    }

    private interface SavedWrapperProvider<T extends UiWrapper> {
        T from(@NonNull Bundle savedState);
    }
}
