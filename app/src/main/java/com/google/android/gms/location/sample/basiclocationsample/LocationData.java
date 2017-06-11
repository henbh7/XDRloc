package com.google.android.gms.location.sample.basiclocationsample;

import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LocationData {

    protected double mLatitude;
    protected double mLongitude;
    protected int mCellId;
    protected int mLac;
    protected int mMCC;
    protected int mMNC;
    protected Long mLastUpdateTime;
    protected String mImei;
    protected String mImsi;
    protected String mMsisdn;
    protected String mOutputFilePath = "/sdcard/xdrloc_locations.txt";

    public String getmMsisdn() {
        return mMsisdn;
    }

    public void setmMsisdn(String mMsisdn) {
        this.mMsisdn = mMsisdn;
    }

    public String getmImsi() {
        return mImsi;
    }

    public void setmImsi(String mImsi) {
        this.mImsi = mImsi;
    }

    public String getmOutputFilePath() {
        return mOutputFilePath;
    }

    public double getmLatitude() {
        return mLatitude;
    }

    public void setmLatitude(double mLatitude) {
        this.mLatitude = mLatitude;
    }

    public double getmLongitude() {
        return mLongitude;
    }

    public void setmLongitude(double mLongitude) {
        this.mLongitude = mLongitude;
    }

    public int getmCellId() {
        return mCellId;
    }

    public void setmCellId(int mCellId) {
        this.mCellId = mCellId;
    }

    public int getmLac() {
        return mLac;
    }

    public void setmLac(int mLac) {
        this.mLac = mLac;
    }

    public int getmMCC() {
        return mMCC;
    }

    public void setmMCC(int mMCC) {
        this.mMCC = mMCC;
    }

    public int getmMNC() {
        return mMNC;
    }

    public void setmMNC(int mMNC) {
        this.mMNC = mMNC;
    }

    public String getmImei() {
        return mImei;
    }

    public void setmImei(String mImei) {
        this.mImei = mImei;
    }

    public Long getmLastUpdateTime() {
        return mLastUpdateTime;
    }

    public void setmLastUpdateTime(Long mLastUpdateTime) {
        this.mLastUpdateTime = mLastUpdateTime;
    }

    //Ctor
    public LocationData() {
        createLocationsFile();
    }

    public void createLocationsFile() {
        try {
            File mOutFile = new File(mOutputFilePath);
            if (!mOutFile.exists()) {
                mOutFile.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeLocationsOnSD() {
        try {
            File outFile = new File(mOutputFilePath);
            String body = String.format("%s,%d,%d,%d,%d,%s,%s;", mLastUpdateTime.toString(), mCellId, mLac, mMCC, mMNC, mImei, mImsi);
            BufferedWriter writer = new BufferedWriter(new FileWriter(outFile, true /*append*/));
            writer.write(body);
            writer.close();
        } catch (IOException e) {
            Log.e("ReadWriteFile", "Unable to write to the TestFile.txt file.");
        }
    }

    public void writeNotesOnSD(String body) {
        try {
            File outFile = new File(mOutputFilePath);
            BufferedWriter writer = new BufferedWriter(new FileWriter(outFile, true /*append*/));
            writer.write(body);
            writer.close();
        } catch (IOException e) {
            Log.e("ReadWriteFile", "Unable to write to the TestFile.txt file.");
        }
    }

}
