package com.davidcryer.accountalert.common;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.content.Context;
import android.support.annotation.NonNull;

public class ServiceProvider {

    public static void alarm(final Context context, final Callback<AlarmManager> callback) {
        service(context, AlarmManager.class, callback);
    }

    public static void notification(final Context context, final Callback<NotificationManager> callback) {
        service(context, NotificationManager.class, callback);
    }

    private static <T> void service(final Context context, final Class<T> clazz, final Callback<T> callback) {
        final T manager = context.getSystemService(clazz);
        if (manager != null) {
            callback.service(manager);
        }
    }

    public interface Callback<T> {
        void service(@NonNull final T service);
    }
}
