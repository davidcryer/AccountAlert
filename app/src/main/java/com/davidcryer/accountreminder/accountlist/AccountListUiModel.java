package com.davidcryer.accountreminder.accountlist;

import com.davidc.uiwrapper.UiModel;
import com.davidcryer.accountreminder.common.domain.AccountList;

interface AccountListUiModel extends UiModel<AccountListUi> {
    void accountList(AccountListUi ui, AccountList accounts);
}
