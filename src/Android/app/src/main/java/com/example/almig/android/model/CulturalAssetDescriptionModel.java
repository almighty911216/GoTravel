package com.example.almig.android.model;

/**
 * Created by almig on 2017-06-11.
 */

public class CulturalAssetDescriptionModel {
    private int mMainImage;
    private int mUpperSubImage;
    private int mLowerSubImage;
    private String mName;
    private String mNumber;
    private String mAge;
    private String mOpenTime;
    private String mCloseTime;
    private String mAddr;
    private String mDescription;
    private long mEntranceFee;
    private long mParkingFee;

    public int getMainImage() {
        return mMainImage;
    }

    public void setMainImage(int mainImage) {
        this.mMainImage = mainImage;
    }

    public int getUpperSubImage() {
        return mUpperSubImage;
    }

    public void setUpperSubImage(int upperSubImage) {
        this.mUpperSubImage = upperSubImage;
    }

    public int getLowerSubImage() {
        return mLowerSubImage;
    }

    public void setLowerSubImage(int lowerSubImage) {
        this.mLowerSubImage = lowerSubImage;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getNumber() {
        return mNumber;
    }

    public void setNumber(String number) {
        this.mNumber = number;
    }


    public String getAge() {
        return mAge;
    }

    public void setAge(String age) {
        this.mAge = age;
    }

    public String getOpenTime() {
        return mOpenTime;
    }

    public void setOpenTime(String openTime) {
        this.mOpenTime = openTime;
    }

    public String getCloseTime() {
        return mCloseTime;
    }

    public void setCloseTime(String closeTime) {
        this.mCloseTime = closeTime;
    }

    public String getAddr() {
        return mAddr;
    }

    public void setAddr(String addr) {
        this.mAddr = addr;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public long getEntranceFee() {
        return mEntranceFee;
    }

    public void setEntranceFee(long entranceFee) {
        this.mEntranceFee = entranceFee;
    }

    public long getParkingFee() {
        return mParkingFee;
    }

    public void setParkingFee(long parkingFee) {
        this.mParkingFee = parkingFee;
    }
}
