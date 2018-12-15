package com.example.yuripps.exitpoll;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.yuripps.exitpoll.db.DatabaseHelper;

import static com.example.yuripps.exitpoll.db.DatabaseHelper.COL_ID;
import static com.example.yuripps.exitpoll.db.DatabaseHelper.COL_SCORE;
//import static com.example.yuripps.exitpoll.adapter.ScoreListAdapter;
import static com.example.yuripps.exitpoll.db.DatabaseHelper.NUMBER_TABLE;


public class MainActivity extends AppCompatActivity {

    private long mId;
    public static String t_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button number1 = findViewById(R.id.number_i);
        number1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mId = 1;
                String newScore = String.valueOf(COL_SCORE) + 1;
                ContentValues cv = new ContentValues();
                cv.put(COL_SCORE, newScore);
//
                db.update(
                        t_name,
                        cv,
                        COL_ID + " = ?",
                        new String[]{String.valueOf(mId)}
                );

                finish();


            }
        });

        Button number2 = findViewById(R.id.number_ii);
        number1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mId = 2;
                String newScore = String.valueOf(COL_SCORE) + 1;
                ContentValues cv = new ContentValues();
                cv.put(COL_SCORE, newScore);
                db.update(
                        t_name,
                        cv,
                        COL_ID + " = ?",
                        new String[]{String.valueOf(mId)}
                );
                finish();
            }
        });

        Button number3 = findViewById(R.id.number_iii);
        number1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mId = 3;
                String newScore = String.valueOf(COL_SCORE) + 1;
                ContentValues cv = new ContentValues();
                cv.put(COL_SCORE, newScore);
//
                db.update(
                        t_name,
                        cv,
                        COL_ID + " = ?",
                        new String[]{String.valueOf(mId)}
                );
                finish();
            }
        });

        Button number4 = findViewById(R.id.number_iv);
        number1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mId = 4;
                String newScore = String.valueOf(COL_SCORE) + 1;
                ContentValues cv = new ContentValues();
                cv.put(COL_SCORE, newScore);

                db.update(
                        t_name,
                        cv,
                        COL_ID + " = ?",
                        new String[]{String.valueOf(mId)}
                );
                finish();

            }
        });

         Button look = findViewById(R.id.button5);
            look.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this,ScoreTotal.class);
                    startActivity(intent);
                }
            });
    }
}
