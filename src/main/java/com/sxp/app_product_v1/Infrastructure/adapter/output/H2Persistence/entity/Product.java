package com.sxp.app_product_v1.Infrastructure.adapter.output.H2Persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Table(name = "PRODUCT")
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @Column("ID")
    private Integer id;

    @Column("BRAND_ID")
    private Integer brandId;

    @Column("START_DATE")
    private LocalDateTime startDate;

    @Column("END_DATE")
    private LocalDateTime endDate;

    @Column("PRICE_LIST")
    private Integer priceList;

    @Column("PRODUCT_ID")
    private Integer productId;

    @Column("PRIORITY")
    private Integer priority;

    @Column("PRICE")
    private BigDecimal price;

    @Column("CURR")
    private String curr;

}
