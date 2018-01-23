package com.davidcryer.accountreminder.accountlist;

import com.davidcryer.accountreminder.common.domain.Account;
import com.davidcryer.accountreminder.common.domain.AccountList;
import com.davidcryer.accountreminder.common.domain.RepeatType;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

class UiAccountMapper {

    static List<UiAccount> from(final AccountList accountList) {
        return accountList.accounts().stream().map(UiAccountMapper::from).collect(Collectors.toList());
    }

    private static UiAccount from(final Account account) {
        return new UiAccount(account.id(), account.title(), account.description(), from(account.nextNotification()), from(account.repeatType()));
    }

    private static String from(final Date nextNotification) {
        return nextNotification.toString();
    }

    private static String from(final RepeatType repeatType) {
        return repeatType.toString();
    }
}
