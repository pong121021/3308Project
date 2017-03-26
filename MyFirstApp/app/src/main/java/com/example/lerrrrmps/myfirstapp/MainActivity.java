package com.example.lerrrrmps.myfirstapp;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lerrrrmps.myfirstapp.ControlStickView;

import org.w3c.dom.Text;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity implements ControlStickView.JoystickListener{
    private Context context;
    private ControlStickView controlStickView;
    private ControlStickViewRight controlStickViewRight;
    Server server;
    TextView infoip, msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        context = getApplicationContext();
        controlStickView = new ControlStickView(context);
        controlStickViewRight = new ControlStickViewRight(context);
        setContentView(R.layout.activity_main);
        infoip = (TextView) findViewById(R.id.infoip);
        msg = (TextView) findViewById(R.id.msg);
        server = new Server(this);
        infoip.setText(server.getIpAddress()+":"+server.getPort());


    }
    
    @Override
    protected void onDestroy() {
        MainActivity.super.onDestroy();
        server.onDestroy();
    }

    @Override
    public void onJoystickMoved(float xPercent, float yPercent, int source) {
        Log.d("Main Method", "X percent: " + xPercent + "Y percent: " + yPercent);
    }
}