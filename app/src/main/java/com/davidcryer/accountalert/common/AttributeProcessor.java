package com.davidcryer.accountalert.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.StyleableRes;
import android.util.AttributeSet;

public class AttributeProcessor {

    public static void process(final Context context, final AttributeSet attrs, @StyleableRes final int[] styleable, final Callback callback) {
        final TypedArray array = context.obtainStyledAttributes(attrs, styleable);
        callback.onProcess(array);
        array.recycle();
    }

    public interface Callback {
        void onProcess(TypedArray attributes);
    }
}
