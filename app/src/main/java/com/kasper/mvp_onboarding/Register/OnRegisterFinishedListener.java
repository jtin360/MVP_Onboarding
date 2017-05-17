package com.kasper.mvp_onboarding.Register;

/**
 * Created by Kasper on 5/16/17.
 */

public interface OnRegisterFinishedListener {
    void onEmptyUsername();
    void onEmptyPassword();
    void onEmptyFirstName();
    void onEmptyLastName();
    void onEmptyEmail();
    void onEmptyPhoneNumber();
    void onFailUsername();
    void onFailPassword();
    void onFailFirstName();
    void onFailLastName();
    void onFailEmail();
    void onFailPhoneNumber();
    void onSuccess();
    void onFail();
}
