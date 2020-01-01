package com.example.hj.mydatepicker;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DateTimePickerDialog  implements TimePicker.OnTimeChangedListener, DatePicker.OnDateChangedListener {
    private int year;
    private int month;
    private int day;
    private int hours;
    private int minutes;
    private DatePicker datePicker;
    private TimePicker timePicker;
    private SetDateTimeChangeListener setDateTimeChangeListener;
    private Calendar c;
    public DateTimePickerDialog(Context context, Calendar calendar){
        this.c=calendar;
        this.year=calendar.get(Calendar.YEAR);
        this.month=calendar.get(Calendar.MONTH);
        this.day=calendar.get(Calendar.DAY_OF_MONTH);
        this.hours=calendar.get(Calendar.HOUR_OF_DAY);
        this.minutes=calendar.get(Calendar.MINUTE);
        init(context);
    }
    /**
     * 调整FrameLayout大小
     * @param tp
     */
    private void resizePikcer(FrameLayout tp){
        List<NumberPicker> npList = findNumberPicker(tp);
        for(NumberPicker np:npList){
            resizeNumberPicker(np);
        }
    }

    /**
     * 得到viewGroup里面的numberpicker组件
     * @param viewGroup
     * @return
     */
    private List<NumberPicker> findNumberPicker(ViewGroup viewGroup){
        List<NumberPicker> npList = new ArrayList<NumberPicker>();
        View child = null;
        if(null != viewGroup){
            for(int i = 0; i < viewGroup.getChildCount(); i++){
                child = viewGroup.getChildAt(i);
                if(child instanceof NumberPicker){
                    npList.add((NumberPicker)child);
                }
                else if(child instanceof LinearLayout){
                    List<NumberPicker> result = findNumberPicker((ViewGroup)child);
                    if(result.size()>0){
                        return result;
                    }
                }
            }
        }
        return npList;
    }

    /*
     * 调整numberpicker大小
     */
    private void resizeNumberPicker(NumberPicker np){
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(80, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(10, 0, 10, 0);
        np.setLayoutParams(params);
    }
    private void init(Context context){
        View view = LayoutInflater.from(context).inflate(R.layout.date_timepicker,null,false);
        timePicker=view.findViewById(R.id.timePicker);
        datePicker=view.findViewById(R.id.datePicker);
        resizePikcer(timePicker);
        resizePikcer(datePicker);
        timePicker.setOnTimeChangedListener(this);
        datePicker.init(year,month,day,this);
        timePicker.setIs24HourView(true);
        timePicker.setCurrentHour(hours);
        timePicker.setCurrentMinute(minutes);
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setTitle("请选择日期");
        builder.setView(view);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (null != setDateTimeChangeListener) {
                    setDateTimeChangeListener.setDateTime(datePicker, timePicker, year, month,
                            day, hours, minutes);
                }
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (null != setDateTimeChangeListener) {
                    setDateTimeChangeListener.setDateTime(datePicker, timePicker, c.get(Calendar.YEAR),
                            c.get(Calendar.MONTH),
                            c.get(Calendar.DAY_OF_MONTH),
                            c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE));
                }
            }
        });
        builder.create().show();
    }
    @Override
    public void onDateChanged(DatePicker datePicker, int year , int month, int day) {
        this.datePicker=datePicker;
        this.year=year;
        this.month=month;
        this.day=day;
    }

    @Override
    public void onTimeChanged(TimePicker timePicker, int hours, int minute) {
        this.timePicker=timePicker;
        this.hours=hours;
        this.minutes=minute;
    }
    public void setOnSetDateTimeChangeListener(SetDateTimeChangeListener listener){
        this.setDateTimeChangeListener=listener;
    }
    public interface SetDateTimeChangeListener{
        void setDateTime(DatePicker datePicker,TimePicker timePicker,int year,int month,int day,int hour,int minute);
    }
}
