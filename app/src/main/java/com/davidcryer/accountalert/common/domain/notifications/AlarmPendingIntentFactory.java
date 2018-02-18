package com.davidcryer.accountalert.common.domain.notifications;

import android.app.PendingIntent;
import android.content.Context;

import com.davidcryer.accountalert.common.domain.Account;

public class AlarmPendingIntentFactory {
    private final Context context;
    private final AlarmIntentFactory alarmIntentFactory;

    public AlarmPendingIntentFactory(Context context, AlarmIntentFactory alarmIntentFactory) {
        this.context = context;
        this.alarmIntentFactory = alarmIntentFactory;
    }

    PendingIntent forReminder(final Account account) {
        return from(alarmIntentFactory.reminder(context, account));
    }

    PendingIntent forExpiry(final Account account) {
        return from(alarmIntentFactory.expiry(context, account));
    }

    private PendingIntent from(final AlarmIntent alarmIntent) {
        return PendingIntent.getBroadcast(context, 0, alarmIntent.toIntent(), PendingIntent.FLAG_UPDATE_CURRENT);
    }
}
