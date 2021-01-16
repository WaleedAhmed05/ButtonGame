package com.example.waleed.buttongame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity {

    TextView finalscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);


        TextView tv = (TextView) findViewById(R.id.finalscore);
        tv.setText(ThirdActivity.Your_score);

    }


    public void onBackPressed() {

        super.onBackPressed();

    }
}
