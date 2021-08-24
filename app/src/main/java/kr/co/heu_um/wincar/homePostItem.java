package kr.co.heu_um.wincar;

public class homePostItem {

    //String accessToken;
    String userCd;
    String cmpnyCd;
    String viewTy;
    String baseDt;

    public homePostItem(){

    }

    public homePostItem(String userCd, String cmpnyCd, String viewTy, String baseDt){
      // this.accessToken=accessToken;
        this.userCd=userCd;
        this.cmpnyCd=cmpnyCd;
        this.viewTy=viewTy;
        this.baseDt=baseDt;
    }


}
