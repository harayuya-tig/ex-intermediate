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
    
    @Autowired
    ClothService service;

    @ModelAttribute
    public ClothForm setUpForm() {
        return new ClothForm();
    }

    /**
     * 入力フォームのviewへ遷移
     * @return 入力フォームのview
     */
    @RequestMapping("/input-form")
    public String inputForm() {
        return "ex03/input-form";
    }

    /**
     * リクエストパラメーターを受取り、処理の後、結果出力画面のviewへ遷移
     * @param form 服の情報のフォーム
     * @param model リクエストスコープのオブジェクト
     * @return 結果出力画面のview
     */
    @RequestMapping("/input-info")
    public String inputInfo(ClothForm form, Model model) {
        List<Cloth> clothList = new ArrayList<>();
        
        clothList = service.searchByColorAndGender(form.getColor(), form.getGender());

        model.addAttribute("clothList", clothList);

        return "ex03/show-list";
    }
}
