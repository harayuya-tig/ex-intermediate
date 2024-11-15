/**
 * ホテルの情報を受け取るフォーム
 * @author harayuya
 */

package com.example.ex_intermediate.ex02.form;

public class HotelForm {
    
    private Integer id;
    private String areaName;
    private String hotelName;
    private String address;
    private String nearestStation;
    private Integer price;
    private String parking;
    
    public Integer getId() {
        return id;
    }
    public void setId(String id) {
        this.id = Integer.parseInt(id);
    }
    public String getAreaName() {
        return areaName;
    }
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
    public String getHotelName() {
        return hotelName;
    }
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getNearestStation() {
        return nearestStation;
    }
    public void setNearestStation(String nearestStation) {
        this.nearestStation = nearestStation;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = Integer.parseInt(price);
    }
    public String getParking() {
        return parking;
    }
    public void setParking(String parking) {
        this.parking = parking;
    }
    @Override
    public String toString() {
        return "HotelForm [id=" + id + ", areaName=" + areaName + ", hotelName=" + hotelName + ", address=" + address
                + ", nearestStation=" + nearestStation + ", price=" + price + ", parking=" + parking + "]";
    }
}
