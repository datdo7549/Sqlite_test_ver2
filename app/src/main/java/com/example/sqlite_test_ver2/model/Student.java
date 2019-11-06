package com.example.sqlite_test_ver2.model;

public class Student {
    private int mId;
    private String mName;
    private String mEmail;
    private String mAddress;
    private String mPhone;

    public Student() {
    }

    public Student(int mId, String mName, String mEmail, String mAddress, String mPhone) {
        this.mId = mId;
        this.mName = mName;
        this.mEmail = mEmail;
        this.mAddress = mAddress;
        this.mPhone = mPhone;
    }

    public Student(String mName, String mEmail, String mAddress, String mPhone) {
        this.mName = mName;
        this.mEmail = mEmail;
        this.mAddress = mAddress;
        this.mPhone = mPhone;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }
}
