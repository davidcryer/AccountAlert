package com.davidcryer.accountalert.common.domain.argchecking;

import com.davidcryer.argrules.multiarg.ArgResults;
import com.davidcryer.argrules.multiarg.Result;

public class AccountEditResults extends ArgResults {
    private final Result title;
    private final Result reminder;

    AccountEditResults(Result title, Result reminder) {
        this.title = title;
        this.reminder = reminder;
    }

    public Result title() {
        return title;
    }

    public Result reminder() {
        return reminder;
    }

    @Override
    protected Result[] asArray() {
        return new Result[] {title(), reminder()};
    }

    static class Builder implements ArgResults.Builder<AccountEditResults> {
        private Result title;
        private Result reminder;

        Builder title(Result title) {
            this.title = title;
            return this;
        }

        Builder reminder(Result reminder) {
            this.reminder = reminder;
            return this;
        }

        @Override
        public AccountEditResults results() {
            return new AccountEditResults(title, reminder);
        }
    }
}
