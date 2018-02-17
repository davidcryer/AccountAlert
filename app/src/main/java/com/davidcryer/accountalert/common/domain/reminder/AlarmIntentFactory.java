package com.davidcryer.accountalert.common.domain.reminder;

import android.content.Context;
import android.content.Intent;

import com.davidcryer.accountalert.common.domain.Account;

public class AlarmIntentFactory {

    AlarmIntent expiry(final Context context, final Account account) {
        return new ExpiryAlarmIntent(context, account.id().toString(), account.title());
    }

    AlarmIntent reminder(final Context context, final Account account) {
        return new ReminderAlarmIntent(context, account.id().toString(), account.title(), account.reminder().toString());//TODO format date
    }

    static AlarmIntent from(final Context context, final Intent intent) {
        try {
            final Action action = Action.from(intent.getAction());
            switch (action.type()) {
                case ExpiryAlarmIntent.ACTION_TYPE: {
                    return new ExpiryAlarmIntent(context, action.id(), intent);
                }
                case ReminderAlarmIntent.ACTION_TYPE: {
                    return new ReminderAlarmIntent(context, action.id(), intent);
                }
            }
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return null;
    }
}
