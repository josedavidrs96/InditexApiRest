package com.Inditex.apiRest.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class PriceInfoPK implements Serializable {

    @NotNull
    @Column(name = "BRAND_ID")
    private Long brandId;

    @NotNull
    @Column(name = "START_DATE")
    private Date startDate;

    @NotNull
    @Column(name = "END_DATE")
    private Date endDate;

    @NotNull
    @Column(name = "PRICE_LIST")
    private Integer priceList;

    @NotNull
    @Column(name = "PRODUCT_ID")
    private Long productId;

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setPriceList(Integer priceList) {
        this.priceList = priceList;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceInfoPK that = (PriceInfoPK) o;
        return Objects.equals(brandId, that.brandId) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(priceList, that.priceList) &&
                Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandId, startDate, endDate, priceList, productId);
    }

}

