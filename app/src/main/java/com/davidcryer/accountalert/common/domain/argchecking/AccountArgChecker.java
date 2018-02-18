package com.davidcryer.accountalert.common.domain.argchecking;

import com.davidcryer.accountalert.common.Dates;
import com.davidcryer.argrules.multiarg.ArgChecker;
import com.davidcryer.argrules.multiarg.ArgException;
import com.davidcryer.argrules.multiarg.ArgResults;
import com.davidcryer.argrules.multiarg.Result;

import java.util.Date;

import static com.davidcryer.argrules.multiarg.DelayedResult.delayed;
import static com.davidcryer.argrules.multiarg.ResultChain.chain;

abstract class AccountArgChecker<R extends ArgResults, E extends ArgException> extends ArgChecker<R, E> {
    private final static String ERROR_TITLE_NULL = "Title cannot be null";
    private final static String ERROR_TITLE_EMPTY = "Title cannot be empty";
    private final static String ERROR_EXPIRY_NULL = "Expiry cannot be null";
    private final static String ERROR_EXPIRY_IN_PAST = "Expiry must be tomorrow or later";

    static Result titleResult(final String title) {
        return chain()
                .add(delayed(() -> title != null, ERROR_TITLE_NULL))
                .add(delayed(() -> !title.isEmpty(), ERROR_TITLE_EMPTY))
                .firstFailing();
    }

    static Result expiryResult(final Date expiry) {
        return chain()
                .add(delayed(() -> expiry != null, ERROR_EXPIRY_NULL))
                .add(delayed(() -> expiry.compareTo(Dates.midnightTomorrow()) >= 0, ERROR_EXPIRY_IN_PAST))
                .firstFailing();
    }
}
