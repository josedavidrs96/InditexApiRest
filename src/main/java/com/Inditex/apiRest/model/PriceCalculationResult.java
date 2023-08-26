package com.Inditex.apiRest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriceCalculationResult {
    private Long productId;
    private Long brandId;
    private BigDecimal appliedRate;
    private Date startDate;
    private Date endDate;
    private BigDecimal finalPrice;
}

