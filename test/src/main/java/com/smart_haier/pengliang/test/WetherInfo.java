package com.smart_haier.pengliang.test;

/**
 * Created by PengLiang on 2015/11/5.
 */
public class WetherInfo {
    /**
     * city : 广州
     * cityid : 101280101
     * temp : 24
     * WD : 东南风
     * WS : 2级
     * SD : 77%
     * WSE : 2
     * time : 10:45
     * isRadar : 1
     * Radar : JC_RADAR_AZ9200_JB
     * njd : 暂无实况
     * qy : 1004
     */


    /**
     *
     {"weatherinfo":{"city":"广州","cityid":"101280101","temp":"24","WD":"东南风","WS":"2级","SD":"77%","WSE":"2","time":"10:45","isRadar":"1","Radar":"JC_RADAR_AZ9200_JB","njd":"暂无实况","qy":"1004"}}
     */
    private String city;
    private String cityid;
    private String temp;
    private String WD;
    private String WS;
    private String SD;
    private String WSE;
    private String time;
    private String isRadar;
    private String Radar;
    private String njd;
    private String qy;

    public WetherInfo(String city, String cityid, String temp, String WD, String WS, String SD, String WSE, String time, String isRadar, String radar, String njd, String qy) {

        this.city = city;
        this.cityid = cityid;
        this.temp = temp;
        this.WD = WD;
        this.WS = WS;
        this.SD = SD;
        this.WSE = WSE;
        this.time = time;
        this.isRadar = isRadar;
        Radar = radar;
        this.njd = njd;
        this.qy = qy;
    }

    public WetherInfo() {
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public void setWD(String WD) {
        this.WD = WD;
    }

    public void setWS(String WS) {
        this.WS = WS;
    }

    public void setSD(String SD) {
        this.SD = SD;
    }

    public void setWSE(String WSE) {
        this.WSE = WSE;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setIsRadar(String isRadar) {
        this.isRadar = isRadar;
    }

    public void setRadar(String Radar) {
        this.Radar = Radar;
    }

    public void setNjd(String njd) {
        this.njd = njd;
    }

    public void setQy(String qy) {
        this.qy = qy;
    }

    public String getCity() {
        return city;
    }

    public String getCityid() {
        return cityid;
    }

    public String getTemp() {
        return temp;
    }

    public String getWD() {
        return WD;
    }

    public String getWS() {
        return WS;
    }

    public String getSD() {
        return SD;
    }

    public String getWSE() {
        return WSE;
    }

    public String getTime() {
        return time;
    }

    public String getIsRadar() {
        return isRadar;
    }

    public String getRadar() {
        return Radar;
    }

    public String getNjd() {
        return njd;
    }

    public String getQy() {
        return qy;
    }

    @Override
    public String toString() {
        return "WetherInfo{" +
                "city='" + city + '\'' +
                ", cityid='" + cityid + '\'' +
                ", temp='" + temp + '\'' +
                ", WD='" + WD + '\'' +
                ", WS='" + WS + '\'' +
                ", SD='" + SD + '\'' +
                ", WSE='" + WSE + '\'' +
                ", time='" + time + '\'' +
                ", isRadar='" + isRadar + '\'' +
                ", Radar='" + Radar + '\'' +
                ", njd='" + njd + '\'' +
                ", qy='" + qy + '\'' +
                '}';
    }
}

