package it.conwine.android.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import it.conwine.android.R;
import it.conwine.android.models.User;
import it.conwine.android.retrofit.RetrofitService;
import it.conwine.android.retrofit.UserApi;
import retrofit2.Call;
import retrofit2.Callback;

public class SignupActivity extends AppCompatActivity {

    TextView login;
    TextInputEditText username, email, firstName, lastName, password;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initializateComponents();

    }

    private void initializateComponents() {
        username = findViewById(R.id.editText_username);
        email = findViewById(R.id.editText_email);
        firstName = findViewById(R.id.editText_firstName);
        lastName = findViewById(R.id.editText_lastName);
        password = findViewById(R.id.editText_passwordSignup);
        login = findViewById(R.id.textView_login);
        register = findViewById(R.id.button_register);

        RetrofitService retrofitService = new RetrofitService();
        UserApi userApi = retrofitService.getRetrofit().create(UserApi.class);

        register.setOnClickListener(view -> {

            String stringUsername = String.valueOf(username.getText());
            String stringEmail = String.valueOf(email.getText());
            String stringFirstName = String.valueOf(firstName.getText());
            String stringLastName = String.valueOf(lastName.getText());
            String stringPassword = String.valueOf(password.getText());

            User user = new User();
            user.setPassword(stringPassword);
            user.setUsername(stringUsername);
            user.setLastName(stringLastName);
            user.setEmail(stringEmail);
            user.setFirstName(stringFirstName);

            userApi.save(user)
                    .enqueue(new Callback<User>() {
                                 @Override
                                 public void onResponse(Call<User> call, retrofit2.Response<User> response) {
                                     Toast.makeText(SignupActivity.this, "registered", Toast.LENGTH_SHORT)
                                             .show();
                                 }

                                 @Override
                                 public void onFailure(Call<User> call, Throwable t) {
                                     Toast.makeText(SignupActivity.this, "not registered /n", Toast.LENGTH_SHORT)
                                             .show();
                                 }
                             }
                    );
            finish();
        });


        login.setOnClickListener(view -> {
            switchOnLogin();
            finish();
        });
    }

    public void switchOnLogin() {

        Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    public boolean validationForm () {
        String stringFirstName = firstName.getText().toString();
        if (stringFirstName.isEmpty()) {
            firstName.setError("first name cannot be empty");
            return false;
        }

        String stringLastName = lastName.getText().toString();
        if (stringLastName.isEmpty()) {
            lastName.setError("last name cannot be empty");
            return false;
        }

        String stringEmail = email.getText().toString();
        if (stringEmail.isEmpty()) {
            email.setError("invalid email");
            return false;
        }

        String stringUsername = username.getText().toString();
        if (stringUsername.isEmpty()) {
            username.setError("username cannot be empty");
            return false;
        }

        String stringPassword = password.getText().toString();
        if (stringPassword.isEmpty()) {
            password.setError("invalid password");
            return false;
        }
        return true;
    }
}