package com.example.app_24_9;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText et_fileName = findViewById(R.id.ed_ten);
        final EditText et_noidung = findViewById(R.id.ed_nhap);
        Button bt_moi = findViewById(R.id.bt_nhap);
        bt_moi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_fileName.setText("");
                et_noidung.setText("");
            }
        });

        final ArrayList<String> fileNameList = new ArrayList<>();
           // fileNameList.add("Tam Beo Hellooo cac ban ...........");
            final Spinner sp_fileName = findViewById(R.id.spinner2);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,fileNameList);
            sp_fileName.setAdapter(adapter);
            sp_fileName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    et_fileName.setText(fileNameList.get(i).toString());
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
            Button bt_luu = findViewById(R.id.bt_luu);
            bt_luu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String fileName = et_fileName.getText().toString();
                    fileNameList.add(fileName);
                    try {
                        FileOutputStream fileOutputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
                        fileOutputStream.write(et_noidung.getText().toString().getBytes());
                        fileOutputStream.close();
                    }
                    catch (Exception e){
                        Toast.makeText(MainActivity.this,"Loi luu file",Toast.LENGTH_LONG);
                    }
                }
            });
            Button bt_mo = findViewById(R.id.bt_mo);
          bt_mo.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  new MainActivity2();
              }
          });
//
//            bt_mo.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    String fileName = et_fileName.getText().toString();
//                    StringBuffer stringBuffer = new StringBuffer();
//                    String line = null;
//                    try {
//                        FileInputStream fileInputStream = openFileInput(fileName);
//                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
//                        while ((line=bufferedReader.readLine())!=null)
//                            stringBuffer.append(line).append("\n");
//                        et_noidung.setText(stringBuffer.toString());
//                    }catch (Exception e){
//
//                    }
//
//                }
//            });
    }
}
