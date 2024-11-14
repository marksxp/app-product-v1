package com.sxp.app.product.v1.infrastructure.adapter.input.controller.mapper;

import com.sxp.app.product.v1.domain.model.ProductDomain;
import com.sxp.app.product.v1.openapi.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {

    Product toProduct(ProductDomain productDomain);

}
