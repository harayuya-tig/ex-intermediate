package com.example.ex_intermediate.domain;

import java.time.LocalDate;

public class Team {
    
    private Integer id;
    private String leagueName;
    private String teamName;
    private String headQuaters;
    private LocalDate inauguration;
    private String history;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getLeagueName() {
        return leagueName;
    }
    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }
    public String getTeamName() {
        return teamName;
    }
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    public String getHeadQuaters() {
        return headQuaters;
    }
    public void setHeadQuaters(String headQuaters) {
        this.headQuaters = headQuaters;
    }
    public LocalDate getInauguration() {
        return inauguration;
    }
    public void setInauguration(LocalDate inauguration) {
        this.inauguration = inauguration;
    }
    public String getHistory() {
        return history;
    }
    public void setHistory(String history) {
        this.history = history;
    }
    @Override
    public String toString() {
        return "Team [id=" + id + ", leagueName=" + leagueName + ", teamName=" + teamName + ", headQuaters="
                + headQuaters + ", history=" + history + "]";
    }
}
