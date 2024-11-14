package com.sxp.app.product.v1.infrastructure.adapter.input.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public enum LevelEnumDto {

    ERROR("ERROR"),
    FATAL("FATAL"),
    INFO("INFO"),
    WARNING("WARNING");

    private String value;

}
