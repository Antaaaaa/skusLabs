package com.example.skus.demo.repository;

import com.example.skus.demo.model.Risk;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Basic {@code RiskMathCalculationDAO} interface which alows you
 * to manage the database
 */
public interface RiskMathCalculationDAO extends JpaRepository<Risk, Long> {}
