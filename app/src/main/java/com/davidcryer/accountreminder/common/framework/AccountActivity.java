package com.davidcryer.accountreminder.common.framework;

import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;

import com.davidcryer.accountreminder.accountlist.AccountListFragment;
import com.davidcryer.simpleactivities.SimpleAppBarActivity;

public class AccountActivity extends SimpleAppBarActivity {
    private final static String FRAGMENT_ACCOUNT_LIST = "account list";

    @Override
    protected void setupActionBar(@NonNull ActionBar actionBar) {

    }

    @Override
    protected void addInitialFragment() {
        add(FRAGMENT_ACCOUNT_LIST, AccountListFragment::newInstance);
    }
}
