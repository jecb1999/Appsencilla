package com.example.semana1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView loginTitle;
    private ImageView loginLogo;
    private EditText loginUserName;
    private EditText loginPassword;
    private Button loginButton;
    private static final int CODE = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginTitle = findViewById(R.id.loginTitle);
        loginLogo = findViewById(R.id.loginLogo);
        loginUserName = findViewById(R.id.loginUserName);
        loginPassword = findViewById(R.id.loginPassword);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(

                (v) -> {
                    String userName = loginUserName.getText().toString();
                    String password = loginPassword.getText().toString();
                    //Toast.makeText(this, userName+" "+password, Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(this, ProfileActivity.class);
                    intent.putExtra("username", userName);
                    startActivityForResult(intent,CODE);
                }
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CODE && resultCode == RESULT_OK){
            String username = data.getExtras().getString("username");
            loginUserName.setText(username);
        }
    }
}