package com.example.yuripps.exitpoll.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yuripps.exitpoll.R;
import com.example.yuripps.exitpoll.model.ScoreItem;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.example.yuripps.exitpoll.model.ScoreItem;

public class ScoreListAdapter extends ArrayAdapter<ScoreItem> {
    private Context mContext;
    private int mResource;
    private List<ScoreItem> mScoreList;

    public ScoreListAdapter(@NonNull Context context,
                            int resource,
                            @NonNull List<ScoreItem> scoreItemList) {
        super(context, resource, scoreItemList);
        this.mContext = context;
        this.mResource = resource;
        this.mScoreList = scoreItemList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(mResource, parent, false);


        TextView score = view.findViewById(R.id.score_text_view);
        TextView unitTextView = view.findViewById(R.id.unit_text_view);
        ImageView imageView = view.findViewById(R.id.image_view);


        ScoreItem scoreItem = mScoreList.get(position);
        String filename = scoreItem.image;
        String sc = scoreItem.score;


        unitTextView.setText(sc);

        AssetManager am = mContext.getAssets();
        try {
            InputStream is = am.open(filename);
            Drawable drawable = Drawable.createFromStream(is, "");
            imageView.setImageDrawable(drawable);
        } catch (IOException e) {
            File privateDir = mContext.getFilesDir();
            File logoFile = new File(privateDir, filename);

            Bitmap bitmap = BitmapFactory.decodeFile(logoFile.getAbsolutePath(), null);
            imageView.setImageBitmap(bitmap);

            e.printStackTrace();
        }

        return view;
    }
}



