package ait.map;


import java.util.*;

/*
abc - 1
ab - 3
limn - 2
a - 1
 */
public class WorldFreqAppl {
    public static void main(String[] args) {
        String [] words = {"abc", "ab", "limn","limn", "ab", "a", "ab"};
        printWordsFrequency(words);
    }

    private static void printWordsFrequency(String[] words) {
        Map<String, Integer> res = new HashMap<>();
        for (String word : words) {
//            if(!res.containsKey(word)){
//                res.put(word, 1);
//            }else {
//                res.put(word, res.get(word) + 1);
//            }
//            if(res.putIfAbsent(word, 1) != null){
//                res.put(word, res.get(word) + 1);
//            }

//            Integer frequency = res.getOrDefault(word, 0);
//            res.put(word, frequency + 1);

//            res.computeIfPresent(word, (k,v) -> v + 1);
//            res.computeIfAbsent(word, k -> 1);

            res.merge(word, 1,(v1, v2) -> v1 + v2);
        }
      //  System.out.println(res);

        Set<Map.Entry<String, Integer>> entries = res.entrySet();
        System.out.println("==== Unsorted ===");
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println("=== Sorted by value desc ===");
        List<Map.Entry<String, Integer>> list = new ArrayList<>(entries);
        list.sort((e1,e2) -> Integer.compare(e2.getValue(), e1.getValue()));
        list.forEach(e -> System.out.println(e));
    }
}

