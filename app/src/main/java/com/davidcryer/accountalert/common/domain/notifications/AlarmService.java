package com.davidcryer.accountalert.common.domain.notifications;

import android.app.AlarmManager;
import android.content.Context;

import com.davidcryer.accountalert.common.ServiceProvider;
import com.davidcryer.accountalert.common.domain.Account;

public class AlarmService {
    private final Context context;
    private final AlarmPendingIntentFactory pendingIntentFactory;

    public AlarmService(Context context, AlarmPendingIntentFactory pendingIntentFactory) {
        this.context = context;
        this.pendingIntentFactory = pendingIntentFactory;
    }

    public void register(final Account account) {
        ServiceProvider.alarm(context, alarmManager -> alarmManager.set(AlarmManager.RTC, account.expiry().getTime(), pendingIntentFactory.forExpiry(account)));
        //TODO reminder
    }

    public void deregister(final Account account) {
        ServiceProvider.alarm(context, alarmManager -> alarmManager.cancel(pendingIntentFactory.forExpiry(account)));
        //TODO reminder
    }

    public void deregisterReminder(final Account account) {//TODO add reminder parameter

    }
}
