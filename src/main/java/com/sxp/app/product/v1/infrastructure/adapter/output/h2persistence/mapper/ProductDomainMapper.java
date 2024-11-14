package com.sxp.app.product.v1.infrastructure.adapter.output.h2persistence.mapper;

import com.sxp.app.product.v1.domain.model.ProductDomain;
import com.sxp.app.product.v1.infrastructure.adapter.output.h2persistence.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.sxp.app.product.v1.infrastructure.adapter.input.controller.constant.ProductConstants.DATE_TIME_FORMAT;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductDomainMapper {

    ProductDomain toProductDomain(Product product);

    default String mapLocalDateTimeToString(LocalDateTime localDateTime) {
        return localDateTime != null ? localDateTime.format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)) : null;
    }

}
