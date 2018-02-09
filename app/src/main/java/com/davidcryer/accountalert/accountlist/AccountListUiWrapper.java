package com.davidcryer.accountalert.accountlist;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.davidc.uiwrapper.UiWrapper;
import com.davidcryer.accountalert.common.domain.GetAccountsInteractor;

public class AccountListUiWrapper extends UiWrapper<AccountListUi, AccountListUi.Listener, AccountListUiModel> {
    private final GetAccountsInteractor getAccountsInteractor;

    private AccountListUiWrapper(@NonNull AccountListUiModel uiModel, GetAccountsInteractor getAccountsInteractor) {
        super(uiModel);
        this.getAccountsInteractor = getAccountsInteractor;
    }

    public static AccountListUiWrapper newInstance(@NonNull final AccountListUiModel uiModel, final GetAccountsInteractor getAccountsInteractor) {
        return new AccountListUiWrapper(uiModel, getAccountsInteractor);
    }

    public static AccountListUiWrapper savedInstance(@NonNull final Bundle savedState, final GetAccountsInteractor getAccountsInteractor) {
        final AccountListUiModel uiModel = savedUiModel(savedState);
        return uiModel == null ? null : newInstance(uiModel, getAccountsInteractor);
    }

    @Override
    protected void registerResources() {
        super.registerResources();
        getAccountsInteractor.perform(accountList -> uiModel().accountList(ui(), accountList));
    }

    @Override
    protected AccountListUi.Listener uiListener() {
        return new AccountListUi.Listener() {
            @Override
            public void onClickAddAccount(AccountListUi ui) {
                ui.showAddAccountUi();
            }
        };
    }
}
