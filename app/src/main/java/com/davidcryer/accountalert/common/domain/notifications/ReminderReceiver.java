package com.davidcryer.accountalert.common.domain.notifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ReminderReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        final AlarmIntent alarmIntent = AlarmIntentFactory.from(context, intent);
        if (alarmIntent != null) {
            alarmIntent.sendNotification();
        }
    }
}
