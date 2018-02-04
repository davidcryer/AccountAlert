package com.davidcryer.accountalert.common.domain.argchecking;

import com.davidcryer.argrules.multiarg.ArgException;

public class BadAccountInitialisationException extends ArgException {
    private final AccountInitialisationResults results;

    BadAccountInitialisationException(AccountInitialisationResults results) {
        super(results);
        this.results = results;
    }

    public AccountInitialisationResults results() {
        return results;
    }
}
