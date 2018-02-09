package com.davidcryer.accountalert.common.domain.argchecking;

import com.davidcryer.argrules.multiarg.Result;

import java.util.Date;

public class AccountInitialisationChecker extends AccountArgChecker<AccountInitialisationResults, BadAccountInitialisationException> {
    private final AccountInitialisationResults results;

    private AccountInitialisationChecker(final String title, final Result reminderResult) {
        results = new AccountInitialisationResults(titleResult(title), reminderResult);
    }

    public static void check(final String title, final Date reminder) throws BadAccountInitialisationException {
        new AccountInitialisationChecker(title, reminderResult(reminder)).check();
    }

    @Override
    protected AccountInitialisationResults results() {
        return results;
    }

    @Override
    protected BadAccountInitialisationException exception(AccountInitialisationResults results) {
        return new BadAccountInitialisationException(results);
    }
}
