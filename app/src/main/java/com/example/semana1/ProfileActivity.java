package com.example.semana1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private Button regresarButton;
    private EditText nuevoNombre;
    private TextView titulo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        String username = getIntent().getExtras().getString("username");

        regresarButton = findViewById(R.id.regresarButton);
        nuevoNombre = findViewById(R.id.nuevoNombre);

        nuevoNombre.setText(username);
        titulo = findViewById(R.id.titulo);

       regresarButton.setOnClickListener(
               (v)->{

                   Intent data = new Intent();
                   data.putExtra("username", nuevoNombre.getText().toString());
                   setResult(RESULT_OK, data);
                   finish();
               }
       );
    }
}