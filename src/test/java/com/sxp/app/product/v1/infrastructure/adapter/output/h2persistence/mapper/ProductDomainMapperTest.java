package com.sxp.app.product.v1.infrastructure.adapter.output.h2persistence.mapper;

import com.sxp.app.product.v1.infrastructure.adapter.output.h2persistence.entity.Product;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class ProductDomainMapperTest {

    private final ProductDomainMapper mapper = Mappers.getMapper(ProductDomainMapper.class);

    @Test
    void givenProduct_WhenCalled_ShouldReturnProductDomain() {
        var product = new Product();
        product.setId(1);
        product.setProductId(35455);
        product.setBrandId(1);
        product.setPriceList(1);
        product.setStartDate(LocalDateTime.now());
        product.setEndDate(LocalDateTime.now());
        product.setPriority(1);
        product.setPrice(BigDecimal.valueOf(35.50));
        product.setCurr("EUR");

        var productDomain = mapper.toProductDomain(product);

        assertNotNull(productDomain);
        assertEquals(productDomain.getCurr(), product.getCurr());
    }

    @Test
    void givenLocalDateTimeIsNull_WhenCalled_ShouldReturnNull() {
        var product = new Product();
        product.setStartDate(null);
        product.setEndDate(null);

        var productDomain = mapper.toProductDomain(product);

        assertNotNull(productDomain);
        assertNull(productDomain.getStartDate());
    }

    @Test
    void givenProductDomainIsNull_WhenCalled_ShouldReturnNull() {
        var productDomain = mapper.toProductDomain(null);

        assertNull(productDomain);
    }

}