package com.example.filesystemsexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class VisualizaDadosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualiza_dados);
        TextView nome = findViewById(R.id.txvNome);
        TextView sobrenome = findViewById(R.id.txvSobrenome);
        Button button = findViewById(R.id.button);

        try {
            FileInputStream fileInputStream = openFileInput("usuarios");
            StringBuffer stringBuffer = new StringBuffer();

            int i;
            while ((i =  fileInputStream.read())!= -1){
                stringBuffer.append((char) i);
            }
            fileInputStream.close();
            String detalhes[] = stringBuffer.toString().split("\n");
            nome.setText(detalhes[0]);
            sobrenome.setText(detalhes[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VisualizaDadosActivity.this, MainActivity.class));
            }
        });
    }
}