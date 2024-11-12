package com.sxp.app_product_v1.application.usecase;

import com.sxp.app_product_v1.application.port.input.ProductServicePort;
import com.sxp.app_product_v1.application.port.output.ProductH2PersistencePort;
import com.sxp.app_product_v1.domain.model.ProductDomain;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService implements ProductServicePort {

    private final ProductH2PersistencePort productH2ServicePort;

    @Override
    public Mono<ProductDomain> retrieveProducts(String applicationDate, Integer productId, Integer brandId) {
        return productH2ServicePort.findProductByFields(applicationDate, productId, brandId);
    }

}
