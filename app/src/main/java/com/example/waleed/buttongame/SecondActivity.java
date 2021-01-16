package com.example.waleed.buttongame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.AbsoluteLayout;
import android.widget.Button;

import java.util.Calendar;
import java.util.Random;

public class SecondActivity extends AppCompatActivity {



    int index = 0;
    int  currentMinute,lastMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);





                Button button = (Button) findViewById(R.id.my_button);
                AbsoluteLayout.LayoutParams absParams =
                        (AbsoluteLayout.LayoutParams) button.getLayoutParams();

                DisplayMetrics displaymetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
                int width = displaymetrics.widthPixels;
                int height = displaymetrics.heightPixels;


                Random r = new Random();

                absParams.x = r.nextInt(width);
                absParams.y = r.nextInt(height);
                button.setLayoutParams(absParams);
           






    }
}
