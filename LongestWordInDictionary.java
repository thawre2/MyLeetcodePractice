import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWordInDictionary {
    public String longestWord(String[] words) {
        // This problem can be solved with Trie and hashset, i will try with hashset

        Arrays.sort(words); // sort words in lexicographic order
        Set<String> built = new HashSet<>(); // set to store all words
        String best = "";  // best string to return

        for(String word : words) {
            // if the word is of length 1, then will become prefix
            // or if built contains its prefix then add that word in built hashset
            if(word.length() == 1 || built.contains(word.substring(0,word.length()-1))) {
                built.add(word);

                // if word length is greater than best length
                if(word.length() > best.length()) {
                    best = word;
                }
            }
        }

        return best;
    }
}
