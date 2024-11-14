/**
 * ページの表示の処理を記述する
 * @author harayuya
 */

package com.example.ex_intermediate.ex01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import java.util.List;
import java.util.ArrayList;
import com.example.ex_intermediate.ex01.domain.Team;
import com.example.ex_intermediate.ex01.service.TeamService;


@Controller
@RequestMapping("/team")
public class TeamController {
    
    @Autowired
    private TeamService service;

    /** 
     * 全チーム一覧のviewへの遷移
     * @return 全チーム一覧のview
     */
    @RequestMapping("/show-list")
    public String showList(Model model) {
        model.addAttribute("teamList", service.findAll());
        
        return "ex01/show-list";
    }

    /**
     * チームの詳細情報のviewへの遷移
     * @return 受け取ったidと合致するチームの詳細情報のview
     */
    @RequestMapping("/show-detail")
    public String showDetail(Integer id, Model model) {
        Team team = service.findById(id);
        model.addAttribute("team", team);
        
        /** teamHistoryを改行で分割しリストに格納. requestスコープに格納 */
        List<String> teamHistoryDivSentences = new ArrayList<String>();
        String[] array = team.getHistory().split("\n");
        for (String sentences : array) {
            teamHistoryDivSentences.add(sentences);
        }
        model.addAttribute("teamHistoryDivSentences", teamHistoryDivSentences);

        for (String str : teamHistoryDivSentences) {
            System.out.println(str);
        }

        return "ex01/show-detail";
    }

    
}
