package com.sxp.app_product_v1.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDomain {

    private Integer brandId;
    private String startDate;
    private String endDate;
    private Integer priceList;
    private Integer productId;
    private BigDecimal price;
    private String curr;

}
