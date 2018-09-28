package com.example.hoanhintern.mythread;

import android.os.Handler;
import android.os.Message;

import java.util.ArrayList;

public class Thread2 extends Thread {
    Handler handler;
    int sum =0;
    Load load;
    private Thread1 thread1;



    private ArrayList<Integer> mData;
    private int mLast;

//    public void add(int i) {
//        mData.add(i);
//    }

    public void mReceiver(Thread1 thread1){
        this.thread1 = thread1;
    }

    public Thread2(Handler handler) {
        this.handler = handler;
        mData = new ArrayList<>();
        mLast = 0;

    }

    @Override
    public void run() {
        load = new Load() {
            @Override
            public void mData(int i) {
                mData.add(i);
            }
        };
        thread1.load = load;
        while (true) {
            if (mLast < mData.size()) {
                // has new data
                // TODO: process data
                sum += mData.get(mLast);
                Message msg = new Message();
                msg.what = 2;
                msg.arg2 = sum;
                handler.sendMessage(msg);
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (mLast == 99) {
                    // done processing all data

                    break;
                }
                //
                mLast++;
            }
        }
    }

}
