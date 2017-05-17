package com.kasper.mvp_onboarding.Register;

/**
 * Created by Kasper on 5/15/17.
 */

public interface IRegister_View {
    void navigateToHome();
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
    void registerFailed();
}
