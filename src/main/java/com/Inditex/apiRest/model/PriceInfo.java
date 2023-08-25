package com.Inditex.apiRest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "PRICE_INFO")
@NoArgsConstructor
public class PriceInfo {

    @EmbeddedId
    private PriceInfoPK id;

    private Integer priority;

    private BigDecimal price;

    private String currency;

    public PriceInfo(Long brandId, Date startDate, Date endDate, Integer priceList, Long productId) {
    }

}
