package com.example.skus.demo.model;

import com.example.skus.demo.enums.RiskCategoryEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * {@code Rist} entity to describe the risk objects
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Risk {
    /**
     * {@code ID} of the actual user
     */
    @Id
    @GeneratedValue
    Long id;
    /**
     * {@code Age} of the actual user
     */
    Long age;
    @Enumerated
    /**
     * {@link RiskCategoryEnum} enum to describe the category
     */
    RiskCategoryEnum riskCategory;
}
