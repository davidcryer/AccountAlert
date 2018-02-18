package com.davidcryer.accountalert.common.domain.argchecking;

import com.davidcryer.argrules.multiarg.ArgResults;
import com.davidcryer.argrules.multiarg.Result;

public class AccountInitialisationResults extends ArgResults {
    private final Result title;
    private final Result expiry;

    AccountInitialisationResults(Result title, Result expiry) {
        this.title = title;
        this.expiry = expiry;
    }

    @Override
    protected Result[] asArray() {
        return new Result[] {title, expiry};
    }

    public void forErrors(final ErrorCallback errorCallback) {
        if (!title.passed()) {
            errorCallback.title(title.note());
        }
        if (!expiry.passed()) {
            errorCallback.expiry(expiry.note());
        }
    }

    public interface ErrorCallback {
        void title(String error);
        void expiry(String error);
        void unknown(String error);
    }
}
