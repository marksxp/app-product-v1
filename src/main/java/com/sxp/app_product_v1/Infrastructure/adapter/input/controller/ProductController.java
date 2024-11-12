package com.sxp.app_product_v1.Infrastructure.adapter.input.controller;

import com.sxp.app_product_v1.Infrastructure.adapter.input.controller.mapper.ProductMapper;
import com.sxp.app_product_v1.application.port.input.ProductServicePort;
import com.sxp.app_product_v1.openapi.api.ProductApi;
import com.sxp.app_product_v1.openapi.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductController implements ProductApi {

    private final ProductServicePort productServicePort;
    private final ProductMapper mapper;

    @Override
    public Mono<ResponseEntity<Product>> _retrieveProducts(String applicationDate,
                                                           Integer productId,
                                                           Integer brandId,
                                                           ServerWebExchange exchange) {
        log.info("Retrieve Product: start");
        return productServicePort.retrieveProducts(applicationDate, productId, brandId)
                .map(mapper::toProduct)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.noContent().build())
                .onErrorResume(e -> {
                    log.error("Retrieve Product: Error={}", e.getMessage());
                    return Mono.just(ResponseEntity.internalServerError().build());
                });
    }

}
