package com.wen.atmpractice;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText edusername;
    private EditText edpassword;
    private String username;
    private String password;
    private SharedPreferences setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edusername = findViewById(R.id.ed_username);
        edpassword = findViewById(R.id.ed_password);
        setting = getSharedPreferences("atm", MODE_PRIVATE);
        edusername.setText(setting.getString("PREF_USERNAME",""));
    }

    public void login(View view) {
        username = edusername.getText().toString();
        password = edpassword.getText().toString();
        if ("wendy".equals(username) && "1234".equals(password)) {
            setting.edit()
                    .putString("PREF_USERNAME", username)
                    .commit();
            setResult(RESULT_OK);
            finish();
        } else {
            new AlertDialog.Builder(this)
                    .setTitle("ERROR")
                    .setMessage("Login Fail.")
                    .setPositiveButton("OK",null)
                    .show();
        }
    }
}
