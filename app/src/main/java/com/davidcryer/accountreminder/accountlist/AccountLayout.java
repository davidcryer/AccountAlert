package com.davidcryer.accountreminder.accountlist;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.davidcryer.accountreminder.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AccountLayout extends LinearLayout {
    @BindView(R.id.title)
    TextView titleView;
    @BindView(R.id.description)
    TextView descriptionView;
    @BindView(R.id.notification_date)
    TextView notificationDateView;

    public AccountLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        ButterKnife.bind(this);
    }

    void title(final String title) {
        titleView.setText(title);
    }

    void description(final String description) {
        descriptionView.setText(description);
    }

    void notificationDate(final String notificationDate) {
        notificationDateView.setText(notificationDate);
    }
}
