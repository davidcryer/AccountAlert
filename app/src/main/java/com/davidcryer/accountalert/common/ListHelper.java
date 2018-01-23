package com.davidcryer.accountalert.common;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

public class ListHelper {

    public static @NonNull <T> List<T> from(@Nullable final List<T> l, final EmptyListProvider<T> emptyListProvider, final PopulatedListProvider<T> populatedListProvider) {
        return l == null ? emptyListProvider.get() : populatedListProvider.from(l);
    }

    public interface EmptyListProvider<T> {
        @NonNull List<T> get();
    }

    public interface PopulatedListProvider<T> {
        @NonNull List<T> from(@Nullable List<T> l);
    }
}
