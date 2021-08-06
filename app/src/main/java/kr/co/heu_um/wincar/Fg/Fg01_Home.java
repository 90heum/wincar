package kr.co.heu_um.wincar.Fg;



import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import kr.co.heu_um.wincar.MyCalAdapter;
import kr.co.heu_um.wincar.R;

import static android.content.ContentValues.TAG;

public class Fg01_Home extends Fragment{


    private Bundle savedInstanceState;

    ArrayList<String> dayList;
    GridView gridView;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fg01_home,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceStat) {
        super.onViewCreated(view, savedInstanceState);


        gridView= view.findViewById(R.id.gridview);

        dayList= new ArrayList<String>();

        Calendar cal = Calendar.getInstance();

        int y = cal.get(Calendar.YEAR);
        int m = cal.get(Calendar.MONTH);

        TextView year= view.findViewById(R.id.year);
        TextView month= view.findViewById(R.id.month);

        year.setText(y+"");
        month.setText(m+1+"");

        //이번달 요일/날짜
        cal.set(y,m,1);  //이렇게하면 현재년달의 1일로 셋팅
        int maxDay=cal.getActualMaximum(Calendar.DATE);
        int startWeek=cal.get(Calendar.DAY_OF_WEEK);
        Log.d(TAG,"대입한 숫자는"+ startWeek);

        //배열에 빈문자열 넣어주기
        for(int j=1; j<startWeek; j++){

            dayList.add(null);
        }

        // 배열에 이번달 일수만큼 넣기
        for(int i=1; i<=maxDay; i++){
            dayList.add(i+"");
        }

        //어댑터생성
        MyCalAdapter adapter= new MyCalAdapter(getContext().getApplicationContext(), R.layout.item_calendar_gridview,dayList);
        adapter.notifyDataSetChanged();

        //어댑터 설정
        GridView gridView = (GridView)view.findViewById(R.id.gridview);
        gridView.setAdapter(adapter);




    }
}







