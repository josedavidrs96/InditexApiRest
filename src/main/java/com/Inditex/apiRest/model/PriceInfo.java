package com.Inditex.apiRest.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "PRICE_INFO")
@NoArgsConstructor
public class PriceInfo {

    @EmbeddedId
    private PriceInfoPK id;


    private Integer priority;

    @NotNull
    private BigDecimal price;

    @NotNull
    private String currency;

    public PriceInfo(Long brandId, Date startDate, Date endDate, Integer priceList, Long productId) {
    }

    public void setPriority(Integer priority) {
        this.priority = Objects.requireNonNullElse(priority, 1);
    }

}
