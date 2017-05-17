package com.kasper.mvp_onboarding.Register;

import com.kasper.mvp_onboarding.Login.OnLoginFinishedListener;

/**
 * Created by Kasper on 5/15/17.
 */

public interface IAsyncRegister_Interactor {
    void createCredentialsAsync(OnRegisterFinishedListener listener, String username, String password, String firstName, String lastName, String email, String phoneNumber);
}
