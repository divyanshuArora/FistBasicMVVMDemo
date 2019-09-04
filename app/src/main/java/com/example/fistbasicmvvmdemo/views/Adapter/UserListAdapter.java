package com.example.fistbasicmvvmdemo.views.Adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fistbasicmvvmdemo.R;
import com.example.fistbasicmvvmdemo.databinding.UserListItemBinding;
import com.example.fistbasicmvvmdemo.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ItemViewHolder> {
    Context context;
    List<User> userList = new ArrayList<>();

    public UserListAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        UserListItemBinding userListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),R.layout.user_list_item,viewGroup,false);
        return new ItemViewHolder(userListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i)
    {
        User user = userList.get(i);
        itemViewHolder.userListItemBinding.setUser(user);
    }

    @Override
    public int getItemCount() {

        if (userList!=null)
        {
            return userList.size();
        }
        else { return 0; }
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder
    {
        UserListItemBinding userListItemBinding;

        public ItemViewHolder(@NonNull UserListItemBinding itemView) {
            super(itemView.getRoot());
            this.userListItemBinding = itemView;
        }
    }
}
