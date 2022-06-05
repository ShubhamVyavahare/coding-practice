package scenariobased.demo12;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Find a duplicate characters in a string
 * <p>
 * Output :
 * Method 1 (Time Complexity - O(n^2)) : [h, a, v]
 * Method 2 (Time Complexity - O(2n)) and space complexity - O(256) : [a, h, v]
 * Method 3 (Time Complexity - O(2n)) and space complexity - O(n) : [a, v, h]
 */
public class Demo12 {
    public static void main(String[] args) {

        String originalString = "shubham vyavahare";

        System.out.println("Method 1 (Time Complexity - O(n^2)) : " + findDupCharUsingForLoopMethod1(originalString));

        System.out.println("Method 2 (Time Complexity - O(2n)) and space complexity - O(256) : " + findDupCharUsingArrayMethod2(originalString));

        System.out.println("Method 3 (Time Complexity - O(2n)) and space complexity - O(n) : " + findDupCharUsingMapsMethod3(originalString));
    }

    private static Set<Character> findDupCharUsingForLoopMethod1(String originalString) {

        Set<Character> duplicateCharSet = new LinkedHashSet<>();

        for (int i = 0; i < originalString.length(); i++) {
            for (int j = i + 1; j < originalString.length(); j++) {
                if (originalString.charAt(i) == originalString.charAt(j))
                    duplicateCharSet.add(originalString.charAt(j));
            }
        }

        return duplicateCharSet;
    }

    private static Set<Character> findDupCharUsingArrayMethod2(String originalString) {

        Set<Character> duplicateCharSet = new LinkedHashSet<>();

        int[] arrForChar = new int[256];

        for (int i = 0; i < originalString.length(); i++) {
            arrForChar[originalString.charAt(i)] = arrForChar[originalString.charAt(i)] + 1;
        }

        for (int i = 0; i < 256; i++) {
            if (arrForChar[i] > 1)
                duplicateCharSet.add((char) i);
        }

        return duplicateCharSet;
    }

    private static Set<Character> findDupCharUsingMapsMethod3(String originalString) {

        Set<Character> duplicateCharSet = new LinkedHashSet<>();

        Map<Character, Integer> charVsCountMap = new HashMap<>();

        for (int i = 0; i < originalString.length(); i++) {
            if (charVsCountMap.containsKey(originalString.charAt(i))) {
                charVsCountMap.put(originalString.charAt(i), charVsCountMap.get(originalString.charAt(i)) + 1);
            } else {
                charVsCountMap.put(originalString.charAt(i), 1);
            }
        }

        charVsCountMap.forEach((character, count) -> {
            if (count > 1)
                duplicateCharSet.add(character);
        });

        return duplicateCharSet;
    }
}
