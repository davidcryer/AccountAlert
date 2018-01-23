package com.davidcryer.accountalert.accountlist;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davidc.uiwrapper.UiWrapper;
import com.davidc.uiwrapper.UiWrapperFactoryFragment;
import com.davidcryer.accountalert.R;
import com.davidcryer.accountalert.addaccount.AddAccountFragment;
import com.davidcryer.accountalert.common.framework.uiwrapper.UiWrapperFactory;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class AccountListFragment extends UiWrapperFactoryFragment<AccountListUi, AccountListUi.Listener, UiWrapperFactory> {
    private final AccountListAdapter accountListAdapter;
    private Unbinder butterKnifeUnbinder;
    private AccountListNavigator navigator;
    @BindView(R.id.accounts)
    RecyclerView accountsView;

    {
        accountListAdapter = new AccountListAdapter(new AccountLayoutInflater());
    }

    public static AccountListFragment newInstance() {
        return new AccountListFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        navigator = (AccountListNavigator) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        navigator = null;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_account_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedState) {
        super.onViewCreated(view, savedState);
        butterKnifeUnbinder = ButterKnife.bind(this, view);
        accountsView.setAdapter(accountListAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        butterKnifeUnbinder.unbind();
    }

    @Override
    public void onStart() {
        super.onStart();
        getActivity().setTitle(R.string.screen_title_account_list);
    }

    @Override
    protected AccountListUi ui() {
        return new AccountListUi() {
            @Override
            public void accounts(@NonNull List<UiAccount> accounts) {
                accountListAdapter.accounts(accounts);
            }

            @Override
            public void add(@NonNull UiAccount account) {
                accountListAdapter.add(account);
            }

            @Override
            public void showAddAccountUi() {
                navigator.showAddAccountFragment(AddAccountFragment::newInstance);
            }
        };
    }

    @Override
    protected UiWrapper<AccountListUi, AccountListUi.Listener, ?> uiWrapper(UiWrapperFactory uiWrapperFactory, @Nullable Bundle savedState) {
        return uiWrapperFactory.accountList(savedState);
    }
}
