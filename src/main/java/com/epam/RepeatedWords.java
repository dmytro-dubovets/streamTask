package com.epam;

import java.util.*;

import static java.util.stream.Collectors.toMap;

public class RepeatedWords {

    public static void getWords(String text) {

        String[] splitText = text.toLowerCase().split(" ");

        Map<String, Integer> words = new HashMap<>();
        for (String word : splitText) {
            if (words.containsKey(word)) {
                words.put(word, words.get(word) + 1);
            } else {
                words.put(word, 1);
            }
        }

        Map<String, Integer> sorted = words
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .filter(value -> value.getValue() > 1)
                .limit(5)
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                        LinkedHashMap::new));

        List<String> list = new ArrayList<>(sorted.keySet());
        list.forEach(System.out::println);
    }

    public static void main(String[] args) {
        String testText = "aaa aaa pp pp kk ll kkk kkk ooo ooo ooo rrr rrr jj jj ll ll ll aa a a a aa aaa a a a a ak";
        RepeatedWords.getWords(testText);
    }
}
