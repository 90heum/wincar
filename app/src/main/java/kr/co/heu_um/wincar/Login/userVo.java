package kr.co.heu_um.wincar.Login;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class userVo {

    @SerializedName("info")
    Info info;


    public class Info{

        @SerializedName("status")
        public String status;
        @SerializedName("count")
        public String count;

        public String getStatus() {
            return status;
        }
        public void setStatus(String status){
            this.status = status;
        }

        public String getCount() { return count; }
        public void setCount(String count){
            this.count = count;
        }

    }


    @SerializedName("dataset")
    dataset dataset;

    public class dataset{

        public  List<data> data = new ArrayList<>();
        public List<data> getData() {return data;}

        //static 확인해보기
        public class data{
            @SerializedName("userNm")
            public String userNm;
            @SerializedName("userCd")
            public String userCd;
            @SerializedName("userTy")
            public String userTy;
            @SerializedName("cmpnyCd")
            public String cmpnyCd;
            @SerializedName("cmpnyNm")
            public String cmpnyNm;
            @SerializedName("cldrViewTy")
            public String cldrViewTy;
            @SerializedName("accessToken")
            public String accessToken;
            @SerializedName("refreshToken")
            public String refreshToken;

            //게터세터
            public String getUserNm() {
                return userNm;
            }
            public  void setUserNm(String userNm){
                this.userNm = userNm;
            }


            public String getUserCd() {
                return userCd;
            }
            public void setUserCd(String userCd){
                this.userCd = userCd;
            }


            public String getUserTy() {
                return userTy;
            }
            public void setUserTy(String userTy){
                this.userTy = userTy;
            }


            public String getCmpnyCd() {
                return cmpnyCd;
            }
            public void setCmpnyTy(String cmpnyCd){
                this.cmpnyCd = cmpnyCd;
            }


            public String getCmpnyNm() {
                return cmpnyNm;
            }
            public void setCmpnyNm(String cmpnyNm){
                this.cmpnyNm = cmpnyNm;
            }


            public String getCldrViewTy() {
                return cldrViewTy;
            }
            public void setCldrViewTy(String cldrViewTy){
                this.cldrViewTy = cldrViewTy;
            }


            public String getAccessToken() {
                return accessToken;
            }
            public void setAccessToken(String accessToken){
                this.accessToken = accessToken;
            }

            public String getRefreshToken() {
                return refreshToken;
            }
            public void setRefreshToken(String refreshToken){
                this.refreshToken = refreshToken;
            }

        }


    }


    public dataset getDataset() {

        return dataset;
    }

    public Info getInfo() {

        return info;
    }




}
