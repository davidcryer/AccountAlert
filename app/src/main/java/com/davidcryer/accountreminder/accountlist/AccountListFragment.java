package com.davidcryer.accountreminder.accountlist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davidc.uiwrapper.UiWrapper;
import com.davidc.uiwrapper.UiWrapperFactoryFragment;
import com.davidcryer.accountreminder.R;
import com.davidcryer.accountreminder.common.framework.uiwrapper.UiWrapperFactory;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class AccountListFragment extends UiWrapperFactoryFragment<AccountListUi, AccountListUi.Listener, UiWrapperFactory> {
    private Unbinder butterKnifeUnbinder;
    private final AccountListAdapter accountListAdapter;
    @BindView(R.id.accounts)
    RecyclerView accountsView;

    {
        accountListAdapter = new AccountListAdapter();
    }

    public static AccountListFragment newInstance() {
        return new AccountListFragment();
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
        getActivity().setTitle(R.string.account_list_title);
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

            }
        };
    }

    @Override
    protected UiWrapper<AccountListUi, AccountListUi.Listener, ?> uiWrapper(UiWrapperFactory uiWrapperFactory, @Nullable Bundle savedState) {
        return uiWrapperFactory.accountList(savedState);
    }
}
