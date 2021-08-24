package kr.co.heu_um.wincar;

public class CalendarList {

    String date;
    String aa;
    String bb;
    String cc;


    public  CalendarList(){

    }
    public  CalendarList(String aa){

        this.aa= aa;

    }


    public CalendarList(String date, String aa, String bb, String cc){
        this.date=date;
        this.aa=aa;
        this.bb=bb;
        this.cc=cc;

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAa() {
        return aa;
    }

    public void setAa(String aa) {
        this.aa = aa;
    }

    public String getBb() {
        return bb;
    }

    public void setBb(String bb) {
        this.bb = bb;
    }

    public String getCc() { return cc; }

    public void setCc(String cc) { this.cc = cc; }
}
