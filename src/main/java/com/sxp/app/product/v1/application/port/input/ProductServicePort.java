package com.sxp.app.product.v1.application.port.input;

import com.sxp.app.product.v1.domain.model.ProductDomain;
import reactor.core.publisher.Mono;

public interface ProductServicePort {

    Mono<ProductDomain> retrieveProducts(final String applicationDate,
                                         final Integer productId,
                                         final Integer brandId);

}
