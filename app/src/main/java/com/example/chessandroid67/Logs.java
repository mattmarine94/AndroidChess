package com.example.chessandroid67;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.io.*;

import java.util.ArrayList;

public class Logs extends AppCompatActivity {

    private final String fileName = "logOfMoves.txt";
    ArrayList<String> log = new ArrayList<String>();
    Context context = this;
    String logMoves;
    ListView lstView;
    TextView textView2;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logs);
        TextView textView2 = findViewById(R.id.textView2);
        ListView  lstView = findViewById(R.id.lstView);
    load();




    }

    public void load() {

        FileInputStream fis = null;

        try {
            fis = openFileInput(fileName);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null) {
                sb.append(text);
                textView2.setText(R.string.debug);
            }



            //LstView.ad(sb.toString());

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

