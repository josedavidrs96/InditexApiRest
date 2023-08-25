package com.Inditex.apiRest;


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

    public PriceInfo getPriceInfoById(PriceInfoPK id){
        Optional<PriceInfo> optionalPriceInfo = priceInfoRepository.findById(id);
        return optionalPriceInfo.get();
    }

    public boolean existsPriceInfo(PriceInfoPK priceInfoPK) {

        return priceInfoRepository.existsById(priceInfoPK);
    }
    public List<PriceInfo> getAllPriceInfo(){
        return priceInfoRepository.findAll();
    }

    public void deletePriceInfo(PriceInfoPK id){
        priceInfoRepository.deleteById(id);
    }

    public PriceInfo calculatePrice(Date intervalDate, Long productId, Long brandId) {
        // Obtener el PriceInfo correspondiente para los parámetros dados
        PriceInfo resultPriceInfo = priceInfoRepository.findPriceInfoByProductIdAndIntervalDateAndBrandId(productId,intervalDate, brandId);

        if (resultPriceInfo == null) {
            throw new NoPriceInfoFoundException("No se encontró información de precio para los parámetros proporcionados");
        }

        // Realizar el cálculo del precio final (usando los campos necesarios del PriceInfo)

        return resultPriceInfo;
    }

}