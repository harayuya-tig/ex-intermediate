package com.example.ex_intermediate.repository;

import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import java.util.List;
import java.util.ArrayList;
import com.example.ex_intermediate.domain.Team;

@Repository
public class TeamRepository {
    
    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<Team> TEAM_ROW_MAPPER = (rs, i) -> {
        Team team = new Team();
        team.setId(rs.getInt("id"));
        team.setLeagueName(rs.getString("leagueName"));
        team.setTeamName(rs.getString("teamName"));
        team.setHeadQuaters(rs.getString("headQuaters"));
        team.setInauguration(rs.getDate("inauguration").toLocalDate());
        team.setHistory(rs.getString("history"));

        return team;
    };

    /**
     * チームの全件検索を行う
     * @return 全チームのオブジェクトのリスト
     */
    public List<Team> findAll() {
        List<Team> teamList = new ArrayList<Team>();
        
        String sql ="SELECT id,league_name,team_name,headquarters,inauguration,history FROM teams ORDER BY inauguration;";;

        teamList = template.query(sql, TEAM_ROW_MAPPER);

        return teamList;
    }

}
