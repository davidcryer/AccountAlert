package com.davidcryer.accountalert.accountlist;

import com.davidcryer.accountalert.common.domain.Account;
import com.davidcryer.accountalert.common.domain.AccountList;
import com.davidcryer.accountalert.common.domain.RepeatType;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

class UiAccountMapper {

    static List<UiAccount> from(final AccountList accountList) {
        return accountList.accounts().map(UiAccountMapper::from).collect(Collectors.toList());
    }

    private static UiAccount from(final Account account) {
        return new UiAccount(account.id(), account.title(), account.description(), from(account.reminder()), from(account.repeatType()));
    }

    private static String from(final Date reminder) {
        return reminder.toString();
    }

    private static String from(final RepeatType repeatType) {
        return repeatType.toString();
    }
}
