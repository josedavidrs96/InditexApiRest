package com.Inditex.apiRest.repository;

import com.Inditex.apiRest.model.PriceInfo;
import com.Inditex.apiRest.model.PriceInfoPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface PriceInfoRepository extends JpaRepository<PriceInfo, PriceInfoPK> {

    boolean existsById(PriceInfoPK id);

    @Query("SELECT p FROM PriceInfo p WHERE " +
            "p.id.productId = :productId AND " +
            "(:intervalDate BETWEEN p.id.startDate AND p.id.endDate) AND " +
            "p.id.brandId = :brandId")
    PriceInfo findPriceInfoByProductIdAndIntervalDateAndBrandId(
            @Param("productId") Long productId,
            @Param("intervalDate") Date intervalDate,
            @Param("brandId") Long brandId
    );
}