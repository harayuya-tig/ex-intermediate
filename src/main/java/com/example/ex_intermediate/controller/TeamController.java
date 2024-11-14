package com.example.ex_intermediate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import com.example.ex_intermediate.service.TeamService;

@Controller
@RequestMapping("/team")
public class TeamController {
    
    @Autowired
    private TeamService service;

    /** 
     * 全チーム一覧の表示
     * @return 全チーム一覧のview
     */
    @RequestMapping("/list")
    public String showList(Model model) {
        model.addAttribute("teamList", service.findAll());
        return "show-list";
    }

    
}
