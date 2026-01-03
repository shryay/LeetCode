class Solution {
    public String discountPrices(String sentence, int discount) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (isPrice(word)) {
                long price = Long.parseLong(word.substring(1));
                double discounted = price * (100.0 - discount) / 100.0;
                result.append("$")
                      .append(String.format("%.2f", discounted));
            } else {
                result.append(word);
            }
            result.append(" ");
        }
        return result.toString().trim();
    }
    private boolean isPrice(String word) {
        if (word.length() <= 1 || word.charAt(0) != '$') return false;
        for (int i = 1; i < word.length(); i++) {
            if (!Character.isDigit(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}