package kr.co.heu_um.wincar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import kr.co.heu_um.wincar.Fg.Fg01_Home;
import kr.co.heu_um.wincar.Fg.Fg02_Calender;
import kr.co.heu_um.wincar.Fg.Fg03_Write;
import kr.co.heu_um.wincar.Fg.Fg04_Noti;
import kr.co.heu_um.wincar.Fg.Fg05_Chat;

public class MainActivity extends AppCompatActivity {

     DrawerLayout mDrawerLayout;
     Context context = this;

    BottomNavigationView bnv;
    Fragment[] fragments= new Fragment[5];
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //toolbar&drawer
        //이거해야 툴메뉴보임
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false); // 기존 title 지우기
       actionBar.setDisplayHomeAsUpEnabled(true); // 열리는 버튼 만들기
        actionBar.setHomeAsUpIndicator(R.drawable.adidas); //아디다스버튼이미지

        mDrawerLayout = findViewById(R.id.drawer_layout);

//        NavigationView navigationView= (NavigationView) findViewById(R.id.drawer_layout);
      /*  navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {
                menuitem.setChecked(true);
                mDrawerLayout.closeDrawer(Gravity.LEFT);

                int id=menuitem.getItemId();
                String title =menuitem.getTitle().toString();

                if(id == R.id.bogi01){
                    Toast.makeText(context, title + ": 3일보기.", Toast.LENGTH_SHORT).show();
                }
                else if(id == R.id.bogi02){
                    Toast.makeText(context, title + ": 주별보기.", Toast.LENGTH_SHORT).show();
                }

                return true;
            }
        });*/


        //Fragment
        fragmentManager=getSupportFragmentManager();

        //Home 기본화면 설정
        FragmentTransaction tran=fragmentManager.beginTransaction();
        fragments[0]=new Fg01_Home();
        tran.add(R.id.container,fragments[0]);
        tran.commit();

        bnv=findViewById(R.id.bnv);
        bnv.setSelectedItemId(R.id.bnv_home);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               //hide 방식

                FragmentTransaction tran=fragmentManager.beginTransaction();
                if(fragments[0]!=null) tran.hide(fragments[0]);
                if(fragments[1]!=null) tran.hide(fragments[1]);
                if(fragments[2]!=null) tran.hide(fragments[2]);
                if(fragments[3]!=null) tran.hide(fragments[3]);
                if(fragments[4]!=null) tran.hide(fragments[4]);

               switch (item.getItemId()){

                   case R.id.bnv_home:
                       if(fragments[0]==null){
                           fragments[0]= new Fg01_Home();
                           tran.add(R.id.container,fragments[0]);
                       }
                       tran.show(fragments[0]);
                       break;

                   case R.id.bnv_calender:
                       if(fragments[1]==null){
                           fragments[1]= new Fg02_Calender();
                           tran.add(R.id.container,fragments[1]);
                       }
                       tran.show(fragments[1]);
                       break;

                   case R.id.bnv_add:
                       if(fragments[2]==null){
                           fragments[2]= new Fg03_Write();
                           tran.add(R.id.container,fragments[2]);
                       }
                       tran.show(fragments[2]);
                       break;
                   case R.id.bnv_noti:
                       if(fragments[3]==null){
                           fragments[3]= new Fg04_Noti();
                           tran.add(R.id.container,fragments[3]);
                       }
                       tran.show(fragments[3]);
                       break;

                   case R.id.bnv_chat:
                       if(fragments[4]==null){
                           fragments[4]= new Fg05_Chat();
                           tran.add(R.id.container,fragments[4]);
                       }
                       tran.show(fragments[4]);
                       break;

               }

                tran.commit();


                return true;
            }
        });

        //플롯팅액션바
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "플롯팅 클릭 반응성공", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });




    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ // 왼쪽 상단 버튼 눌렀을 때
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

       getMenuInflater().inflate(R.menu.topmenu01,menu);

        return super.onCreateOptionsMenu(menu);

    }





}