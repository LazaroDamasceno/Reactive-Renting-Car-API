package com.api.v1.utils.rent;

import java.math.BigDecimal;

public class RentPriceSetterUtil {

    public static BigDecimal set(int days) {
        double price = 65.0;
        return new BigDecimal(days * price);
    }

}
