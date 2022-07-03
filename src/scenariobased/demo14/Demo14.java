package scenariobased.demo14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Create a program to get
 * input should be : 3d7p11e
 * output should be : dddpppppppeeeeeeeeeee
 * <p>
 * Output :
 * ------------------ Method 1 ------------------
 * dddpppppppeeeeeeeeeeeaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
 * ------------------ Method 2 ------------------
 * dddpppppppeeeeeeeeeeeaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
 */
public class Demo14 {
    public static void main(String[] args) {
        String input = "3d7p11e101a";
        System.out.println("------------------ Method 1 ------------------");
        method1(input);
        System.out.println("\n------------------ Method 2 ------------------");
        method2(input);
    }

    private static void method1(String input) {
        String[] countArr = input.split("[a-zA-Z]");
        List<String> countList = Arrays.asList(countArr);
        List<Integer> countListInteger = countList
                .stream()
                .map(Integer::parseInt).toList();

        List<Character> characterList = new ArrayList<>();
        char[] charArray = input.toCharArray();
        for (char c : charArray) {
            if (Character.isAlphabetic(c))
                characterList.add(c);
        }

        for (int i = 0; i < characterList.size(); i++) {
            Character character = characterList.get(i);
            Integer count = countListInteger.get(i);
            for (int j = 0; j < count; j++) {
                System.out.print(character);
            }
        }
    }

    public static void method2(String input) {

        int num = 0;

        for (int i = 0; i < input.length(); i++) {

            char c = input.charAt(i);

            if (Character.isDigit(c)) {
                num = (num * 10) + Character.getNumericValue(c);
            } else {
                for (int j = 0; j < num; j++) {
                    System.out.print(c);
                }
                num = 0;
            }
        }
    }
}
