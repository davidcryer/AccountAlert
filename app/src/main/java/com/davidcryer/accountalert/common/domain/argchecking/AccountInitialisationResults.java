package com.davidcryer.accountalert.common.domain.argchecking;

import com.davidcryer.argrules.multiarg.ArgResults;
import com.davidcryer.argrules.multiarg.Result;

public class AccountInitialisationResults extends ArgResults {
    private final Result id;
    private final Result title;
    private final Result reminder;

    AccountInitialisationResults(Result id, Result title, Result reminder) {
        this.id = id;
        this.title = title;
        this.reminder = reminder;
    }

    @Override
    protected Result[] asArray() {
        return new Result[] {id, title, reminder};
    }

    public void forErrors(final ErrorCallback errorCallback) {
        if (!id.passed()) {
            errorCallback.unknown(id.note());
        }
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
