package com.davidcryer.accountalert.common.framework;

import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;

import com.davidcryer.accountalert.R;
import com.davidcryer.accountalert.accountlist.AccountListFragment;
import com.davidcryer.accountalert.accountlist.AccountListNavigator;
import com.davidcryer.accountalert.addaccount.AddAccountFragment;
import com.davidcryer.accountalert.common.Provider;
import com.davidcryer.simpleactivities.SimpleAppBarActivity;

public class AccountActivity extends SimpleAppBarActivity implements AccountListNavigator {
    private final static String FRAGMENT_ACCOUNT_LIST = "account list";
    private final static String FRAGMENT_ADD_ACCOUNT = "add account";

    @Override
    protected void setupActionBar(@NonNull ActionBar actionBar) {

    }

    @Override
    protected void addInitialFragment() {
        add(FRAGMENT_ACCOUNT_LIST, AccountListFragment::newInstance);
    }

    @Override
    public void showAddAccountFragment(Provider<AddAccountFragment> provider) {
        replace(FRAGMENT_ADD_ACCOUNT, provider::get, anims(R.anim.enter_bottom, 0), anims(R.anim.exit_bottom, 0));
    }
}
