package com.davidcryer.accountalert.common.domain;

import com.davidc.interactor.Interactor;
import com.davidc.interactor.TaskScheduler;

public class AddAccountInteractor extends Interactor {
    private final AddAccountTask addAccountTask;

    public AddAccountInteractor(TaskScheduler taskScheduler, AddAccountTask addAccountTask) {
        super(taskScheduler);
        this.addAccountTask = addAccountTask;
    }

    public void add(final AccountSubmission submission, final OnSuccessCallback onSuccessCallback, final OnErrorCallback onErrorCallback) {
        executeOnWorkerThread(() -> addAccountAndHandleExceptions(submission, onSuccessCallback, onErrorCallback));
    }

    private void addAccountAndHandleExceptions(final AccountSubmission submission, final OnSuccessCallback onSuccessCallback, final OnErrorCallback onErrorCallback) {
        try {
            dispatch(addAccountTask.addAccount(submission), onSuccessCallback);
        } catch (BadAccountInitialisationException e) {
            dispatch(e, onErrorCallback);
        }
    }

    private void dispatch(final Account account, final OnSuccessCallback onSuccessCallback) {
        executeOnCallbackThread(() -> onSuccessCallback.account(account));
    }

    private void dispatch(final BadAccountInitialisationException e, final OnErrorCallback onErrorCallback) {
        executeOnCallbackThread(() -> {
            //TODO call specific error callbacks (may be more than one!
        });
    }

    public interface OnSuccessCallback {
        void account(Account account);
    }

    public interface OnErrorCallback {
        void title(String error);
        void description(String error);
        void nextNotification(String error);
        void unknown(String error);
    }
}
