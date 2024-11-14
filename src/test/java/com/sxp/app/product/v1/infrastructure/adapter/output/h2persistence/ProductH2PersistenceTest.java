package com.sxp.app.product.v1.infrastructure.adapter.output.h2persistence;

import com.sxp.app.product.v1.domain.model.ProductDomain;
import com.sxp.app.product.v1.infrastructure.adapter.output.h2persistence.entity.Product;
import com.sxp.app.product.v1.infrastructure.adapter.output.h2persistence.mapper.ProductDomainMapper;
import com.sxp.app.product.v1.infrastructure.adapter.output.h2persistence.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.sxp.app.product.v1.infrastructure.adapter.input.controller.constant.ProductConstants.DATE_TIME_FORMAT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductH2PersistenceTest {

    @InjectMocks
    private ProductH2Persistence productH2Persistence;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductDomainMapper mapper;

    @Test
    void givenFieldsAreInformed_WhenCalled_ShouldReturnProductDomain() {
        var product = new Product();
        product.setId(1);
        product.setProductId(35455);
        product.setBrandId(1);
        product.setPriceList(1);
        product.setStartDate(LocalDateTime.parse("2020-06-14-00.00.00", DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)));
        product.setEndDate(LocalDateTime.parse("2020-12-31-23.59.59", DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)));
        product.setPriority(1);
        product.setPrice(BigDecimal.valueOf(35.50));
        product.setCurr("EUR");

        var productDomain = ProductDomain.builder()
                .brandId(1)
                .startDate("2020-06-14-00.00.00")
                .endDate("2020-12-31-23.59.59")
                .priceList(1)
                .productId(35455)
                .price(BigDecimal.valueOf(35.50))
                .curr("EUR")
                .build();

        when(productRepository.findProductByFields(anyString(), anyInt(), anyInt())).thenReturn(Mono.just(product));
        when(mapper.toProductDomain(any())).thenReturn(productDomain);

        var result = productH2Persistence.findProductByFields("2020-06-14-10.00.00", 35455, 1);

        StepVerifier.create(result)
                .assertNext(r -> assertEquals(productDomain, r))
                .verifyComplete();
    }

    @Test
    void givenProductRepository_WhenCalled_ShouldReturnException() {
        when(productRepository.findProductByFields(anyString(), anyInt(), anyInt())).thenReturn(Mono.error(new Throwable("error")));

        var result = productH2Persistence.findProductByFields("2020-06-14-10.00.00", 35455, 1);

        StepVerifier.create(result)
                .expectError(Throwable.class)
                .verify();
    }

}