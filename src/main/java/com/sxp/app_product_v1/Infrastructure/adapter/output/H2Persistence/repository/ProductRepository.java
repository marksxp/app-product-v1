package com.sxp.app_product_v1.Infrastructure.adapter.output.H2Persistence.repository;

import com.sxp.app_product_v1.Infrastructure.adapter.output.H2Persistence.entity.Product;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface ProductRepository extends ReactiveCrudRepository<Product, Integer> {

    @Query(value = "SELECT * FROM PRODUCT p" +
            " WHERE PARSEDATETIME(:applicationDate, 'yyyy-MM-dd-HH.mm.ss') >= p.START_DATE" +
            " AND PARSEDATETIME(:applicationDate, 'yyyy-MM-dd-HH.mm.ss') <= p.END_DATE" +
            " AND p.PRODUCT_ID = :productId" +
            " AND p.BRAND_ID = :brandId" +
            " ORDER BY p.PRIORITY DESC" +
            " LIMIT 1")
    Mono<Product> findProductByFields(
            @Param("applicationDate") String applicationDate,
            @Param("productId") Integer productId,
            @Param("brandId") Integer brandId);

}
