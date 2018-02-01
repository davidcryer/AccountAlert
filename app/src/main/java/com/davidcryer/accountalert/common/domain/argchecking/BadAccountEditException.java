package com.davidcryer.accountalert.common.domain.argchecking;

import com.davidcryer.argrules.multiarg.ArgException;

public class BadAccountEditException extends ArgException {
    private final AccountEditResults results;

    public BadAccountEditException(AccountEditResults results) {
        super(results);
        this.results = results;
    }

    public AccountEditResults results() {
        return results;
    }
}
