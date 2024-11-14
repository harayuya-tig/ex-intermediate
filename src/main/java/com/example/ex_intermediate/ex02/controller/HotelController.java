package com.example.ex_intermediate.ex02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import java.util.List;
import com.example.ex_intermediate.ex02.domain.Hotel;
import com.example.ex_intermediate.ex02.form.HotelForm;
import com.example.ex_intermediate.ex02.service.HotelService;

@Controller
@RequestMapping("/hotel")
public class HotelController {
    
    @ModelAttribute
    private HotelForm setUpForm() {
        return new HotelForm();
    }

    @Autowired
    HotelService service;

    @RequestMapping("")
    private String index() {
        return "input";
    }

    @RequestMapping("/search-by-less-than-price")
    private String searchByLessThanPrice(HotelForm form, Model model) {
        List<Hotel> hotelList = service.searchByLessThanPrice(form.getId());
        model.addAttribute("hotelList", hotelList);
        return "show-list";
    } 
}
