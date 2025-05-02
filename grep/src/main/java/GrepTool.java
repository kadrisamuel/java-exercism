import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GrepTool {

    static class Result {
        private final String filename;
        private final int linenumber;
        private final String line;

        public Result(String filename, int linenumber, String line ){
            this.filename = filename;
            this.linenumber = linenumber;
            this.line = line;
        }

    }

    String grep(String phrase, List<String> flags, List<String> files) {
        List<Result> results = new ArrayList<>();
        Pattern pattern = Pattern.compile(phrase);

        files.stream().forEach(file -> {
            try (BufferedReader reader = Files.newBufferedReader(Paths.get(file))) {
                String line;
                int linenumber = 0;
    
                while ((line = reader.readLine()) != null) {
                    linenumber += 1;
                    Matcher matcher = pattern.matcher(line);

                    if (matcher.find()) {
                        results.add(new Result(file, linenumber, line));
                    }
                }
            } catch (IOException e) {
                System.err.println("IOException " + e);
            }

        });

        return null;
    }

}

/*
 * 
 * Return lines in the order in which they were found. 
 * When searching in multiple files, each matching line 
 * is prepended by the file name and a colon (':').
 * 
 * -n Prepend the line number and a colon (':') to each line in the output, placing the number after the filename (if present).
 * -l Output only the names of the files that contain at least one matching line.
 * -i Match using a case-insensitive comparison.
 * -v Invert the program -- collect all lines that fail to match.
 * -x Search only for lines where the search string matches the entire line.
 * 
 */