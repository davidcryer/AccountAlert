package com.davidcryer.accountalert.common.domain;

import com.davidcryer.accountalert.common.domain.argchecking.BadAccountInitialisationException;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface AccountDb {
    List<UUID> orderedAccounts();
    Map<UUID, Account> accountMap();
    Account add(AccountSubmission submission) throws BadAccountInitialisationException;
    Account update(Account account);
    void delete(UUID account);
}
