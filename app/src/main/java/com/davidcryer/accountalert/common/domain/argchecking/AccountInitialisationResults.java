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

    public Result id() {
        return id;
    }

    public Result title() {
        return title;
    }

    public Result reminder() {
        return reminder;
    }

    @Override
    protected Result[] asArray() {
        return new Result[] {id(), title(), reminder()};
    }
}
