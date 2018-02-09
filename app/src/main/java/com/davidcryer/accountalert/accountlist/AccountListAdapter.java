package com.davidcryer.accountalert.accountlist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.davidcryer.accountalert.common.Lists;

import java.util.LinkedList;
import java.util.List;

class AccountListAdapter extends RecyclerView.Adapter<UiAccount.AccountViewHolder> {
    private final AccountLayoutInflater layoutInflater;
    private List<UiAccount> accounts = new LinkedList<>();;

    AccountListAdapter(AccountLayoutInflater layoutInflater) {
        this.layoutInflater = layoutInflater;
    }

    void accounts(@NonNull final List<UiAccount> accounts) {
        this.accounts = Lists.from(accounts, LinkedList::new, LinkedList::new);
        notifyDataSetChanged();
    }

    void add(@NonNull final UiAccount account) {
        accounts.add(account);
        notifyItemInserted(accounts.size() - 1);
    }

    @Override
    public UiAccount.AccountViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return accounts.get(viewType).viewHolder(layoutInflater.inflateFrom(parent));
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(UiAccount.AccountViewHolder holder, int position) {
        holder.bind(accounts.get(position));
    }

    @Override
    public int getItemCount() {
        return accounts.size();
    }
}
