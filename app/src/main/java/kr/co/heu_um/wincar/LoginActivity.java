package kr.co.heu_um.wincar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import kr.co.heu_um.wincar.Login.userVo;
import kr.co.heu_um.wincar.Retrofit2.RetrofitHelper;
import kr.co.heu_um.wincar.Retrofit2.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends Activity {

    EditText etLogin;
    EditText etPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    public void clickLogin(View view) {

        etLogin=findViewById(R.id.etLogin);
        etPassword=findViewById(R.id.etPassword);

        //Edit text에서 정보가져오기
        String userId=etLogin.getText().toString();
        String userPwd=etPassword.getText().toString();

        //retrofit 연결
        Retrofit retrofit= RetrofitHelper.getRetrofitInstance();
        RetrofitService retrofitService=retrofit.create(RetrofitService.class);
        retrofitService.postLoginMethod(userId,userPwd).enqueue(new Callback<userVo>() {
            @Override
            public void onResponse(Call<userVo> call, Response<userVo> response) {

                userVo userVo=response.body();
                String sts=userVo.getInfo().getStatus();

               switch (sts){

                   case "S" :

                       Intent intent= new Intent(getApplicationContext(), MainActivity.class);
                       intent.putExtra("userNm",userVo.getDataset().getData().get(0).getUserNm());
                       intent.putExtra("cmpnyNm",userVo.getDataset().getData().get(0).getCmpnyNm());
                       intent.putExtra("accessToken",userVo.getDataset().getData().get(0).getAccessToken()); //엑세스토큰
                       intent.putExtra("userCd",userVo.getDataset().getData().get(0).getUserCd());//사용자 코드
                       intent.putExtra("cmpnyCd",userVo.getDataset().getData().get(0).getCmpnyCd());//기업코드
                       intent.putExtra("userId",userId);


                       startActivity(intent);
                       break;


                   case "E" :

                       Toast.makeText(LoginActivity.this, "아이디와 비밀번호를 확인하세요", Toast.LENGTH_SHORT).show();
                       break;

               }


            }

            @Override
            public void onFailure(Call<userVo> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "오류가 발생했습니다.", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void clickJoin(View view) {
        Intent intent1= new Intent(this, JoinActivity.class);
        startActivity(intent1);
    }

}
