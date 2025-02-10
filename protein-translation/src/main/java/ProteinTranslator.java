import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class ProteinTranslator {
    private ArrayList<String> proteins = new ArrayList<String>();
    private String protein;

    HashMap<String, String> codonProtein = new HashMap<>(){{
        put("AUG", "Methionine");
        put("UUU", "Phenylalanine");
        put("UUC", "Phenylalanine");
        put("UUA", "Leucine");
        put("UUG", "Leucine");
        put("UCU", "Serine");
        put("UCC", "Serine");
        put("UCA", "Serine");
        put("UCG", "Serine");
        put("UAU", "Tyrosine");
        put("UAC", "Tyrosine");
        put("UGU", "Cysteine");
        put("UGC", "Cysteine");
        put("UGG", "Tryptophan");
        put("UAA", "STOP");
        put("UAG", "STOP");
        put("UGA", "STOP");
    }};

    List<String> translate(String rnaSequence) throws IllegalArgumentException {
        for (int index = 0; index < rnaSequence.length(); index += 3) {
            
            try {
                protein = codonProtein.get(rnaSequence.substring(index, index+3));
            } catch (Exception e) {
                throw new IllegalArgumentException("Invalid codon");
            }

            if (protein == null) {
                throw new IllegalArgumentException("Invalid codon");
            }
            if (protein == "STOP") {
                return proteins;
            }

            proteins.add(protein);
        }
        return proteins;
    }
}
