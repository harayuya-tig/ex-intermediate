/**
 * 業務処理を行う
 * @author harayuya
 */

package com.example.ex_intermediate.ex03.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.ex_intermediate.ex03.domain.Cloth;
import com.example.ex_intermediate.ex03.repository.ClothRepository;

@Service
@Transactional
public class ClothService {
    
    @Autowired
    ClothRepository repository;

    /** 
     * 指定した色と性別に合致する服のリストを取得する
     * @param color 色
     * @param gender 性別
     * @return 服のリスト
     */
    public List<Cloth> searchByColorAndGender(String color, Integer gender) {
        return repository.searchByColorAndGender(color, gender);
    }
}
