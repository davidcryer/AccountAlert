package com.davidcryer.accountalert.common.domain.notifications;

import android.content.Context;
import android.content.Intent;

import com.davidcryer.accountalert.R;

class ReminderAlarmIntent extends AlarmIntent {
    final static String ACTION_TYPE = "REMINDER";
    private final static String ARG_REMINDER = "reminder";
    private final String reminder;

    ReminderAlarmIntent(Context context, String id, String title, final String reminder) {
        super(context, id, title);
        this.reminder = reminder;
    }

    ReminderAlarmIntent(Context context, String id, Intent intent) {
        super(context, id, intent);
        this.reminder = intent.getStringExtra(ARG_REMINDER);
    }

    @Override
    String actionType() {
        return ACTION_TYPE;
    }

    @Override
    String notificationTitle(Context context) {
        return context.getString(R.string.notification_reminder_title);
    }

    @Override
    String notificationText(Context context, String title) {
        return context.getString(R.string.notification_reminder_content_format, title, reminder);
    }
}
