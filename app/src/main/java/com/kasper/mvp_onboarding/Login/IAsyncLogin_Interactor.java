package com.kasper.mvp_onboarding.Login;

/**
 * Created by Kasper on 5/15/17.
 */

public interface IAsyncLogin_Interactor {
    void validateCredentialsAsync(OnLoginFinishedListener listener, String username, String password);
}
