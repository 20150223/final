package com.example.dayeon.capstone;

import android.graphics.drawable.Drawable;
import android.media.Image;

public class Alarm {

    String alarmDate;
    String alarmTime;
    String alarmStatus;
    String alarmValue;
    Drawable alarmImage;

    public Alarm(String alarmDate, String alarmTime, String alarmStatus, String alarmValue,Drawable alarmImage) {
        this.alarmDate = alarmDate;
        this.alarmTime = alarmTime;
        this.alarmStatus = alarmStatus;
        this.alarmValue = alarmValue;
        this.alarmImage = alarmImage;
    }

    public String getAlarmDate() {
        return alarmDate;
    }

    public void setAlarmDate(String alarmDate) {
        this.alarmDate = alarmDate;
    }

    public String getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(String alarmTime) {
        this.alarmTime = alarmTime;
    }

    public String getAlarmStatus() {
        return alarmStatus;
    }

    public void setAlarmStatus(String alarmStatus) {
        this.alarmStatus = alarmStatus;
    }

    public String getAlarmValue() {
        return alarmValue;
    }

    public void setAlarmValue(String alarmValue) {
        this.alarmValue = alarmValue;
    }
    public Drawable getAlarmImage() {
        return alarmImage;
    }

    public void setAlarmImage(Drawable alarmImage) {
        this.alarmImage = alarmImage;
    }
}
