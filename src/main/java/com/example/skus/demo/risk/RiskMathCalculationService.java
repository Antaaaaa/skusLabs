package com.example.skus.demo.risk;

import com.example.skus.demo.enums.RiskCategoryEnum;
import com.example.skus.demo.model.Risk;
import com.example.skus.demo.repository.RiskMathCalculationDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * <h1>This is {@code RiskMathCalculationService} class which might be used
 * to calculate the actual rist of users. Uses annotations: @Service, @RequiredArgsConstructor</h1>
 *
 * <p>It uses {@link java.lang.String} class and method {@link String#length()}.</p>
 *
 * @author  Juriy Skus
 * @see     java.lang.String
 * @see     java.lang.Double
 * @see     java.util.List
 * @see     java.util.concurrent.atomic.AtomicInteger
 * @since   8
 */
@Log4j2
@Service
@RequiredArgsConstructor
public class RiskMathCalculationService implements RiskMathCalculation {
    /**
     * Constant to represent the maximum sum of the risk
     */
    private static final Long MAX_SUM = 50_000L;
    /**
     * Constant to represent the standart percent of the risk
     */
    private static final Double STANDART_PERCENT = 0.05D;
    /**
     * DAO interface to invoke DB methods
     */
    private final RiskMathCalculationDAO mathCalculation;

    /**
     * @PostContruct method which alows you to add new users
     */
    @PostConstruct
    public void addInfos() {
        mathCalculation.save(new Risk(null, 10L, RiskCategoryEnum.FIRST));
        mathCalculation.save(new Risk(null, 30L, RiskCategoryEnum.SECOND));
        mathCalculation.save(new Risk(null, 50L, RiskCategoryEnum.THIRD));
        mathCalculation.save(new Risk(null, 40L, RiskCategoryEnum.FOURTH));
        mathCalculation.save(new Risk(null, 60L, RiskCategoryEnum.FOURTH));
        mathCalculation.save(new Risk(null, 25L, RiskCategoryEnum.FIRST));
        mathCalculation.save(new Risk(null, 20L, RiskCategoryEnum.FIRST));
    }

    /**
     * @PostConcruct method which find and calculate the actual risk sum
     */
    @Override
    @PostConstruct
    public void calculate() {
        List<Risk> riskList = mathCalculation.findAll();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        riskList.stream().map(i ->
        {
            if (i.getAge() <= 20 && i.getRiskCategory().equals(RiskCategoryEnum.FIRST)) {
                return MAX_SUM * i.getRiskCategory().getPercent();
            } else if (i.getAge() <= 30 && i.getRiskCategory().equals(RiskCategoryEnum.SECOND)) {
                return MAX_SUM * i.getRiskCategory().getPercent();
            } else if (i.getAge() <= 40 && i.getRiskCategory().equals(RiskCategoryEnum.THIRD)) {
                return MAX_SUM * i.getRiskCategory().getPercent();
            } else if (i.getRiskCategory().equals(RiskCategoryEnum.FOURTH)) {
                return MAX_SUM * i.getRiskCategory().getPercent();
            } else {
                return MAX_SUM * STANDART_PERCENT;
            }
        }).forEach(i -> {
           log.info(String.format("Користувач #%s має отримати: %s грн", atomicInteger.incrementAndGet(), i));
        });
    }
}
