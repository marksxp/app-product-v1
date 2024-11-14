package com.sxp.app.product.v1.infrastructure.adapter.output.h2persistence;

import com.sxp.app.product.v1.application.port.output.ProductH2PersistencePort;
import com.sxp.app.product.v1.domain.model.ProductDomain;
import com.sxp.app.product.v1.infrastructure.adapter.output.h2persistence.mapper.ProductDomainMapper;
import com.sxp.app.product.v1.infrastructure.adapter.output.h2persistence.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductH2Persistence implements ProductH2PersistencePort {

    private final ProductRepository productRepository;
    private final ProductDomainMapper mapper;

    @Override
    public Mono<ProductDomain> findProductByFields(final String applicationDate,
                                                   final Integer productId,
                                                   final Integer brandId) {
        return productRepository.findProductByFields(applicationDate, productId, brandId)
                .map(mapper::toProductDomain);
    }

}
