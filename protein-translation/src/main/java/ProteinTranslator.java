import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class ProteinTranslator {
    private ArrayList<String> proteins = new ArrayList<String>();

    HashMap<String, String> mapping = new HashMap<>(){{
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
            String protein;

            try {
                protein = mapping.get(rnaSequence.substring(index, index+3));
            } catch (IndexOutOfBoundsException e) {
                throw new IllegalArgumentException("Invalid codon");
            }

            switch (protein) {
                case null:
                    throw new IllegalArgumentException("Invalid codon");
                case "STOP":
                    return proteins;
                default:
                    proteins.add(protein);
                    break;
            }
        }

        return proteins;
    }
}
