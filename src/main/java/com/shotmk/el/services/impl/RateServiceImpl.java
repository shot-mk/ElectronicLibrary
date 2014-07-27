package com.shotmk.el.services.impl;

import com.shotmk.el.entity.Rate;
import com.shotmk.el.repository.RateRepository;
import com.shotmk.el.services.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RateServiceImpl implements RateService {

    @Autowired
    private RateRepository rateRepository;

    @Override
    public Rate addRate(Rate rate) {
        return rateRepository.saveAndFlush(rate);
    }

    @Override
    public Rate getRate(int id) {
        return rateRepository.findOne(id);
    }

    @Override
    public List<Rate> getRateList() {
        return rateRepository.findAll();
    }

    @Override
    public Rate getExistRate(String userid, int bookid) {
        return rateRepository.getExistRate(userid, bookid);
    }
}
