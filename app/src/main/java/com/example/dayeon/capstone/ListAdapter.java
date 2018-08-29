package com.example.dayeon.capstone;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class ListAdapter extends BaseAdapter {

    private Context context;
    private List<Alarm> alarmList;

    public ListAdapter(Context context,List<Alarm> alarmList)
    {
        this.context = context;
        this.alarmList = alarmList;
    }

    @Override
    public int getCount() {
        return alarmList.size();
    }

    @Override
    public Object getItem(int i) {
        return alarmList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = View.inflate(context,R.layout.alarm,null);
        TextView alarmDate = (TextView)v.findViewById(R.id.alarmDate);
        TextView alarmTime = (TextView)v.findViewById(R.id.alarmTime);
        TextView alarmStatus = (TextView)v.findViewById(R.id.alarmStatus);
        TextView alarmValue = (TextView)v.findViewById(R.id.alarmValue);
        ImageView alarmImage = (ImageView)v.findViewById(R.id.alarmImage);

        alarmDate.setText(alarmList.get(i).getAlarmDate());
        alarmTime.setText(alarmList.get(i).getAlarmTime());
        alarmStatus.setText(alarmList.get(i).getAlarmStatus());
        alarmValue.setText(alarmList.get(i).getAlarmValue());
        alarmImage.setImageDrawable(alarmList.get(i).getAlarmImage());

        v.setTag(alarmList.get(i).getAlarmDate());
        return v;

    }
}
