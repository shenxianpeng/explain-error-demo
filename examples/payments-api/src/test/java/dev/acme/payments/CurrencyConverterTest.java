package dev.acme.payments;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Map;
import org.junit.jupiter.api.Test;

class CurrencyConverterTest {

    private final CurrencyConverter converter = new CurrencyConverter(TestRates.TABLE);

    @Test
    void convertsUsdToEur() {
        assertEquals(new BigDecimal("92.00"), converter.convert(new BigDecimal("100"), "USD", "EUR"));
    }

    @Test
    void sameCurrencyIsUnchanged() {
        assertEquals(new BigDecimal("15.50"), converter.convert(new BigDecimal("15.50"), "GBP", "GBP"));
    }

    @Test
    void roundsHalfUp() {
        assertEquals(new BigDecimal("0.92"), converter.convert(new BigDecimal("0.995"), "USD", "EUR"));
    }
}
