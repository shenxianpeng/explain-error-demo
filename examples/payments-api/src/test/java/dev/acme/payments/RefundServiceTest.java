package dev.acme.payments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class RefundServiceTest {

    private final RefundService refunds = new RefundService(new CurrencyConverter(TestRates.TABLE));

    @Test
    void refundsInTheChargeCurrency() {
        assertEquals(new BigDecimal("108.70"), refunds.refund(new BigDecimal("100"), "EUR", "USD"));
    }

    @Test
    void refundsAJapaneseCustomerInYen() {
        assertEquals(new BigDecimal("16250.00"), refunds.refund(new BigDecimal("100"), "EUR", "JPY"));
    }

    @Test
    void refusesAnEmptyRefund() {
        assertThrows(IllegalArgumentException.class,
                () -> refunds.refund(BigDecimal.ZERO, "EUR", "USD"));
    }
}
