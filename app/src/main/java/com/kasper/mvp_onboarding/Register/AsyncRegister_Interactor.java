package com.kasper.mvp_onboarding.Register;

import android.os.Handler;

import com.kasper.mvp_onboarding.Login.OnLoginFinishedListener;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Kasper on 5/16/17.
 */

public class AsyncRegister_Interactor implements IAsyncRegister_Interactor {

    public void createCredentialsAsync(final OnRegisterFinishedListener listener, final String username, final String password, final String firstName, final String lastName, final String email, final String phoneNumber) {

        new Handler().postDelayed(new Runnable() {
            @Override public void run() {

                if (validateUsername(username, listener)) {

                    if (validatePassword(password, listener)) {

                        if (validateFirstName(firstName, listener)) {

                            if (validateLastName(lastName, listener)) {

                                if (validateEmail(email, listener)) {

                                    if (validatePhoneNumber(phoneNumber, listener)) {
                                        ParseUser user = new ParseUser();
                                        user.put("first_name", firstName);
                                        user.put("last_name", lastName);
                                        user.setUsername(username.trim().toLowerCase());
                                        user.setPassword(password.trim());
                                        user.setEmail(email.trim());
                                        user.put("phone", phoneNumber.trim());

                                        user.signUpInBackground(new SignUpCallback() {
                                            public void done(ParseException e) {
                                                if (e == null) {
                                                    listener.onSuccess();
                                                } else {
                                                    System.out.println("cant sign up " + e.getLocalizedMessage());
                                                    listener.onFail();
                                                }
                                            }
                                        });
                                    } else {
                                        //phone number didnt work :(
                                    }
                                } else {
                                    //email didnt work :(
                                }
                            } else {
                                //last name didnt work :(
                            }
                        } else {
                            //first name didnt work :(
                        }
                    } else {
                        //password didnt work :(
                    }
                } else {
                    //username didnt work :(
                }
            }
        }, 0);
    }

    public boolean validateUsername(final String username, final OnRegisterFinishedListener listener) {

        //regex to only allow alphanumeric
        Pattern pattern = Pattern.compile("^[0-9a-zA-Z]+$");
        Matcher matcher = pattern.matcher(username);

        if(!username.isEmpty()){
            if (matcher.matches()) {
                return true;
            }
            else {
                listener.onFailUsername();
                return false;
            }
        }
        else {
            listener.onEmptyUsername();
            return false;
        }
    }

    public boolean validatePassword(final String password, final OnRegisterFinishedListener listener) {

        //regex to only alloww 8 chars with 1 symbol
        Pattern pattern = Pattern.compile("^(?=.{8,})(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=]).*$");
        Matcher matcher = pattern.matcher(password);

        if(!password.isEmpty() && password.length() >= 1){
            if(matcher.matches()) {
                return true;
            }
            else {
                listener.onFailPassword();
                return false;
            }
        }
        else {
            listener.onEmptyPassword();
            return false;
        }
    }

    public boolean validateFirstName(final String firstName, final OnRegisterFinishedListener listener) {

        //regex to only allow characters
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
        Matcher matcher = pattern.matcher(firstName);

        if(!firstName.isEmpty() && firstName.length() >= 1) {
            if (matcher.matches()) {
                return true;
            }
            else {
                listener.onFailFirstName();
                return false;
            }
        }
        listener.onEmptyFirstName();
        return false;
    }

    public boolean validateLastName(final String lastName, final OnRegisterFinishedListener listener) {
        //regex to only allow characters
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
        Matcher matcher = pattern.matcher(lastName);

        if(!lastName.isEmpty() && lastName.length() >= 1) {
            if (matcher.matches()) {
                return true;
            }
            else {
                listener.onFailLastName();
                return false;
            }
        }
        listener.onEmptyLastName();
        return false;
    }

    public boolean validateEmail(final String email, final OnRegisterFinishedListener listener) {

        //regex to validate email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(email);

        if(!email.isEmpty()){
            if (matcher.matches()) {
                return true;
            }
            else {
                listener.onFailEmail();
                return false;
            }
        }
        listener.onEmptyEmail();
        return false;
    }

    public boolean validatePhoneNumber(final String phoneNumber, final OnRegisterFinishedListener listener) {
        String number = phoneNumber;
        number = phoneNumber.replaceAll("[^0-9]", "");

        if(number.length() == 10) {
            return true;
        }
        else if(number.length() == 0){
            listener.onEmptyPhoneNumber();
            return false;
        }
        else {
            listener.onFailPhoneNumber();
            return false;
        }
    }
}
