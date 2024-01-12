package Regex;

import java.util.Arrays;
import java.util.Collections;

public class Longestprefix {
	public static String findLongestCommonPrefix(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }

        // Take the first word as the initial prefix
        String prefix = words[0];

        // Iterate through the remaining words
        for (int i = 1; i < words.length; i++) {
            int j = 0;
            // Compare characters of the current word with the prefix
            while (j < prefix.length() && j < words[i].length() && prefix.charAt(j) == words[i].charAt(j)) {
                j++;
                System.out.println(j);
            }

            // Update the prefix to the common part
            prefix = prefix.substring(0, j);

            // If the prefix becomes empty, no common prefix exists
            if (prefix.isEmpty()) {
                break;
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        // Sample Case 0
        String[] wordsCase0 = {"apple", "app", "application"};
        String outputCase0 = findLongestCommonPrefix(wordsCase0);
        System.out.println(outputCase0);  // Output: "app"

        // Sample Case 1
        String[] wordsCase1 = {"dog", "racecar", "car"};
        String outputCase1 = findLongestCommonPrefix(wordsCase1);
        System.out.println(outputCase1);  // Output: ""
    }
	 


}