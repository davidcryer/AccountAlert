package com.davidcryer.accountalert.common.framework.navigators;

import com.davidcryer.accountalert.addaccount.AddAccountFragment;
import com.davidcryer.accountalert.common.Provider;

public interface ToAddAccount {
    void showAddAccountFragment(final Provider<AddAccountFragment> provider);
}
