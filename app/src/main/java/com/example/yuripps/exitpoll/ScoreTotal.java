package com.example.yuripps.exitpoll;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.yuripps.exitpoll.adapter.ScoreListAdapter;
import com.example.yuripps.exitpoll.db.DatabaseHelper;
import com.example.yuripps.exitpoll.model.ScoreItem;
import com.example.yuripps.exitpoll.MainActivity;
import com.example.yuripps.exitpoll.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.yuripps.exitpoll.db.DatabaseHelper.COL_ID;
import static com.example.yuripps.exitpoll.db.DatabaseHelper.COL_NAME;
import static com.example.yuripps.exitpoll.db.DatabaseHelper.COL_IMAGE;
import static com.example.yuripps.exitpoll.db.DatabaseHelper.COL_SCORE;

import static com.example.yuripps.exitpoll.db.DatabaseHelper.NUMBER_TABLE;







public class ScoreTotal extends AppCompatActivity {
    private long mId;
    public static String t_name;

    private static final String TAG = MainActivity.class.getName();

    private DatabaseHelper mHelper;
    private SQLiteDatabase mDb;
    private List<ScoreItem> mScoreItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_total);

        mHelper = new DatabaseHelper(ScoreTotal.this);
        mDb = mHelper.getWritableDatabase();

        Button clearScore = findViewById(R.id.clear_button);
        clearScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mId = 1;
                ContentValues cv = new ContentValues();
                cv.put(COL_SCORE, 0);
//                for(mId = 1; mId <= 4; ++mId) {
//                    db.update(
//                            t_name,
//                            cv,
//                            COL_ID + " = ?",
//                            new String[]{String.valueOf(mId)}
//
//
//                    );
//                }

                finish();



            }
        });




    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadPhoneData();
        setupListView();
    }
    private void loadPhoneData() {

        Cursor c = mDb.query(NUMBER_TABLE, null, null, null, null, null, null);
        mScoreItemList = new ArrayList<>();
        while (c.moveToNext()) {
            long id = c.getLong(c.getColumnIndex(COL_ID));
            String image = c.getString(c.getColumnIndex(COL_IMAGE));
            String score = c.getString(c.getColumnIndex(COL_SCORE));

            ScoreItem item = new ScoreItem(id, image, score);
            mScoreItemList.add(item);
        }
        c.close();
    }

    private void setupListView() {
        ScoreListAdapter adapter = new ScoreListAdapter(
                ScoreTotal.this,
                R.layout.activity_item_score,
                mScoreItemList
        );
        ListView lv = findViewById(R.id.result_list_view);
        lv.setAdapter(adapter);
    }
}