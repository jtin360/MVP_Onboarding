package com.kasper.mvp_onboarding.Login;

/**
 * Created by Kasper on 5/15/17.
 */

public interface ILogin_View {
    void navigateToHome();
    void loginFailed();
    void usernameFailed();
    void passwordFailed();
}
