package com.aditya.scanit;


public class HistoryModel {
    private String ID;
    private String BarNUM;
    private String country;
    private byte[] Image;



    public HistoryModel(String ID, String BarNUM, String country, byte[] Image) {
        this.ID = ID;
        this.BarNUM = BarNUM;
        this.country = country;
        this.Image=Image;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getBarNUM() {
        return BarNUM;
    }

    public void setBarNUM(String barNUM) {
        BarNUM = barNUM;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public byte[] getImage() {
        return Image;
    }

    public void setImage(byte[] image) {
        Image = image;
    }
}
