package com.davidcryer.accountalert.common.domain.argchecking;

import com.davidcryer.argrules.multiarg.ArgResults;
import com.davidcryer.argrules.multiarg.Result;

public class AccountEditResults extends ArgResults {
    private final Result title;
    private final Result expiry;

    AccountEditResults(Result title, Result expiry) {
        this.title = title;
        this.expiry = expiry;
    }

    public Result title() {
        return title;
    }

    public Result expiry() {
        return expiry;
    }

    @Override
    protected Result[] asArray() {
        return new Result[] {title(), expiry()};
    }

    static class Builder implements ArgResults.Builder<AccountEditResults> {
        private Result title;
        private Result expiry;

        Builder title(Result title) {
            this.title = title;
            return this;
        }

        Builder expiry(Result expiry) {
            this.expiry = expiry;
            return this;
        }

        @Override
        public AccountEditResults results() {
            return new AccountEditResults(title, expiry);
        }
    }
}
