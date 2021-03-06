package com.davidcryer.accountalert;

import android.content.Context;
import android.os.Looper;

import com.davidc.interactor.TaskScheduler;
import com.davidc.interactor.ThreadPoolExecutorAndHandlerTaskScheduler;
import com.davidcryer.accountalert.common.domain.AccountDb;
import com.davidcryer.accountalert.common.domain.AccountFactory;
import com.davidcryer.accountalert.common.domain.AccountStore;
import com.davidcryer.accountalert.common.domain.AddAccountInteractor;
import com.davidcryer.accountalert.common.domain.AddAccountTask;
import com.davidcryer.accountalert.common.domain.GetAccountsInteractor;
import com.davidcryer.accountalert.common.domain.GetAccountsTask;
import com.davidcryer.accountalert.common.domain.SharedPreferencesAccountDb;
import com.davidcryer.accountalert.common.domain.notifications.AlarmIntentFactory;
import com.davidcryer.accountalert.common.domain.notifications.AlarmPendingIntentFactory;
import com.davidcryer.accountalert.common.domain.notifications.AlarmService;
import com.davidcryer.accountalert.common.framework.uiwrapper.UiWrapperFactory;
import com.google.gson.Gson;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class AppDependencies {

    static UiWrapperFactory uiWrapperFactory(final Context context) {
        final TaskScheduler taskScheduler = taskScheduler();
        final AccountStore accountStore = accountStore(context);
        return new UiWrapperFactory(getAccountsInteractor(taskScheduler, accountStore), addAccountInteractor(taskScheduler, addAccountTask(alarmService(context), accountStore)));
    }

    private static GetAccountsInteractor getAccountsInteractor(final TaskScheduler taskScheduler, final AccountStore accountStore) {
        return new GetAccountsInteractor(taskScheduler, getAccountsTask(accountStore));
    }

    private static GetAccountsTask getAccountsTask(final AccountStore accountStore) {
        return new GetAccountsTask(accountStore);
    }

    private static AddAccountInteractor addAccountInteractor(final TaskScheduler taskScheduler, final AddAccountTask addAccountTask) {
        return new AddAccountInteractor(taskScheduler, addAccountTask);
    }

    private static TaskScheduler taskScheduler() {
        return new ThreadPoolExecutorAndHandlerTaskScheduler(new ThreadPoolExecutor(2, 3, 2, TimeUnit.SECONDS, new LinkedBlockingDeque<>()), Looper.getMainLooper());
    }

    private static AddAccountTask addAccountTask(final AlarmService alarmService, final AccountStore accountStore) {
        return new AddAccountTask(alarmService, accountStore);
    }

    private static AlarmService alarmService(final Context context) {
        return new AlarmService(context, alarmPendingIntentFactory(context));
    }

    private static AlarmPendingIntentFactory alarmPendingIntentFactory(final Context context) {
        return new AlarmPendingIntentFactory(context, alarmIntentFactory());
    }

    private static AlarmIntentFactory alarmIntentFactory() {
        return new AlarmIntentFactory();
    }

    private static AccountStore accountStore(final Context context) {
        return new AccountStore(accountDb(context));
    }

    private static AccountDb accountDb(final Context context) {
        return new SharedPreferencesAccountDb(context, gson(), accountFactory());
    }

    private static AccountFactory accountFactory() {
        return new AccountFactory();
    }

    private static Gson gson() {
        return new Gson();
    }
}
