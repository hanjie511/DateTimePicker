package com.example.hj.mydatepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private void selectTime(){
        Calendar c=Calendar.getInstance();
        DateTimePickerDialog dateTimePickerDialog=new DateTimePickerDialog(MainActivity.this,c);
        dateTimePickerDialog.setOnSetDateTimeChangeListener(new DateTimePickerDialog.SetDateTimeChangeListener() {
            @Override
            public void setDateTime(DatePicker datePicker, TimePicker timePicker, int year, int month, int day, int hour, int minute) {
                Toast.makeText(MainActivity.this,year+"-"+(month+1)+"-"+day+" "+hour+":"+minute,Toast.LENGTH_SHORT).show();
            }
        });
    }

    public  void showTime(View view){
        selectTime();
    }
}
