/**
 * ページの表示の処理を記述する
 * @author harayuya
 */

package com.example.ex_intermediate.ex03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import com.example.ex_intermediate.ex03.domain.Cloth;
import com.example.ex_intermediate.ex03.form.ClothForm;
import com.example.ex_intermediate.ex03.service.ClothService;

@Controller
@RequestMapping("/cloth")
public class ClothController {
    
    @ModelAttribute
    public ClothForm setUpForm() {
        return new ClothForm();
    }

    @Autowired
    ClothService service;

    @RequestMapping("/input-form")
    public String inputForm() {
        return "ex03/input-form";
    }

    @RequestMapping("/input-info")
    public String inputInfo(ClothForm form, Model model) {
        List<Cloth> clothList = new ArrayList<>();
        clothList = service.searchByColorAndGender(form.getColor(), form.getGender());

        /** テスト用 */
        for (Cloth cloth : clothList) {
            System.out.println(cloth.getCategory());
        }

        return "ex03/show-list";
    }
}
