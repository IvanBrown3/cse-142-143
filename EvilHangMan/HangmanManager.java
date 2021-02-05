import java.util.*;

public class HangmanManager {
    private Set<String> wordSet;
    private int guessesLeft;
    private Set<Character> guesses;
    private String pattern;

    public HangmanManager(Collection<String> dictionary, int length, int max){
        wordSet = new TreeSet<>();
        guesses = new TreeSet<>();
        guessesLeft = max;
        if(length < 1||max < 0){
            throw new IllegalArgumentException();
        }
        for(String word : dictionary){
            if(!wordSet.contains(word) && word.length() == length){
                wordSet.add(word);
            } 
        }
        pattern = "";
        for(int i = 0; i < length; i++){
            pattern += "- ";
        }
        pattern = pattern.trim();
    }

    public Set<String> words(){
        return wordSet;
    }

    public int guessesLeft(){
        return guessesLeft;
    }

    public Set<Character> guesses(){
        return guesses;
    }

    public String pattern(){
        if(wordSet.isEmpty()){
            throw new IllegalStateException();
        }
        return pattern;
    }

    public int record(char guess){
        if(guessesLeft < 1 || wordSet.isEmpty()){
            throw new IllegalStateException();
        }
        if(guesses.contains(guess)){
            throw new IllegalArgumentException();
        }
        guesses.add(guess);
        Map<String, Set<String>> famMap = buildTreeMap();
        String tPattern = setWordSet(famMap);
        //figure out the count of the occurances of the character 
        //return the character count
        int count = getGuessOccuranceCount(guess, tPattern);
        if(count == 0){
            guessesLeft--;
        } else{
            pattern = tPattern;
        }
        return count;
    }

    private Map<String, Set<String>> buildTreeMap() {
        Map<String, Set<String>> famMap = new TreeMap<>();
        for(String word : wordSet){
            //get the pattern for each of the words and add it into the mapping
            addToTreeMap(famMap, word, getPattern(word));
        }
        return famMap;
    }

    private int getGuessOccuranceCount(char guess, String p) {
        int retCount = 0;
        for (int i = 0; i < p.length(); i++){
            char t = p.charAt(i);
            if (t == guess){
                retCount++;
            }
        }
        return retCount;
    }

    private String setWordSet(Map<String, Set<String>> famMap) {
        int maxSize = 0;
        String maxKey = "";
        for (String key : famMap.keySet()){
            int tmp = famMap.get(key).size();
            // Take the first in the series if the size is the same as next
            if (tmp > maxSize){
                maxKey = key;
                maxSize = tmp;
            }
        }
        // Updating the wordSet from the key with the most items
        wordSet = famMap.get(maxKey);
        return maxKey;
    }

    private void addToTreeMap(Map<String, Set<String>> famMap, String word, String tPattern) {
        if (famMap.containsKey(tPattern)){
            Set<String> set = famMap.get(tPattern);
            set.add(word);
        } else {
            Set<String> set = new TreeSet<>();
            set.add(word);
            famMap.put(tPattern,set);
        }
    }

    private String getPattern(String word){
        String retPattern = "";
        for (int i = 0;i < word.length(); i++){
            if (guesses.contains(word.charAt(i))){
                retPattern += word.charAt(i) + " ";
            }
            else {
                retPattern +=  "- ";
            }
        }
        return retPattern.trim();
    }    

}
