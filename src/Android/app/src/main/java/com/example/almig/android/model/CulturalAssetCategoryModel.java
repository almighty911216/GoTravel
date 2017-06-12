package com.example.almig.android.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by almig on 2017-06-11.
 */

public class CulturalAssetCategoryModel implements Parcelable {
    private long mId;
    private int mLogoId;
    private int mTitleId;
    private boolean mVisit;

    public CulturalAssetCategoryModel() {
    }

    protected CulturalAssetCategoryModel(Parcel in) {
        mId = in.readLong();
        mLogoId = in.readInt();
        mTitleId = in.readInt();
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public int getLogoId() {
        return mLogoId;
    }

    public void setLogoId(int logoId) {
        mLogoId = logoId;
    }

    public int getTitleId() {
        return mTitleId;
    }

    public void setTitleId(int titleId) {
        mTitleId = titleId;
    }

    public void setVisit(boolean visit) {
        mVisit = visit;
    }

    public boolean getVisit() { return mVisit; }

    public boolean isVisit() {
        return mVisit;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(mId);
        dest.writeInt(mLogoId);
        dest.writeInt(mTitleId);
    }

    public static final Creator<CulturalAssetCategoryModel> CREATOR = new Creator<CulturalAssetCategoryModel>() {
        @Override
        public CulturalAssetCategoryModel createFromParcel(Parcel in) {
            return new CulturalAssetCategoryModel(in);
        }

        @Override
        public CulturalAssetCategoryModel[] newArray(int size) {
            return new CulturalAssetCategoryModel[size];
        }
    };
}
