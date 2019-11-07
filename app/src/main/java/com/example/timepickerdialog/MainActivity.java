package com.example.timepickerdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.setTimeId);

        textView = (TextView) findViewById(R.id.texViewId);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimePicker timePicker = new TimePicker(MainActivity.this);

                int currentHour = 0;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    currentHour = timePicker.getHour();
                }
                int currentMinute = 0;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    currentMinute = timePicker.getMinute();
                }

                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,

                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                                textView.setText("Selected Time is "+ i + ":"+ i1);
                            }
                        }, currentHour, currentMinute, false);

                timePickerDialog.show();

            }
        });
    }
}
