package org.javamoney.moneta.convert;

import static org.testng.Assert.assertEquals;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.convert.ExchangeRate;
import javax.money.convert.RateType;

import org.javamoney.moneta.convert.ExchangeRateBuilder;
import org.javamoney.moneta.spi.DefaultNumberValue;
import org.testng.annotations.Test;

public class ExchangeRateSimpleTest {
    private static final CurrencyUnit EUR = Monetary.getCurrency("EUR");
    private static final CurrencyUnit GBP = Monetary.getCurrency("GBP");

    @Test
    public void equalsTest() {
        DefaultNumberValue factor = new DefaultNumberValue(1.1);

        ExchangeRate rate1 = new ExchangeRateBuilder("myprovider", RateType.ANY)
                .setBase(EUR)
                .setTerm(GBP)
                .setFactor(factor)
                .build();

        ExchangeRate rate2 = new ExchangeRateBuilder("myprovider", RateType.ANY)
                .setBase(EUR)
                .setTerm(GBP)
                .setFactor(factor)
                .build();

        assertEquals(rate1, rate2);
    }
}
