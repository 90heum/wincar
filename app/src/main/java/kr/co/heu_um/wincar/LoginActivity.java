package kr.co.heu_um.wincar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    public void clickLogin(View view) {
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);

    }

}
