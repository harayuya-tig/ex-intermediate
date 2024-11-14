/**
 * 服の情報を受け取る
 * @author harayuya
 */

package com.example.ex_intermediate.ex03.form;

public class ClothForm {
    
    /** ID */
    private Integer id;
    /** カテゴリー */
    private String category;
    /** ジャンル */
    private String genre;
    /** 性別 */
    private Integer gender;
    /** 色 */
    private String color;
    /** 価格 */
    private Integer price;
    /** サイズ */
    private String size;
    
    public Integer getId() {
        return id;
    }
    public void setId(String id) {
        this.id = Integer.parseInt(id);
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public Integer getGender() {
        return gender;
    }
    public void setGender(Integer gender) {
        this.gender = gender;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = Integer.parseInt(price);
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }



}