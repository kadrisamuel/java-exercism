import java.util.HashMap;

class SqueakyClean {
    private final static HashMap<Character, Character> REPLACEMENTS = new HashMap<Character, Character>(){{
        put('7','t');
        put('4','a');
        put('3','e');
        put('1','l');
        put('0','o');
        put(' ', '_');
    }};


    public static void main(String[] args) {
        String cleaned = clean("Stuff  and so-on ..$&94 73s7H3ll0 W0rld");
        System.out.println(cleaned);
    }

    static String clean(String identifier) {
        StringBuffer dirty = new StringBuffer(identifier);
        StringBuffer clean = new StringBuffer();

        for (int i = 0; i < dirty.length(); i++){
            char c = dirty.charAt(i);
            if (c == '-') {
                //dirty.deleteCharAt(i);
                //c = Character.toUpperCase(dirty.charAt(i));
                dirty.setCharAt(i+1, Character.toUpperCase(dirty.charAt(i+1)));
            } else if (REPLACEMENTS.containsKey(c)) {
                clean.append(REPLACEMENTS.get(c));
            } else if (Character.isLetter(c)) {
                clean.append(c);
            }
        }

        return clean.toString();
    }
}
