package com.example.fistbasicmvvmdemo.viewmodels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;


import com.android.databinding.library.baseAdapters.BR;
import com.example.fistbasicmvvmdemo.model.User;

public class LoginViewModel extends BaseObservable
{

    private User user;
    View view;


    private String successMessage = "Login was successful";
    private String errorMessage = "Email or Password not valid";

    @Bindable
    private String toastMessage = null;

    @Bindable
    private String userEmail = null;

    public String getToastMessage() {
        return toastMessage;
    }

    private void setToastMessage(String toastMessage,String userEmail) {

        this.toastMessage = toastMessage;
        this.userEmail = userEmail;
        notifyPropertyChanged(BR.toastMessage);
    }


    public void setUserEmail(String email) {
        user.setEmail(email);
        notifyPropertyChanged(BR.userEmail);
    }

    @Bindable
    public String getUserEmail() {
        return user.getEmail();
    }

    @Bindable
    public String getUserPassword() {
        return user.getPassword();
    }

    public void setUserPassword(String password) {
        user.setPassword(password);
        notifyPropertyChanged(BR.userPassword);
    }

    public LoginViewModel() {
        user = new User("","");
    }

    public void onLoginClicked() {
        if (isInputDataValid())
        {
            setToastMessage(successMessage, userEmail);

        }
        else
            setToastMessage(errorMessage,userEmail);
    }
    public boolean isInputDataValid() {
        return !TextUtils.isEmpty(getUserEmail()) && Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches() && getUserPassword().length() > 5;
    }
}





