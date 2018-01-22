package com.davidcryer.accountreminder.addaccount;

class AccountSubmission {
    private final String title;
    private final String description;
    private final String notificationDate;
    //TODO repeat type

    AccountSubmission(String title, String description, String notificationDate) {
        this.title = title;
        this.description = description;
        this.notificationDate = notificationDate;
    }
}
