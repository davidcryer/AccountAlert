package com.davidcryer.accountalert.common.domain.notifications;

import android.content.Context;
import android.content.Intent;

import com.davidcryer.accountalert.R;

class ExpiryAlarmIntent extends AlarmIntent {
    final static String ACTION_TYPE = "EXPIRY";

    ExpiryAlarmIntent(Context context, String id, String title) {
        super(context, id, title);
    }

    ExpiryAlarmIntent(Context context, String id, Intent intent) {
        super(context, id, intent);
    }

    @Override
    String actionType() {
        return ACTION_TYPE;
    }

    @Override
    String notificationTitle(Context context) {
        return context.getString(R.string.notification_expiry_title);
    }

    @Override
    String notificationText(Context context, String title) {
        return context.getString(R.string.notification_expiry_content_format, title);
    }
}
