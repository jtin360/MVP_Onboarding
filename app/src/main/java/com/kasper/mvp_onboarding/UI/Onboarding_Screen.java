package com.kasper.mvp_onboarding.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kasper.mvp_onboarding.Onboarding.Onboarding_Presenter;
import com.kasper.mvp_onboarding.Onboarding.IOnboarding_Screen_View;
import com.kasper.mvp_onboarding.R;


public class Onboarding_Screen extends AppCompatActivity implements IOnboarding_Screen_View {

    private Button login_button, register_button;
    private Onboarding_Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboarding_screen);

        initalizeLayout();
        presenter = new Onboarding_Presenter(this);
    }

    private void initalizeLayout() {
        register_button = (Button) findViewById(R.id.register_button);
        login_button = (Button) findViewById(R.id.login_button);

        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.navigateToRegisterActivity();
            }
        });

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.navigateToLoginActivity();
            }
        });

    }

    @Override
    public void navigateToRegisterActivity() {
        Intent intent = new Intent(Onboarding_Screen.this, Register_Screen.class);
        startActivity(intent);
    }

    @Override
    public void navigateToLoginActivity() {
        Intent intent = new Intent(Onboarding_Screen.this, Login_Screen.class);
        startActivity(intent);
    }
}
