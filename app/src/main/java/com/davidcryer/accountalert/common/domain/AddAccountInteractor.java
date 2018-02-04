package com.davidcryer.accountalert.common.domain;

import com.davidc.interactor.Interactor;
import com.davidc.interactor.TaskScheduler;
import com.davidcryer.accountalert.common.domain.argchecking.AccountInitialisationResults;
import com.davidcryer.accountalert.common.domain.argchecking.BadAccountInitialisationException;

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
            dispatch(e.results(), onErrorCallback);
        }
    }

    private void dispatch(final Account account, final OnSuccessCallback onSuccessCallback) {
        executeOnCallbackThread(() -> onSuccessCallback.account(account));
    }

    private void dispatch(final AccountInitialisationResults results, final OnErrorCallback onErrorCallback) {
        executeOnCallbackThread(() -> results.forErrors(errorCallback(onErrorCallback)));
    }

    private AccountInitialisationResults.ErrorCallback errorCallback(final OnErrorCallback onErrorCallback) {
        return new AccountInitialisationResults.ErrorCallback() {
            @Override
            public void title(String error) {
                onErrorCallback.title(error);
            }

            @Override
            public void reminder(String error) {
                onErrorCallback.reminder(error);
            }

            @Override
            public void unknown(String error) {
                onErrorCallback.unknown(error);
            }
        };
    }

    public interface OnSuccessCallback {
        void account(Account account);
    }

    public interface OnErrorCallback {
        void title(String error);
        void reminder(String error);
        void unknown(String error);
    }
}
