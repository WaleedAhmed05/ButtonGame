package com.example.waleed.buttongame;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class ThirdActivity extends AppCompatActivity {

    ImageButton score_btn;
    TextView score_view;
    int counter;
    String counter_string;
    public static String Your_score;

    DBHelper helperr;
    SQLiteDatabase dbb;
    Cursor cc;
    String test="test";
    int max_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        helperr = new DBHelper(this);
        dbb= helperr.getReadableDatabase();
        cc = dbb.rawQuery("SELECT Max(score) FROM High_chart",null);
        cc.moveToFirst();
        max_score =cc.getInt(0);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.click);
        final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.lost);










        //db=openOrCreateDatabase("ButtonGame", Context.MODE_PRIVATE, null);
        //db.execSQL("CREATE TABLE IF NOT EXISTS High_score(score INTEGER);");
        //db.execSQL("INSERT INTO High_score VALUES('17');");




        score_btn = findViewById(R.id.button);
        score_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                mp.start();
                counter = counter + 1;
                counter_string = Integer.toString(counter);

                TextView tv = (TextView) findViewById(R.id.score_view);
                tv.setText(counter_string);
            }
        });


        RelativeLayout rlayout = (RelativeLayout) findViewById(R.id.mainlayout);
        rlayout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {



                //Toast.makeText(this,"Game Over",Toast.LENGTH_LONG.show());
                Your_score=counter_string;
                mp2.start();
                Intent i = new Intent( ThirdActivity.this, GameOverActivity.class);
                startActivity(i);



            }

        });




        final ImageButton button = (ImageButton) findViewById(R.id.button);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Random rand = new Random();
                while (true) {
                    Log.e("TAG", "thread");
                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) button.getLayoutParams();
                    params.setMargins(rand.nextInt(1000), rand.nextInt(1000), 0, 0);







                    try {

                        if (counter<10)
                        {
                            Thread.sleep(1100);
                        }//If counter score

                        else if (counter<15)
                        {
                            Thread.sleep(900);
                        }

                        else if (counter<20)
                        {
                            Thread.sleep(600);
                        }

                        else
                        {
                            Thread.sleep(500);
                        }

                       // Thread.sleep(1000);
                    } catch (Exception e) {

                    }
                    button.post(new Runnable() {
                        @Override
                        public void run() {
                            button.requestLayout(); //has to be called in UI thread
                        }
                    });

                }
            }
        });
        thread.start();











    }
    @Override
    public void onBackPressed() {

        if (counter>max_score)
        {


            DBHelper helper = new DBHelper(this);
            SQLiteDatabase db = helper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("score",counter);

            db.insert("High_chart", null, values);

            db.close();




            Toast.makeText(this,"New High Score", Toast.LENGTH_LONG).show();
        }

      Toast.makeText(this,"Your Score "+ counter_string, Toast.LENGTH_LONG).show();

        super.onBackPressed();
    }


    @Override
    public void onRestart() {
        super.onRestart();
        finish();
        startActivity(getIntent());
    }

}
