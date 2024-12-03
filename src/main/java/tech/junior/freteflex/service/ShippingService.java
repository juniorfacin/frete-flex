package tech.junior.freteflex.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import tech.junior.freteflex.domain.ExpressShippingCalculator;
import tech.junior.freteflex.domain.ShippingCalculator;
import tech.junior.freteflex.domain.StandardShippingCalculator;

// Bean controlada pelo Spring Container - Dependency Injection
@Service
public class ShippingService {

    private final StandardShippingCalculator standardShippingCalculator;
    private final ExpressShippingCalculator expressShippingCalculator;

    public ShippingService(@Qualifier("standardShippingCalculator") StandardShippingCalculator standardShippingCalculator,
                           @Qualifier("expressShippingCalculator") ExpressShippingCalculator expressShippingCalculator) {
        this.standardShippingCalculator = standardShippingCalculator;
        this.expressShippingCalculator = expressShippingCalculator;
    }

    public Double calculate(String shippingType,
                            Double distance,
                            Double weight) {

        if (shippingType.equalsIgnoreCase("standard")) {
            return standardShippingCalculator.calculate(distance, weight);

        } else if (shippingType.equalsIgnoreCase("express")) {
            return expressShippingCalculator.calculate(distance, weight);
        }

        return null;
    }
}
