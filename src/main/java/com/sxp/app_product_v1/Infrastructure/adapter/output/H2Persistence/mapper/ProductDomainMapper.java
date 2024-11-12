package com.sxp.app_product_v1.Infrastructure.adapter.output.H2Persistence.mapper;

import com.sxp.app_product_v1.Infrastructure.adapter.output.H2Persistence.entity.Product;
import com.sxp.app_product_v1.domain.model.ProductDomain;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.sxp.app_product_v1.Infrastructure.adapter.input.controller.constant.ProductConstants.DATE_TIME_FORMAT;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductDomainMapper {

    ProductDomain toProductDomain(Product product);

    default String mapLocalDateTimeToString(LocalDateTime localDateTime) {
        return localDateTime != null ? localDateTime.format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)) : null;
    }

}
