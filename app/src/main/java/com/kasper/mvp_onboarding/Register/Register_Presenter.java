package com.kasper.mvp_onboarding.Register;

/**
 * Created by Kasper on 5/16/17.
 */

public class Register_Presenter implements OnRegisterFinishedListener {

    private IRegister_View view;
    private AsyncRegister_Interactor interactor;

    public Register_Presenter(IRegister_View view){
        this.view = view;
        this.interactor = new AsyncRegister_Interactor();
    }

    public void createCredentialsAsync(String username, String password, String firstName, String lastName, String email, String phoneNumber) {
        interactor.createCredentialsAsync(this, username, password, firstName, lastName, email, phoneNumber);
    }

    @Override
    public void onEmptyUsername() {
        view.onEmptyUsername();
    }

    @Override
    public void onEmptyPassword() {
        view.onEmptyPassword();
    }

    @Override
    public void onEmptyFirstName() {
        view.onEmptyFirstName();
    }

    @Override
    public void onEmptyLastName() {
        view.onEmptyLastName();
    }

    @Override
    public void onEmptyEmail() {
        view.onEmptyEmail();
    }

    @Override
    public void onEmptyPhoneNumber() {
        view.onEmptyPhoneNumber();
    }

    @Override
    public void onFailUsername() {
        view.onFailUsername();
    }

    @Override
    public void onFailPassword() {
        view.onFailPassword();
    }

    @Override
    public void onFailFirstName() {
        view.onFailFirstName();
    }

    @Override
    public void onFailLastName() {
        view.onFailLastName();
    }

    @Override
    public void onFailEmail() {
        view.onFailEmail();
    }

    @Override
    public void onFailPhoneNumber() {
        view.onFailPhoneNumber();
    }

    @Override
    public void onSuccess() {
        view.navigateToHome();
    }

    @Override
    public void onFail() {
        view.registerFailed();
    }
}
