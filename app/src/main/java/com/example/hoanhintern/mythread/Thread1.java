package com.example.hoanhintern.mythread;

import android.os.Handler;
import android.os.Message;

import java.util.ArrayList;

public class Thread1 extends Thread {
    Handler handler;
    ArrayList<Integer> mData;

    Load load;

    private Thread2 mReceiver;

    public void setReceiver(Thread2 receiver) {
        this.mReceiver = receiver;
    }


    public Thread1(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        mData = new ArrayList<>();
        for (int i = 0;i<=100;i++){
                load.mData(i);
//                mData.add(i);

//                mReceiver.add(i);

                Message msg = new Message();
                msg.what = 1;
                msg.arg1 = i;
                handler.sendMessage(msg);

                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
    }
    }

