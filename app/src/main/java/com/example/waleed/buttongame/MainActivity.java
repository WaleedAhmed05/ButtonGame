package com.example.waleed.buttongame;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView tv_high_score,tv_instruction;
    int temp;
    String temp2;
    String DB_high_score;

    DBHelper helper;
    SQLiteDatabase db;
    Cursor c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        helper = new DBHelper(this);
        db = helper.getReadableDatabase();
        c = db.rawQuery("SELECT MAX(score) FROM High_chart",null);
        c.moveToLast();
        temp =c.getInt(0);
        DB_high_score=Integer.toString(temp);


        tv_high_score = findViewById(R.id.high_score);
        tv_high_score.setText(DB_high_score);

        tv_instruction=findViewById(R.id.tv_instruct);



        btn = findViewById(R.id.start_game);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent( MainActivity.this, ThirdActivity.class);
                startActivity(i);

            }
        });


        tv_instruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent( MainActivity.this, InstructionActivity.class);
                startActivity(i);

            }
        });






    }


    @Override
    protected void onResume() {

        super.onResume();
        //finish();
        startActivity(getIntent());


    }





}
