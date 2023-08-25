package com.Inditex.apiRest.controller;

import com.Inditex.apiRest.model.PriceInfo;
import com.Inditex.apiRest.service.PriceInfoService;
import com.Inditex.apiRest.model.ResultPriceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import com.Inditex.apiRest.model.PriceInfoPK;

@RestController
@RequestMapping("api/priceInfo")
@Validated
public class PriceInfoController {

    @Autowired
    private PriceInfoService priceInfoService;

    @PostMapping
    public PriceInfo createPriceInfo(@Valid @RequestBody PriceInfo priceInfo){
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

    @GetMapping("{productId}")
    public List<PriceInfo> searchPriceInfoByProductId(@PathVariable("productId") String productId){
        return priceInfoService.getPriceInfoByProductId(productId);
    }
    @DeleteMapping("{id}")
    public void deletePriceInfoByProductId(@PathVariable("id") String productId){
        priceInfoService.deletePriceInfo(productId);
    }

    @GetMapping("calculatePrice")
    public ResponseEntity<Object> calculatePrice(
            @RequestParam("applicationDate") @Valid @NotNull(message = "The applicationDate field cannot be null")
            String intervalDate,
            @RequestParam("productId") @Valid @NotNull(message = "The productId field cannot be null")
            @Positive(message = "ProductID must be positive") Long productId,
            @RequestParam("brandId") @NotNull(message = "The brandId field cannot be null")
            @Positive(message = "BrandID must be positive") Long brandId) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date combinedIntervalDate;

        try {
            combinedIntervalDate = dateFormat.parse(intervalDate);
        } catch (ParseException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CustomErrorResponse("Invalid date format. The correct format is: dd/MM/yyyy HH:mm:ss"));
        }


        try {
            PriceInfo calculationResult = priceInfoService.calculatePrice(combinedIntervalDate, productId, brandId);

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
            String errorMessage = "Product not found, please try another search with others parameters";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CustomErrorResponse(errorMessage));
        }

    }

}