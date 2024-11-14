/**
 * ページの表示の処理を記述する
 * @author harayuya
 */

package com.example.ex_intermediate.ex01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ex_intermediate.ex01.service.TeamService;

import org.springframework.ui.Model;

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
        model.addAttribute("team", service.findById(id));
        return "ex01/show-detail";
    }

    
}
