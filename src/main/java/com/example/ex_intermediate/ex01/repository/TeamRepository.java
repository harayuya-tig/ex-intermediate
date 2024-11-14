/**
 * Teamテーブルを操作する
 * @author harayuya
 */

package com.example.ex_intermediate.ex01.repository;

import org.springframework.stereotype.Repository;

import com.example.ex_intermediate.ex01.domain.Team;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import java.util.List;
import java.util.ArrayList;

@Repository
public class TeamRepository {
    
    @Autowired
    private NamedParameterJdbcTemplate template;

    /** クエリの結果を受取り、対応するフィールドと紐づける */
    private static final RowMapper<Team> TEAM_ROW_MAPPER = (rs, i) -> {
        Team team = new Team();
        team.setId(rs.getInt("id"));
        team.setLeagueName(rs.getString("league_name"));
        team.setTeamName(rs.getString("team_name"));
        team.setHeadQuarters(rs.getString("headquarters"));
        team.setInauguration(rs.getString("inauguration"));
        team.setHistory(rs.getString("history"));

        return team;
    };

    /**
     * 全件検索を行う
     * @return 全チームのリストのオブジェクト
     */
    public List<Team> findAll() {
        List<Team> teamList = new ArrayList<Team>();
        
        String sql ="SELECT id,league_name,team_name,headquarters,inauguration,history FROM teams ORDER BY inauguration;";
        teamList = template.query(sql, TEAM_ROW_MAPPER);

        return teamList;
    }

    /**
     * idでのチーム情報の全件検索を行う
     * @param id ID
     * @return idに合致するチームのオブジェクト
     */
    public Team findById(Integer id) {
        Team team = new Team();

        String sql = "SELECT id,league_name,team_name,headquarters,inauguration,history FROM teams WHERE id=:id;";
        SqlParameterSource param = new MapSqlParameterSource("id", id);
        team = template.queryForObject(sql, param, TEAM_ROW_MAPPER);

        return team;
    }
}
