/**
 * Clothテーブルを操作する
 * @author harayuya
 */

package com.example.ex_intermediate.ex03.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.ArrayList;

import com.example.ex_intermediate.ex03.domain.Cloth;

@Repository
public class ClothRepository {

    @Autowired
    NamedParameterJdbcTemplate template;

    private static final RowMapper<Cloth> CLOTH_ROW_MAPPER = (rs, i) -> {
        Cloth cloth = new Cloth();
        cloth.setId(rs.getInt("id"));
        cloth.setCategory((rs.getString("category")));
        cloth.setGenre(rs.getString("genre"));
        cloth.setGender(rs.getInt("gender"));
        cloth.setColor(rs.getString("color"));;
        cloth.setPrice(rs.getInt("price"));
        cloth.setSize(rs.getString("size"));
        
        return cloth;
    };

    /** 
     * 指定した色と性別に合致する服を検索する
     * @param color 色
     * @param gender 性別
     * @return 服のリスト
     */
    public List<Cloth> searchByColorAndGender(String color, Integer gender) {
        List<Cloth> clothList = new ArrayList<>();
        String sql = "SELECT id,category,genre,gender,color,price,size FROM clothes WHERE color=:color AND gender=:gender;";
        SqlParameterSource param = new MapSqlParameterSource().addValue("color", color).addValue("gender", gender);
        clothList = template.query(sql, param, CLOTH_ROW_MAPPER);

        return clothList;
    }
}