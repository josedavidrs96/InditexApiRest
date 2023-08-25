package com.Inditex.apiRest.service;


import com.Inditex.apiRest.model.PriceInfo;
import com.Inditex.apiRest.controller.NoPriceInfoFoundException;
import com.Inditex.apiRest.repository.PriceInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import com.Inditex.apiRest.model.PriceInfoPK;

@Component
public class PriceInfoService {
    @Autowired
    private PriceInfoRepository priceInfoRepository;

    public PriceInfo createPriceInfo(PriceInfo priceInfo){
        return priceInfoRepository.save(priceInfo);
    }

    public boolean existsPriceInfo(PriceInfoPK priceInfoPK) {

        return priceInfoRepository.existsById(priceInfoPK);
    }
    public List<PriceInfo> getAllPriceInfo(){
        return priceInfoRepository.findAll();
    }

    public void deletePriceInfo(String productId){
        priceInfoRepository.deleteAllByProductId(productId);
    }

    public PriceInfo calculatePrice(Date intervalDate, Long productId, Long brandId) {


        PriceInfo resultPriceInfo = priceInfoRepository.findHighestPriorityPriceInfo(productId,intervalDate, brandId);

        if (resultPriceInfo == null) {
            throw new NoPriceInfoFoundException("The price information was not found for the provided parameters.");
        }

        return resultPriceInfo;
    }

    public List<PriceInfo> getPriceInfoByProductId(String productId) {
        return priceInfoRepository.findAllByProductId(productId);
    }
}