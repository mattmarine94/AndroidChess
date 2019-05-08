package com.example.chessandroid67;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.*;

import java.util.ArrayList;

public class Logs extends AppCompatActivity {

    private final String fileName = "logOfMoves.txt";
    ArrayList<String> log = new ArrayList<String>();
    Context context = this;
    String logMoves;
    String logName = "";
    ArrayList<String> names = new ArrayList<String>();




    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logs);
        ListView lstView = findViewById(R.id.lstView);
        TextView textView2 = findViewById(R.id.textView2);
        Button btnDefault = findViewById(R.id.btnDefault);
        names.add("Daniel Cherdak");
        names.add("Matthew");



        btnDefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Logs.this, Watch.class);
                intent.putExtra("logOfMoves", logMoves);
                startActivity(intent);
            }
        });

    }


    public void load() {

        FileInputStream fis = null;

        try {
            fis = openFileInput(fileName);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            StringBuilder sa = new StringBuilder();
            String text;
            int counter = 0;
            while ((text = br.readLine()) != null) {
                if(text.equals("\n") == false) {
                    sb.append(text);
                }
                else{
                    counter++;
                    logName = sb.toString();
                    names.add(logName);
                    sb.setLength(0);
                }

                if (counter == 1 &&text.equals("\n") == false) {
                    sa.append(text);
                }else{
                    counter--;
                    logMoves = sa.toString();
                    log.add(logMoves);
                    sa.setLength(0);
                }

            }





        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    }

