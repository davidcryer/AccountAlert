package com.davidcryer.accountalert.accountlist;

import com.davidc.uiwrapper.UiModel;
import com.davidcryer.accountalert.common.domain.AccountList;

interface AccountListUiModel extends UiModel<AccountListUi> {
    void accountList(AccountListUi ui, AccountList accounts);
}
