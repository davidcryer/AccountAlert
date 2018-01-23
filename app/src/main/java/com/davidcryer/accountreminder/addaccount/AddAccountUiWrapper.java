package com.davidcryer.accountreminder.addaccount;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.davidc.uiwrapper.UiWrapper;
import com.davidcryer.accountreminder.common.domain.AccountSubmission;
import com.davidcryer.accountreminder.common.domain.AddAccountInteractor;

public class AddAccountUiWrapper extends UiWrapper<AddAccountUi, AddAccountUi.Listener, AddAccountUiModel> {
    private final AddAccountInteractor addAccountInteractor;

    private AddAccountUiWrapper(@NonNull AddAccountUiModel uiModel, AddAccountInteractor addAccountInteractor) {
        super(uiModel);
        this.addAccountInteractor = addAccountInteractor;
    }

    public static AddAccountUiWrapper newInstance(
            @NonNull final AddAccountUiModel uiModel,
            final AddAccountInteractor addAccountInteractor
    ) {
        return new AddAccountUiWrapper(uiModel, addAccountInteractor);
    }

    public static AddAccountUiWrapper savedInstance(
            @NonNull final Bundle savedState,
            final AddAccountInteractor addAccountInteractor
    ) {
        final AddAccountUiModel uiModel = savedUiModel(savedState);
        return uiModel == null ? null : newInstance(uiModel, addAccountInteractor);
    }

    @Override
    protected AddAccountUi.Listener uiListener() {
        return new AddAccountUi.Listener() {
            @Override
            public void onSubmitNewAccount(AddAccountUi ui, AccountSubmission submission) {
                addAccountInteractor.add(submission, onSuccessCallback, onErrorCallback);
            }
        };
    }

    private final AddAccountInteractor.OnSuccessCallback onSuccessCallback = account -> uiModel().dismiss(ui());

    private final AddAccountInteractor.OnErrorCallback onErrorCallback = new AddAccountInteractor.OnErrorCallback() {
        @Override
        public void title(String error) {
            uiModel().title(ui(), error);
        }

        @Override
        public void description(String error) {
            uiModel().description(ui(), error);
        }

        @Override
        public void nextNotification(String error) {
            uiModel().nextNotification(ui(), error);
        }

        @Override
        public void unknown(String error) {
            uiModel().generic(ui(), error);
        }
    };
}
