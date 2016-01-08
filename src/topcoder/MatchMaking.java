package topcoder;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by navid.mazaheri on 12/3/15.
 * https://community.topcoder.com/stat?c=problem_statement&pm=2911&rd=5849
 */

public class MatchMaking {
    public static void main(String[] args) {
        MatchMaking matchMaking = new MatchMaking();
                System.out.println(matchMaking
                        .makeMatch(new String[] { "Constance", "Bertha", "Alice" }, new String[] { "aaba", "baab", "aaaa" },
                                new String[] { "Chip", "Biff", "Abe" }, new String[] { "bbaa", "baaa", "aaab" }, "Bertha"));
                System.out.println(matchMaking
                        .makeMatch(new String[] { "Constance", "Bertha", "Alice" }, new String[] { "aaba", "baab", "aaaa" },
                                new String[] { "Chip", "Biff", "Abe" }, new String[] { "bbaa", "baaa", "aaab" }, "Constance"));

        System.out.println(matchMaking.makeMatch(new String[] { "Constance", "Alice", "Bertha", "Delilah", "Emily" },
                new String[] { "baabaa", "ababab", "aaabbb", "bababa", "baabba" },
                new String[] { "Ed", "Duff", "Chip", "Abe", "Biff" },
                new String[] { "aabaab", "babbab", "bbbaaa", "abbbba", "abaaba" }, "Constance"));


                System.out.println(matchMaking.makeMatch(new String[] { "Constance", "Alice", "Bertha", "Delilah", "Emily" },
                        new String[] { "baabaa", "ababab", "aaabbb", "bababa", "baabba" },
                        new String[] { "Ed", "Duff", "Chip", "Abe", "Biff" },
                        new String[] { "aabaab", "babbab", "bbbaaa", "abbbba", "abaaba" }, "Delilah"));

                System.out.println(matchMaking.makeMatch(new String[] { "Constance", "Alice", "Bertha", "Delilah", "Emily" },
                        new String[] { "baabaa", "ababab", "aaabbb", "bababa", "baabba" },
                        new String[] { "Ed", "Duff", "Chip", "Abe", "Biff" },
                        new String[] { "aabaab", "babbab", "bbbaaa", "abbbba", "abaaba" }, "Emily"));

                System.out.println(matchMaking
                        .makeMatch(new String[] { "anne", "Zoe" }, new String[] { "a", "a" }, new String[] { "bob", "chuck" },
                                new String[] { "a", "a" }, "Zoe"));
                System.out.println(matchMaking.makeMatch(
                        new String[] { "F", "M", "S", "h", "q", "g", "r", "N", "U", "x", "H", "P", "o", "E", "R", "z", "L", "m",
                                "e", "u", "K", "A", "w", "Q", "O", "v", "j", "a", "t", "p", "C", "G", "k", "c", "V", "B", "D",
                                "s", "n", "i", "f", "T", "I", "l", "d", "J", "y", "b" },
                        new String[] { "abaabbbb", "bbaabbbb", "aaabaaab", "aabbaaaa", "baabbaab", "aaababba", "bbabbbbb",
                                "bbbabbba", "aaabbbba", "aabbbaaa", "abbabaaa", "babbabbb", "aaaaabba", "aaaabbaa", "abbbabaa",
                                "babababa", "abbaaaaa", "bbababba", "baaaaaba", "baaaaabb", "bbbbabba", "ababbaaa", "abbbabab",
                                "baabbbaa", "bbbaabbb", "aababbab", "ababbabb", "abbaabba", "baabbabb", "aaabaaab", "aabbbaba",
                                "aabaaabb", "abababba", "aabbaaaa", "aabbabaa", "bababaaa", "aabaaaab", "bbbbaabb", "baaababb",
                                "abaabbab", "aabbbaaa", "baabbaba", "bbabbbaa", "aabbbbaa", "abbbaaab", "abababbb", "ababaaba",
                                "bababaaa" },
                        new String[] { "f", "C", "v", "g", "Q", "z", "n", "c", "B", "o", "M", "F", "u", "x", "I", "T", "K", "L",
                                "E", "U", "w", "A", "d", "t", "e", "R", "D", "s", "p", "q", "m", "r", "H", "j", "J", "V", "l",
                                "a", "k", "h", "G", "y", "i", "P", "O", "N", "b", "S" },
                        new String[] { "bbbaabab", "bbabaabb", "ababbbbb", "bbbababb", "baababaa", "bbaaabab", "abbabbaa",
                                "bbbabbbb", "aabbabab", "abbababa", "aababbbb", "bababaab", "aaababbb", "baabbaba", "abaaaaab",
                                "bbaababa", "babaabab", "abbabbba", "ababbbab", "baabbbab", "babbaaab", "abbbbaba", "bbabbbba",
                                "baaabaab", "ababbabb", "abbbaabb", "bbbbaabb", "bbbaaabb", "baabbaba", "bbabaaab", "aabbbaab",
                                "abbbbabb", "bbaaaaba", "bbbababa", "abbaabba", "bababbbb", "aabaaabb", "babbabab", "baaaabaa",
                                "ababbaba", "aaabaabb", "bbaaabaa", "baaaaabb", "bbaabaab", "bbababab", "aabaaaab", "aaaaabab",
                                "aabbaaba" }, "U"));
                System.out.println(matchMaking.makeMatch(
                        new String[] { "q", "M", "w", "y", "p", "N", "s", "r", "a", "H", "o", "n", "F", "m", "l", "b", "D", "j",
                                "C", "u", "f", "I", "g", "L", "i", "x", "A", "G", "O", "k", "h", "d", "c", "E", "B", "v", "J",
                                "z", "K", "e", "t" },
                        new String[] { "aabbaaabb", "baabababb", "bbaababba", "bbbaaaaaa", "abaaaabaa", "bababbbab",
                                "abbaabbaa", "aabababbb", "bababaaaa", "abbababaa", "aabbbbbba", "bbabbabab", "babaabbba",
                                "babbabbbb", "baaabbbbb", "baaabaaaa", "aaabbaaab", "abbaabbbb", "abbabbbab", "bbaaaabba",
                                "babbaaabb", "aabbabbab", "baaababba", "ababaabab", "bbbaabbab", "aaaabbabb", "babaaaaaa",
                                "abbbbaaab", "aabaaabba", "bbbaaaaba", "bbbbbbaab", "aabbaaabb", "aabaabbab", "aababaaba",
                                "bbabbbbab", "abbabaaab", "babaaabbb", "bababbaaa", "aabbaabaa", "baaabbabb", "bbbbbbbbb" },
                        new String[] { "m", "k", "n", "q", "L", "E", "M", "l", "w", "x", "g", "e", "i", "z", "F", "r", "a", "h",
                                "f", "D", "J", "K", "j", "v", "A", "t", "N", "y", "s", "c", "o", "p", "d", "b", "B", "G", "O",
                                "I", "u", "C", "H" },
                        new String[] { "bbaaabbba", "bbaaaaaab", "abaaababb", "baaaabbbb", "abbbababa", "baaaaaaaa",
                                "aabbbbbab", "aaaaabbba", "baabababb", "babaaabab", "baaababaa", "bbbbaabba", "bbaabbabb",
                                "bbaaababb", "abbabbaba", "aababaaab", "abbbbbbaa", "aabbaabaa", "bbbaabbba", "abbabbaba",
                                "aaabbbaaa", "bbaabaaaa", "aabababbb", "abbbbabab", "baaabbbba", "bababbbba", "aababbaab",
                                "bbaabbaab", "bbbaaabbb", "babbbbabb", "ababababb", "babaaabab", "bbaaaaaba", "aaaaabaaa",
                                "abbaaabbb", "bbbbababb", "baabababb", "bbaabaaaa", "aaababbbb", "abbbbbbba", "bbaabbaaa" },
                        "o"));

    }

    public String makeMatch(String[] namesWomen, String[] answersWomen, String[] namesMen, String[] answersMen,
            String queryWoman) {

        Map<String, String> menNameAnswerMap = getTreeMap(namesMen, answersMen);
        Map<String, String> womanNameAnswerMap = getTreeMap(namesWomen, answersWomen);

        Map<String, String> match = new HashMap();
        for (String wName : womanNameAnswerMap.keySet()) {
            match.put(wName, getBestMan(womanNameAnswerMap.get(wName), menNameAnswerMap));
        }

        return match.get(queryWoman);
    }

    private Map<String, String> getTreeMap(String[] names, String[] answers) {
        // guarantee order of key using treeMap
        Map<String, String> map = new TreeMap();
        for (int i = 0; i < names.length; i++) {
            map.put(names[i], answers[i]);
        }
        return map;
    }

    private String getBestMan(String womenAnswer, Map<String, String> menAnswers) {
        int bestMatch = -1;
        String closestMan = null;

        for (Map.Entry<String, String> currentEntry : menAnswers.entrySet()) {
            int matchSize = matchSize(currentEntry.getValue(), womenAnswer);
            if (matchSize > bestMatch) {
                bestMatch = matchSize;
                closestMan = currentEntry.getKey();
            }
        }

        menAnswers.remove(closestMan);
        return closestMan;
    }

    private int matchSize(String menAnswer, String womenAnswer) {
        int count = 0;
        for (int i = 0; i < menAnswer.length(); i++) {
            if (menAnswer.charAt(i) == womenAnswer.charAt(i))
                count++;
        }
        return count;
    }

}
