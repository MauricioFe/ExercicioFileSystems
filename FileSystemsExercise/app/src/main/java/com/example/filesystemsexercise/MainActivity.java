package com.example.filesystemsexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText edtNome = findViewById(R.id.edtNome);
        final EditText edtSobrenome = findViewById(R.id.edtSobrenome);
        Button btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = edtNome.getText().toString()+"\n";
                String sobrenome = edtSobrenome.getText().toString();
                try{
                    FileOutputStream fileOutputStream = openFileOutput("usuarios",MODE_PRIVATE);
                    fileOutputStream.write(nome.getBytes());
                    fileOutputStream.write(sobrenome.getBytes());
                    fileOutputStream.close();
                    fileOutputStream.flush();

                    Toast.makeText(MainActivity.this, "Usuário salvo com sucesso", Toast.LENGTH_LONG).show();

                    startActivity(new Intent(MainActivity.this, VisualizaDadosActivity.class));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}