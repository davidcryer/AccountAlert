package com.davidcryer.accountalert.accountlist;

import android.support.annotation.Nullable;

import com.davidcryer.accountalert.common.domain.Account;
import com.davidcryer.accountalert.common.domain.AccountList;
import com.davidcryer.accountalert.common.domain.RepeatType;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

class UiAccountMapper {
    private final static String REPEAT_TYPE_NEVER = "Never";

    static List<UiAccount> from(final AccountList accountList) {
        return accountList.accounts().map(UiAccountMapper::from).collect(Collectors.toList());
    }

    private static UiAccount from(final Account account) {
        return new UiAccount(account.id(), account.title(), account.description(), from(account.expiry()), from(account.repeatType()));
    }

    private static String from(final Date expiry) {
        final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
        return dateFormat.format(expiry);
    }

    private static String from(@Nullable final RepeatType repeatType) {
        return repeatType == null ? REPEAT_TYPE_NEVER : repeatType.toString();
    }
}
