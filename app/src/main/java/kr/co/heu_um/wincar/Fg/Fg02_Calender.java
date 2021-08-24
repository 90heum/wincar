package kr.co.heu_um.wincar.Fg;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Calendar;

import kr.co.heu_um.wincar.CalendarList;
import kr.co.heu_um.wincar.MyCalAdapter;
import kr.co.heu_um.wincar.R;

import static android.content.ContentValues.TAG;

public class Fg02_Calender extends Fragment {
    private Bundle savedInstanceState;

    ArrayList<String> dayList;
    GridView gridView;
    ArrayList<CalendarList> calendarList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fg02_calender,container,false);
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
        MyCalAdapter adapter= new MyCalAdapter(getContext().getApplicationContext(), R.layout.item_calendar_gridview,calendarList);
        adapter.notifyDataSetChanged();

        //어댑터 설정
        GridView gridView = (GridView)view.findViewById(R.id.gridview);
        gridView.setAdapter(adapter);

        Button next= view.findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextClick();
            }


            //달력 앞으로가기
            private void nextClick() {

                //12월달에 +1이됐을때 다음해로 넘어가기 1월로 초기화
                if(cal.get(Calendar.DAY_OF_MONTH)==Calendar.DECEMBER){
                    dayList.clear();
                    cal.set(Calendar.YEAR, cal.get(Calendar.YEAR)+1);
//                   cal.set(Calendar.MONTH,2);

                }else{
                    // 다음달~
                    dayList.clear();
                    cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)+1);

                }

                int maxDay=cal.getActualMaximum(Calendar.DATE);
                int startWeek=cal.get(Calendar.DAY_OF_WEEK);

                //배열에 빈문자열 넣어주기
                for(int j=1; j<startWeek; j++){
                    dayList.add(null);
                }
                // 배열에 이번달 일수만큼 넣기
                for(int i=1; i<=maxDay; i++){
                    dayList.add(i+"");
                }

                int y = cal.get(Calendar.YEAR);
                int m = cal.get(Calendar.MONTH);

                month.setText((m+1)+"");
                year.setText(y+"");



                //어댑터생성
                MyCalAdapter adapter= new MyCalAdapter(getContext().getApplicationContext(), R.layout.item_calendar_gridview,calendarList);
                adapter.notifyDataSetChanged();
                //어댑터 설정
                GridView gridView = (GridView)view.findViewById(R.id.gridview);
                gridView.setAdapter(adapter);
            }
        });


        Button back= view.findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                backClick();

            }


            //달력 뒤로가기
            public void backClick(){

                //1월달에 -1이됐을때 다음해로 넘어가기+ 1월로 초기화
                if(cal.get(Calendar.DAY_OF_MONTH)==Calendar.JANUARY){
                    dayList.clear();
                    cal.set(Calendar.YEAR, cal.get(Calendar.YEAR)-1);
                    //    cal.set(Calendar.MONTH,11);

                }else{
                    // 이전달~
                    dayList.clear();
                    cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)-1);

                }

                int maxDay=cal.getActualMaximum(Calendar.DATE);
                int startWeek=cal.get(Calendar.DAY_OF_WEEK);

                //배열에 빈문자열 넣어주기
                for(int j=1; j<startWeek; j++){
                    dayList.add(null);
                }
                // 배열에 이번달 일수만큼 넣기
                for(int i=1; i<=maxDay; i++){
                    dayList.add(i+"");
                }

                int y = cal.get(Calendar.YEAR);
                int m = cal.get(Calendar.MONTH);

                month.setText((m+1)+"");
                year.setText(y+"");
                //어댑터생성
                MyCalAdapter adapter= new MyCalAdapter(getContext().getApplicationContext(),R.layout.item_calendar_gridview,calendarList);
                adapter.notifyDataSetChanged();
                //어댑터 설정
                GridView gridView = (GridView)view.findViewById(R.id.gridview);
                gridView.setAdapter(adapter);

            }
        });


    }




    }

