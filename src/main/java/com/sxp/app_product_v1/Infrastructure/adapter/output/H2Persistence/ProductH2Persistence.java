package com.sxp.app_product_v1.Infrastructure.adapter.output.H2Persistence;

import com.sxp.app_product_v1.Infrastructure.adapter.output.H2Persistence.mapper.ProductDomainMapper;
import com.sxp.app_product_v1.Infrastructure.adapter.output.H2Persistence.repository.ProductRepository;
import com.sxp.app_product_v1.application.port.output.ProductH2PersistencePort;
import com.sxp.app_product_v1.domain.model.ProductDomain;
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
