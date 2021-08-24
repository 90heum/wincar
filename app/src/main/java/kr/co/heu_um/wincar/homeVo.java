package kr.co.heu_um.wincar;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import kr.co.heu_um.wincar.Login.userVo;

public class homeVo {

    @SerializedName("info")
    Info info;

    public Info getInfo() {
        return info;
    }

    public class Info{
        @SerializedName("status")
        public String status;

        public String getStatus() {
            return status;
        }


        @SerializedName("count")
        public String count;

        public String getCount() {
            return count;
        }


    }


    @SerializedName("dataset")
    Dataset dataset;

    public class Dataset{
        public  List<data> data = new ArrayList<>();
        public List<data> getData() {return data;}

        class data{

            @SerializedName("orderDt")
            public String orderDt; //주문일자

            public String getOrderDt() {
                return orderDt;
            }

            @SerializedName("orderCount")
            public String orderCount; //주문갯수

            public String getOrderCount() {
                return orderCount;
            }

            @SerializedName("orders")
            Orders orders;

            public Orders getOrders() {
                return orders;
            }

            public class Orders{
                public List<orders> orders= new ArrayList<>();
                public List<orders> getOrders(){return orders;}

                class orders{

                    @SerializedName("orderCd")
                    public String orderCd; //주문번호

                    public String getOrderCd() {
                        return orderCd;
                    }

                    @SerializedName("orderNm")
                    public String orderNm; //주문이름

                    public String getOrderNm() {
                        return orderNm;
                    }

                    @SerializedName("carNm")
                    public String carNm; //차량명

                    public String getCarNm() {
                        return carNm;
                    }

                    @SerializedName("carNo")
                    public String carNo;//차량번호

                    public String getCarNo() {
                        return carNo;
                    }

                    @SerializedName("cstmrNm")
                    public String cstmrNm; //예약자명

                    public String getCstmrNm() {
                        return cstmrNm;
                    }

                    @SerializedName("orderStateTy")
                    public String orderStateTy; //주문상태

                    public String getOrderStateTy() {
                        return orderStateTy;
                    }

                    @SerializedName("orderStateTyNm")
                    public String orderStateTyNm; //주문상태명

                    public String getOrderStateTyNm() {
                        return orderStateTyNm;
                    }

                    @SerializedName("chargeTy")
                    public String chargeTy; //청구구분

                    public String getChargeTy() {
                        return chargeTy;
                    }

                    @SerializedName("chargeTyNm")
                    public String chargeTyNm; //청구구분명

                    public String getChargeTyNm() {
                        return chargeTyNm;
                    }

                    @SerializedName("startDt")
                    public String startDt; //주문시작일

                    public String getStartDt() {
                        return startDt;
                    }

                    @SerializedName("endDt")
                    public String endDt; //주문종료일일

                    public String getEndDt() {
                        return endDt;
                    }

                    @SerializedName("cmpnyNm")
                    public String cmpnyNm;// 업체명

                    public String getCmpnyNm() {
                        return cmpnyNm;
                    }
                }

            }




        }



    }


}
