package com.kasper.mvp_onboarding.UI;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.kasper.mvp_onboarding.Login.ILogin_View;
import com.kasper.mvp_onboarding.Login.Login_Presenter;
import com.kasper.mvp_onboarding.R;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

/**
 * Created by Kasper on 5/15/17.
 */

public class Login_Screen extends AppCompatActivity implements ILogin_View {

    private EditText username, password;
    private Button login_button;
    private Login_Presenter presenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        initalizeLayout();

        presenter = new Login_Presenter(this);

    }

    private void initalizeLayout() {
        username = (EditText)  findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login_button = (Button) findViewById(R.id.login_button);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = ProgressDialog.show(v.getContext(), "Authenticating...", null);
                presenter.validateCredentialsAsync(username.getText().toString().toLowerCase().trim(), password.getText().toString().toLowerCase().trim());
            }
        });
    }

    @Override
    public void navigateToHome() {
        progressDialog.dismiss();
        Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailed() {
        progressDialog.dismiss();
        Toast.makeText(this, "I can't find your account in my database :(",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void usernameFailed() {
        progressDialog.dismiss();
        Toast.makeText(this, "Oop! You forgot to enter your username!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void passwordFailed() {
        progressDialog.dismiss();
        Toast.makeText(this, "Oop! You forgot to enter your password!",Toast.LENGTH_SHORT).show();
    }
}
