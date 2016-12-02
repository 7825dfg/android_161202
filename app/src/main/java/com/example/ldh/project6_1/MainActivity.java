package com.example.ldh.project6_1;

import android.graphics.Color;
import android.icu.util.Calendar;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    Chronometer Cmeter;
    Button btn1, btn2;
    RadioGroup rg;
    RadioButton rb1, rb2;
    TimePicker timePicker;
    CalendarView calendar;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button)findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);
        Cmeter = (Chronometer)findViewById(R.id.chronometer);
        rb1 = (RadioButton)findViewById(R.id.radioButton1);
        rb2 = (RadioButton)findViewById(R.id.radioButton2);
        rg = (RadioGroup)findViewById(R.id.radiogroup);
        timePicker = (TimePicker)findViewById(R.id.timePicker);
        calendar = (CalendarView)findViewById(R.id.calendarView);
        textView = (TextView)findViewById(R.id.textView);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(group.getId()==R.id.radiogroup){
                    switch (checkedId){
                        case R.id.radioButton1 :
                            calendar.setVisibility(View.VISIBLE);
                            timePicker.setVisibility(View.INVISIBLE);
                            break;
                        case R.id.radioButton2 :
                            calendar.setVisibility(View.INVISIBLE);
                            timePicker.setVisibility(View.VISIBLE);
                            break;
                    }

                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cmeter.setBase(SystemClock.elapsedRealtime());
                Cmeter.start();

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cmeter.stop();

            }
        });
    }
}
