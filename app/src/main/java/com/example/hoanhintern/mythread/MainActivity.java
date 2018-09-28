package com.example.hoanhintern.mythread;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    Button bt;
    TextView tv1, tv2;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);

        initHandler();

        bt = (Button) findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Thread1 thread1 = new Thread1(handler);
                Thread2 thread2 = new Thread2(handler);
                thread2.mReceiver(thread1);
                thread2.start();
                thread1.start();


            }
        });


    }

    private void initHandler(){
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what){
                    case 1:
                        tv1.setText(msg.arg1+"");
                        break;
                    case 2:
                        tv2.setText(msg.arg2+"");
                }
            }
        };
    }
}
