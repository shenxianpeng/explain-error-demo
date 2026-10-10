package dev.acme.payments;

/** Luhn check for card numbers. */
public final class CardValidator {

    private CardValidator() {}

    public static boolean isValid(String number) {
        String digits = number.replace(" ", "");
        if (digits.length() < 12 || !digits.chars().allMatch(Character::isDigit)) {
            return false;
        }
        int sum = 0;
        boolean doubleIt = false;
        for (int i = digits.length() - 1; i >= 0; i--) {
            int d = digits.charAt(i) - '0';
            if (doubleIt) {
                d *= 2;
                if (d > 9) {
                    d -= 9;
                }
            }
            sum += d;
            doubleIt = !doubleIt;
        }
        return sum % 10 == 0;
    }
}
