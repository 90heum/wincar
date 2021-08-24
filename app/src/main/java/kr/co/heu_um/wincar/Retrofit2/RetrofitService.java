package kr.co.heu_um.wincar.Retrofit2;

import kr.co.heu_um.wincar.Login.userVo;
import kr.co.heu_um.wincar.homePostItem;
import kr.co.heu_um.wincar.homeVo;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RetrofitService {

    // 로그인 Post방식
    // POST방식으로  개별 값 전달 [@Field]
    // @Field를 사용하려면 반드시 @FormUrlEncoded와 함께 사용해야함.
    @FormUrlEncoded
    @POST("mobileapi/v1/auth/login")
    Call<userVo> postLoginMethod(@Field("userId") String userId, @Field("userPwd") String userPwd);


    //6. POST방식으로 값 전달 [@Body] - 객체를 전달하면 자동으로 json문자열로 변환하여 서버로 전송해줌
    @POST("mobileapi/v1/user/main/inqry")
    Call<homeVo> postHomeMethod(@Body homePostItem homePostItem);

    @FormUrlEncoded
    @POST("mobileapi/v1/user/main/inqry")
    Call<homeVo> postHomeMethod2(@Header("Authorization") String accessToken, @Field("userCd") String userCd, @Field("cmpnyCd") String cmpnyCd, @Field("viewTy")String viewTy, @Field("baseDt") String baseDt);

    @POST("mobileapi/v1/user/main/inqry")
    Call<homeVo> postHomeMethod3(@Body homePostItem homePostItem,@Header("accessToken") String accessToken);


}
