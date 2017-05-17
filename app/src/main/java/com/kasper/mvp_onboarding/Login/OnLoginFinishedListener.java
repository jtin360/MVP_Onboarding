package com.kasper.mvp_onboarding.Login;

/**
 * Created by Kasper on 5/15/17.
 */

public interface OnLoginFinishedListener {
    void onError();
    void onSuccess();
    void onUsernameFailed();
    void onPasswordFailed();
}
