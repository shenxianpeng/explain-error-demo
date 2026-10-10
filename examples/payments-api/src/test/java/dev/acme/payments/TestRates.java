package dev.acme.payments;

import java.math.BigDecimal;
import java.util.Map;

/** The exchange rates the tests run against. */
final class TestRates {

    static final Map<String, BigDecimal> TABLE = Map.of(
            "USD/EUR", new BigDecimal("0.92"),
            "EUR/USD", new BigDecimal("1.087"),
            "USD/JPY", new BigDecimal("149.50"),
            "GBP/USD", new BigDecimal("1.27"));

    private TestRates() {}
}
