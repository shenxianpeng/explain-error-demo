package dev.acme.payments;

import java.math.BigDecimal;

/** Works out how much of a payment goes back to the customer. */
public class RefundService {

    private final CurrencyConverter converter;

    public RefundService(CurrencyConverter converter) {
        this.converter = converter;
    }

    /** A refund is paid in the currency the customer was charged in. */
    public BigDecimal refund(BigDecimal settled, String settlementCurrency, String chargeCurrency) {
        if (settled.signum() <= 0) {
            throw new IllegalArgumentException("Nothing to refund: " + settled);
        }
        return converter.convert(settled, settlementCurrency, chargeCurrency);
    }
}
