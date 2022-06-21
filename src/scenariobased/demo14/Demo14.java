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
 * dddpppppppeeeeeeeeeee
 */
public class Demo14 {
    public static void main(String[] args) {
        String input = "3d7p11e";

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
}
