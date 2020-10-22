package com.example.skus.demo.enums;

import lombok.AllArgsConstructor;

/**
 * {@code RistCategoryEnum} which collects the basic rist categories
 */
@AllArgsConstructor
public enum RiskCategoryEnum {
    /**
     * Basic rist categories
     */
    FIRST(0.1D), SECOND(0.25D), THIRD(0.5D), FOURTH(0.75D);

    Double percent;
    public Double getPercent(){
        return percent;
    }
}
