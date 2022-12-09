package it.conwine.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText username, password;
    Button login;
    TextView register, resetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initializeComponents();
    }

    private void initializeComponents() {
        username=findViewById(R.id.editText_username);
        password=findViewById(R.id.editText_password);
        login = findViewById(R.id.button_loginuser);
        register= findViewById(R.id.textView_Register);
        resetPassword = findViewById(R.id.textView_passwordReset);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.button_loginuser:
                startActivity(new Intent(LoginActivity.this,
                        HomeActivity.class ));
                break;
            case R.id.textView_Register:
                switchOnRegister();
        }
    }

    private void switchOnRegister() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }
}