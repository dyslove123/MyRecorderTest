package com.example.administrator.myrecordertest;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2015/4/22.
 */
public class mRecorderAndPlayer {
    String LOG_D="RecordAndPlay";
    File file=null;
    public String fileName="";
    boolean isRecord=false;
    boolean isPlay=false;
    public MediaRecorder mRecorder=null;
    public MediaPlayer mPlayer=null;
    String DOCUMENT_NAME ="Recorder";
    public boolean record(String FileName){
        stop();
        if(!setFileName(FileName))return false;
        try {
            if (file.exists()) {
                file.delete();
            }
            mRecorder=new MediaRecorder();
            mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mRecorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
            mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
            mRecorder.setOutputFile(fileName);
            mRecorder.prepare();
            mRecorder.start();
            isRecord=true;
            Log.e("myRecorder_Record_Suc", fileName);
        } catch (IOException e) {
            Log.e("myRecorder_Record_Fail",e.getMessage());
            return false;
        }
        return true;
    }
    public boolean mediaPlay(String FileName){
        stop();
        if(!setFileName(FileName))return false;
        mPlayer = new MediaPlayer();
        try {
            if(!file.exists()){
                Log.d(LOG_D,"File no exist:"+FileName);
                return false;
            }
            FileInputStream fis = new FileInputStream(file);
            mPlayer.setDataSource(fis.getFD());
            Log.e("record_test",fileName+":"+fis.getFD().toString());
            mPlayer.prepare();
            //播放之
            mPlayer.start();
            isPlay=true;
        } catch (IOException e) {
            Log.e(LOG_D, "prepare() failed"+e.getMessage());
            return false;
        }
        return true;
    }
    public void stop()
    {
        if(isRecord){
            mRecorder.stop();
            mRecorder.release();
            mRecorder=null;
            isRecord=false;
        }
        if(mPlayer!=null&&mPlayer.isPlaying())
        {
            mPlayer.stop();
            mPlayer.release();
            mPlayer=null;
            isPlay=false;
        }
    }
    //confirm ths sdCard, the FileName,and whether the parent of file exist;
    public boolean setFileName(String FileName){
        boolean sdCardExit = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        if (!sdCardExit)
        {
            Log.d("RecordAndPlay","Without ExternalStorage");
            return false;
        }
        File sdcardDir = Environment.getExternalStorageDirectory();
        String filePath = sdcardDir.getPath() + java.io.File.separator + DOCUMENT_NAME;
        fileName=FileName;
        if(fileName.equals("")||fileName==null){
            Log.d("RecordAndPlay","fileName invalid："+fileName);
            return false;
        }
        file = new File(filePath,fileName+".amr");
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        fileName = file.getAbsolutePath();
        Log.d("RecordAndPlay","fileName valid："+fileName+".amr");
        return true;
    }
}
