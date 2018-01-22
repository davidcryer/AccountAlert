package com.davidcryer.accountreminder.accountlist;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.davidcryer.accountreminder.R;

class AccountLayoutInflater {

    AccountLayout inflateFrom(final ViewGroup group) {
        return (AccountLayout) LayoutInflater.from(group.getContext()).inflate(R.layout.list_item_account, group, false);
    }
}
