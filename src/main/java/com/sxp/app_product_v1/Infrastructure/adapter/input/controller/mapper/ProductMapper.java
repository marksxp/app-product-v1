package com.sxp.app_product_v1.Infrastructure.adapter.input.controller.mapper;

import com.sxp.app_product_v1.domain.model.ProductDomain;
import com.sxp.app_product_v1.openapi.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {

    Product toProduct(ProductDomain productDomain);

}
