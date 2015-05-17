package com.example.administrator.sqlite;

/**
 * Created by Administrator on 2015/5/13.
 */
public class clockMessage {
    public final static int AlarmInVoice=1;
    public final static int  AlarmInShake=2;

    long alarmTime;
    String VoiceFileRoot;
    int alarmMethod;
    String message;

    public clockMessage(long time,String file,int method,String message)
    {
        this.alarmTime=time;
        this.VoiceFileRoot=file;
        this.alarmMethod=method;
        this.message=message;
    }

    public int getAlarmMethod() {
        return alarmMethod;
    }
    public void setAlarmMethod(int alarmMethod) {
        this.alarmMethod = alarmMethod;
    }

    public String getVoiceFileRoot() {
        return VoiceFileRoot;
    }

    public void setVoiceFileRoot(String voiceFileRoot) {
        VoiceFileRoot = voiceFileRoot;
    }

    public long getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(long alarmTime) {
        this.alarmTime = alarmTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



}
