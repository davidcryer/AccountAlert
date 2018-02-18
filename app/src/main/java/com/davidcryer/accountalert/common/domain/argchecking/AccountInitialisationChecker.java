package com.davidcryer.accountalert.common.domain.argchecking;

import com.davidcryer.argrules.multiarg.Result;

import java.util.Date;

public class AccountInitialisationChecker extends AccountArgChecker<AccountInitialisationResults, BadAccountInitialisationException> {
    private final AccountInitialisationResults results;

    private AccountInitialisationChecker(final String title, final Result expiryResult) {
        results = new AccountInitialisationResults(titleResult(title), expiryResult);
    }

    public static void check(final String title, final Date expiry) throws BadAccountInitialisationException {
        new AccountInitialisationChecker(title, expiryResult(expiry)).check();
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
