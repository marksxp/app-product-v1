package com.sxp.app_product_v1.Infrastructure.adapter.input.controller.mapper;

import com.sxp.app_product_v1.domain.model.ProductDomain;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class ProductMapperTest {

    private final ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    @Test
    void givenProductDomain_WhenCalled_ShouldReturnProduct() {
        var productDomain = ProductDomain.builder()
                .brandId(1)
                .startDate("2020-06-14-00.00.00")
                .endDate("2020-12-31-23.59.59")
                .priceList(1)
                .productId(35455)
                .price(BigDecimal.valueOf(35.50))
                .curr("EUR")
                .build();

        var product = mapper.toProduct(productDomain);

        assertNotNull(product);
        assertEquals(product.getCurr(), productDomain.getCurr());
    }

    @Test
    void givenProductDomainIsNull_WhenCalled_ShouldReturnNull() {
        var product = mapper.toProduct(null);

        assertNull(product);
    }

}