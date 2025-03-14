import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Say {
    final static HashMap<Integer, String> lookup = new HashMap<>(){{
        put(0, "zero");
        put(1, "one");
        put(2, "two");
        put(3, "three");
        put(4, "four");
        put(5, "five");
        put(6, "six");
        put(7, "seven");
        put(8, "eight");
        put(9, "nine");
        put(10, "ten");
        put(11, "eleven");
        put(12, "twelve");
        put(13, "thirteen");
        put(14, "fourteen");
        put(15, "fifteen");
        put(16, "sixteen");
        put(17, "seventeen");
        put(18, "eighteen");
        put(19, "nineteen");
        put(20, "twenty");
        put(30, "thirty");
        put(40, "forty");
        put(50, "fifty");
        put(60, "sixty");
        put(70, "seventy");
        put(80, "eighty");
        put(90, "ninety");
    }};

    final static long UPPER_BOUND = 999_999_999_999L;
    final static long BILLION = 1_000_000_000;
    final static long MILLION = 1_000_000;
    final static long THOUSAND = 1_000;
    final static long HUNDRED = 100;
    final static String SPACE = " ";
    final static String DASH = "-"; 

    public String say(long number) throws IllegalArgumentException {

        if (number < 0 || number > UPPER_BOUND) {
            throw new IllegalArgumentException("Input has to be between 0 and 999,999,999,999");
        }

        String result = sayIt(number).toString();
        withVoice(result);

        return result;
    }

    private void withVoice(String command) {
        ProcessBuilder builder = new ProcessBuilder("/bin/sh", "-c", "say \"" + command + "\"");
        Process process;
        try {
            process = builder.start();
            Voice voice = new Voice(process.getInputStream(), System.out::println);
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            Future<?> future = executorService.submit(voice);
            int exitCode = process.waitFor();

            assertDoesNotThrow(() -> future.get(10, TimeUnit.SECONDS));
            assertEquals(0, exitCode); 
            executorService.shutdown();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }    

    }

    private StringBuffer sayIt(long number) {
        StringBuffer collect = new StringBuffer();

        if (number >= BILLION) { 
            return collect.append(sayIt(number/BILLION))
                .append(SPACE).append("billion")
                .append(more(number % BILLION)); 
        }

        if (number >= MILLION) { 
            return collect.append(sayIt(number/MILLION))
                .append(SPACE).append("million")
                .append(more(number % MILLION)); 
            }

        if (number >= THOUSAND) { 
            return collect.append(sayIt(number/THOUSAND))
                .append(SPACE).append("thousand")
                .append(more(number % THOUSAND)); 
        }

        if (number >= 100) { 
            return collect.append(sayIt(number / 100))
                .append(SPACE).append("hundred")
                .append(more(number % 100)); }

        Integer num = (int) number;
        if (num >= 20) {
            if (num % 10 != 0) {
                return collect.append(lookup.get(num - num % 10))
                    .append(DASH).append(lookup.get(num % 10));
            }
            return collect.append(lookup.get(num));
        }

        if (num < 20) {
            return collect.append(lookup.get(num));
        }

        return collect;
    }

    private StringBuffer more(long number) {
        StringBuffer collectMore = new StringBuffer();
        return collectMore.append((number != 0)? SPACE + sayIt(number) : "");
    }
}