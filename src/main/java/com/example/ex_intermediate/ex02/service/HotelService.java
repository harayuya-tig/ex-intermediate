/**
 * 業務処理を記述する
 * @author harayuya
 */

package com.example.ex_intermediate.ex02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ex_intermediate.ex02.domain.Hotel;
import com.example.ex_intermediate.ex02.repository.HotelRepository;

@Service
@Transactional
public class HotelService {
    
    @Autowired
    HotelRepository repository;

    /**
     * 引数以下のpriceのホテルオブジェクトの業務処理を記述する
     * @param price 価格
     * @return 引数以下のpriceのホテルオブジェクトのリスト
     */
    public List<Hotel> searchByLessThanPrice(Integer price) {
        return repository.searchByLessThanPrice(price);
    }
}
