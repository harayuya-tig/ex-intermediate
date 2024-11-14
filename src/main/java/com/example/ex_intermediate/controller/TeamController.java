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

    @RequestMapping("/list")
    public String showList(Model model) {
        model.addAttribute("teamList", service.findAll());
        return "show-list";
    }
}
