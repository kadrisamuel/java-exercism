class ReverseString {

    String reverse(String inputString) {
        StringBuffer buffer = new StringBuffer(inputString);
        String reversed = new String(buffer.reverse());
        return reversed;
    }
  
}
