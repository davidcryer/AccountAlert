package com.davidcryer.accountalert.accountlist;

import android.support.v7.widget.RecyclerView;

import java.util.UUID;

class UiAccount {
    private final UUID id;
    private final String title;
    private final String description;
    private final String notificationDate;
    private final String repeatType;//TODO add to layout

    UiAccount(UUID id, String title, String description, String notificationDate, String repeatType) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.notificationDate = notificationDate;
        this.repeatType = repeatType;
    }

    UUID id() {
        return id;
    }

    private void onto(final AccountLayout layout) {
        layout.title(title);
        layout.description(description);
        layout.notificationDate(notificationDate);
    }

    AccountViewHolder viewHolder(final AccountLayout layout) {
        return new AccountViewHolder(layout);
    }

    class AccountViewHolder extends RecyclerView.ViewHolder {
        private final AccountLayout accountLayout;

        private AccountViewHolder(final AccountLayout itemView) {
            super(itemView);
            this.accountLayout = itemView;
        }

        void bind(final UiAccount account) {
            account.onto(accountLayout);
        }
    }
}
