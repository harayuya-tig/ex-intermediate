/**
 * チーム情報を格納する
 * @author harayuya
 */

package com.example.ex_intermediate.ex01.domain;

public class Team {
    
    /** ID */
    private Integer id;
    /** 所属するリーグ名 */
    private String leagueName;
    /** チーム名 */
    private String teamName;
    /** 本拠地 */
    private String headQuarters;
    /** 発足日 */
    private String inauguration;
    /** 歴史 */
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
    public String getHeadQuarters() {
        return headQuarters;
    }
    public void setHeadQuarters(String headQuarters) {
        this.headQuarters = headQuarters;
    }
    public String getInauguration() {
        return inauguration;
    }
    public void setInauguration(String inauguration) {
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
                + headQuarters + ", history=" + history + "]";
    }
}
