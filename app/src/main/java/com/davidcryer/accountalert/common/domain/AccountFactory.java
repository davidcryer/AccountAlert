package com.davidcryer.accountalert.common.domain;

import java.util.UUID;

public class AccountFactory {

    Account from(final AccountSubmission submission) {
        return Account.create(submission.title, submission.description, submission.reminder, submission.repeatType);
    }

    Account from(final UUID id, final AccountJson json) {
        return Account.inflate(id, json.getTitle(), json.getDescription(), json.getReminder(), json.getRepeatType());
    }
}
