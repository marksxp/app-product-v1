package com.sxp.app.product.v1.infrastructure.adapter.input.controller;

import com.sxp.app.product.v1.application.port.input.ProductServicePort;
import com.sxp.app.product.v1.domain.exception.InternalServerErrorException;
import com.sxp.app.product.v1.domain.model.ProductDomain;
import com.sxp.app.product.v1.infrastructure.adapter.input.controller.mapper.ProductMapper;
import com.sxp.app.product.v1.openapi.model.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @InjectMocks
    private ProductController controller;

    @Mock
    private ProductServicePort productServicePort;

    @Mock
    private ProductMapper mapper;

    @Mock
    private ServerWebExchange exchange;

    @Test
    void givenProductInDatabase_WhenCalled_ShouldReturnResponseEntity() {
        var productDomain = ProductDomain.builder()
                .brandId(1)
                .startDate("2020-06-14-00.00.00")
                .endDate("2020-12-31-23.59.59")
                .priceList(1)
                .productId(35455)
                .price(BigDecimal.valueOf(35.50))
                .curr("EUR")
                .build();

        var product = new Product();
        product.setProductId(35455);
        product.setBrandId(1);
        product.setPriceList(1);
        product.setStartDate("2020-06-14-00.00.00");
        product.setEndDate("2020-12-31-23.59.59");
        product.setPrice(BigDecimal.valueOf(35.50));
        product.setCurr("EUR");

        when(productServicePort.retrieveProducts(anyString(), anyInt(), anyInt())).thenReturn(Mono.just(productDomain));
        when(mapper.toProduct(any())).thenReturn(product);

        var result = controller._retrieveProducts(anyString(), anyInt(), anyInt(), exchange);

        StepVerifier.create(result)
                .assertNext(r -> {
                    assertEquals(200, r.getStatusCodeValue());
                    assertEquals(product, r.getBody());
                })
                .verifyComplete();
    }

    @Test
    void givenProductServicePort_WhenCalled_ShouldReturnException() {
        when(productServicePort.retrieveProducts(anyString(), anyInt(), anyInt())).thenReturn(Mono.error(new Throwable("error")));

        var result = controller._retrieveProducts(anyString(), anyInt(), anyInt(), exchange);

        StepVerifier.create(result)
                .expectError(InternalServerErrorException.class)
                .verify();
    }

}