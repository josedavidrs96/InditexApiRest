package com.Inditex.apiRest.controller;

import com.Inditex.apiRest.model.PriceInfo;
import com.Inditex.apiRest.PriceInfoService;
import com.Inditex.apiRest.model.ResultPriceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


import com.Inditex.apiRest.model.PriceInfoPK;

@RestController
@RequestMapping("api/priceInfo")
public class PriceInfoController {

    @Autowired
    private PriceInfoService priceInfoService;

    @PostMapping
    public PriceInfo createPriceInfo(@RequestBody PriceInfo priceInfo){
        try {
            // Verifica si ya existe un registro con los mismos IDs compuestos
            boolean exists = priceInfoService.existsPriceInfo(priceInfo.getId());

            if (exists) {
                throw new RegistroExistenteException("El registro ya existe");
            }
        return priceInfoService.createPriceInfo(priceInfo);
    } catch (RegistroExistenteException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public List<PriceInfo> getAllPriceInfo(){
        return priceInfoService.getAllPriceInfo();
    }

    @GetMapping("{id}")
    public PriceInfo searchPriceInfoById(@PathVariable("id") PriceInfoPK id){
        return priceInfoService.getPriceInfoById(id);
    }
    @DeleteMapping("{id}")
    public void deletePriceInfoById(@PathVariable("id") PriceInfoPK id){
        priceInfoService.deletePriceInfo(id);
    }

    @GetMapping("calculatePrice")
    public ResponseEntity<ResultPriceInfo> calculatePrice(
            @RequestParam("applicationDate") @DateTimeFormat(pattern = "dd/MM/yyyy") Date intervalDate,
            @RequestParam("productId") Long productId,
            @RequestParam("brandId") Long brandId) {
        try {
            PriceInfo calculationResult = priceInfoService.calculatePrice(intervalDate, productId, brandId);

            ResultPriceInfo result = new ResultPriceInfo();

            PriceInfoPK resultId = new PriceInfoPK();
            resultId.setProductId(calculationResult.getId().getProductId());
            resultId.setStartDate(calculationResult.getId().getStartDate());
            resultId.setEndDate(calculationResult.getId().getEndDate());
            resultId.setPriceList(calculationResult.getId().getPriceList());
            resultId.setBrandId(calculationResult.getId().getBrandId());
            result.setId(resultId);

            result.setPrice(calculationResult.getPrice());

            return ResponseEntity.ok(result);
        } catch (NoPriceInfoFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}