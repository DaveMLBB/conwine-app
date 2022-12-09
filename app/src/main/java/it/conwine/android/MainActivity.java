package it.conwine.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView login;
    TextView username, email, firstName, lastName, password;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializateComponents();
        getSupportActionBar();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void initializateComponents() {
        username = findViewById(R.id.editText_username);
        email = findViewById(R.id.editText_email);
        firstName = findViewById(R.id.editText_firstName);
        lastName = findViewById(R.id.editText_lastName);
        password = findViewById(R.id.editText_password);
        login = findViewById(R.id.textView_login);



    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.button_register:
                Toast.makeText(this, "registered", Toast.LENGTH_SHORT).show();
                break;
            case R.id.textView_login:
                switchOnLogin();
                break;
            default:
                
                break;        
                
        }

    }

    private void switchOnLogin() {

        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}