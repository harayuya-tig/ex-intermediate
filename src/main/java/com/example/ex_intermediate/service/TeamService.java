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

    public List<Team> findAll() {
        return repository.findAll();
    }

}
