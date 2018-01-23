package com.davidcryer.accountalert.common.domain;

import com.davidc.interactor.Interactor;
import com.davidc.interactor.TaskScheduler;

public class GetAccountsInteractor extends Interactor {
    private final GetAccountsTask task;

    public GetAccountsInteractor(TaskScheduler taskScheduler, GetAccountsTask task) {
        super(taskScheduler);
        this.task = task;
    }

    public void perform(final Callback callback) {
        executeOnWorkerThread(() -> dispatch(task.accountList(), callback));
    }

    private void dispatch(final AccountList accountList, final Callback callback) {
        executeOnCallbackThread(() -> callback.accountList(accountList));
    }

    public interface Callback {
        void accountList(AccountList accountList);
    }
}
