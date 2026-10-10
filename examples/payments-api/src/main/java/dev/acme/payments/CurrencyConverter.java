package dev.acme.payments;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

/** Converts an amount between two currencies using a table of exchange rates. */
public class CurrencyConverter {

    private final Map<String, BigDecimal> rates;

    public CurrencyConverter(Map<String, BigDecimal> rates) {
        this.rates = rates;
    }

    public BigDecimal convert(BigDecimal amount, String from, String to) {
        if (from.equals(to)) {
            return amount;
        }
        BigDecimal rate = rates.get(from + "/" + to);
        return amount.multiply(rate).setScale(2, RoundingMode.HALF_UP);
    }
}
