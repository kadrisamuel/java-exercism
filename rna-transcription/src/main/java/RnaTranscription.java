import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class RnaTranscription {
    final static private Character[] _dna = {'G', 'C', 'T', 'A'};
    final static private Character[] _rna = {'C', 'G', 'A', 'U'};
    final static private List<Character> DNA = Arrays.asList(_dna);
    final static private List<Character> RNA = Arrays.asList(_rna);

    String transcribe(String dnaStrand) {
        return dnaStrand.chars()
            .mapToObj(c ->  RNA.get(DNA.indexOf((char)c)).toString())
            .collect(Collectors.joining());         
    }

}
