package com.example.ex_intermediate.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.ex_intermediate.domain.Team;
import com.example.ex_intermediate.repository.TeamRepository;
import java.util.List;

@Service
@Transactional
public class TeamService {
    
    @Autowired
    private TeamRepository repository;

    /**
     * 全チームの検索を行う
     * @return 全チームのリストのオブジェクト
     */
    public List<Team> findAll() {
        return repository.findAll();
    }

    /**
     * idでチームの全件検索を行う
     * @param id ID
     * @return チームのオブジェクト
     */
    public Team findById(Integer id) {
        return repository.findById(id);
    }

}
