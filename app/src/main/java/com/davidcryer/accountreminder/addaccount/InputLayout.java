package com.davidcryer.accountreminder.addaccount;

import android.content.Context;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;

import com.davidcryer.accountreminder.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InputLayout extends TextInputLayout {
    @BindView(R.id.edit_text)
    TextInputEditText editText;

    public InputLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        ButterKnife.bind(this);
    }
}
