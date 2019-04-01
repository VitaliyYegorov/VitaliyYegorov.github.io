package com.assignment3;
//
//  WordCount.java


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WordCount {
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
        
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());
        
        // Sort the list
        Collections.sort(list, new java.util.Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        
        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        // open the file
        System.out.print("Enter Filename:");
        Scanner in = new Scanner(System.in);
        File file = new File(in.nextLine());
        in.close();
        in = new Scanner(file);
        // count occurrences
        HashMap<String, Integer> wordCounts = new HashMap<String, Integer>();
        while (in.hasNextLine()) {
            String next = in.nextLine().toLowerCase();// read line by line
            String [] splitted = next.split("\\s+"); // split the words using space regex
            for (String word : splitted){
                //Remove the special characters at the start and end of the words.
                word=word.trim().replaceAll("[?!,.()]*", "");
                if(word.trim().length()==0)
                    continue;
                if (!wordCounts.containsKey(word)) {
                    wordCounts.put(word, 1);
                } else {
                    wordCounts.put(word, wordCounts.get(word) + 1);
                }
            }
        }
        in.close();
        System.out.println("Total words = " + wordCounts.size());
        
        HashMap<String, Integer> sortedMapAsc = sortByValue(wordCounts);
        
        // Report frequencies
        for (String word : sortedMapAsc.keySet()) {
            int count = sortedMapAsc.get(word);
            System.out.println(count + ":\t" + word);
        }
    }
}
