package com.davidcryer.accountreminder.accountlist;

import android.os.Parcel;
import android.support.annotation.NonNull;

public class AccountListUiModelImpl implements AccountListUiModel {

    public AccountListUiModelImpl() {

    }

    @Override
    public void onto(@NonNull AccountListUi ui) {

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
