package HW3;

import java.io.*;
import java.util.*;

public class NamesCounter {
    public static void main(String[] args) {
        File file = new File("words.txt");
        Map<String, Integer> wordCounts = new HashMap<>();
        try (InputStream fis = new FileInputStream(file);
             Scanner scanner = new Scanner(fis)) {
            while (scanner.hasNextLine()) {
                String nc = scanner.nextLine();
                String[] words = nc.split(" ");
               for (String word : words) {
                   word = word.replaceAll("[^a-zA-Z ]", "").toLowerCase();
                    if (word.length() > 0) {
                        if (wordCounts.containsKey(word)) {
                            wordCounts.put(word, wordCounts.get(word) + 1);
                        } else {
                            wordCounts.put(word, 1);

                        }
                    }
                }
            }
            }
         catch (IOException e) {
            e.printStackTrace();
        }

        Comparator<String> comperator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return wordCounts.get(o1).compareTo(wordCounts.get(o2))>0 ? 1 : -1;
            }
        };
    Map< String , Integer> result = new TreeMap<>(comperator.reversed());
        result.putAll(wordCounts);
        System.out.println(result);
     }

    }






