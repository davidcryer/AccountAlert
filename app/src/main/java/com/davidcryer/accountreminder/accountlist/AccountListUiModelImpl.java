package com.davidcryer.accountreminder.accountlist;

import android.os.Parcel;
import android.support.annotation.NonNull;

import com.davidcryer.accountreminder.common.domain.AccountList;

import java.util.LinkedList;
import java.util.List;

public class AccountListUiModelImpl implements AccountListUiModel {
    private AccountList accountList;

    public AccountListUiModelImpl() {
        this.accountList = null;
    }

    @Override
    public void accountList(AccountListUi ui, AccountList accountList) {
        if (ui != null) {
            ui.accounts(uiAccounts(accountList));
        }
        this.accountList = accountList;
    }

    @Override
    public void onto(@NonNull AccountListUi ui) {
        ui.accounts(uiAccounts(accountList));
    }

    private static List<UiAccount> uiAccounts(final AccountList accountList) {
        return accountList == null ? new LinkedList<>() : UiAccountMapper.from(accountList);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    private AccountListUiModelImpl(Parcel in) {

    }

    public static final Creator<AccountListUiModelImpl> CREATOR = new Creator<AccountListUiModelImpl>() {
        @Override
        public AccountListUiModelImpl createFromParcel(Parcel source) {
            return new AccountListUiModelImpl(source);
        }

        @Override
        public AccountListUiModelImpl[] newArray(int size) {
            return new AccountListUiModelImpl[size];
        }
    };
}
