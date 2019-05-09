package com.example.chessandroid67;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.*;

import java.util.ArrayList;
import java.util.List;

public class Logs extends AppCompatActivity {

    private final String fileName = "logOfMoves.txt";
    ArrayList<String> log = new ArrayList<String>();
    Context context = this;
    String logMoves;
    String logName = "";
    List<String> names = new ArrayList<String>();




    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logs);
        //ListView lstView = findViewById(R.id.lstView);
        Button btnDefault = findViewById(R.id.btnDefault);


        load();


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.listlogs,names);
        ListView lstView = (ListView) findViewById(R.id.lstView);
        lstView.setAdapter(adapter);


        btnDefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Logs.this, Watch.class);
                intent.putStringArrayListExtra("logOfMoves", log);
                startActivity(intent);
            }
        });

        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Logs.this, Watch.class);
                // find log of moves according to the position
                ArrayList<String> logging = new ArrayList<String>();

                logging.add(log.get(position));

                intent.putStringArrayListExtra("logOfMoves", logging);
                startActivity(intent);
            }
        });
    }


    public void load() {

        Toast.makeText(Logs.this, "Pulling file from " + getFilesDir() + "/" + fileName, Toast.LENGTH_LONG).show();

        String ret = "";

        try {
            InputStream inputStream = context.openFileInput(fileName);

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();
                int counter = 0;
                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);

                    if (counter == 0){
                        names.add(stringBuilder.toString());
                        counter++;
                        stringBuilder.setLength(0);
                    }
                    if(stringBuilder.length() > 0 && stringBuilder.substring(stringBuilder.length()-3).toString().equals("end"))
                    {
                        System.out.println("inside end loop");
                        log.add(stringBuilder.toString());
                        counter = 0;
                        stringBuilder.setLength(0);
                    }


                }
                log.add(stringBuilder.toString());

                inputStream.close();

                //names.add(stringBuilder.toString());
            }
        }
        catch (FileNotFoundException e) {

        } catch (IOException e) {

        }


    }

}