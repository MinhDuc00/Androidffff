package com.example.app_24_9;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class MainActivity2 extends AppCompatActivity {
    Button btnmo;
    EditText et_filename;
    EditText et_noidung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    btnmo = (Button)findViewById(R.id.btn_mo);
    btnmo.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button bt_mo = findViewById(R.id.bt_mo);
            bt_mo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String fileName = et_filename.getText().toString();
                    StringBuffer stringBuffer = new StringBuffer();
                    String line = null;
                    try {
                        FileInputStream fileInputStream = openFileInput(fileName);
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                        while ((line=bufferedReader.readLine())!=null)
                            stringBuffer.append(line).append("\n");
                        et_noidung.setText(stringBuffer.toString());
                    }catch (Exception e){

                    }

                }
            });
        }
    });
}}
