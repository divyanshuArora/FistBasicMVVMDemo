package com.example.fistbasicmvvmdemo.views.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.fistbasicmvvmdemo.R;
import com.example.fistbasicmvvmdemo.databinding.ActivityDashboardBinding;
import com.example.fistbasicmvvmdemo.model.User;
import com.example.fistbasicmvvmdemo.viewmodels.LoginViewModel;
import com.example.fistbasicmvvmdemo.views.Adapter.UserListAdapter;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity {
ActivityDashboardBinding activityDashboardBinding;
    String email;
    List<User> userList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        activityDashboardBinding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard);
        activityDashboardBinding.setViewModel(new LoginViewModel());
        activityDashboardBinding.executePendingBindings();

        email = getIntent().getStringExtra("email");
        activityDashboardBinding.textView.setText(email);
        loadData();
    }

    private void loadData()
    {

        userList.add(new User("divyanshu.arora8@gmail.com","divyanshu","7737729400"));
        userList.add(new User("afsdf@gmail.com","adfa","1234567890"));
        userList.add(new User("sdfsd@gmail.com","sdfas","9876543210"));
        userList.add(new User("dfd@gmail.com","dfd","7418529630"));

        UserListAdapter userListAdapter = new UserListAdapter(getApplicationContext(),userList);
        activityDashboardBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        activityDashboardBinding.recyclerView.setAdapter(userListAdapter);



    }


}
