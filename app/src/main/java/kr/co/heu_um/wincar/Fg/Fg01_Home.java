package kr.co.heu_um.wincar.Fg;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Calendar;

import kr.co.heu_um.wincar.CalendarList;
import kr.co.heu_um.wincar.MyCalAdapter;
import kr.co.heu_um.wincar.R;
import kr.co.heu_um.wincar.Retrofit2.RetrofitHelper;
import kr.co.heu_um.wincar.Retrofit2.RetrofitService;
import kr.co.heu_um.wincar.homePostItem;
import kr.co.heu_um.wincar.homeVo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.content.ContentValues.TAG;

public class Fg01_Home extends Fragment{

    private Bundle savedInstanceState;

    ArrayList<CalendarList> calendarList;
    GridView gridView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fg01_home,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceStat) {
        super.onViewCreated(view, savedInstanceState);

        //유저정보 로그인화면단에서 유저정보 itent로받고 서버로 쏘기
        //intent정보 받기
        //인텐트로 로그인정보 받아와 셋팅
        Intent secondIntent =getActivity().getIntent();
        String userName=secondIntent.getStringExtra("userNm");
        String userCmpnyNm=secondIntent.getStringExtra("cmpnyNm");
        String userId=secondIntent.getStringExtra("userId");

        //home화면에서 post로쏴줄 intent정보들
        String useraccessToken=secondIntent.getStringExtra("accessToken");
        String userUserCd=secondIntent.getStringExtra("userCd");
        String userCmpnyCd=secondIntent.getStringExtra("cmpnyCd");

        String userViewTy="M";
        String userBaseDt="20210823";

        Log.d("##useraccessToken",""+useraccessToken);
        Log.d("##userCd",""+userUserCd);
        Log.d("##userCmpnyCd",""+userCmpnyCd);

        String accessToken=useraccessToken;


        //포스트로 보내기
        homePostItem homePostItem= new homePostItem(""+userUserCd,""+userCmpnyCd,"M","20210824");


       /* //헤더 추가해보기

        OkHttpClient client= new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request newRequest= chain.request().newBuilder().addHeader("Authorization","accessToken "+accessToken).build();
                return chain.proceed(newRequest);
            }
        }).build();

        Retrofit retrofit= new Retrofit.Builder().client(client).baseUrl("http://15.165.55.102/").addConverterFactory(GsonConverterFactory.create()).build();

        RetrofitService retrofitService=retrofit.create(RetrofitService.class);
        retrofitService.postHomeMethod(homePostItem).enqueue(new Callback<homeVo>() {
            @Override
            public void onResponse(Call<homeVo> call, Response<homeVo> response) {
                homeVo homeVo=response.body();
                Log.d("bbb",homeVo.getInfo().status+"");

                Log.d("aaaa",homeVo.getInfo().getStatus()+"");
            }

            @Override
            public void onFailure(Call<homeVo> call, Throwable t) {
                Toast.makeText(getContext(), "실패"+t, Toast.LENGTH_LONG).show();
                Toast.makeText(getContext(), "실패"+t, Toast.LENGTH_LONG).show();
                Toast.makeText(getContext(), "실패"+t, Toast.LENGTH_LONG).show();
                Toast.makeText(getContext(), "실패"+t, Toast.LENGTH_LONG).show();
                Toast.makeText(getContext(), "실패"+t, Toast.LENGTH_LONG).show();

            }
        });*/

        Retrofit retrofit= RetrofitHelper.getRetrofitInstance();
        RetrofitService retrofitService=retrofit.create(RetrofitService.class);
        retrofitService.postHomeMethod3(homePostItem,accessToken).enqueue(new Callback<homeVo>() {
            @Override
            public void onResponse(Call<homeVo> call, Response<homeVo> response) {

                homeVo homeVo=response.body();

                Log.d("aaaa",homeVo.getInfo().getStatus()+"");
                Log.d("aaaa",homeVo.getInfo().getCount()+"");


            }

            @Override
            public void onFailure(Call<homeVo> call, Throwable t) {
                Toast.makeText(getContext(), "실패"+t, Toast.LENGTH_LONG).show();
                Toast.makeText(getContext(), "실패"+t, Toast.LENGTH_LONG).show();
                Toast.makeText(getContext(), "실패"+t, Toast.LENGTH_LONG).show();
                Toast.makeText(getContext(), "실패"+t, Toast.LENGTH_LONG).show();
                Toast.makeText(getContext(), "실패"+t, Toast.LENGTH_LONG).show();
            }
        });



        //캘린더 그리기
        calendarList= new ArrayList<CalendarList>();
        gridView= view.findViewById(R.id.gridview);

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
            calendarList.add(null);
        }

        // 배열에 이번달 일수만큼 넣기
        for(int i=1; i<=maxDay; i++){
            calendarList.add(new CalendarList(i+"","","",""));
        }

        //먼가 새로운값이 있을때!!

        //라인 넣어보기

        //어댑터생성
        MyCalAdapter adapter= new MyCalAdapter(getContext().getApplicationContext(), R.layout.item_calendar_gridview,calendarList);
        adapter.notifyDataSetChanged();

        //어댑터 설정
        GridView gridView = (GridView)view.findViewById(R.id.gridview);
        gridView.setAdapter(adapter);
    }
}







