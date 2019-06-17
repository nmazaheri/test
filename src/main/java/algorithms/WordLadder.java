package algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

/**
 * Created by nav on 5/30/15.
 */
public class WordLadder {

    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();
        HashSet<String> dict = new HashSet<>(Arrays.asList("dot", "dog", "lot", "pot", "log", "hot"));
        System.out.println(wordLadder.ladderLength("hit", "cog", dict));
    }

    public int ladderLength(String start, String end, HashSet<String> dict) {
        if (dict.size() == 0)
            return 0;

        dict.add(end);
        Stack<WordNode> wordQueue = new Stack<WordNode>();

        wordQueue.add(new WordNode(start, 1));

        while (!wordQueue.isEmpty()) {
            WordNode currentWordNode = wordQueue.pop();
            String currWord = currentWordNode.word;
            Integer currDistance = currentWordNode.distance;

            if (currWord.equals(end)) {
                return currDistance;
            }

            for (int i = 0; i < currWord.length(); i++) {
                char[] currCharArr = currWord.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    currCharArr[i] = c;

                    String newWord = new String(currCharArr);
                    if (dict.contains(newWord)) {
                        dict.remove(newWord);
                        WordNode wordNode = new WordNode(newWord, currDistance + 1);
                        System.out.println(wordNode + " " + dict);
                        wordQueue.add(wordNode);

                    }
                }
            }
        }
        return 0;
    }

    public class WordNode {
        public int distance;
        public String word;

        public WordNode(String word, int distance) {
            this.distance = distance;
            this.word = word;
        }

        @Override
        public String toString() {
            return "WordNode{" +
                    "distance=" + distance +
                    ", word='" + word + '\'' +
                    '}';
        }
    }
}
