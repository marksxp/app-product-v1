package com.sxp.app.product.v1.application.usecase;

import com.sxp.app.product.v1.application.port.output.ProductH2PersistencePort;
import com.sxp.app.product.v1.domain.model.ProductDomain;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductH2PersistencePort productH2ServicePort;


    @Test
    void givenProductInDatabase_WhenCalled_ShouldReturnData() {
        var productDomain = ProductDomain.builder()
                .brandId(1)
                .startDate("2020-06-14-00.00.00")
                .endDate("2020-12-31-23.59.59")
                .priceList(1)
                .productId(35455)
                .price(BigDecimal.valueOf(35.50))
                .curr("EUR")
                .build();

        when(productH2ServicePort.findProductByFields(anyString(), anyInt(), anyInt())).thenReturn(Mono.just(productDomain));

        var result = productService.retrieveProducts(anyString(), anyInt(), anyInt());

        StepVerifier.create(result)
                .expectNextMatches(productDomain::equals)
                .expectComplete()
                .verify();
    }

    @Test
    void givenNoProductInDatabase_WhenCalled_ShouldReturnEmpty() {
        when(productH2ServicePort.findProductByFields(anyString(), anyInt(), anyInt())).thenReturn(Mono.empty());

        var result = productService.retrieveProducts(anyString(), anyInt(), anyInt());

        StepVerifier.create(result)
                .expectComplete()
                .verify();
    }

}