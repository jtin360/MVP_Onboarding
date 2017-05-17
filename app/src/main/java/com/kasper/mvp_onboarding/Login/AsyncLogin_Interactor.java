package com.kasper.mvp_onboarding.Login;

import android.os.Handler;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

/**
 * Created by Kasper on 5/15/17.
 */

public class AsyncLogin_Interactor implements IAsyncLogin_Interactor {

    public void validateCredentialsAsync(final OnLoginFinishedListener listener, final String username, final String password){

        //validates credential using Parse
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {

                if(username.isEmpty()) {
                    listener.onUsernameFailed();
                }
                else if(password.isEmpty()) {
                    listener.onPasswordFailed();
                }

                ParseUser.logInInBackground(username, password, new LogInCallback() {
                    public void done(ParseUser user, ParseException e) {
                        if (e == null) {
                            listener.onSuccess();
                        } else {
                            listener.onError();
                        }
                    }
                });
            }
        }, 0);
    }
}
