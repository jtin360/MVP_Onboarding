package com.kasper.mvp_onboarding.UI;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kasper.mvp_onboarding.R;
import com.kasper.mvp_onboarding.Register.IRegister_View;
import com.kasper.mvp_onboarding.Register.Register_Presenter;

/**
 * Created by Kasper on 5/15/17.
 */

public class Register_Screen extends AppCompatActivity implements IRegister_View {

    private EditText username, password, firstName, lastName, email, phoneNumber;
    private Button register_button;
    private Register_Presenter presenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_screen);

        initalizeLayout();

    }

    private void initalizeLayout() {
        presenter = new Register_Presenter(this);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        firstName = (EditText) findViewById(R.id.first_name);
        lastName = (EditText) findViewById(R.id.last_name);
        email = (EditText) findViewById(R.id.email);
        phoneNumber = (EditText) findViewById(R.id.phone_number);
        register_button = (Button) findViewById(R.id.register_button);

        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = ProgressDialog.show(v.getContext(), "Authenticating...", null);
                String u = username.getText().toString().toLowerCase().trim();
                String p = password.getText().toString().trim();
                String f = firstName.getText().toString().toLowerCase().trim();
                String l = lastName.getText().toString().toLowerCase().trim();
                String e = email.getText().toString().toLowerCase().trim();
                String pn = phoneNumber.getText().toString().trim();

                System.out.println(u + " " + p + " " + f + " " + l + " " + e + " " + pn);

                presenter.createCredentialsAsync(u, p, f, l, e, pn);
            }
        });
    }

    @Override
    public void navigateToHome() {
        progressDialog.dismiss();
        Toast.makeText(this, "Register Success!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEmptyUsername() {
        progressDialog.dismiss();
        Toast.makeText(this, "Oop! You forgot to enter your username!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEmptyPassword() {
        progressDialog.dismiss();
        Toast.makeText(this, "Oop! You forgot to enter your password!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEmptyFirstName() {
        progressDialog.dismiss();
        Toast.makeText(this, "Oop! You forgot to enter your first name!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEmptyLastName() {
        progressDialog.dismiss();
        Toast.makeText(this, "Oop! You forgot to enter your last name!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEmptyEmail() {
        progressDialog.dismiss();
        Toast.makeText(this, "Oop! You forgot to enter your email!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEmptyPhoneNumber() {
        progressDialog.dismiss();
        Toast.makeText(this, "Oop! You forgot to enter your phone number!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailUsername() {
        progressDialog.dismiss();
        Toast.makeText(this, "Oop! You cannot use that in your username", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailPassword() {
        progressDialog.dismiss();
        Toast.makeText(this, "Your password has to be at least 8 characters that contains at least one lowercase and one uppercase with at least one special symbol!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailFirstName() {
        progressDialog.dismiss();
        Toast.makeText(this, "Oop! You cannot use that in your first name", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailLastName() {
        progressDialog.dismiss();
        Toast.makeText(this, "Oop! You cannot use that in your last name", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailEmail() {
        progressDialog.dismiss();
        Toast.makeText(this, "Oop! You cannot use that in your email", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailPhoneNumber() {
        progressDialog.dismiss();
        Toast.makeText(this, "Oop! You cannot use that in your phone number", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void registerFailed() {
        progressDialog.dismiss();
        Toast.makeText(this, "Oop! Unable to register right now.", Toast.LENGTH_SHORT).show();
    }
}
