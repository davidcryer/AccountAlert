package com.davidcryer.accountalert.addaccount;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davidc.uiwrapper.UiWrapper;
import com.davidc.uiwrapper.UiWrapperFactoryFragment;
import com.davidcryer.accountalert.R;
import com.davidcryer.accountalert.common.framework.uiwrapper.UiWrapperFactory;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class AddAccountFragment extends UiWrapperFactoryFragment<AddAccountUi, AddAccountUi.Listener, UiWrapperFactory> {
    private Unbinder unbinder;
    @BindView(R.id.title)
    InputLayout titleInputLayout;
    @BindView(R.id.description)
    InputLayout descriptionInputLayout;
    @BindView(R.id.next_notification)
    InputLayout nextNotificationInputLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_account, container, false);
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
        getActivity().setTitle(R.string.screen_title_add_account);
    }

    @Override
    protected AddAccountUi ui() {
        return new AddAccountUi() {
            @Override
            public void titleError(String error) {
                if (getView() != null) {
                    titleInputLayout.setError(error);
                }
            }

            @Override
            public void descriptionError(String error) {
                if (getView() != null) {
                    descriptionInputLayout.setError(error);
                }
            }

            @Override
            public void nextNotificationError(String error) {
                if (getView() != null) {
                    nextNotificationInputLayout.setError(error);
                }
            }

            @Override
            public void genericError(String error) {
                final View root = getView();
                if (root != null) {
                    Snackbar.make(root, error, Snackbar.LENGTH_LONG).show();
                }
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
