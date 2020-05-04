package com.example.hj.mydatepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.hj.datetimepickerview.DateTimePickerDialog;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private void selectTime(int showType){
        DateTimePickerDialog dateTimePickerDialog=new DateTimePickerDialog(MainActivity.this,showType);
        dateTimePickerDialog.setOnSetDateTimeChangeListener(new DateTimePickerDialog.SetDateTimeChangeListener() {
            @Override
            public void setDateTime(DatePicker datePicker, TimePicker timePicker, int year, int month, int day, int hour, int minute) {
                Toast.makeText(MainActivity.this,year+"-"+month+"-"+day+" "+hour+":"+minute,Toast.LENGTH_SHORT).show();
            }
        });
    }

    public  void showTime(View view){
        selectTime(DateTimePickerDialog.justShowTimePicker);
    }
    public  void showDateTime(View view){
        selectTime(DateTimePickerDialog.showAll);
    }
    public  void showDate(View view){
        selectTime(DateTimePickerDialog.justShowDatePicker);
    }
    public  void showYearMonth(View view){
        selectTime(DateTimePickerDialog.showYearAndMonth);
    }
    public  void showMonthDay(View view){
        selectTime(DateTimePickerDialog.showMonthAndDay);
    }
}
