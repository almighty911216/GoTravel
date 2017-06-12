package com.example.almig.android.model;

/**
 * Created by almig on 2017-06-11.
 */

public class FootprintTextModel {
    private long mId;
    private int mImageURL;
    private String mTitle;
    private String mContent;
    private String mDate;

    public FootprintTextModel() {
    }

    public FootprintTextModel(long id, int imageURL, String title, String content, String date) {
        mId = id;
        mImageURL = imageURL;
        mTitle = title;
        mContent = content;
        mDate = date;
    }

    public long getId() {
        return mId;
    }

    public void setId(long mId) {
        this.mId = mId;
    }

    public int getImageURL() {
        return mImageURL;
    }

    public void setImageURL(int mImageURL) {
        this.mImageURL = mImageURL;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String mContent) {
        this.mContent = mContent;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String mDate) {
        this.mDate = mDate;
    }

    @Override
    public String toString() {
        return mTitle;
    }
}
