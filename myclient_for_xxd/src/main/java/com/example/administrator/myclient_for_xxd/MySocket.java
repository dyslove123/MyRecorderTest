package com.example.administrator.myclient_for_xxd;

/**
 * Created by Administrator on 2015/5/17.
 */



import android.os.StrictMode;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class MySocket {
    String push;
    String get;

    public MySocket(String Message) {
        this.push = Message;
    }

    public void Required(String IP, int PORT) {
        Socket socket = null;
        BufferedReader br = null;
        PrintWriter pw = null;
        try {

            /* 客户端socket指定服务器的地址和端口号 */
            Log.e("mylog","socket success"+IP+PORT);
            socket = new Socket(IP, PORT);
            Log.e("mylog","socket success");
            System.out.println("Socket=" + socket);
            // 同服务器原理一样
            br = new BufferedReader(new InputStreamReader(
                    socket.getInputStream(),"Unicode"));
            Log.e("mylog","br success");
            pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
                    socket.getOutputStream(),"Unicode")));
            Log.e("mylog","pw success");
            Log.e("mylog","out=" +new String(push.getBytes("ASCII")));
            pw.println(push);

            pw.flush();
            get=br.readLine()+br.readLine();
            pw.println("END");
            pw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.println("close......");
                if (br != null) {
                    br.close();
                }
                else Log.e("log","br null");
                if (pw != null) {
                    pw.close();
                }
                if (socket != null) {
                    socket.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
