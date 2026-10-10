package dev.acme.payments;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CardValidatorTest {

    @Test
    void acceptsAValidNumber() {
        assertTrue(CardValidator.isValid("4539 1488 0343 6467"));
    }

    @Test
    void rejectsAWrongCheckDigit() {
        assertFalse(CardValidator.isValid("4539 1488 0343 6468"));
    }

    @Test
    void rejectsLetters() {
        assertFalse(CardValidator.isValid("4539 1488 0343 64AB"));
    }
}
