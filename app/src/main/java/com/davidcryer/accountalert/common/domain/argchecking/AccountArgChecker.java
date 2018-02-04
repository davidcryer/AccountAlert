package com.davidcryer.accountalert.common.domain.argchecking;

import com.davidcryer.accountalert.common.Dates;
import com.davidcryer.argrules.multiarg.ArgChecker;
import com.davidcryer.argrules.multiarg.ArgException;
import com.davidcryer.argrules.multiarg.ArgResults;
import com.davidcryer.argrules.multiarg.Result;

import java.util.Date;
import java.util.UUID;

import static com.davidcryer.argrules.multiarg.DelayedResult.delayed;
import static com.davidcryer.argrules.multiarg.ImmediateResult.forCheck;
import static com.davidcryer.argrules.multiarg.ResultChain.chain;

abstract class AccountArgChecker<R extends ArgResults, E extends ArgException> extends ArgChecker<R, E> {
    private final static String ERROR_ID_NULL = "Id cannot be null";
    private final static String ERROR_TITLE_NULL = "Title cannot be null";
    private final static String ERROR_TITLE_EMPTY = "Title cannot be empty";
    private final static String ERROR_REMINDER_NULL = "Reminder cannot be null";
    private final static String ERROR_REMINDER_IN_PAST = "Reminder must be tomorrow or later";

    Result idResult(final UUID id) {
        return forCheck(id != null, ERROR_ID_NULL);
    }

    Result titleResult(final String title) {
        return chain()
                .add(delayed(() -> title != null, ERROR_TITLE_NULL))
                .add(delayed(() -> !title.isEmpty(), ERROR_TITLE_EMPTY))
                .firstFailing();
    }

    Result reminderResult(final Date reminder) {
        return chain()
                .add(delayed(() -> reminder != null, ERROR_REMINDER_NULL))
                .add(delayed(() -> reminder.compareTo(Dates.midnightTomorrow()) >= 0, ERROR_REMINDER_IN_PAST))
                .firstFailing();
    }
}
