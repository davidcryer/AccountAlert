package com.davidcryer.accountalert.common.domain;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import com.davidcryer.accountalert.common.domain.argchecking.BadAccountInitialisationException;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class SharedPreferencesAccountDb implements AccountDb {
    private final static String PREFS_KEY_ACCOUNTS = "accounts";
    private final static String PREFS_KEY_ORDERS = "accountOrders";
    private final SharedPreferences accounts;
    private final SharedPreferences accountOrders;
    private final Gson gson;
    private final AccountFactory accountFactory;

    public SharedPreferencesAccountDb(final Context context, final Gson gson, final AccountFactory accountFactory) {
        accounts = context.getSharedPreferences(PREFS_KEY_ACCOUNTS, Context.MODE_PRIVATE);
        accountOrders = context.getSharedPreferences(PREFS_KEY_ORDERS, Context.MODE_PRIVATE);
        this.gson = gson;
        this.accountFactory = accountFactory;
    }

    @Override
    public List<UUID> orderedAccounts() {
        final Map<String, ?> orderMap = accountOrders.getAll();
        final List<UUID> orderedAccounts = new LinkedList<>();
        for (Object id = orderMap.get(null); id != null; id = orderMap.get(id)) {
            orderedAccounts.add(parseId(id.toString()));
        }
        return orderedAccounts;
    }

    @Override
    public Map<UUID, Account> accountMap() {
        final Map<UUID, Account> accountMap = new HashMap<>();
        accounts.getAll().forEach((key, json) -> {
            final UUID id = parseId(key);
            accountMap.put(id, from(id, json.toString()));
        });
        return accountMap;
    }

    private Account from(final UUID id, final String json) {
        return from(id, gson.fromJson(json, AccountJson.class));
    }

    private Account from(final UUID id, final AccountJson json) {
        return accountFactory.from(id, json);
    }

    private UUID parseId(final String id) {
        return UUID.fromString(id);
    }

    @Override
    public Account add(AccountSubmission submission) throws BadAccountInitialisationException {
        final Account account = update(accountFactory.from(submission));
        final String id = account.id().toString();
        accountOrders.edit().putString(getLastAccountId(), id).putString(id, null).apply();
        return account;
    }

    private @Nullable String getLastAccountId() {
        return accountOrders
                .getAll()
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == null)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Account update(Account account) {
        accounts.edit().putString(account.id().toString(), gson.toJson(account)).apply();
        return account;
    }

    @Override
    public void delete(UUID account) {
        accounts.edit().remove(account.toString()).apply();
    }
}
