package com.example.vedanta.fleavatest.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.vedanta.fleavatest.R;
import com.example.vedanta.fleavatest.model.Login;
import com.example.vedanta.fleavatest.service.RestManager;
import com.jgabrielfreitas.core.BlurImageView;

import static com.example.vedanta.fleavatest.util.Constant.LOGIN_URL;

public class LoginActivity extends AppCompatActivity {

    private RestManager mRestManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        BlurImageView blur = findViewById(R.id.blur_background);
        blur.setBlur(5);

        final EditText etEmail = findViewById(R.id.email);
        final EditText etPassword = findViewById(R.id.password);
        Button loginBtn = findViewById(R.id.login_btn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etEmail.getText()) || TextUtils.isEmpty(etPassword.getText())) {
                    Toast.makeText(getApplicationContext(), "Username or password can't be empty.", Toast.LENGTH_SHORT).show();
                } else {
                    String email = etEmail.getText().toString();
                    String password = etPassword.getText().toString();
                    mRestManager = new RestManager();
                    signIn(email, password);
                }
            }
        });
    }

    private void signIn(String email, String password) {
        Call<Login> loginCall = mRestManager.getDataService(LOGIN_URL).signIn(email, password);

        loginCall.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if (response.isSuccessful()) {
                    Login loginData = response.body();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);

                } else {
                    Toast.makeText(getApplicationContext(), "error code: " + response.code(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
