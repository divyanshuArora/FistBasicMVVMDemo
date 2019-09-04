package com.example.fistbasicmvvmdemo.views.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.fistbasicmvvmdemo.R;
import com.example.fistbasicmvvmdemo.databinding.ActivityMainBinding;
import com.example.fistbasicmvvmdemo.viewmodels.LoginViewModel;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(new LoginViewModel());
        activityMainBinding.executePendingBindings();
        email = activityMainBinding.getViewModel().getUserEmail();
    }

    @BindingAdapter({"toastMessage","userEmail"})
    public static void runMe(View view, String message,String userEmail)
    {
        if (message != null)
        {
            Toast.makeText(view.getContext(), message+" "+userEmail, Toast.LENGTH_SHORT).show();
            openActivity(view.getContext(),userEmail);
        }
    }

    private static void openActivity(Context context,String userEmail)
    {
        context.startActivity(new Intent(context,Dashboard.class).putExtra("email",userEmail));
    }
}
