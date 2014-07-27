package com.shotmk.el.services;

import com.shotmk.el.entity.Rate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RateService {

    public Rate addRate(Rate rate);

    public Rate getRate(int id);

    public List<Rate> getRateList();

    public Rate getExistRate(String userid, int bookid);

}
