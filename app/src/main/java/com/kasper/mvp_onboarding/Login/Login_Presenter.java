package com.kasper.mvp_onboarding.Login;

/**
 * Created by Kasper on 5/15/17.
 */

public class Login_Presenter implements OnLoginFinishedListener {

    private ILogin_View view;
    private AsyncLogin_Interactor interactor;

    public Login_Presenter(ILogin_View view) {
        this.view = view;
        this.interactor = new AsyncLogin_Interactor();
    }

    public void validateCredentialsAsync(String username, String password){
        interactor.validateCredentialsAsync(this, username, password);
    }

    @Override
    public void onError() {
        view.loginFailed();
    }

    @Override
    public void onSuccess() {
        view.navigateToHome();
    }

    @Override
    public void onUsernameFailed() {
        view.usernameFailed();
    }

    @Override
    public void onPasswordFailed() {
        view.passwordFailed();
    }

}
