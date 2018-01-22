package com.davidcryer.accountreminder.common.framework.uiwrapper;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.davidc.uiwrapper.UiWrapper;
import com.davidcryer.accountreminder.accountlist.AccountListUiModelImpl;
import com.davidcryer.accountreminder.accountlist.AccountListUiWrapper;

public class UiWrapperFactory {

    public AccountListUiWrapper accountList(@Nullable final Bundle savedState) {
        return wrapper(
                savedState,
                () -> AccountListUiWrapper.newInstance(new AccountListUiModelImpl()),
                AccountListUiWrapper::savedInstance
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
