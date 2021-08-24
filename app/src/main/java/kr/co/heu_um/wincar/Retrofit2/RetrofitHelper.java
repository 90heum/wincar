package kr.co.heu_um.wincar.Retrofit2;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {


    static String baseUrl="http://15.165.55.102/";

    //Retrofit 객체를 만들어서 리턴해주는 static 메소드[객체 생성없이 사용 가능 함]
    public static Retrofit getRetrofitInstance(){


        //   Gson gson= new GsonBuilder().setLenient().create();

        Retrofit.Builder builder=new Retrofit.Builder();
        builder.baseUrl(baseUrl);
        builder.addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit=builder.build();


        return retrofit;
        //매번만들때마다 4줄짜리만들어야되서 이렇게 ㅅ스테이틱으로만ㄷ들어서 편하게 만든상황임지금
    }

}
