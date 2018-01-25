package com.davidcryer.accountalert.accountlist;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.davidcryer.accountalert.R;

class AccountLayoutInflater {

    AccountLayout inflateFrom(final ViewGroup group) {
        return (AccountLayout) LayoutInflater.from(group.getContext()).inflate(R.layout.holder_account, group, false);
    }
}
