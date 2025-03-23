class LuhnValidator {

    boolean isValid(String candidate) {
        if (candidate.strip().length() <= 1) {
            return  false;
        }
        int factor = 2, sum = 0;
        for (int i = candidate.length() - 1; i > -1; i--) {
            char c = candidate.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (c < '0' || c > '9') {
                return false;
            }
            factor = 3 - factor;
            int digit = (c - '0') * factor;
            if (digit > 9) {
                digit -= 9;
            }
            sum += digit;
        }

        return sum % 10 == 0;
    }

}
