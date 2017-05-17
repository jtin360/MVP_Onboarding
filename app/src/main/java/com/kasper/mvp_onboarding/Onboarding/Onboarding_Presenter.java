package com.kasper.mvp_onboarding.Onboarding;

/**
 * Created by Kasper on 5/15/17.
 */

public class Onboarding_Presenter implements IOnboarding_Screen_View {

    private IOnboarding_Screen_View view;

    public Onboarding_Presenter(IOnboarding_Screen_View view){
        this.view = view;
    }


    @Override
    public void navigateToRegisterActivity() {
        view.navigateToRegisterActivity();
    }

    @Override
    public void navigateToLoginActivity() {
        view.navigateToLoginActivity();
    }
}
