import java.util.HashMap;
import java.util.Map;

public class DialingCodes {
    private Map<Integer, String> codes = new HashMap<>();

    public Map<Integer, String> getCodes() {
        return this.codes;
    }

    public void setDialingCode(Integer code, String country) {
        this.codes.put(code, country);
    }

    public String getCountry(Integer code) {
        return codes.get(code);
    }

    public void addNewDialingCode(Integer code, String country) {
        if (!codes.containsKey(code) && !codes.containsValue(country)) {
            codes.put(code, country);
        }
    }

    public Integer findDialingCode(String country) {
        return codes
            .entrySet()
            .stream()
            .filter(entry -> country.equals(entry.getValue()))
            .map(Map.Entry::getKey)
            .findFirst()
            .orElse(null);
    }

    public void updateCountryDialingCode(Integer code, String country) {
        if (codes.containsValue(country)) {
            codes.remove(findDialingCode(country));
            setDialingCode(code, country);
        }
    }
}
