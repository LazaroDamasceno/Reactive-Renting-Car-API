package com.api.v1.utils;

import java.math.BigInteger;
import java.time.ZonedDateTime;

public class RentOrderNumberGeneratorUtil {

    public static BigInteger generate() {
        int year = ZonedDateTime.now().getYear();
        String format = "%04d0000".formatted(year);
        BigInteger number = new BigInteger(format);
        number = number.add(BigInteger.ONE);
        return number;
    }

}
