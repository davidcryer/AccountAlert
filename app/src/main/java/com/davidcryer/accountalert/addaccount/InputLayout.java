package com.davidcryer.accountalert.addaccount;

import android.content.Context;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;

import com.davidcryer.accountalert.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InputLayout extends TextInputLayout {
    @BindView(R.id.edit_text)
    TextInputEditText editText;

    public InputLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.layout_input, this);
        //TODO hint
        ButterKnife.bind(this);
    }
}
