package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;
public class MainActivity extends AppCompatActivity {
    boolean check=false;
    boolean b=false;
    final int []count={0,0,0};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn=(Button) findViewById(R.id.start_count);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count_time(1);
            }
        });
        Button btn1=(Button) findViewById(R.id.hold_count);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b)
                {
                    count_time(1);
                    b=false;
                }
                else
                {
                    check=true;
                    b=true;
                }
            }
        });
        Button btn2=(Button) findViewById(R.id.clear_count);
       btn2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               count[0]=0;
               count[1]=0;
               count[2]=0;
               check=true;
               TextView show=(TextView) findViewById(R.id.textView2);
               show.setText("00 : 00 : 00");


           }
       });
    }
    private void count_time(int k)
    {
        if(k==1)
        {
            Timer t=new Timer();
            t.scheduleAtFixedRate(new TimerTask()
            {
                public void run() {
                    TextView shower=(TextView) findViewById(R.id.textView2);
                    count[2]++;
                    if(count[2]==100) {
                        count[1]++;
                        count[2] = 0;
                    }
                    if(count[1]==60)
                    {
                        count[0]++;
                        count[1]=0;
                    }
                    String s1=Integer.toString(count[0]);
                    String s2=Integer.toString(count[1]);
                    String s3=Integer.toString(count[2]);
                    if(count[0]<10)
                    {
                        s1="0"+s1;
                    }
                    if(count[1]<10)
                    {
                        s2="0"+s2;
                    }
                    if(count[2]<10)
                    {
                        s3="0"+s3;
                    }


                    if(check) {
                        cancel();
                        check=false;
                    }
                    else {
                        shower.setText(s1 + " : " + s2 + " : " + s3);
                    }
                }
            },0,10);

        }
    }


}