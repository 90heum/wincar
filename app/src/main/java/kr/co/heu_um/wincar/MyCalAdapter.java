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
    ArrayList<String> dayList;
    Context context;

    public MyCalAdapter(Context applicationContext, int item_calendar_gridview, ArrayList<String> dayList) {
        this.dayList=dayList;
        this.context=applicationContext;

    }

    @Override
    public int getCount() {
        return dayList.size();
    }

    @Override
    public Object getItem(int position) {
        return dayList.get(position);
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
        tv.setText(dayList.get(position));

        return convertView;
    }
}
