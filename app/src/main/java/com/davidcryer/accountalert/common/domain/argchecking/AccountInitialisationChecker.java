package com.davidcryer.accountalert.common.domain.argchecking;

import java.util.Date;
import java.util.UUID;

public class AccountInitialisationChecker extends AccountArgChecker<AccountInitialisationResults, BadAccountInitialisationException> {
    private final AccountInitialisationResults results;

    private AccountInitialisationChecker(final UUID id, final String title, final Date reminder) {
        results = new AccountInitialisationResults(idResult(id), titleResult(title), reminderResult(reminder));
    }

    public static void check(final UUID id, final String title, final Date reminder) throws BadAccountInitialisationException {
        new AccountInitialisationChecker(id, title, reminder).check();
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
