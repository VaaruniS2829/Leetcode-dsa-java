import java.util.*;

class Solution {
    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");

        // Length mismatch
        if(pattern.length() != words.length)
            return false;

        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> usedWords = new HashSet<>();

        for(int i = 0; i < pattern.length(); i++) {

            char ch = pattern.charAt(i);
            String word = words[i];

            // If pattern character already exists
            if(map.containsKey(ch)) {

                // Check mapping is same
                if(!map.get(ch).equals(word))
                    return false;
            }
            else {

                // Another character already mapped to this word
                if(usedWords.contains(word))
                    return false;

                map.put(ch, word);
                usedWords.add(word);
            }
        }

        return true;
    }
}
