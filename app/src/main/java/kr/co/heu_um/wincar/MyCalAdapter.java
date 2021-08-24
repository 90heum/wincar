package kr.co.heu_um.wincar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MyCalAdapter extends BaseAdapter {
    ArrayList<CalendarList> calendarList;
    Context context;

    public MyCalAdapter(Context applicationContext, int item_calendar_gridview, ArrayList<CalendarList> calendarList) {
        this.calendarList=calendarList;
        this.context=applicationContext;

    }

    @Override
    public int getCount() {
        return calendarList.size();
    }

    @Override
    public Object getItem(int position) {
        return calendarList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){

            LayoutInflater inflater= LayoutInflater.from(context);

            convertView=(LinearLayout)inflater.inflate(R.layout.item_calendar_gridview,null);

        }

        TextView tv= convertView.findViewById(R.id.tv_item_gridview);
        TextView tv1= convertView.findViewById(R.id.tv_item_gridview1);
        TextView tv2= convertView.findViewById(R.id.tv_item_gridview2);
        TextView tv3= convertView.findViewById(R.id.tv_item_gridview3);

        tv.setText(calendarList.get(position).date);
        tv1.setText(calendarList.get(position).aa);
        tv2.setText(calendarList.get(position).bb);
        tv3.setText(calendarList.get(position).cc);


        return convertView;

    }
}
