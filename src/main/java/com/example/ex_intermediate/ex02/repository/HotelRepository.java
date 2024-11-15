/**
 * Hotelテーブルを操作する
 * @author harayuya
 */

package com.example.ex_intermediate.ex02.repository;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.RowMapper;
import java.util.List;
import java.util.ArrayList;
import com.example.ex_intermediate.ex02.domain.Hotel;

@Repository
public class HotelRepository {
    
    @Autowired
    NamedParameterJdbcTemplate template;

    /** クエリの結果をHotelドメインと紐づけ */
    private final static RowMapper<Hotel> HOTEL_ROW_MAPPER = (rs, i) -> {
        Hotel hotel = new Hotel();

        hotel.setId(rs.getInt("id"));
        hotel.setAreaName(rs.getString("area_name"));
        hotel.setHotelName(rs.getString("hotel_name"));
        hotel.setAddress(rs.getString("address"));
        hotel.setNearestStation(rs.getString("nearest_station"));
        hotel.setPrice(rs.getInt("price"));
        hotel.setParking(rs.getString("parking"));

        return hotel;
    };

    /**
     * 引数以下のpriceのホテルオブジェクトを返す
     * @param price 価格
     * @return 引数以下のpriceのホテルオブジェクトのリスト
     */
    public List<Hotel> searchByLessThanPrice(Integer price) {
        List<Hotel> hotelList = new ArrayList<Hotel>();

        String sql = "SELECT id,area_name,hotel_name,address,nearest_station,price,parking FROM hotels WHERE price <= :price;";

        SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);

        hotelList = template.query(sql, param, HOTEL_ROW_MAPPER);

        return hotelList;
    }
}
