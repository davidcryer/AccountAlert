package com.davidcryer.accountreminder.accountlist;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.davidc.uiwrapper.UiWrapper;

public class AccountListUiWrapper extends UiWrapper<AccountListUi, AccountListUi.Listener, AccountListUiModel> {

    private AccountListUiWrapper(@NonNull AccountListUiModel uiModel) {
        super(uiModel);
    }

    public static AccountListUiWrapper newInstance(@NonNull final AccountListUiModel uiModel) {
        return new AccountListUiWrapper(uiModel);
    }

    public static AccountListUiWrapper savedInstance(@NonNull final Bundle savedState) {
        final AccountListUiModel uiModel = savedUiModel(savedState);
        return uiModel == null ? null : newInstance(uiModel);
    }

    @Override
    protected AccountListUi.Listener uiListener() {
        return new AccountListUi.Listener() {

        };
    }
}
