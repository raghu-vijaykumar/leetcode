class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> alphabets = new HashMap<>();

        int i=0;
        for(char c: order.toCharArray()) {
            alphabets.put(c, i++);
        }

        for(int j = 1;j<words.length;j++){
            int k = 0;
            String first = words[j-1];
            String second = words[j];
            while(true) {
                if(k>= first.length()) break;

                if( k>= second.length()) return false;

                if(alphabets.get(first.charAt(k)) < alphabets.get(second.charAt(k))) break;

                else if(alphabets.get(first.charAt(k)) > alphabets.get(second.charAt(k))) return false; 
                else k++;

            }
            
        }

        return true;
    }
}