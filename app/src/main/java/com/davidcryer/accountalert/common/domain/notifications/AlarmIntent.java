package com.davidcryer.accountalert.common.domain.notifications;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import com.davidcryer.accountalert.R;
import com.davidcryer.accountalert.common.framework.AccountActivity;

abstract class AlarmIntent {
    private final static String ARG_TITLE = "title";
    private final Context context;
    private final String id;
    private final String title;

    AlarmIntent(Context context, String id, String title) {
        this.context = context;
        this.id = id;
        this.title = title;
    }

    AlarmIntent(Context context, String id, Intent intent) {
        this(context, id, intent.getStringExtra(ARG_TITLE));
    }

    Intent toIntent() {
        return intent(action().toString(), title);
    }

    private Action action() {
        return new Action(actionType(), id);
    }

    abstract String actionType();

    private Intent intent(final String action, final String title) {
        return new Intent(context, ReminderReceiver.class).setAction(action).putExtra(ARG_TITLE, title);
    }

    void sendNotification() {
        final PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, AccountActivity.forNotification(context, id), 0);
        final Notification notification = new NotificationCompat.Builder(context, id)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setAutoCancel(true)
                .setContentTitle(notificationTitle(context))
                .setContentText(notificationText(context, title))
                .setContentIntent(pendingIntent)
                .build();
        final NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
        if (notificationManager != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                if (notificationManager.getNotificationChannel(id) == null) {
                    notificationManager.createNotificationChannel(new NotificationChannel(id, title, NotificationManager.IMPORTANCE_DEFAULT));
                }
            }
            notificationManager.notify(id.hashCode(), notification);
        }
    }

    abstract String notificationTitle(Context context);

    abstract String notificationText(Context context, String title);
}
