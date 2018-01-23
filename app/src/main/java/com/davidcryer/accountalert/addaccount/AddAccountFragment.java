package com.davidcryer.accountalert.addaccount;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davidc.uiwrapper.UiWrapper;
import com.davidc.uiwrapper.UiWrapperFactoryFragment;
import com.davidcryer.accountalert.R;
import com.davidcryer.accountalert.common.framework.uiwrapper.UiWrapperFactory;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class AddAccountFragment extends UiWrapperFactoryFragment<AddAccountUi, AddAccountUi.Listener, UiWrapperFactory> {
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedState) {
        super.onViewCreated(view, savedState);
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onStart() {
        super.onStart();
        getActivity().setTitle(R.string.add_account_title);
    }

    @Override
    protected AddAccountUi ui() {
        return new AddAccountUi() {
            @Override
            public void titleError(String error) {

            }

            @Override
            public void descriptionError(String error) {

            }

            @Override
            public void nextNotificationError(String error) {

            }

            @Override
            public void genericError(String error) {

            }

            @Override
            public void dismiss() {
                getActivity().onBackPressed();//TODO check if correct
            }
        };
    }

    @Override
    protected UiWrapper<AddAccountUi, AddAccountUi.Listener, ?> uiWrapper(UiWrapperFactory uiWrapperFactory, @Nullable Bundle savedState) {
        return uiWrapperFactory.addAccount(savedState);
    }
}
