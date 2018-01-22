package com.davidcryer.accountreminder.addaccount;

public interface AddAccountUi {
    void titleError(String error);
    void descriptionError(String error);
    void notificationDateError(String error);

    interface Listener {
        void onSubitNewAccount(AddAccountUi ui, AccountSubmission account);
    }
}
