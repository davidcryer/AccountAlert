package com.davidcryer.accountalert.common.domain.argchecking;

import com.davidcryer.argrules.multiarg.ArgResults;
import com.davidcryer.argrules.multiarg.Result;

public class AccountInitialisationResults extends ArgResults {
    private final Result title;
    private final Result reminder;

    AccountInitialisationResults(Result title, Result reminder) {
        this.title = title;
        this.reminder = reminder;
    }

    @Override
    protected Result[] asArray() {
        return new Result[] {title, reminder};
    }

    public void forErrors(final ErrorCallback errorCallback) {
        if (!title.passed()) {
            errorCallback.title(title.note());
        }
        if (!reminder.passed()) {
            errorCallback.reminder(reminder.note());
        }
    }

    public interface ErrorCallback {
        void title(String error);
        void reminder(String error);
        void unknown(String error);
    }
}
