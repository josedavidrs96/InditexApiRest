package com.Inditex.apiRest.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ResultPriceInfo {

    private PriceInfoPK id;

    private BigDecimal price;

    public ResultPriceInfo(Long brandId, Date startDate, Date endDate, Integer priceList, Long productId) {
    }

}
