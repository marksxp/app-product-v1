package com.sxp.app.product.v1.application.port.output;

import com.sxp.app.product.v1.domain.model.ProductDomain;
import reactor.core.publisher.Mono;

public interface ProductH2PersistencePort {

    Mono<ProductDomain> findProductByFields(final String applicationDate,
                                            final Integer productId,
                                            final Integer brandId);

}
