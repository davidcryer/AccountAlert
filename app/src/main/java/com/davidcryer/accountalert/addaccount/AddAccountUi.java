package com.davidcryer.accountalert.addaccount;

import com.davidcryer.accountalert.common.domain.AccountSubmission;

public interface AddAccountUi {
    void titleError(String error);
    void descriptionError(String error);
    void nextNotificationError(String error);
    void genericError(String error);
    void dismiss();

    interface Listener {
        void onSubmitNewAccount(AddAccountUi ui, AccountSubmission account);
    }
}
