package com.example.yuripps.exitpoll.model;

import java.util.Locale;

public class ScoreItem {
    public final long _id;
    public final String name;
    public final String image;
    public final String score;

    public ScoreItem(long _id, String name, String image, String score) {
        this._id = _id;
        this.name = name;
        this.image = image;
        this.score = score;
    }

    @Override
    public String toString() {
        String msg = String.format(
                Locale.getDefault(),
                "%s (%s) (%s)",
                this.name,
                this.score
        );
        return msg;
    }
}